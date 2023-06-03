package org.mql.users.dao;

import java.util.List;

import org.mql.jdbc.DataBase;
import org.mql.users.dao.mapper.UserMapper;
import org.mql.users.models.User;

public class UserDaoMySQL implements UserDao {

	private DataBase db;
	private int count;

	public UserDaoMySQL(DataBase db) {
		super();
		this.db = db;
	}

	@Override
	public List<User> select() {
		return UserMapper.toList(db.select());
	}

	@Override
	public User selectById(int id) {
		return UserMapper.toList(db.selectById(id)).get(0);
	}

	@Override
	public List<User> selectByKeyword(String keyword) {
		return UserMapper.toList(db.selectByKeyword(keyword));
	}

	@Override
	public boolean insert(User user) {
		count = db.insert(user.getId(), user.getFirstname(), user.getLastname(), user.getAddress(), user.getPhone());
		return count == 1 ? true : false;
	}

	@Override
	public boolean update(int id, User user) {
		count = db.update(id, user.getFirstname(), user.getLastname(), user.getAddress(), user.getPhone());
		return count == 1 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		count = db.delete(id);
		return count == 1 ? true : false;
	}
}
