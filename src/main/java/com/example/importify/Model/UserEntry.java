package com.example.importify.Model;

import java.io.Serializable;

public class UserEntry implements Serializable {
    private String login;
    private String password;

    public UserEntry(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
