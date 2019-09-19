package com.cs414.blueberries;
import java.awt.*;


public class Board {
    private final Point WHITE_STARTING_LOCATION = new Point(3,1);
    private final Point BLACK_STARTING_LOCATION = new Point(3,5);

    private Piece[][] currentGrid;


    public Board(){
        currentGrid = new Piece[7][7];
        // Set Center 3x3 To Invalid
        for(int i = 2; i < 5; i++){
            for(int j = 2; j < 5; j++){
                currentGrid[i][j] = new InvalidSpace(new Point(i, j), this);
            }
        }
        //Set Sides To Blank
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if(i == 2 || i == 3 || i == 4){
                    continue;
                }
                currentGrid[i][j] = new BlankSpace(new Point(i, j), this);
            }
        }
        //TODO:Add Pieces To Starting Board
        /*Place Pieces: Starting Board Should Look like:
        Rook, Bishop, Pawn
        Rook, King, Pawn
        xxxxxxxxxxxxxxxxxx
        Pawn, King, Rook
        Pawn, Bishop, Rook
        */

    }

    public boolean movePiece(Piece p, Point newPosition){
        Point oldPosition = p.getLocation();
        this.currentGrid[newPosition.x][newPosition.y] = p;

        return true;
    }

    public Piece getPieceAtPoint(Point p){
        return currentGrid[p.x][p.y];
    }

    public Piece getPieceAtPoint(int x, int y){
        return currentGrid[x][y];
    }

    //TODO: Implement These
    //Takes a player color as input and returns a bool
    public boolean isCheck(PieceColor checkedSide){
        return false;
    }

    public boolean isCheckmate(PieceColor checkedSide){
        return false;
    }
}
