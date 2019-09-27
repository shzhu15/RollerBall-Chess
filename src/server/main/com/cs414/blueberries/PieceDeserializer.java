package com.cs414.blueberries;

import com.google.gson.*;
import java.awt.*;
import java.lang.reflect.Type;

public class PieceDeserializer implements JsonDeserializer {

    @Override
    public Piece deserialize(JsonElement piece, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String pieceType = piece.getAsJsonObject().get("type").getAsString();
        String pieceColor = piece.getAsJsonObject().get("pieceColor").getAsString();
        JsonElement location = piece.getAsJsonObject().get("location");

        int xLocation = location.getAsJsonObject().getAsJsonPrimitive("x").getAsInt();
        int yLocation = location.getAsJsonObject().getAsJsonPrimitive("y").getAsInt();
        switch(pieceType){
            case ("ROOK"):
                return new Rook(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
            case ("KING"):
                return new King(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
            case ("BISHOP"):
                return new Bishop(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));
            case ("PAWN"):
                return new Pawn(Enum.valueOf(PieceColor.class, pieceColor), new Point(xLocation, yLocation));

            default:
                return null;
        }
    }
}
