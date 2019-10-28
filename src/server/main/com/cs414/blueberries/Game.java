package com.cs414.blueberries;

import java.util.Random;

public class Game {
    private int id;
    private String p1;
    private String p2;
    public boolean ready;
    private Board board;

    public Game (String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.ready = false;

        Random random = new Random();
        this.id = random.nextInt();

        this.board = new Board(this.id);
        this.board.initialize();
    }

    public int getId () {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    @Override
    public String toString () {
        return "Game Id: " + id + ", Status: " + ready + "\nPlayers: " + p1 + ", "
                + p2 + "\n" + this.board;
    }

    public Board getBoard() {return this.board;}
}
