package com.cs414.blueberries;

import jdk.nashorn.internal.objects.Global;
import org.json.simple.JSONObject;
import spark.Request;

import java.util.ArrayList;
import java.util.Map;

public class Player {
    private String email;
    private String UserID;
    private String password;
    private ArrayList<Integer> gameIDs;


    public Player(String email, String userId, String password, ArrayList gameIDs) {
        this.email = email;
        this.UserID = userId;
        this.password = password;
        this.gameIDs = gameIDs;
        this.register();
    }

    public Player(String email, String userId, String password) {
        this.email = email;
        this.UserID = userId;
        this.password = password;
        this.gameIDs = new ArrayList<Integer>();
        this.register();
    }


    public boolean register() {
        if (GlobalData.players.containsKey(this.email)) return false;
        GlobalData.players.put(this.email, this);
        GlobalData.writePlayers(GlobalData.PLAYERS_FILENAME);
        System.out.println("Players file updated");
        return true;
    }

    public String buildLoginResponse(String password, JSONObject requestBody){
        if (password.equals(this.password)){
            requestBody.put("UserID", UserID);
            requestBody.put("success", true);
            requestBody.put("activeGameIDs", gameIDs);

        }
        else{
            requestBody.put("success", false);
        }
        return requestBody.toJSONString();
    }

    public boolean sendInvite (String senderId, String recipientId) {
        Game game = new Game(senderId, recipientId);
        GlobalData.games.put(game.getId(), game);
        Player p1 = GlobalData.players.get(senderId);
        Player p2 = GlobalData.players.get(recipientId);
        p1.getGameIDs().add(game.getId());
        p2.getGameIDs().add(game.getId());
        return true;
    }

    public boolean acceptInvite (String senderId, String recipientId, int gameId) {
        Game game = GlobalData.games.get(gameId);
        if(!game.ready) { // This means that the invite hasn't been accepted and that the game isn't ready
            game.ready = true;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "User email: " + this.email + ", UserID: " + this.UserID;
    }

    public ArrayList getGameIDs(){
        return this.gameIDs;
    }
    public String getUserId(){
        return UserID;
    }
    public String getEmail(){return email;}
}
