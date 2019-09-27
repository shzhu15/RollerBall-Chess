package com.cs414.blueberries;
import java.awt.*;

public class King extends Piece {

    public King(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.KING, board);
    }

    @Override
    public void updateMoves() {
    }

    public boolean isCheck(){
        if(this.getPieceColor().equals(PieceColor.BLACK)){
            if(this.board.getAllMovesOfColor(PieceColor.WHITE).contains(this.getLocation())){
                return true;
            }
            return false;
        }
        else {
            if(this.board.getAllMovesOfColor(PieceColor.BLACK).contains(this.getLocation())){
                return true;
            }
            return false;
        }

    }

    public boolean isCheckmate(){
        return false;
    }
}
