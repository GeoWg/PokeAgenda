package com.example.george.pokeagenda;

/**
 * Created by George on 6/13/2018.
 */

public class User {
    public String id;
    public String username;
    public String password;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
