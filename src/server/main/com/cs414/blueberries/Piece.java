
package com.cs414.blueberries;
import java.awt.*;

enum PieceColor {
    BLACK, WHITE, NONE
}
enum PieceType {
    KING, ROOK, BISHOP, PAWN, INVALID, BLANK
}

public abstract class Piece {
    private PieceColor pieceColor;
    private Point location;
    private PieceType type;
    private Board board;

    protected Piece(PieceColor pieceColor, Point location, PieceType type, Board board){
        this.pieceColor = pieceColor;
        this.location = location;
        this.type = type;
        this.board = board;
    }

    public Point getLocation() {
        return location;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean move(Point newPosition){
        if(!isValidMove(newPosition)){
            System.out.println(type + "cannot be moved to " + newPosition);
            return false;
        }
        board.movePiece(this, newPosition);
        this.location = newPosition;
        return true;
    }

    abstract boolean isValidMove(Point newPosition);
}
