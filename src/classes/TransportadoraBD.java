package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.BuscaTransportadorasBD;

public class TransportadoraBD implements BuscaTransportadorasBD{

	@Override
	public List<Transportadora> buscaTodas(Connection con, String query) throws SQLException {
		try {
			List<Transportadora> transportadoras = new ArrayList<>();						
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				transportadoras.add(new Transportadora(result.getInt("idTipoTransporte"), result.getDouble("valor"), result.getInt("tempo")));
			}
			statement.close();				
			return transportadoras;
		} catch(SQLException e) {
			throw new SQLException("Não foi possível buscar as transportadoras da base de dados");
		}
	}

	@Override
	public List<Transportadora> buscaPorTipoTransporte(Connection con, String query, int tipoTransporte) throws SQLException{ 
		try {
			List<Transportadora> transportadoras = new ArrayList<>();			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, tipoTransporte);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				transportadoras.add(new Transportadora(result.getInt("idTipoTransporte"), result.getDouble("valor"), result.getInt("tempo")));
			}
			statement.close();			
			return transportadoras;
		} catch(SQLException e) {
			throw new SQLException("Não foi possível buscar as transportadoras da base de dados");
		}
	}

}
