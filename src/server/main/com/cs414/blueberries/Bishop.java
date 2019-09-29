package com.cs414.blueberries;
import java.awt.*;

public class Bishop extends Piece{
    public Bishop(PieceColor pieceColor, Point location){
        super(pieceColor, location, PieceType.BISHOP);
    }

    @Override
    public void updateMoves() {
    }
}