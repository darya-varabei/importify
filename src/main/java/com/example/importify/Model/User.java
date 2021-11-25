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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public LocalDate getDateLastExit() {
        return dateLastExit;
    }

    public void setDateLastExit(LocalDate dateLastExit) {
        this.dateLastExit = dateLastExit;
    }

    public LocalDate getDateLastAutorization() {
        return dateLastAutorization;
    }

    public void setDateLastAutorization(LocalDate dateLastAutorization) {
        this.dateLastAutorization = dateLastAutorization;
    }
}
