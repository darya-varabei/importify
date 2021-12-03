package com.example.importify.Model;

public class UserView extends UserEntry{
    private Integer id;
    private String lastAccessDate;
    private String country;

    public UserView(String login, String password, Integer id, String lastAccessDate, String country, String role) {
        super(login, password, role);
        this.id = id;
        this.lastAccessDate = lastAccessDate;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return lastAccessDate;
    }

    public void setDate(String lastAccessDated) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }
}
