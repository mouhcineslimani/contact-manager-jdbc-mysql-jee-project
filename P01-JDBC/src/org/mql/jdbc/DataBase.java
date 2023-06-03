package org.mql.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private Connection cnx;

	public DataBase(DataSource ds) {
		super();
		this.cnx = ds.getConnetion();
	}

	public String[][] selectQuery(String query) {
		try {
			Statement sql = cnx.createStatement();
			ResultSet rs = sql.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();
			rs.last();
			int rows = rs.getRow();
			int cols = rsm.getColumnCount();
			String data[][] = new String[rows + 1][cols];
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			rs.beforeFirst();
			int row = 0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}
			}
			rs.close();
			return data;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	public String[][] select() {
		return selectQuery("SELECT * FROM users");
	}

	public String[][] selectByKeyword(String keyword) {
		return selectQuery("SELECT * FROM users WHERE firstname LIKE '%" + keyword + "%' OR lastname LIKE '%" + keyword
				+ "%' OR phone LIKE '%" + keyword + "%' OR address LIKE '%" + keyword + "%'");
	}

	public String[][] selectById(int id) {
		return selectQuery("SELECT * FROM users WHERE id = " + id);
	}

	public int queryUpdate(String query) { 
		try {
			Statement sql = cnx.createStatement();
			int count = sql.executeUpdate(query);
			return count;
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
			return -1;
		}
	}

	public int insert(int id, String... fields) {
		return queryUpdate("INSERT INTO users (id,firstname,lastname,address,phone) VALUES (" + id + ",'" + fields[0]
				+ "','" + fields[1] + "','" + fields[2] + "','" + fields[3] + "')");
	}

	public int update(int id, String... fields) {
		return queryUpdate("UPDATE users SET firstname = '" + fields[0] + "', lastname = '" + fields[1]
				+ "', address = '" + fields[2] + "', phone = '" + fields[3] + "' WHERE id = " + id);
	}

	public int delete(int id) {
		return queryUpdate("DELETE FROM users WHERE id=" + id);
	}
}
