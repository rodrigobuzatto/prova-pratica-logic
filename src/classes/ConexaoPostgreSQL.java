package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL extends ConexaoBD{

	private String url, user, pass;	
	
	public ConexaoPostgreSQL(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	@Override
	public Connection conectar() throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection(this.url, this.user, this.pass);
		} catch(SQLException e) {
			throw new SQLException("Não foi possível conectar na base de dados.");
		}
		return con;
	}

}
