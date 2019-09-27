package com.cs414.blueberries;
import java.awt.*;

public class Pawn extends Piece{
    public Pawn(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.PAWN, board);
    }

    @Override
    public void updateMoves() {

    }
}
