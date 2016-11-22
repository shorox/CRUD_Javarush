package crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import crud.dao.UserDAO;
import crud.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // Inject User dao
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional
    public List<User> getUsers(String str) {
        return userDAO.getUsers(str);
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Transactional
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }

}
