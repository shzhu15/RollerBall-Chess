package com.cs414.blueberries;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import jdk.nashorn.internal.objects.Global;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import spark.Filter;
import spark.Request;
import spark.Response;

public class GameApi {
    public static void main(String[] args) {

        GlobalData.readPlayers(GlobalData.PLAYERS_FILENAME);
        GlobalData.readGames(GlobalData.GAMES_FILENAME);

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "*");
            response.header("Access-Control-Allow-Headers", "*");

        });
//        after((Filter) (request, response) -> {
//            response.header("Access-Control-Allow-Origin", "*");
//            response.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
//            response.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, PATCH, DELETE");
//        });

        get("/hello", (req, res) -> "Hello World");

        // Register new player
        post("/register", (req, res) -> {
            Gson gson = new Gson();
            Player player = gson.fromJson(req.body(), Player.class);
            System.out.println("Registering new player: " + player.toString());
            return player.register();
        });

        // Log in player
        post("/login", (req, res) -> {
            System.out.println(req.body());
            JSONObject body = (JSONObject) new JSONParser().parse(req.body());
            Player player = GlobalData.players.get(body.get("email"));
            if (player != null) {
                return player.buildLoginResponse((String) body.get("password"), body);
            }
            return "fail";
        });

        // Send an updated board
        post("/game", (req, res) -> {
           System.out.println(req.body());
           Gson gson = new Gson();
           Game game = gson.fromJson(req.body(), Game.class);
           if (game != null) {
               GlobalData.games.put(game.getId(), game);
               return "Board updated";
           }
           return "Board not found";
        });

        // Get all games that a player is a part of
        get("/game", (req, res) -> {
            Gson gson = new Gson();
            System.out.println(req.body());
            JSONObject body = (JSONObject) new JSONParser().parse(req.body());

            HashMap<String, ArrayList<Game>> gamesMap = new HashMap<>();

            gamesMap.put("sent", new ArrayList<>());
            gamesMap.put("pending", new ArrayList<>());
            gamesMap.put("active", new ArrayList<>());

            GlobalData.games.forEach((id, game) -> {
                if (!game.ready) {
                    if (game.getP1().equals(body.get("email"))) gamesMap.get("sent").add(game);
                    if (game.getP2().equals(body.get("email"))) gamesMap.get("pending").add(game);
                }
                else {
                    gamesMap.get("active").add(game);
                }
            });
            return gson.toJson(gamesMap);
        });

        post("/acceptInvite", (req, res) -> {
            JSONObject body = (JSONObject) new JSONParser().parse(req.body());
            GlobalData.games.get(Integer.parseInt((String) body.get("id"))).ready = true;
            return "Invite accepted";
        });

        post("/sendInvite", (req, res) -> {
           System.out.println(req.body());
           JSONObject body = (JSONObject) new JSONParser().parse(req.body());
           Game game = new Game((String) body.get("p1"), (String) body.get("p2"));
           GlobalData.games.put(game.getId(), game);
           GlobalData.writeGames(GlobalData.GAMES_FILENAME);
           return "Game created: " + game.toString();
        });

    }

}