/**
 * 
 */
package com.jp.db;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class ConnectionUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("JDBC Driver found and Loaded!");

		// Step 2: Create a connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");
		System.out.println("Connected to DB");
		return con;
	}

	public boolean UserExists(String userName, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		final String strQuery = "SELECT count(1) FROM EMPLOYEES WHERE Upper(FIRST_NAME) = ? and LAST_NAME = ?";

		try {
			conn = ConnectionUtil.getConnection();

			ps = conn.prepareStatement(strQuery);
			ps.setString(1, userName.toUpperCase());
			ps.setString(2, password);
			rs = ps.executeQuery();

			rs.next();
			int count = rs.getInt(1);
			System.out.println(count);
			if (count > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (SQLException SQLex) {
			System.out.println(SQLex.getMessage());
			SQLex.printStackTrace();
		} catch (ClassNotFoundException cnfException) {
			System.out.println(cnfException.getMessage());
			cnfException.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException sqlEX) {
				System.out.println(sqlEX.getMessage());
				sqlEX.printStackTrace();
			}

		}
		return flag;

	}

	public ArrayList<String> getDatabaseTables() {
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<String> tableList = new ArrayList<String>();
		try {
			conn = ConnectionUtil.getConnection();
			DatabaseMetaData dbMetaData = conn.getMetaData();
			rs = dbMetaData.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				tableList.add(rs.getString(3));
			}
		} catch (SQLException SQLex) {
			System.out.println(SQLex.getMessage());
			SQLex.printStackTrace();
		} catch (ClassNotFoundException cnfException) {
			System.out.println(cnfException.getMessage());
			cnfException.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException sqlEX) {
				System.out.println(sqlEX.getMessage());
				sqlEX.printStackTrace();
			}

		}
		return tableList;
	}

	public ArrayList<ArrayList<String>> getTableDetails(String tableName) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		final String strQuery = "SELECT * FROM " + tableName;

		ArrayList<String> colNames = new ArrayList<String>();
		ArrayList<ArrayList<String>> dataValues = new ArrayList<ArrayList<String>>();
		try {
			conn = ConnectionUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(strQuery);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int colCount = rsMetaData.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				colNames.add(rsMetaData.getColumnName(i));
			}
			dataValues.add(colNames);
			while (rs.next()) {
				ArrayList<String> rowValues = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {

					rowValues.add(rs.getString(i));
				}
				dataValues.add(rowValues);
			}

		} catch (SQLException SQLex) {
			System.out.println(SQLex.getMessage());
			SQLex.printStackTrace();
		} catch (ClassNotFoundException cnfException) {
			System.out.println(cnfException.getMessage());
			cnfException.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException sqlEX) {
				System.out.println(sqlEX.getMessage());
				sqlEX.printStackTrace();
			}

		}
		return dataValues;

	}

}
