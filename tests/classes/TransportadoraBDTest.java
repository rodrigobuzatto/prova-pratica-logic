package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TransportadoraBDTest {
	
	Connection con = null;
	ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();	
	TransportadoraBD transportadoraBD = new TransportadoraBD();
	List<Transportadora> lista = new ArrayList<>();
	String queryTodas = "SELECT * FROM \"dadosTransportadoraView\"";
	String queryPorTipoTransporte = "SELECT * FROM \"dadosTransportadoraView\" where \"idTipoTransporte\" = ?";
	String queryErrada = "SELECT * FROM dados";
	
	@Test
	void buscaTodasTest() throws SQLException{
		con = conexao.conectar();		
		lista.add(new Transportadora(1, 10.00, 3));
		assertEquals(1, transportadoraBD.buscaTodas(con, queryTodas).size());
	}
	
	@Test
	void buscaTodasSQLExceptionTest() throws SQLException{
		con = conexao.conectar();
		SQLException e = assertThrows(SQLException.class, () -> {
			transportadoraBD.buscaTodas(con, queryErrada);	
		});		
		assertEquals(e.getMessage(), "Não foi possível buscar as transportadoras da base de dados");
	}
	
	@Test
	void buscaPorTipoTransporteAereoTest() throws SQLException{
		con = conexao.conectar();
		assertEquals(0, transportadoraBD.buscaPorTipoTransporte(con, queryPorTipoTransporte, 1).size());
	}
	
	@Test
	void buscarPorTipoTransporteAereoSQLExceptionTest() throws SQLException{
		con = conexao.conectar();
		SQLException e = assertThrows(SQLException.class, () -> {
			transportadoraBD.buscaPorTipoTransporte(con, queryErrada, 1);
		});
		assertEquals(e.getMessage(), "Não foi possível buscar as transportadoras da base de dados");
	}
	
	@Test
	void buscaPorTipoTransporteTerrestreTest() throws SQLException{
		con = conexao.conectar();
		lista.add(new Transportadora(1, 10.00, 3));
		assertEquals(1, transportadoraBD.buscaPorTipoTransporte(con, queryPorTipoTransporte, 2).size());
	}
	
	@Test
	void buscarPorTipoTransporteTerrestreSQLExceptionTest() throws SQLException{
		con = conexao.conectar();
		SQLException e = assertThrows(SQLException.class, () -> {
			transportadoraBD.buscaPorTipoTransporte(con, queryErrada, 2);
		});
		assertEquals(e.getMessage(), "Não foi possível buscar as transportadoras da base de dados");
	}

}
