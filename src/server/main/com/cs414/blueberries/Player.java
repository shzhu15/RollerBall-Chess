package com.cs414.blueberries;

import java.util.ArrayList;
import java.util.Map;

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
        this.register();
    }

    public Player(String email, String userId, String password) {
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.gameIDs = new ArrayList<Integer>();
        this.register();
    }


    public boolean register() {
        if (GlobalData.players.containsKey(this.userId)) return false;
        GlobalData.players.put(this.userId, this);
        GlobalData.writePlayers(GlobalData.PLAYERS_FILENAME);
        return true;
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
