package classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import interfaces.BuscaTransportadorasWS;

public class TransportadoraWS implements BuscaTransportadorasWS{
	
	private static int HTTP_COD_SUCESSO = 200;

	@Override
	public List<Transportadora> buscaTodas() throws Exception {
		List<Transportadora> transportadoras = new ArrayList<>();
		try {
			Gson gson = new Gson();
			URL url = new URL("http://localhost:8080/service/transportadora/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			if(connection.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("Ocorreu um erro na requisição HTTP com o número: " + connection.getResponseCode());
			}			
	        			
			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
	        Transportadora[] lista = gson.fromJson(br, Transportadora[].class);
	        for(Transportadora t: lista) {
	        	transportadoras.add(new Transportadora(t.getIdTipoTransporte(), t.getValor(), t.getTempo()));
	        }
	        
	        System.out.println(transportadoras);
			
			return transportadoras;
		} catch(Exception e) {			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Transportadora> buscaPorTipoTransporte(int tipoTransporte) throws Exception {
		List<Transportadora> transportadoras = new ArrayList<>();
		try {
			Gson gson = new Gson();
			URL url = new URL("http://localhost:8080/service/transportadora?tipoTransporte="+tipoTransporte);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			if(connection.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("Ocorreu um erro na requisição HTTP com o número: " + connection.getResponseCode());
			}			
	        			
			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
	        Transportadora[] lista = gson.fromJson(br, Transportadora[].class);
	        for(Transportadora t: lista) {
	        	transportadoras.add(new Transportadora(tipoTransporte, t.getValor(), t.getTempo()));
	        }
			
			return transportadoras;
		} catch(Exception e) {			
			throw new Exception(e.getMessage());
		}
	}

}
