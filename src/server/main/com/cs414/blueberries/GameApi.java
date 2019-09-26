package com.cs414.blueberries;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;

import spark.Filter;
import spark.Request;
import spark.Response;

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
        post("/login", (req, res) -> {
            System.out.println(req.body());
            JSONObject body = (JSONObject) new JSONParser().parse(req.body());
            Player player = GlobalData.players.get(body.get("email"));
            if (player != null)
                return player.buildLoginResponse((String) body.get("password"), body);

            return null;
        });


    }

}