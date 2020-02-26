import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.ConexaoPostgreSQL;
import classes.Transportadora;
import classes.TransportadoraBD;
import classes.Transporte;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		ConexaoPostgreSQL conexao = new ConexaoPostgreSQL("jdbc:postgresql://localhost:5432/logic", "logic", "logic");	
		TransportadoraBD transportadoraBD = new TransportadoraBD();
		List<Transportadora> lista = new ArrayList<>();
		String queryTodas = "SELECT * FROM \"dadosTransportadoraView\"";
		
		con = conexao.conectar();
		if(con != null) {
			lista = transportadoraBD.buscaTodas(con, queryTodas);
			
			Transporte spAm = new Transporte("São Paulo - SP", "Manaus - AM", 3875, 1, "preco");
			Transporte flCa = new Transporte("Florianopolis - SC", "Campinas - SP", 762, 2, "preco");
			Transporte saBe = new Transporte("Salvador - BA", "Belem - PA", 2018, "tempo");
			Transporte spAs = new Transporte("São Paulo - SP", "Assuncao - PAR", 1350, "tempo");
			Transporte saBr = new Transporte("Salvador - BA", "Brasilia - DF", 1449, 2, "tempo");
			
			try {
				spAm.solicitaTransportadora(spAm);
				flCa.solicitaTransportadora(flCa);
				saBe.solicitaTransportadora(saBe);
				spAs.solicitaTransportadora(spAs);
				saBr.solicitaTransportadora(saBr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
