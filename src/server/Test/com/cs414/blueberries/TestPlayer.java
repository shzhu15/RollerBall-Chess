package com.cs414.blueberries;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestPlayer {

    @Test
    public void testCreateNewPlayer(){
        Player player = new Player("email@email.com", "userID", "secure");
        player.toString();
        assertEquals(player.toString(), "User email: email@email.com, UserId: userID");

    }
}