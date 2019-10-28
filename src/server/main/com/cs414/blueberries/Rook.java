package com.cs414.blueberries;

import java.awt.*;

public class Rook extends Piece {

    public Rook(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.ROOK, board);
    }

    public Rook(PieceColor pieceColor, Point location){
        super(pieceColor, location, PieceType.ROOK);
    }

    @Override
    public void updateMoves() {
        return;
    }
}
