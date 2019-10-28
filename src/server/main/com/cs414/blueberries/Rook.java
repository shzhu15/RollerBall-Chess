package com.cs414.blueberries;

import java.awt.*;

public class Rook extends Piece {

    public Rook(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.ROOK, board);
    }

    @Override
    public void updateMoves() {
        return;
    }
}
