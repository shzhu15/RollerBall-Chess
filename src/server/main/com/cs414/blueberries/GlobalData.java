package com.cs414.blueberries;
import com.google.gson.Gson;
import org.eclipse.jetty.util.ArrayUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;


public class GlobalData {

    public static String PLAYERS_FILENAME = "./JSONfiles/Players.json";
    public static String GAMES_FILENAME = "./JSONfiles/Games.json";

    public static HashMap<String, Player> players = new HashMap<>();
    public static ArrayList<Integer> games = new ArrayList<>();

    public static void readPlayers(String filename){
        Gson gson = new Gson();
        try  {
            Player [] playersArray = gson.fromJson(new FileReader(filename), Player[].class);
            for (Player player : playersArray)
                players.put(player.getEmail(), player);
        } catch (FileNotFoundException notIgnored) {
            notIgnored.printStackTrace();
        }
    }

    public static void writePlayers(String filename){
        Gson gson = new Gson();
        try {
            Writer fileWriter = new FileWriter(filename);
            gson.toJson(GlobalData.players.values(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}