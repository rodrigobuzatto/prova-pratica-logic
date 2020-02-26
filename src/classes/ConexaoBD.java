package classes;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConexaoBD {
	public abstract Connection conectar() throws SQLException;
}
