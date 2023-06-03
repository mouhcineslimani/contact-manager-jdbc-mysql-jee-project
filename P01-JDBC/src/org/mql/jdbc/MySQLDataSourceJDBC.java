package org.mql.jdbc;

public class MySQLDataSourceJDBC extends DataSource {
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_BRIDGE = "jdbc:mysql:";

	public MySQLDataSourceJDBC(String host, String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, password);
	}

	public MySQLDataSourceJDBC(String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, user, password);
	}

	public MySQLDataSourceJDBC(String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", "mysql", user, password);
	}

	public MySQLDataSourceJDBC(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "");
	}

	public MySQLDataSourceJDBC() {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", "mysql", "root", "");
	}

}
