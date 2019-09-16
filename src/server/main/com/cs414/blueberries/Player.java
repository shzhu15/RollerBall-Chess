package com.cs414.blueberries;

import java.util.ArrayList;
public class Player {
    private String email;
    private String userId;
    private String password;
    private ArrayList<Integer> gameIDs;


    public Player(String email, String userId, String password, ArrayList gameIDs) {
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.gameIDs = gameIDs;
    }




    @Override
    public String toString() {
        return "User email: " + this.email + ", UserId: " + this.userId;
    }

    public ArrayList getGameIDs(){
        return this.gameIDs;
    }
    public String getUserId(){
        return userId;
    }
}
