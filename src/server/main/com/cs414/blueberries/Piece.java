package com.cs414.blueberries;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.HashSet;

enum PieceColor {
    BLACK, WHITE
}
enum PieceType {
    KING, ROOK, BISHOP, PAWN
}

public abstract class Piece {
    public enum Orientation {BOTTOM, LEFT, TOP, RIGHT}
    protected PieceType type;
    private PieceColor pieceColor;
    private Point location;
    protected HashSet<Point> possibleMoves;
    protected transient Board board;

    protected Piece(PieceColor pieceColor, Point location, PieceType type, Board board){
        this.pieceColor = pieceColor;
        this.location = location;
        this.type = type;
        this.possibleMoves = new HashSet<Point>();
        this.board = board;
    }

    protected Piece(PieceColor pieceColor, Point location, PieceType type){
        this.pieceColor = pieceColor;
        this.location = location;
        this.type = type;
        this.possibleMoves = new HashSet<Point>();
        this.board = null;
    }

    public void setBoard(Board board){this.board = board;}

    public Point getLocation() {
        return location;
    }

    public PieceType getType(){
        return this.type;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean isTurnOfPiece(int turn){
        if(turn < 0){
            return true;
        }
        if(turn % 2 == 0){
            if(this.getPieceColor() == PieceColor.WHITE){
                return true;
            }
            else{
                return false;
            }
        }
            if(this.getPieceColor() == PieceColor.BLACK){
                return true;
            }
            else{
                return false;
            }
    }

    public boolean move(Point newPosition, int turn){
        // Return False If Not This Pieces Turn
        if(!isTurnOfPiece(turn)){
            return false;
        }
        if(!this.getPossibleMoves().contains(newPosition)){
            //System.out.println(type + "cannot be moved to " + newPosition);
            return false;
        }
        this.location = newPosition;
        return true;
    }

    public HashSet<Point> getPossibleMoves(){return this.possibleMoves;}

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[" +this.type + " " + this.getPieceColor() + " " + this.location + "]");
        return builder.toString();
    }

    public Orientation getPieceOrientation(Point point){
        int x = point.x;
        int y = point.y;
        if((x <= 5 && x>= 2 && y ==5) || (x<=6 && x >=1 && y==6)){
            return Orientation.BOTTOM;
        }
        else if((y<=6 && y>=1 && x==0) || (y<=5 && y>=2 && x== 1)){
            return Orientation.LEFT;
        }
        else if((x <= 4 && x>= 1 && y ==1) || (x<=5 && x >=0 && y==0)){
            return Orientation.TOP;
        }
        else{
            return Orientation.RIGHT;
        }
    }

    public boolean isValidLocation(Point point){
        if(point.x < 0 || point.y < 0){
            return false;
        }
        if(point.x >6 || point.y > 6){
            return false;
        }
        if( (point.x>=2 && point.x <=4) && (point.y>=2 && point.y <= 4)){
            return false;
        }

        return true;
    }

    public static boolean isCorner(Point p){
        return (p.equals(new Point(0,0)) || p.equals(new Point(0,6)) || p.equals(new Point(6,0)) || p.equals(new Point(6,6)));
    }

    // Should be called for every piece at the start of every turn
    abstract public void updateMoves();
}

