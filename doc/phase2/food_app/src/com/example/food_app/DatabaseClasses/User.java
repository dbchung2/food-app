package com.example.food_app.DatabaseClasses;

/**
 * Created by Matt on 2015-11-01.
 */
public class User {
    String username;
    String password;
    String firstname;
    String lastname;
    public User(String username, String password, String firstname, String lastname){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
