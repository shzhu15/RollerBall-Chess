package com.cs414.blueberries;

import static spark.Spark.*;
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
        GlobalData.readPlayers("./JSONfiles/Players.json");
        System.out.println(GlobalData.players);
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        get("/hello", (req, res) -> "Hello World");
    }


}