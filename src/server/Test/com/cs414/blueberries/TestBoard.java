package com.cs414.blueberries;

import org.junit.Test;

import java.awt.*;

public class TestBoard {

    @Test
    public void testGetPiece(){
        Board board = new Board(101);
        board.initialize();
        Piece piece = board.getPieceAtPoint(new Point(2,0));
        assertTrue(piece instanceof Rook, "First Rook");
        assertTrue(piece.getPieceColor() == PieceColor.BLACK, "First rook wrong color");

        Piece piece = board.getPieceAtPoint(new Point(2,1));
        assertTrue(piece instanceof Rook, "2nd Rook");
        assertTrue(piece.getPieceColor() == PieceColor.BLACK, "2nd Rook wrong color");

        Piece piece = board.getPieceAtPoint(new Point(3,0));
        assertTrue(piece instanceof Bishop, "Bishop");
        assertTrue(piece.getPieceColor() == PieceColor.BLACK, "Bishop wrong color");

        Piece piece = board.getPieceAtPoint(new Point(3,1));
        assertTrue(piece instanceof King, "King");
        assertTrue(piece.getPieceColor() == PieceColor.BLACK, "King wrong color");

        Piece piece = board.getPieceAtPoint(new Point(4,0));
        assertTrue(piece instanceof Pawn, "Pawn 1");
        assertTrue(piece.getPieceColor() == PieceColor.BLACK, "Pawn 1 wrong color");

        Piece piece = board.getPieceAtPoint(new Point(4,1));
        assertTrue(piece instanceof Pawn, "Pawn 2");
        assertTrue(piece.getPieceColor() == PieceColor.BLACK, "Pawn 2 wrong color");

    }
}
