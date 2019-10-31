package com.cs414.blueberries;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import static org.junit.Assert.*;

public class TestBishop {

    @Test
    public void testUpdateMoves1(){
        Board board = new Board(100);
        Bishop bishop = new Bishop(PieceColor.WHITE, new Point(1,6), board);
        board.placePiece(bishop);
        bishop.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(2,5));
        expected.add(new Point(0,5));
        expected.add(new Point(1,4));

        HashSet<Point> actual = bishop.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testUpdateMoves2(){
        Board board = new Board(100);
        Bishop bishop = new Bishop(PieceColor.WHITE, new Point(3,6), board);
        board.placePiece(bishop);
        bishop.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(4,5));
        expected.add(new Point(2,5));
        expected.add(new Point(1,4));
        expected.add(new Point(0,3));
        expected.add(new Point(1,2));
        expected.add(new Point(2,1));
        expected.add(new Point(3,0));
        HashSet<Point> actual = bishop.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testUpdateMoves3(){
        Board board = new Board(100);
        Bishop bishop = new Bishop(PieceColor.BLACK, new Point(3,0), board);
        board.placePiece(bishop);
        bishop.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(4,1));
        expected.add(new Point(2,1));
        expected.add(new Point(5,2));
        expected.add(new Point(6,3));
        expected.add(new Point(5,4));
        expected.add(new Point(4,5));
        expected.add(new Point(3,6));
        HashSet<Point> actual = bishop.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testUpdateMoves4(){
        Board board = new Board(100);
        Bishop bishop = new Bishop(PieceColor.BLACK, new Point(5,0), board);
        board.placePiece(bishop);
        bishop.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(4,1));
        expected.add(new Point(6,1));
        expected.add(new Point(5,2));
        HashSet<Point> actual = bishop.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }


    @Test
    public void testUpdateMoves5(){
        Board board = new Board(100);
        Bishop bishop = new Bishop(PieceColor.BLACK, new Point(5,0), board);
        board.placePiece(bishop);


        Pawn pawn = new Pawn(PieceColor.WHITE, new Point(6,1), board);
        board.placePiece(pawn);

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(4,1));
        expected.add(new Point(6,1));
        bishop.updateMoves();
        HashSet<Point> actual = bishop.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testUpdateMoves6(){
        Board board = new Board(100);
        Bishop bishop = new Bishop(PieceColor.BLACK, new Point(5,0), board);
        board.placePiece(bishop);


        Pawn pawn = new Pawn(PieceColor.WHITE, new Point(6,1), board);
        board.placePiece(pawn);

        Pawn pawn2 = new Pawn(PieceColor.BLACK, new Point(4,1), board);
        board.placePiece(pawn2);

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(6,1));
        bishop.updateMoves();
        HashSet<Point> actual = bishop.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }



}
