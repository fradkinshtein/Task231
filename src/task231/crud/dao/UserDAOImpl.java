package task231.crud.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;
import task231.crud.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(User u) {
		String sql = "INSERT INTO users (name, email, address, phone, username, password) VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, u.getName(), u.getEmail(), u.getAddress(), u.getPhone(), u.getUsername(), u.getPassword());
	}

	@Override
	public int update(User u) {
		String sql = "UPDATE users Set name=?, email=?, address=?, username=?, password=?, phone=? WHERE id=?";
		return jdbcTemplate.update(sql, u.getName(), u.getEmail(), u.getAddress(), u.getPhone(), u.getUsername(), u.getPassword(), u.getId());

	}

	@Override
	public User get(Integer id) {
		String sql = "SELECT * FROM users WHERE id=" + id;
		ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String username = rs.getString("username");
					String password = rs.getString("password");
					return new User(id, name, email, address, phone, username, password);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM users WHERE id =" + id;

		return jdbcTemplate.update(sql);
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		RowMapper<User> rowMapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String username = rs.getString("username");
				String password = rs.getString("password");
				return new User(id, name, email, address, phone, username, password);
			}
		};
		
		return jdbcTemplate.query(sql, rowMapper);
		
	}

}
