package com.cs414.blueberries;
import java.awt.*;

public class King extends Piece {

    public King(PieceColor pieceColor, Point location){
        super(pieceColor, location, PieceType.KING);
    }

    @Override
    public void updateMoves() {
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

    public boolean isCheckmate(){
        return false;
    }
}
