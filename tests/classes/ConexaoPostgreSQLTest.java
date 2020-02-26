package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ConexaoPostgreSQLTest {
	
	Connection con = null;
	ConexaoPostgreSQL conexao = new ConexaoPostgreSQL("jdbc:postgresql://localhost:5432/logic", "logic", "logic");
	ConexaoPostgreSQL conexaoErrada = new ConexaoPostgreSQL("jdbc:postgresql://localhost:5432/logic", "logic", "logic2");
	
	@Test
	void conexaoComSucesso() throws SQLException {
		con = conexao.conectar();
		assertNotNull(con);
	}
	
	@Test
	void conexaoSemSucesso() throws SQLException {				
		SQLException e = assertThrows(SQLException.class, () -> {
			conexaoErrada.conectar();
		});
		assertEquals(e.getMessage(), "Não foi possível conectar na base de dados.");
	}
}
