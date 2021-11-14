package com.example.importify.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

    private int codeUser;
    private UserEntry userEntry;
    private String email;
    private Country country;
    private String codeCountry;
    private LocalDate dateLastAutorization;
    private LocalDate dateLastExit;

    public User(){}

    public int getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(int codeUser) {
        this.codeUser = codeUser;
    }

    public UserEntry getUserEntry() {
        return userEntry;
    }

    public void setUserEntry(UserEntry userEntry) {
        this.userEntry = userEntry;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
