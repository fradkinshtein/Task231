package task231.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task231.crud.dao.UserDAO;
import task231.crud.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public int save(User u) {
        return userDAO.save(u);
    }

    @Override
    public int update(User u) {
        return userDAO.update(u);
    }

    @Override
    public User get(Integer id) {
        return userDAO.get(id);
    }

    @Override
    public int delete(Integer id) {
        return userDAO.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
