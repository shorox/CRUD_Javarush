package crud.dao;

import crud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    // Inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUsers() {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query sorted by name
        Query<User> query = currentSession.createQuery("from User order by name", User.class);

        // Execute query and get result list
        List<User> users = query.getResultList();

        // Return the results
        return users;
    }

    public List<User> getUsers(String str) {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query sorted by name
        Query<User> query = currentSession.createQuery("from User where name like CONCAT('%',:str,'%') order by name", User.class);
        query.setParameter("str", str);

        // Execute query and get result list
        List<User> users = query.getResultList();

        // Return the results
        return users;
    }

    public void saveUser(User user) {

        // Get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save/update the user
        session.saveOrUpdate(user);
    }

    public User getUser(int userId) {

        // Get the hibernate current session
        Session session = sessionFactory.getCurrentSession();

        // retreve/read from database using the primary key
        User user = session.get(User.class, userId);

        // Return the user
        return user;
    }

    public void deleteUser(int userId) {

        // Get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Delete object by primary key
        Query query = session.createQuery("delete from User where id=:userId");
        query.setParameter("userId", userId);

        query.executeUpdate();

    }

}
