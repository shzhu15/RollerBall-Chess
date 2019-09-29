package com.cs414.blueberries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    public static HashMap<Integer, Game> games = new HashMap<>();


    public static void readPlayers(String filename){
        Gson gson = new Gson();
        try  {
            Reader reader = new FileReader(filename);
            Player [] playersArray = gson.fromJson(reader, Player[].class);
            for (Player player : playersArray)
                players.put(player.getEmail(), player);
            reader.close();
        } catch (FileNotFoundException notIgnored) {
            notIgnored.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePlayers(String filename){
        Gson gson = new Gson();
        try {
            Writer fileWriter = new FileWriter(filename);
            gson.toJson(GlobalData.players.values(), fileWriter);
            System.out.println("writing players file : " + filename);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readGames(String filename){
        Gson gson = new GsonBuilder().registerTypeAdapter(Piece.class, new PieceDeserializer()).create();
        try  {
            Game[] gamesArray = gson.fromJson(new FileReader(filename), Game[].class);
            for (Game game : gamesArray)
                games.put(game.getId(), game);
        } catch (FileNotFoundException notIgnored) {
            notIgnored.printStackTrace();
        }
    }
    public static void writeGames(String filename){
        Gson gson = new Gson();
        try {
            Writer fileWriter = new FileWriter(filename);
            gson.toJson(GlobalData.games.values(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}