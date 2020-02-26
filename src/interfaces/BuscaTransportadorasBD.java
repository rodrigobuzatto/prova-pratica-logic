package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classes.Transportadora;

public interface BuscaTransportadorasBD {
	public List<Transportadora> buscaTodas(Connection con, String query) throws SQLException;
	public List<Transportadora> buscaPorTipoTransporte(Connection con, String query, int tipoTransporte) throws SQLException;
}
