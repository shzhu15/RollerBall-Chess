package com.cs414.blueberries;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestRook {

    @Test
    //This matches the first of the rook example moves pictures
    public void testUpdateMoves1(){
        Board board = new Board(100);
        Rook rook = new Rook(PieceColor.WHITE, new Point(5,5), board);
        board.placePiece(rook);
        rook.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        //1 Length Moves
        expected.add(new Point(5,4));
        expected.add(new Point(5,6));
        expected.add(new Point(6,5));
        //Recursive Moves
        expected.add(new Point(0,5));
        expected.add(new Point(1,5));
        expected.add(new Point(2,5));
        expected.add(new Point(3,5));
        expected.add(new Point(4,5));

        HashSet<Point> actual = rook.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    //This matches the second of the rook example pictures
    public void testUpdateMoves2() {
        Board board = new Board(100);
        Rook rook = new Rook(PieceColor.WHITE, new Point(6, 6), board);
        board.placePiece(rook);
        rook.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        //1 Length Moves
        expected.add(new Point(6, 5));
        //Recursive Moves Left
        expected.add(new Point(0, 6));
        expected.add(new Point(1, 6));
        expected.add(new Point(2, 6));
        expected.add(new Point(3, 6));
        expected.add(new Point(4, 6));
        expected.add(new Point(5, 6));
        //Recursive Moves Up
        expected.add(new Point(0, 5));
        expected.add(new Point(0, 4));
        expected.add(new Point(0, 3));
        expected.add(new Point(0, 2));
        expected.add(new Point(0, 1));
        expected.add(new Point(0, 0));

        HashSet<Point> actual = rook.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    //This matches the fourth of the rook example pictures
    public void testUpdateMoves3() {
        Board board = new Board(100);
        Rook rook = new Rook(PieceColor.WHITE, new Point(1, 6), board);
        board.placePiece(rook);
        rook.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        //1 Length Moves
        expected.add(new Point(2, 6));
        //Recursive Moves Left
        expected.add(new Point(0, 6));
        //Recursive Moves Up
        expected.add(new Point(0, 5));
        expected.add(new Point(0, 4));
        expected.add(new Point(0, 3));
        expected.add(new Point(0, 2));
        expected.add(new Point(0, 1));
        expected.add(new Point(0, 0));
        expected.add(new Point(1, 5));
        expected.add(new Point(1, 4));
        expected.add(new Point(1, 3));
        expected.add(new Point(1, 2));
        expected.add(new Point(1, 1));
        expected.add(new Point(1, 0));

        HashSet<Point> actual = rook.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    //This tests for the rook stoping before it hits a friend and once it hits an enemy
    public void testUpdateMoves4() {
        Board board = new Board(100);
        Rook rook = new Rook(PieceColor.WHITE, new Point(1, 6), board);
        Pawn friend = new Pawn(PieceColor.WHITE, new Point(0, 2), board);
        Pawn foe = new Pawn(PieceColor.BLACK, new Point(1, 1), board);
        board.placePiece(friend);
        board.placePiece(foe);
        board.placePiece(rook);
        rook.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        //1 Length Moves
        expected.add(new Point(2, 6));
        //Recursive Moves Left
        expected.add(new Point(0, 6));
        //Recursive Moves Up
        expected.add(new Point(0, 5));
        expected.add(new Point(0, 4));
        expected.add(new Point(0, 3));
        expected.add(new Point(1, 5));
        expected.add(new Point(1, 4));
        expected.add(new Point(1, 3));
        expected.add(new Point(1, 2));
        expected.add(new Point(1, 1));

        HashSet<Point> actual = rook.getPossibleMoves();
        System.out.println(actual);
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(), actual.size());
    }
}
