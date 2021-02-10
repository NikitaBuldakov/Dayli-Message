package org.buldakov.dailymassage.Models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class User {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String login;

    @Size(min = 2, max = 30, message = "Password should be between 2 and 30 characters")
    public String password;

    @NotEmpty(message = "Error input")
    public boolean admin;

    public User() {

    }

    public User(int id, String login, String password, boolean admin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
