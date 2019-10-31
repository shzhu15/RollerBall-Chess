package com.cs414.blueberries;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Pawn extends Piece{
    public Pawn(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.PAWN, board);
    }

    public Pawn(PieceColor pieceColor, Point location){
        super(pieceColor, location, PieceType.PAWN);
    }

    @Override
    public void updateMoves() {
        this.possibleMoves.clear();
        this.possibleMoves = getLegalMoves();
    }

    public HashSet<Point> getLegalMoves(){
        HashSet<Point> moves = new HashSet<>();
        ArrayList<Point> allMoves = new ArrayList<>();
        Point location = this.getLocation();
        switch(getPieceOrientation(this.getLocation())){
            case BOTTOM:
                System.out.println("Bot");
                Point left = new Point(location.x-1, location.y);
                Point upLeft = new Point(location.x-1, location.y-1);
                Point downLeft = new Point(location.x-1, location.y+1);
                allMoves.addAll(Arrays.asList(left, upLeft, downLeft));
                return new HashSet<>(validatePawnMoves(allMoves));

            case TOP:
                System.out.println("top");
                Point right = new Point(location.x+1, location.y);
                Point upRight = new Point(location.x+1, location.y-1);
                Point downRight = new Point(location.x+1, location.y+1);
                allMoves.addAll(Arrays.asList(right, upRight, downRight));
                return new HashSet<>(validatePawnMoves(allMoves));

            case LEFT:
                System.out.println("left");
                Point up = new Point(location.x, location.y-1);
                Point rightUp = new Point(location.x+1, location.y-1);
                Point leftUp = new Point(location.x-1, location.y-1);
                allMoves.addAll(Arrays.asList(rightUp, up, leftUp));
                return new HashSet<>(validatePawnMoves(allMoves));

            case RIGHT:
                System.out.println("right");
                Point down = new Point(location.x, location.y+1);
                Point rightDown = new Point(location.x+1, location.y+1);
                Point leftDown = new Point(location.x-1, location.y+1);
                allMoves.addAll(Arrays.asList(down, rightDown, leftDown));
                return new HashSet<>(validatePawnMoves(allMoves));
        }
        return null;
    }

    private ArrayList<Point> validatePawnMoves(ArrayList<Point> potential){
        ArrayList<Point> valid = new ArrayList<>();
        for(Point p: potential){
            if((board.getPieceAtPoint(p) == null || board.getPieceAtPoint(p).getPieceColor() != this.getPieceColor()) && isValidLocation(p)){
                System.out.println(p.toString());
                valid.add(p);
            }
        }
        return valid;
    }


}
