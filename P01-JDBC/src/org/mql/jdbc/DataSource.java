package org.mql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	private String driver;
	private String bridge;
	private String host;
	private String source;
	private String user;
	private String password;

	public DataSource() {
	}

	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnetion() {
		try {
			Class.forName(driver);
			String url = bridge + "/" + host + "/" + source;
			Connection cnx = DriverManager.getConnection(url, user, password);
			System.out.println("Connesction is established ...");
			return cnx;
		} catch (Exception e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}

}
