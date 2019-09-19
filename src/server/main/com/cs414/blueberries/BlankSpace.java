package com.cs414.blueberries;

import java.awt.*;

public class BlankSpace extends Piece{

    public BlankSpace(Point location, Board board){
        super(BlankSpace.generateColor(location), location, PieceType.BLANK, board);
    }

    @Override
    boolean isValidMove(Point newPosition) {
        return false;
    }

    // This is to create the checkerboard pattern
    private static PieceColor generateColor(Point location){
        int x = location.x % 2;
        int y = location.y % 2;
        if(x + y == 1){
            return PieceColor.BLACK;
        }
        else {
            return PieceColor.WHITE;
        }
    }

}