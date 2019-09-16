package com.cs414.blueberries;
import com.google.gson.Gson;
import org.eclipse.jetty.util.ArrayUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.ArrayList;


public class GlobalData {
    public static HashMap<String, Player> players = new HashMap<>();
    public static ArrayList<Integer> games = new ArrayList<>();

    public static void readPlayers(String filename){
        Gson gson = new Gson();
        try  {
            Player [] playersArray = gson.fromJson(new FileReader(filename), Player[].class);
            for (Player player : playersArray)
                players.put(player.getUserId(), player);

        } catch (FileNotFoundException ignored) {

        }

    }
}