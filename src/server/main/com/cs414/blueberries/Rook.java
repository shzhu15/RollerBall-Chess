package com.cs414.blueberries;

import java.awt.*;
import java.util.HashSet;

public class Rook extends Piece {

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public Rook(PieceColor pieceColor, Point location, Board board) {
        super(pieceColor, location, PieceType.ROOK, board);
    }

    public Rook(PieceColor pieceColor, Point location) {
        super(pieceColor, location, PieceType.ROOK);
    }

    @Override
    public void updateMoves() {
        this.possibleMoves.clear();
        this.possibleMoves = this.generateMoves(this.getLocation());
    }

    private HashSet<Point> generateMoves(Point p) {
        HashSet<Point> setOfMoves = new HashSet<>();
        Direction currentDirection = orientationToDirection(this.getPieceOrientation(p));
        assert currentDirection != null;
        //Add all moves of 1 length
        setOfMoves.addAll(addInitialMoves(currentDirection));
        if(canRecursivelyMoveTwoDirections(this.getLocation())){
            Direction extraDirection = orientationToDirection(getPieceOrientation(move(currentDirection, this.getLocation())));
            setOfMoves.addAll(addRecursiveMoves(extraDirection, true, this.getLocation()));
        }
        setOfMoves.addAll(addRecursiveMoves(currentDirection, true, this.getLocation()));
        return setOfMoves;
    }


    //This is to handle the 4 spaces where a rook can launch 2 different directions
    private boolean canRecursivelyMoveTwoDirections(Point location) {
        int x = location.x;
        int y = location.y;
        return (x == 1 && y == 6) || (x == 0 && y == 1) || (x == 5 && y == 0) || (x == 6 && y == 5);
    }

    private Direction orientationToDirection(Orientation orientation) {
        switch (orientation) {
            case BOTTOM:
                return Direction.LEFT;
            case TOP:
                return Direction.RIGHT;
            case LEFT:
                return Direction.UP;
            case RIGHT:
                return Direction.DOWN;
            default:
                return null;
        }
    }

    private HashSet<Point> addInitialMoves(Direction direction) {
        HashSet<Point> setOfMoves = new HashSet<>();
        switch (direction) {
            case UP:
                if (isValidSpace(this.move(Direction.RIGHT, this.getLocation())))
                    setOfMoves.add(this.move(Direction.RIGHT, this.getLocation()));
                if (isValidSpace(this.move(Direction.LEFT, this.getLocation())))
                    setOfMoves.add(this.move(Direction.LEFT, this.getLocation()));
                if (isValidSpace(this.move(Direction.DOWN, this.getLocation())))
                    setOfMoves.add(this.move(Direction.DOWN, this.getLocation()));
                return setOfMoves;
            case DOWN:
                if (isValidSpace(this.move(Direction.RIGHT, this.getLocation())))
                    setOfMoves.add(this.move(Direction.RIGHT, this.getLocation()));
                if (isValidSpace(this.move(Direction.LEFT, this.getLocation())))
                    setOfMoves.add(this.move(Direction.LEFT, this.getLocation()));
                if (isValidSpace(this.move(Direction.UP, this.getLocation())))
                    setOfMoves.add(this.move(Direction.UP, this.getLocation()));
                return setOfMoves;
            case LEFT:
                if (isValidSpace(this.move(Direction.RIGHT, this.getLocation())))
                    setOfMoves.add(this.move(Direction.RIGHT, this.getLocation()));
                if (isValidSpace(this.move(Direction.DOWN, this.getLocation())))
                    setOfMoves.add(this.move(Direction.DOWN, this.getLocation()));
                if (isValidSpace(this.move(Direction.UP, this.getLocation())))
                    setOfMoves.add(this.move(Direction.UP, this.getLocation()));
                return setOfMoves;
            case RIGHT:
                if (isValidSpace(this.move(Direction.LEFT, this.getLocation())))
                    setOfMoves.add(this.move(Direction.LEFT, this.getLocation()));
                if (isValidSpace(this.move(Direction.DOWN, this.getLocation())))
                    setOfMoves.add(this.move(Direction.DOWN, this.getLocation()));
                if (isValidSpace(this.move(Direction.UP, this.getLocation())))
                    setOfMoves.add(this.move(Direction.UP, this.getLocation()));
                return setOfMoves;
            default:
                return setOfMoves;
        }
    }

    private boolean isValidSpace(Point p) {
        if (!isValidLocation(p)) return false;
        return board.getPieceAtPoint(p) == null || !board.getPieceAtPoint(p).getPieceColor().equals(this.getPieceColor());
    }

    private HashSet<Point> addRecursiveMoves(Direction direction, boolean canBounce, Point nextPoint) {
        nextPoint = move(direction, nextPoint);
        assert nextPoint != null;
        if(board.getPieceAtPoint(nextPoint) != null) {
            //Teammate
            if (board.getPieceAtPoint(nextPoint).getPieceColor().equals(this.getPieceColor()))
                return new HashSet<>();
                //Enemy
            else if (!board.getPieceAtPoint(nextPoint).getPieceColor().equals(this.getPieceColor())) {
                HashSet<Point> ret = new HashSet<>();
                ret.add(nextPoint);
                return ret;
            }
        }
        //Hit Corner And Can Bounce
        if (Piece.isCorner(nextPoint) && canBounce) {
            HashSet<Point> ret = new HashSet<>();
            ret.add(nextPoint);
            Direction bounce = orientationToDirection(getPieceOrientation(nextPoint));
            assert bounce != null;
            ret.addAll(addRecursiveMoves(bounce, false, nextPoint));
            return ret;
        }
        //Other: Hit Corner Can't Bounce, Hit Wall, Empty Space, Invalid Space
        else {
            if (isValidLocation(nextPoint)) {
                HashSet<Point> ret = new HashSet<>();
                ret.add(nextPoint);
                ret.addAll(addRecursiveMoves(direction, canBounce, nextPoint));
                return ret;
            } else {
                return new HashSet<>();
            }
        }
    }

    private Point move(Direction direction, Point currentPoint){
        Point nextPoint;
        int x = currentPoint.x;
        int y = currentPoint.y;
        switch (direction) {
            case UP:
                nextPoint = new Point(x, y - 1);
                break;
            case DOWN:
                nextPoint = new Point(x, y + 1);
                break;
            case LEFT:
                nextPoint = new Point(x - 1, y);
                break;
            case RIGHT:
                nextPoint = new Point(x + 1, y);
                break;
            default:
                nextPoint = null;
                break;
        }
        return nextPoint;
    }
}
