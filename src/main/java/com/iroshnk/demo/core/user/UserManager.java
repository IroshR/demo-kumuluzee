package com.iroshnk.demo.core.user;

import com.iroshnk.demo.model.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class UserManager {
    @PersistenceContext
    private EntityManager em;

    public User getUser(int userId) {
        return em.find(User.class, userId);
    }
}
