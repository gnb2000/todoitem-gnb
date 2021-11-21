package com.todolist.testControllers;

import com.todolist.controllers.UserController;
import com.todolist.exceptions.UserException;
import com.todolist.models.User;
import junit.framework.TestCase;

public class UserControllerTest extends TestCase {

    public void testCreateUser(){
        UserController.getInstance().createUser("admin","admin");
    }

    public void testDeleteUser() {
        try {
            UserController.getInstance().deleteUser(1);
        } catch (UserException e){
            System.out.println(e.getMessage());
        }
    }

    public void testGetUserByUsernameAndPassword(){
        try {
            System.out.println(UserController.getInstance().getUserByUsernameAndPassword("admin","admin").getUsername());
        } catch (UserException e){
            System.out.println(e.getMessage());
        }
    }
}
