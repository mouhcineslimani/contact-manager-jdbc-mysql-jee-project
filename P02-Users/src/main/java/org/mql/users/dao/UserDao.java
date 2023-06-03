package org.mql.users.dao;

import java.util.List;

import org.mql.users.models.User;

public interface UserDao {

	public List<User> select();

	public User selectById(int id);

	public List<User> selectByKeyword(String keyword);

	public boolean insert(User user);

	public boolean update(int id, User user);

	public boolean delete(int id);
}
