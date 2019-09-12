package com.cs414.blueberries;

public class Player {
    private String email;
    private String userId;
    private String password;

    public Player(String email, String userId, String password) {
        this.email = email;
        this.userId = userId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User email: " + this.email + ", UserId: " + this.userId;
    }
}
