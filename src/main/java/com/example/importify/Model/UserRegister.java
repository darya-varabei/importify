package com.example.importify.Model;

import java.io.Serializable;

public class UserRegister extends UserEntry {
    private int codeUser;
    private String passwordRep;
    private String email;

    public UserRegister(String login, String password, String passwordRep, String email) {
        super(login, password, "User");
        this.passwordRep = passwordRep;
        this.email = email;
    }

    public String getRepPassword() {
        return passwordRep;
    }

    public void setRepPassword(String passwordRep) {
        this.passwordRep = passwordRep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(int codeUser) {
        this.codeUser = codeUser;
    }
}
