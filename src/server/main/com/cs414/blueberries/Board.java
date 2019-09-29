package com.cs414.blueberries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;


public class Board {

    // If the opposing king gets here its game over
    // 0,0 Is Top Left
    private final Point WHITE_STARTING_LOCATION = new Point(3,5);
    private final Point BLACK_STARTING_LOCATION = new Point(3,1);
    private ArrayList<Piece> pieces;

    public Board(){
        this.pieces = new ArrayList<Piece>();
        pieces.add(new King(PieceColor.BLACK, BLACK_STARTING_LOCATION));
        pieces.add(new Rook(PieceColor.BLACK, new Point(4, 0)));
        pieces.add(new Rook(PieceColor.BLACK, new Point(4, 1)));
        pieces.add(new Pawn(PieceColor.BLACK, new Point(2, 0)));
        pieces.add(new Pawn(PieceColor.BLACK, new Point(2, 1)));
        pieces.add(new Bishop(PieceColor.BLACK, new Point(3, 1)));

        pieces.add(new King(PieceColor.WHITE, WHITE_STARTING_LOCATION));
        pieces.add(new Rook(PieceColor.WHITE, new Point(4, 5)));
        pieces.add(new Rook(PieceColor.WHITE, new Point(4, 6)));
        pieces.add(new Pawn(PieceColor.WHITE, new Point(2, 5)));
        pieces.add(new Pawn(PieceColor.WHITE, new Point(2, 6)));
        pieces.add(new Bishop(PieceColor.WHITE, new Point(3, 6)));

    }

    //This should be called by the api whenever a player tries to make a move
    public boolean movePiece(Piece piece, Point newPosition){
        Piece pieceInSpace = this.getPieceAtPoint(newPosition);
        if(piece.move(newPosition)){
            if(pieceInSpace != null){
                pieces.remove(pieceInSpace);
            }
            return true;
        }
        return false;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Piece> getPieces(PieceColor color){
        ArrayList<Piece> ret = new ArrayList<Piece>();
        for(int i = 0; i < this.pieces.size(); i++){
            if(this.pieces.get(i).getPieceColor().equals(color)){
                ret.add(this.pieces.get(i));
            }
        }
        return ret;
    }

    public Piece getPieceAtPoint(Point p){
        for(int i = 0; i < this.pieces.size(); i++){
            if(pieces.get(i).getLocation().equals(p)){
                return pieces.get(i);
            }
        }
        return null;
    }

    public HashSet<Point> getAllMovesOfColor(PieceColor color){
        HashSet<Point> ret = new HashSet<>();
        ArrayList<Piece> temp = this.getPieces(color);
        for(int i = 0; i < temp.size(); i++){
            HashSet<Point> moves = temp.get(i).getPossibleMoves();
            for(Point move : moves){
                ret.add(move);
            }
        }
        return ret;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Piece piece : this.pieces){
            builder.append(piece + " ");
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Game b = new Game("p1", "p2");
        Gson gson = new GsonBuilder().registerTypeAdapter(Piece.class, new PieceDeserializer()).create();
        String json = gson.toJson(b);
        System.out.println(json);
        System.out.println(gson.fromJson(json, Game.class));

    }

}