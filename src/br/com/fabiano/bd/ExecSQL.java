package br.com.fabiano.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecSQL {

	private boolean status = false;

	/*
	 * public ExecSQL(String sqlSentence) throws Exception { return
	 * exec(sqlSentence); }
	 */

	public boolean testeDB() {
		Connection conn;
		try {
			conn = new ConnectionDB().getConnection();
			if (conn != null) {
				setStatus(true);
				if (!conn.isClosed()) {
					conn.close();
				}
			} else {
				setStatus(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean exec(String query, Connection conn) throws Exception {
		conn = new ConnectionDB().getConnection();
		if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		Statement stmt = null;
		// String query = sqlSentence;
		try {

			stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.toString());
				/*
				 * String coffeeName = rs.getString("COF_NAME"); int supplierID =
				 * rs.getInt("SUP_ID"); float price = rs.getFloat("PRICE"); int sales =
				 * rs.getInt("SALES"); int total = rs.getInt("TOTAL");
				 * System.out.println(coffeeName + "\t" + supplierID + "\t" + price + "\t" +
				 * sales + "\t" + total);
				 */
			}
			setStatus(true);
		} catch (SQLException e) {
			// JDBCTutorialUtilities.printSQLException(e);
			System.out.println(e.getMessage().toString());
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			setStatus(false);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return status;
	}

	public boolean execInsert(String query, Connection conn) throws Exception {

		if (conn != null) {
			//System.out.println("You made it, take control your database now!");

			Statement stmt = null;
			// String query = sqlSentence;
			try {

				// execute insert SQL stetement
				stmt = (Statement) conn.createStatement();
				stmt.executeUpdate(query);

				setStatus(true);
			} catch (SQLException e) {
				// JDBCTutorialUtilities.printSQLException(e);
				System.out.println(e.getMessage().toString());
				System.out.println(e.getErrorCode());
				System.out.println(e.getSQLState());
				setStatus(false);
			} finally {
				if (stmt != null) {
					stmt.close();
				}
			}
		} else {
			System.out.println("Failed to make connection!");
			setStatus(false);
		}

		return status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
