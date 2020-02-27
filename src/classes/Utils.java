package classes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Utils {
	public static double precoFinal(int km, double preco) {
		return ((km * preco) / 10);
	}
	
	public static int converteTempo(double tempo) {
		final int horas = (int) tempo;
		final int minutos = (int)Math.round((tempo - (int)tempo) * 100);
		return (int) ((horas * 60) + minutos);
	}
	
	public static double pegarMenorPreco(List<Transportadora> lista) {
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
	
	public static double pegarMenorTempo(List<Transportadora> lista) {
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
	
	public static List<Transportadora> fitroMenorPreco(List<Transportadora> t) {
		List<Transportadora> menorPreco = new ArrayList<>();
		menorPreco = t.stream().filter(transportadora -> transportadora.getValor() == pegarMenorPreco(t)).collect(Collectors.toList());
		return menorPreco;
	}
	
	public static List<Transportadora> fitroMenorTempo(List<Transportadora> t) {
		List<Transportadora> menorTempo = new ArrayList<>();
		menorTempo = t.stream().filter(transportadora -> transportadora.getTempo() == pegarMenorTempo(t)).collect(Collectors.toList());
		return menorTempo;
	}
	
	public static List<Transportadora> fitroMenorTempoePreco(List<Transportadora> t) {
		List<Transportadora> menorTempoePreco = new ArrayList<>();
		menorTempoePreco = t.stream().filter(transportadora -> transportadora.getValor() == pegarMenorPreco(t) && transportadora.getTempo() == pegarMenorTempo(t)).collect(Collectors.toList());
		return menorTempoePreco;
	}
	
	public static List<Transportadora> atualizaValores(List<Transportadora> t, int distancia) {
		List<Transportadora> novaLista = new ArrayList<>();
		for(Transportadora transportadora : t) {
			novaLista.add(
				new Transportadora(
					transportadora.getIdTipoTransporte(), 
					Utils.precoFinal(distancia, transportadora.getValor()),
					Utils.converteTempo(transportadora.getTempo())
				)
			);
		}
		return novaLista;
	}
	
	public static List<Transportadora> listaTransportadoras(Transporte t) throws Exception{
		Connection con = null;
		ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
		List<Transportadora> listaTransportadoras = new ArrayList<>();
		TransportadoraBD listaBD = new TransportadoraBD();
		TransportadoraWS listaWS = new TransportadoraWS();
		
		con = conexao.conectar();
		String query = "SELECT * FROM \"dadosTransportadoraView\"";
		listaTransportadoras = listaBD.buscaTodas(con, query);
		listaTransportadoras.addAll(listaWS.buscaTodas());
		
		if(t.getTipoTransporte() > 0) {
			query = "SELECT * FROM \"dadosTransportadoraView\" where \"idTipoTransporte\" = ?";
			listaTransportadoras = listaBD.buscaPorTipoTransporte(con, query, t.getTipoTransporte());
			listaTransportadoras.addAll(listaWS.buscaPorTipoTransporte(t.getTipoTransporte()));
		}
		
		return listaTransportadoras;
	}
}
