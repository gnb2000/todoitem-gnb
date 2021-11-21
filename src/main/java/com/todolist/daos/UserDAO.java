package com.todolist.daos;

import com.todolist.dbConnection.EManagerUtil;
import com.todolist.exceptions.UserException;
import com.todolist.models.Item;
import com.todolist.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class UserDAO {

    private static UserDAO instance;

    private UserDAO() {}

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public void save(User user){
        EntityManager em = EManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User getUserById(Integer id) throws UserException {
        try{
            EntityManager em = EManagerUtil.getEntityManager();
            User user = (User) em.createQuery("FROM User WHERE status = true AND id="+id).getSingleResult();
            em.close();
            return user;
        } catch (NoResultException e){
            throw new UserException("User not found with id "+id);
        }
    }

    public void update(User user){
        EntityManager em = EManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public User getUserByUsernameAndPassword(String username, String password) throws UserException {
        try{
            EntityManager em = EManagerUtil.getEntityManager();
            User user = (User) em.createQuery("SELECT u FROM User u WHERE u.username='"+username+"' AND u.password='"+password+"'").getSingleResult();
            em.close();
            return user;
        } catch (NoResultException e){
            throw new UserException("User not found with username "+username+" and password "+password);
        }
    }



}
