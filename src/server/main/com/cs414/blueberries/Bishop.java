package com.cs414.blueberries;

import java.awt.*;

public class Bishop extends Piece{

    private enum moveDirection {UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT}
    private enum Orientation {BOTTOM, LEFT, TOP, RIGHT}
    public Bishop(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.BISHOP, board);
    }

    public Bishop(PieceColor pieceColor, Point location) {
        super(pieceColor, location, PieceType.BISHOP);
    }

    @Override
    public void updateMoves() {
        this.possibleMoves.clear();
        moveBasedOnLocation(this.getLocation(), false);


    }

    private void move(Point point, int maxSquares, moveDirection direction, boolean hasRebounded){
        int increaseX = 0;
        int increaseY = 0;
        switch (direction){
            case UPLEFT:
                increaseX = -1;
                increaseY = -1;
                break;
            case DOWNLEFT:
                increaseX = -1;
                increaseY = 1;
                break;
            case UPRIGHT:
                increaseX = 1;
                increaseY = -1;
                break;
            case DOWNRIGHT:
                increaseX = 1;
                increaseY = 1;
                break;
        }
        Point location = new Point(point.x, point.y);

        int squaresMoved = 0;
        while(squaresMoved < maxSquares){
            location.move(location.x + increaseX, location.y + increaseY);
            if ( !this.isValidLocation(location)) { break;}
            Piece piece = this.board.getPieceAtPoint(location);
            if (piece != null){
                //there is a piece in the way, see if it can be captured
                if(piece.getPieceColor() != this.getPieceColor()){
                    //can capture it
                    this.possibleMoves.add(new Point(location.x, location.y));
                }

                break;
            }

            this.possibleMoves.add(new Point(location.x, location.y));

            if(!hasRebounded && canRebound(location, direction)){
                switch (direction){
                    case UPLEFT:
                        move(location, Integer.MAX_VALUE, moveDirection.UPRIGHT, true);
                        break;
                    case UPRIGHT:
                        move(location, Integer.MAX_VALUE, moveDirection.UPLEFT, true);
                        break;
                    case DOWNLEFT:
                        move(location, Integer.MAX_VALUE, moveDirection.DOWNRIGHT, true);
                        break;
                    case DOWNRIGHT:
                        move(location, Integer.MAX_VALUE, moveDirection.DOWNLEFT, true);
                        break;
                }
                break;
            }




            squaresMoved += 1;
        }
    }



    private void moveBasedOnLocation(Point point, boolean hasRebounded){
        Orientation orientation = this.getPieceOrientation(point);

        switch(orientation){
            case BOTTOM:
                move(point, Integer.MAX_VALUE, moveDirection.UPLEFT, hasRebounded);
                move(point, Integer.MAX_VALUE, moveDirection.DOWNLEFT, hasRebounded);
                move(point, 1, moveDirection.UPRIGHT, true);
                move(point, 1, moveDirection.DOWNRIGHT, true);
                break;
            case LEFT:
                move(point, Integer.MAX_VALUE, moveDirection.UPRIGHT, hasRebounded);
                move(point, Integer.MAX_VALUE, moveDirection.UPLEFT, hasRebounded);
                move(point, 1, moveDirection.DOWNLEFT, true);
                move(point, 1, moveDirection.DOWNRIGHT, true);
                break;
            case TOP:
                move(point, Integer.MAX_VALUE, moveDirection.UPRIGHT, hasRebounded);
                move(point, Integer.MAX_VALUE, moveDirection.DOWNRIGHT, hasRebounded);
                move(point, 1, moveDirection.DOWNLEFT, true);
                move(point, 1, moveDirection.UPLEFT, true);
                break;
            case RIGHT:
                move(point, Integer.MAX_VALUE, moveDirection.DOWNRIGHT, hasRebounded);
                move(point, Integer.MAX_VALUE, moveDirection.DOWNLEFT, hasRebounded);
                move(point, 1, moveDirection.UPLEFT, true);
                move(point, 1, moveDirection.UPRIGHT, true);
                break;
        }
    }

    private boolean canRebound(Point point, moveDirection direction){
        //if you are moving and hit a wall you can always rebound off of that wall
        switch(direction){
            case UPLEFT:
                if( point.x == 0) { return true;}
                else if(point.y == 5 && point.x ==4){return true;}
                else { return false;}
            case DOWNLEFT:
                if(point.x == 5 && point.y ==2  ){return true;}
                else if(point.y == 6){return  true;}
                else{return false;}
            case UPRIGHT:
                if(point.y == 0){return true;}
                else if (point.x ==1 && point.y == 4){return true;}
                else {return false;}
            case DOWNRIGHT:
                if(point.x == 6){return true;}
                if(point.x==2 && point.y == 1){return true;}
                else {return false;}
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

    private Orientation getPieceOrientation(Point point){
        int x = point.x;
        int y = point.y;
        if((x <= 5 && x>= 2 && y ==5) || (x<=6 && x >=1 && y==6)){
            return Orientation.BOTTOM;
        }
        else if((y<=6 && y>=1 && x==0) || (y<=5 && y>=2 && x== 1)){
            return Orientation.LEFT;
        }
        else if((x <= 4 && x>= 1 && y ==1) || (x<=5 && x >=0 && y==0)){
            return Orientation.TOP;
        }
        else{
            return Orientation.RIGHT;
        }
    }




}