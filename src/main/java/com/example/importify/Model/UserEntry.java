package com.example.importify.Model;

import java.io.Serializable;

public class UserEntry implements Serializable {
    protected String login;
    protected String password;
    protected String role;

    public UserEntry(String login, String password, String role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

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

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
