package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.BuscaTransportadorasWS;

public class TransportadoraWS implements BuscaTransportadorasWS{

	@Override
	public List<Transportadora> buscaTodas() throws Exception {
		List<Transportadora> transportadoras = new ArrayList<>();
		return transportadoras;
	}

	@Override
	public List<Transportadora> buscaPorTipoTransporte(int tipoTransporte) throws Exception {
		List<Transportadora> transportadoras = new ArrayList<>();
		return transportadoras;
	}

}
