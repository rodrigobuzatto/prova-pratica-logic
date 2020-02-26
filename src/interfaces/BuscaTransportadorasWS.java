package interfaces;

import java.util.List;

import classes.Transportadora;

public interface BuscaTransportadorasWS {
	public List<Transportadora> buscaTodas() throws Exception;
	public List<Transportadora> buscaPorTipoTransporte(int tipoTransporte) throws Exception;
}
