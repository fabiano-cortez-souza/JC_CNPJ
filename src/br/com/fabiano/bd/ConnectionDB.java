package br.com.fabiano.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.fabiano.infra.GetProperties;

public class ConnectionDB {

	public Connection getConnection() throws Exception {
		Connection connection = null;

		Properties prop = new GetProperties().getProperties();
		
		String db = prop.getProperty("dbtipo");
		String driver = prop.getProperty(db + "_db_driver");
		String connString = prop.getProperty(db + "_db_conn");
		String user = prop.getProperty(db + "_db_user");
		String password = prop.getProperty(db + "_db_pass");

		System.out.println("-------- " + db + " JDBC Connection Testing ------");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your " + db + " JDBC Driver?");
			e.printStackTrace();
		}
		System.out.println(db + " JDBC Driver Registered!");

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(connString, user, password);
			// return;
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			// return;
		}
		return connection;
	}
}
