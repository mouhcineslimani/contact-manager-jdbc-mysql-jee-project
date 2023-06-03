package org.mql.users.business;

import java.util.List;

import org.mql.users.dao.UserDao;
import org.mql.users.models.User;

public class ContactServiceDefault implements ContactService {

	private UserDao userDao;

	public ContactServiceDefault(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> users() {
		return userDao.select();
	}

	@Override
	public List<User> usersByKeyword(String keyword) {
		return userDao.selectByKeyword(keyword);
	}

	@Override
	public User userById(int id) {
		return userDao.selectById(id);
	}

	@Override
	public boolean addUser(User user) {
		return userDao.insert(user);
	}

	@Override
	public boolean updateUser(int id, User user) {
		return userDao.update(id, user);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.delete(id);
	}

}
