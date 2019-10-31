package com.cs414.blueberries;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;

public class TestBoard {

    @Test
    public void testInitializeBlackPieces(){
        Board board = new Board(101);
        board.initialize();
        Piece piece = board.getPieceAtPoint(new Point(2,0));
        assertTrue("First Rook", piece instanceof Rook);
        assertTrue("First rook wrong color", piece.getPieceColor() == PieceColor.BLACK);

        piece = board.getPieceAtPoint(new Point(2,1));
        assertTrue("2nd Rook", piece instanceof Rook);
        assertTrue("2nd Rook wrong color", piece.getPieceColor() == PieceColor.BLACK);

        piece = board.getPieceAtPoint(new Point(3,0));
        assertTrue("Bishop", piece instanceof Bishop);
        assertTrue("Bishop wrong color", piece.getPieceColor() == PieceColor.BLACK);

        piece = board.getPieceAtPoint(new Point(3,1));
        assertTrue("King", piece instanceof King);
        assertTrue("King wrong color", piece.getPieceColor() == PieceColor.BLACK);

        piece = board.getPieceAtPoint(new Point(4,0));
        assertTrue("Pawn 1", piece instanceof Pawn);
        assertTrue("Pawn 1 wrong color", piece.getPieceColor() == PieceColor.BLACK);

        piece = board.getPieceAtPoint(new Point(4,1));
        assertTrue("Pawn 2", piece instanceof Pawn);
        assertTrue("Pawn 2 wrong color", piece.getPieceColor() == PieceColor.BLACK);

    }

    @Test
    public void testInitializeWhitePieces(){
        Board board = new Board(101);
        board.initialize();
        Piece piece = board.getPieceAtPoint(new Point(4,5));
        assertTrue("First Rook", piece instanceof Rook);
        assertTrue("First rook wrong color", piece.getPieceColor() == PieceColor.WHITE);

        piece = board.getPieceAtPoint(new Point(4,6));
        assertTrue("2nd Rook", piece instanceof Rook);
        assertTrue("2nd Rook wrong color", piece.getPieceColor() == PieceColor.WHITE);

        piece = board.getPieceAtPoint(new Point(3,6));
        assertTrue("Bishop", piece instanceof Bishop);
        assertTrue("Bishop wrong color", piece.getPieceColor() == PieceColor.WHITE);

        piece = board.getPieceAtPoint(new Point(3,5));
        assertTrue("King", piece instanceof King);
        assertTrue("King wrong color", piece.getPieceColor() == PieceColor.WHITE);

        piece = board.getPieceAtPoint(new Point(2,5));
        assertTrue("Pawn 1", piece instanceof Pawn);
        assertTrue("Pawn 1 wrong color", piece.getPieceColor() == PieceColor.WHITE);

        piece = board.getPieceAtPoint(new Point(2,6));
        assertTrue("Pawn 2", piece instanceof Pawn);
        assertTrue("Pawn 2 wrong color", piece.getPieceColor() == PieceColor.WHITE);

    }


    @Test
    public void testMovePiece1(){

    }
}
