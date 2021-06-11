package task231.crud.dao;

import java.util.List;

import task231.crud.model.User;

public interface UserDAO {
	public int save(User u);

	public int update(User u);

	public User get(Integer id);

	public int delete(Integer id);

	public List<User> getAllUsers();

}
