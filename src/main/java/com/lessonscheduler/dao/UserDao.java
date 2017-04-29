package com.lessonscheduler.dao;

import com.lessonscheduler.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Günay on 4.4.2017.
 */

@Repository
public class UserDao extends GenericDao<User> {
    public UserDao() {
        super(User.class);
    }

    public List<User> findByUsername(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsername", User.class);
        query.setParameter(1, username);
        return query.getResultList();
    }

    public User findByUsernameAndPassword(User user) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsernameAndPassword", User.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return query.getSingleResult();
    }
}
