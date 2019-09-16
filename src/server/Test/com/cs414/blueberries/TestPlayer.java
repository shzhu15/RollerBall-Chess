package com.cs414.blueberries;

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
}