package classes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Transporte {
	private String origem;
	private String destino;
	private int distancia;
	private int tipoTransporte;
	private String prioridade;
	
	public Transporte(String origem, String destino, int distancia, int tipoTransporte, String prioridade) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.tipoTransporte = tipoTransporte;
		this.prioridade = prioridade;
	}
	
	public Transporte(String origem, String destino, int distancia, String prioridade) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.prioridade = prioridade;
	}
	
	protected String getOrigem() {
		return origem;
	}

	protected String getDestino() {
		return destino;
	}

	protected int getTipoTransporte() {
		return tipoTransporte;
	}

	protected String getPrioridade() {
		return prioridade;
	}

	protected int getDistancia() {
		return this.distancia;
	}
	
	public List<Transportadora> solicitaTransportadora(Transporte t) throws Exception{
		TransportadoraBD lista = new TransportadoraBD();
		List<Transportadora> listaTransportadoras = new ArrayList<>();
		List<Transportadora> novaLista = new ArrayList<>();
		List<Transportadora> melhorOpcao = new ArrayList<>();
		Connection con = null;
		ConexaoPostgreSQL conexao = new ConexaoPostgreSQL("jdbc:postgresql://localhost:5432/logic", "logic", "logic");		
		try {
			con = conexao.conectar();
			String query = "SELECT * FROM \"dadosTransportadoraView\"";
			listaTransportadoras = lista.buscaTodas(con, query);
			if(t.getTipoTransporte() > 0) {
				query = "SELECT * FROM \"dadosTransportadoraView\" where \"idTipoTransporte\" = ?";
				listaTransportadoras = lista.buscaPorTipoTransporte(con, query, t.getTipoTransporte());
			}			
			for(Transportadora transportadora : listaTransportadoras) {
				novaLista.add(
					new Transportadora(
						transportadora.getIdTipoTransporte(), 
						Utils.precoFinal(t.getDistancia(), transportadora.getValor()),
						Utils.converteTempo(transportadora.getTempo())
					)
				);
			}
			if(t.getPrioridade() == "preco") {
				melhorOpcao = novaLista.stream().filter(transportadora -> transportadora.getValor() == pegarMenorPreco(novaLista)).collect(Collectors.toList());
				if(melhorOpcao.size() > 1) {
					List<Transportadora> novoFiltro = melhorOpcao;
					melhorOpcao = novoFiltro.stream().filter(transportadora -> transportadora.getValor() == pegarMenorPreco(novoFiltro) && transportadora.getTempo() == pegarMenorTempo(novoFiltro)).collect(Collectors.toList());
				}				
			}
			if(t.getPrioridade() == "tempo") {
				melhorOpcao = novaLista.stream().filter(transportadora -> transportadora.getTempo() == pegarMenorTempo(novaLista)).collect(Collectors.toList());
				if(melhorOpcao.size() > 1) {
					List<Transportadora> novoFiltro = melhorOpcao;
					melhorOpcao = novoFiltro.stream().filter(transportadora -> transportadora.getTempo() == pegarMenorTempo(novoFiltro) && transportadora.getValor() == pegarMenorPreco(novoFiltro)).collect(Collectors.toList());
				}				
			}			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return melhorOpcao;
	}
	
	protected double pegarMenorPreco(List<Transportadora> lista) {
		double menorPreco = 0;
		for(Transportadora transportadora : lista) {
			if(menorPreco == 0) {
				menorPreco = transportadora.getValor();
			} else if(transportadora.getValor() < menorPreco) {
				menorPreco = transportadora.getValor();
			}
		}
		return menorPreco;
	}
	
	protected double pegarMenorTempo(List<Transportadora> lista) {
		double menorTempo = 0;
		for(Transportadora transportadora : lista) {
			if(menorTempo == 0) {
				menorTempo = transportadora.getTempo();
			} else if(transportadora.getTempo() < menorTempo) {
				menorTempo = transportadora.getTempo();
			}
		}
		return menorTempo;
	}
}