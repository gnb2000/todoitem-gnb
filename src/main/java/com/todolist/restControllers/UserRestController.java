package com.todolist.restControllers;

import com.todolist.controllers.UserController;
import com.todolist.exceptions.UserException;
import com.todolist.vo.UserVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @PostMapping("/createUser")
    @CrossOrigin(origins="http://localhost:3000/")
    public void createUser(@RequestParam(name="username") String username, @RequestParam(name="password") String password){
        UserController.getInstance().createUser(username,password);
    }

    @RequestMapping("/getUserById")
    @CrossOrigin(origins="http://localhost:3000/")
    public UserVO getUserById(@RequestParam(name="user_id") int user_id) throws UserException {
        return UserController.getInstance().getUserById(user_id);
    }

    @RequestMapping("/getUserByUsernameAndPassword")
    @CrossOrigin(origins="http://localhost:3000/")
    public UserVO getUserByUsernameAndPassword(@RequestParam(name="username") String username, @RequestParam(name="password") String password) throws UserException {
        return UserController.getInstance().getUserByUsernameAndPassword(username, password);
    }


}
