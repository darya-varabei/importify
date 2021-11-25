package com.example.importify.Model;

import java.io.Serializable;

public class UserRegister extends UserEntry {
    private String passwordRep;

    public UserRegister(String txtFieldLoginText, String text, String passwordRep) {
        super();
       this.passwordRep = passwordRep;
    }

    public String getRepPassword() {
        return passwordRep;
    }

    public void setRepPassword(String passwordRep) {
        this.passwordRep = passwordRep;
    }
}
