package com.cs414.blueberries;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestGame {

    @Test
    public void testCreateNewGame(){
        String p1 = "p1";
        String p2 = "p2";

        Game game = new Game(p1, p2, "1", "2");
        game.toString();

        assertEquals(false, game.ready);
        assertEquals("p1",game.getP1());
        assertEquals("p2", game.getP2());


    }
}
