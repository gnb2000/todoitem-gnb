package com.todolist.controllers;

import com.todolist.daos.UserDAO;
import com.todolist.exceptions.UserException;
import com.todolist.models.User;
import com.todolist.vo.UserVO;

public class UserController {

    private static UserController instance;

    private UserController() {}

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public void createUser(String username, String password){
        User user = new User(username, password);
        user.save();
    }

    public UserVO getUserById(Integer id) throws UserException {
        return UserDAO.getInstance().getUserById(id).toVO();
    }

    public void deleteUser(Integer id) throws UserException {
        User user = UserDAO.getInstance().getUserById(id);
        user.setStatus(false);
        user.update();
    }
}
