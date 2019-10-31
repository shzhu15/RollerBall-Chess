package com.cs414.blueberries;
import java.awt.*;

public class King extends Piece {


    public King(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.KING, board);
    }

    public King(PieceColor pieceColor, Point location){
        super(pieceColor, location, PieceType.KING);
    }

    @Override
    public void updateMoves() {
        this.possibleMoves.clear();
        moveSet(this.getLocation());
    }

    public boolean isCheck(Board board){
        if(this.getPieceColor().equals(PieceColor.BLACK)){
            if(board.getAllMovesOfColor(PieceColor.WHITE).contains(this.getLocation())){
                return true;
            }
            return false;
        }
        else {
            if(board.getAllMovesOfColor(PieceColor.BLACK).contains(this.getLocation())){
                return true;
            }
            return false;
        }

    }

    public void moveSet(Point point) {

        //up
        move(point, 0, -1);

        //down
        move(point, 0, 1);

        //left
        move(point, -1, 0);

        //right
        move(point, 1, 0);

        //upLeft
        move(point, -1, -1);

        //upRight
        move(point, 1, -1);


        //downLeft
        move(point, -1, 1);

        //downRight
        move(point, 1, 1);

    }

    public void move(Point start, int x, int y) {
        Point newLocation = new Point(start.x, start.y);

        newLocation.move(newLocation.x + x, newLocation.y + y);

        Piece piece = this.board.getPieceAtPoint(newLocation);
        //check if location is out of bounds or not
        if(this.isValidLocation(newLocation) == true) {
            //if there is no piece or piece of same color at the new location, process
            if(piece == null || piece.getPieceColor() != this.getPieceColor()) {
                //Check if move will place king into check, if not add move
                if(this.board.getAllMovesOfColor(PieceColor.WHITE).contains(newLocation) == false) {
                    this.possibleMoves.add(new Point(newLocation.x, newLocation.y));
                }
            }
        }
    }


    public boolean isCheckmate() {
        //check if the moves that a king can make is zero, and the king is in a check
        if(this.possibleMoves.isEmpty() == true && isCheck(this.board) == true) {
            return true;
        }
        return false;
    }

    public boolean checkMoveWin() {
        Point location = this.getLocation();
        PieceColor color = this.getPieceColor();
        //check if the white king is at the black king start position
        if(color.equals(PieceColor.WHITE)) {
            if(location.x == 3 && location.y == 1) {
                return true;
            }
        }
        //check if the black king is at the white king start position
        if(color.equals(PieceColor.BLACK)) {
            if(location.x == 3 && location.y == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidLocation(Point point){
        if(point.x < 0 || point.y < 0){
            return false;
        }
        if(point.x >6 || point.y > 6){
            return false;
        }
        if( (point.x>=2 && point.x <=4) && (point.y>=2 && point.y <= 4)){
            return false;
        }

        return true;
    }
}
