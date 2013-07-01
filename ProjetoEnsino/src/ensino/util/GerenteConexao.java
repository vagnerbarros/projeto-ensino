
package ensino.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenteConexao {

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/ensino";
	public static String user = "root";
	public static String passw = "";
	static Connection con;

	private GerenteConexao(){

	}

	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, passw);
		return con;
	}
}
