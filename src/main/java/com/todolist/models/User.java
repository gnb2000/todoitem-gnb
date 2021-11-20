package com.todolist.models;

import com.todolist.daos.UserDAO;
import com.todolist.vo.UserVO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password; //Password should be hashed
    @OneToMany(mappedBy="user", orphanRemoval=true, cascade = CascadeType.ALL)
    private List<Folder> folders;
    private boolean status;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.status = true;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserVO toVO(){
        return new UserVO(this.id,this.username,this.password);
    }

    public void save(){
        UserDAO.getInstance().save(this);
    }

    public void update(){
        UserDAO.getInstance().update(this);
    }
}
