package com.cs414.blueberries;

import static spark.Spark.*;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import spark.Filter;

public class GameApi {
    public static void main(String[] args) {
        GlobalData.readPlayers(GlobalData.PLAYERS_FILENAME);
        System.out.println(GlobalData.players);
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        get("/hello", (req, res) -> "Hello World");
        post("/register", (req, res) -> {
            Gson gson = new Gson();
            Player player = gson.fromJson(req.body(), Player.class);
            System.out.println("Registering new player: " + player.toString());
            return player.register();
        });
    }


}