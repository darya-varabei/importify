package com.example.importify.Model;

import java.io.Serializable;

public class UserEntry implements Serializable {
    private String login;
    private String password;
    private byte role;

    public UserEntry(String login, String password, byte role){
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

    public byte getRole() { return role; }

    public void setRole(byte role) { this.role = role; }
}
