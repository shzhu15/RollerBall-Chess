package com.cs414.blueberries;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;


public class Board {

    // If the opposing king gets here its game over
    private final Point WHITE_STARTING_LOCATION = new Point(3,1);
    private final Point BLACK_STARTING_LOCATION = new Point(3,5);
    private ArrayList<Piece> pieces;

    public Board(){
        this.pieces = new ArrayList<Piece>();
        pieces.add(new King(PieceColor.WHITE, WHITE_STARTING_LOCATION, this));
        pieces.add(new King(PieceColor.BLACK, BLACK_STARTING_LOCATION, this));
    }

    //This should be called by the api whenever a player tries to make a move
    public boolean movePiece(Piece piece, Point newPosition){
        if(piece.move(newPosition)){
            Piece pieceInSpace = this.getPieceAtPoint(newPosition);
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

}
