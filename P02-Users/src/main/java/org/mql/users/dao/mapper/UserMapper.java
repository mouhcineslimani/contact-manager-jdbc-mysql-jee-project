package org.mql.users.dao.mapper;

import java.util.List;
import java.util.Vector;

import org.mql.users.models.User;

public class UserMapper {

	public static List<User> toList(String[][] data) {
		List<User> users = new Vector<>();
		for (int i = 0; i < data.length; i++) {
			users.add(row(data[i]));
		}
		return users;
	}

	private static User row(String[] row) {
		return new User(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4]);
	}
}
