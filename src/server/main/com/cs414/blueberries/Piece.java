package com.cs414.blueberries;
import java.awt.*;
import java.util.HashSet;

enum PieceColor {
    BLACK, WHITE
}
enum PieceType {
    KING, ROOK, BISHOP, PAWN
}

public abstract class Piece {
    private PieceColor pieceColor;
    private Point location;
    protected PieceType type;
    protected Board board;
    protected HashSet<Point> possibleMoves;

    protected Piece(PieceColor pieceColor, Point location, PieceType type, Board board){
        this.pieceColor = pieceColor;
        this.location = location;
        this.type = type;
        this.board = board;
        this.possibleMoves = new HashSet<Point>();
    }

    public Point getLocation() {
        return location;
    }

    public PieceType getType(){
        return this.type;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean move(Point newPosition){
        if(!this.getPossibleMoves().contains(newPosition)){
            System.out.println(type + "cannot be moved to " + newPosition);
            return false;
        }
        this.location = newPosition;
        return true;
    }

    // I hope calling this a ton will be the worst thing in the world, but if it gets to be computationally
    // expensive we can store the result and call an updateMoves method at the start of every turn
    public HashSet<Point> getPossibleMoves(){
        //This is just every point on the board
        HashSet<Point> ret = new HashSet<Point>();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                ret.add(new Point(i, j));
            }
        }
        return ret;
    }

    abstract public void updateMoves();
}
