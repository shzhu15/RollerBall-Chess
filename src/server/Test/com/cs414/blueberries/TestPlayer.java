package com.cs414.blueberries;

import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class TestPlayer {

    @Test
    public void testCreateNewPlayer(){
        ArrayList<Integer> gameIDs = new ArrayList<>();
        gameIDs.add(1);
        gameIDs.add(2);
        Player player = new Player("email@email.com", "userID", "secure", gameIDs );
        player.toString();
        assertEquals(player.toString(), "User email: email@email.com, UserId: userID");
        assertEquals(player.getGameIDs(), gameIDs);

    }

    @Test
    public void testCreateNewPlayerNoGameIds(){
        ArrayList<Integer> gameIDs = new ArrayList<>();
        Player player = new Player("email@email.com", "userID", "secure" );
        player.toString();
        assertEquals(player.toString(), "User email: email@email.com, UserId: userID");
        assertEquals(player.getGameIDs(), gameIDs);

    }
    @Test
    public void testBuildLoginResponseCorrectPassword(){
        JSONObject json = new JSONObject();
        ArrayList<Integer> gameIds = new ArrayList<>();
        gameIds.add(1);
        Player player = new Player("email", "id", "password", gameIds);
        String response = player.buildLoginResponse("password", json );
        String expectedResponse = "{\"UserID\":\"id\",\"success\":true,\"activeGameIDs\":[1]}";
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testBuildLoginResponseIncorrectPassword(){
        JSONObject json = new JSONObject();
        ArrayList<Integer> gameIds = new ArrayList<>();
        gameIds.add(1);
        Player player = new Player("email", "id", "password", gameIds);
        String response = player.buildLoginResponse("wrong", json );
        String expectedResponse = "{\"success\":false}";
        assertEquals(expectedResponse, response);
    }
}