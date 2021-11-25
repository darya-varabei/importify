package com.example.importify.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

    private static User user;
    private int codeUser;
    private UserEntry userEntry;
    private String email;
    private String country;
    private String dateLastAutorization;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }
}
