package com.cs414.blueberries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;


public class Board {

    // 0,0 Is Top Left
    // If the opposing king gets here its game over
    private transient final Point WHITE_STARTING_LOCATION = new Point(3,5);
    private transient final Point BLACK_STARTING_LOCATION = new Point(3,1);
    private ArrayList<Piece> pieces;
    public transient int gameId;

    public Board(int gameId){
        this.gameId = gameId;
        this.pieces = new ArrayList<Piece>();

    }

    public void initialize(){
        pieces.add(new King(PieceColor.BLACK, BLACK_STARTING_LOCATION, this));
        pieces.add(new Rook(PieceColor.BLACK, new Point(2, 0), this));
        pieces.add(new Rook(PieceColor.BLACK, new Point(2, 1), this));
        pieces.add(new Pawn(PieceColor.BLACK, new Point(4, 0), this));
        pieces.add(new Pawn(PieceColor.BLACK, new Point(4, 1), this));
        pieces.add(new Bishop(PieceColor.BLACK, new Point(3, 0), this));

        pieces.add(new King(PieceColor.WHITE, WHITE_STARTING_LOCATION, this));
        pieces.add(new Rook(PieceColor.WHITE, new Point(4, 5), this));
        pieces.add(new Rook(PieceColor.WHITE, new Point(4, 6), this));
        pieces.add(new Pawn(PieceColor.WHITE, new Point(2, 5), this));
        pieces.add(new Pawn(PieceColor.WHITE, new Point(2, 6), this));
        pieces.add(new Bishop(PieceColor.WHITE, new Point(3, 6), this));

        this.updateMoves();
    }

    public void updateMoves(){
        for (Piece piece: this.pieces) {
            piece.updateMoves();
        }
    }

    //This should be called whenever the board gets read in
    public void setBoardReferenceOfPieces(){
        for (Piece piece : this.pieces) {
            piece.setBoard(this);
        }
    }

    //This should be called by the api whenever a player tries to make a move
    public boolean movePiece(Piece piece, Point newPosition, int turn){
        Piece pieceInSpace = this.getPieceAtPoint(newPosition);
        if(piece.move(newPosition, turn)){
            if(pieceInSpace != null){
                pieces.remove(pieceInSpace);
            }
            return true;
        }
        return false;
    }

    public void placePiece(Piece piece){
        pieces.add(piece);
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
//        Game b = new Game("p1", "p2");
//        Gson gson = new GsonBuilder().registerTypeAdapter(Piece.class, new PieceSerializer()).create();
//        String json = gson.toJson(b);
//        System.out.println(json);
//        System.out.println(gson.fromJson(json, Game.class));

    }

}
