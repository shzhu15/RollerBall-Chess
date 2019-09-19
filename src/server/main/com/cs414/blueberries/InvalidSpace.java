package com.cs414.blueberries;

import java.awt.*;

public class InvalidSpace extends Piece{

    public InvalidSpace(Point location, Board board){
        super(PieceColor.NONE, location, PieceType.BLANK, board);
    }

    @Override
    boolean isValidMove(Point newPosition) {
        return false;
    }
}

