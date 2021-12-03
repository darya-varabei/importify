package com.example.importify.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User implements Serializable {

    private static User user;
    private int codeUser;
    private UserEntry userEntry;
    private String email;
    private Country country;
    private String codeCountry;
    private String dateLastAutorization;
    private String dateLastExit;

    public User(){}

    public User(int codeUser,
                UserEntry userEntry,
                String email,
                Country country,
                String codeCountry,
                String dateLastAutorization,
                String dateLastExit){
        this.codeUser = codeUser;
        this.userEntry = userEntry;
        this.email = email;
        this.country = country;
        this.codeCountry = codeCountry;
        this.dateLastAutorization = dateLastAutorization;
        this.dateLastExit = dateLastExit;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static User getInstance( int codeUser,
                                    UserEntry userEntry,
                                    String email,
                                    Country country,
                                    String codeCountry,
                                    String dateLastAutorization,
                                    String dateLastExit ) {
        if (user == null) {
            user = new User(codeUser,
                            userEntry,
                            email,
                            country,
                            codeCountry,
                            dateLastAutorization,
                            dateLastExit);
        }
        return user;
    }

    public static User getInstance() {
        return user;
    }

    public String getDateLastExit() {
        return dateLastExit;
    }

    public void setDateLastExit(String dateLastExit) {
        this.dateLastExit = dateLastExit;
    }

    public String getDateLastAutorization() {
        return dateLastAutorization;
    }

    public void setDateLastAutorization(String dateLastAutorization) {
        this.dateLastAutorization = dateLastAutorization;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }
}
