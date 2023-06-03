package org.mql.users.business;

import java.util.List;

import org.mql.users.models.User;

public interface ContactService {
	public List<User> users();

	public List<User> usersByKeyword(String keyword);

	public User userById(int id);

	public boolean addUser(User user);

	public boolean updateUser(int id, User user);

	public boolean deleteUser(int id);
}
