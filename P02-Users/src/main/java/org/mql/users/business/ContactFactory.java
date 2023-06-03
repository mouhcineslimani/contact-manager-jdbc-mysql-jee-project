package org.mql.users.business;

import org.mql.jdbc.DataBase;
import org.mql.jdbc.DataSource;
import org.mql.jdbc.MySQLDataSourceJDBC;
import org.mql.users.dao.UserDao;
import org.mql.users.dao.UserDaoMySQL;

public class ContactFactory {
	private static ContactService service;
	static {
		DataSource ds = new MySQLDataSourceJDBC("users");
		DataBase db = new DataBase(ds);
		UserDao userDao = new UserDaoMySQL(db);
		service = new ContactServiceDefault(userDao);
	}

	public static ContactService getService() {
		return service;
	}

}
