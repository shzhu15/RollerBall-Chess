package com.cs414.blueberries;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import static org.junit.Assert.*;

public class TestPawn {

    @Test
    public void testBottom(){
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(2,5), board);
        board.placePiece(p);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(1,4));
        expected.add(new Point(1,5));
        expected.add(new Point(1,6));
        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testLeft(){
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(0,6), board);
        board.placePiece(p);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(1,5));
        expected.add(new Point(0,5));
        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testTop(){
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(1,1), board);
        board.placePiece(p);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(2,1));
        expected.add(new Point(2,0));

        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testTopLeftCorner() {
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(0, 0), board);
        board.placePiece(p);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(1, 0));
        expected.add(new Point(1, 1));
        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(), actual.size());
    }


    @Test
    public void testBottomWithPieces(){
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(2,5), board);
        Pawn p1 = new Pawn(PieceColor.WHITE, new Point(1, 4), board);
        Pawn p2 = new Pawn(PieceColor.BLACK, new Point(1, 5), board);
        board.placePiece(p);
        board.placePiece(p1);
        board.placePiece(p2);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(1,4));
        expected.add(new Point(1,6));
        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testTopRightCorner(){
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(6,0), board);
        board.placePiece(p);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(6,1));
        expected.add(new Point(5,1));

        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testBottomRightCorner(){
        Board board = new Board(100);
        Pawn p = new Pawn(PieceColor.BLACK, new Point(6,6), board);
        board.placePiece(p);
        p.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(5,6));
        expected.add(new Point(5,5));

        HashSet<Point> actual = p.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }


}
