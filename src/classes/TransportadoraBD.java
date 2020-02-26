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
			transportadoras.add(new Transportadora(1, 200.00, 0.30));
			transportadoras.add(new Transportadora(2, 75.00, 0.59));
			transportadoras.add(new Transportadora(1, 180.00, 0.33));
			transportadoras.add(new Transportadora(2, 55.00, 1.05));
			transportadoras.add(new Transportadora(1, 175.00, 0.30));
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
			transportadoras.add(new Transportadora(1, 200.00, 0.30));
			transportadoras.add(new Transportadora(2, 50.00, 0.59));
			transportadoras.add(new Transportadora(1, 180.00, 0.33));
			transportadoras.add(new Transportadora(2, 55.00, 1.05));
			transportadoras.add(new Transportadora(1, 175.00, 0.30));
			statement.close();			
			return transportadoras;
		} catch(SQLException e) {
			throw new SQLException("Não foi possível buscar as transportadoras da base de dados");
		}
	}

}
