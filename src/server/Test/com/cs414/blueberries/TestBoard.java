package com.cs414.blueberries;

import org.junit.Test;

import java.awt.*;

public class TestBoard {

    @Test
    public void testGetPiece(){
        Board board = new Board(101);
        board.initialize();
        Piece piece = board.getPieceAtPoint(new Point(0,2));
        assert(piece instanceof Rook);
        assert(piece.getPieceColor() == PieceColor.BLACK);

    }
}
