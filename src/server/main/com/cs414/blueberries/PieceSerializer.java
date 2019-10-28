package com.cs414.blueberries;

import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

public class PieceSerializer implements JsonDeserializer, JsonSerializer<Piece> {

    @Override
    public Piece deserialize(JsonElement piece, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        // System.out.println(piece);
        String pieceType = piece.getAsJsonObject().get("type").getAsString();
        String pieceColor = piece.getAsJsonObject().get("pieceColor").getAsString();
        JsonElement location = piece.getAsJsonObject().get("location");
        int gameId = piece.getAsJsonObject().get("gameId").getAsInt();

        int xLocation = location.getAsJsonObject().getAsJsonPrimitive("x").getAsInt();
        int yLocation = location.getAsJsonObject().getAsJsonPrimitive("y").getAsInt();
        switch (pieceType) {
            case ("ROOK"):
                if (GlobalData.games.get(gameId) == null) {
                    return new Rook(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
                } else {
                    return new Rook(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation), GlobalData.games.get(gameId).getBoard());
                }
            case ("KING"):
                if (GlobalData.games.get(gameId) == null) {
                    return new King(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
                } else {
                    return new King(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation), GlobalData.games.get(gameId).getBoard());
                }
            case ("BISHOP"):
                if (GlobalData.games.get(gameId) == null) {
                    return new Bishop(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
                } else {
                    return new Bishop(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation), GlobalData.games.get(gameId).getBoard());
                }
            case ("PAWN"):
                if (GlobalData.games.get(gameId) == null) {
                    return new Pawn(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
                } else {
                    return new Pawn(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation), GlobalData.games.get(gameId).getBoard());
                }
            default:
                return null;
        }
    }

    @Override
    public JsonElement serialize(Piece piece, Type type, JsonSerializationContext jsonSerializationContext) {

        Gson gson = new Gson();
        JsonElement obj = gson.toJsonTree(piece);
        JsonObject jsonObj = obj.getAsJsonObject();
        jsonObj.addProperty("gameId", piece.board.gameId);
        return jsonObj;
    }
}
