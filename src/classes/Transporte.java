package classes;

import java.util.ArrayList;
import java.util.List;

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

	protected int getTipoTransporte() {
		return tipoTransporte;
	}

	protected String getPrioridade() {
		return prioridade;
	}

	protected int getDistancia() {
		return this.distancia;
	}
	
	public List<Transportadora> solicitaTransportadora() throws Exception{
		List<Transportadora> melhorOpcao = new ArrayList<>();
		try {
			List<Transportadora> listaTransportadoras = Utils.listaTransportadoras(this);			
			
			List<Transportadora> novaLista = Utils.atualizaValores(listaTransportadoras, getDistancia());
			
			System.out.println(novaLista);
			
			if(getPrioridade() == "preco") {
				melhorOpcao = Utils.fitroMenorPreco(novaLista);
			}
			if(getPrioridade() == "tempo") {
				melhorOpcao = Utils.fitroMenorTempo(novaLista);
			}
			if(melhorOpcao.size() > 1) {
				melhorOpcao = Utils.fitroMenorTempoePreco(novaLista);
			}
			
		} catch (Exception e) {
			throw new Exception("Não foram encontradas transportadoras disponíveis");
		}		
		return melhorOpcao;
	}	
}