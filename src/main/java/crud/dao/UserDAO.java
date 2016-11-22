package crud.dao;

import crud.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();

    public List<User> getUsers(String str);

    public void saveUser(User user);

    public User getUser(int userId);

    public void deleteUser(int userId);

}
