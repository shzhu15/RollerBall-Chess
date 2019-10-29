package com.cs414.blueberries;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class TestGlobalData{

    @Test
    public void test1(){
        GlobalData.readPlayers("./TestFiles/TestPlayers.json");
        Player hippy = GlobalData.players.get("email@email.com");
        ArrayList<Integer> expectedGameIDsHippy = new ArrayList<>();
        expectedGameIDsHippy.add(1);
        expectedGameIDsHippy.add(2);
        expectedGameIDsHippy.add(3);
        assertEquals(hippy.getGameIDs(), expectedGameIDsHippy);

        assertEquals(hippy.getUserId(), "hippy123");
    }
    @Test
    public void testFileNotFound(){
        GlobalData.players.clear();
        GlobalData.readPlayers("./TestFiles/noHweretobefound.json");

        assert(GlobalData.players.isEmpty());
    }

    @Test
    public void testReadGames(){
        GlobalData.readGames("./TestFiles/TestGames.json");
        Game g1 = GlobalData.games.get(-195438572);
        String p1 = g1.getP1();
        GlobalData.writeGames("./TestFiles/TestGames.json");
        assertEquals("p1", p1);
        GlobalData.games.clear();
    }

    @After
    public void clearData(){
        GlobalData.players.clear();
        GlobalData.games.clear();
    }
}