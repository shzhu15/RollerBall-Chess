package com.cs414.blueberries;

import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Game {
    private int id;
    private String p1;
    private String p2;
    public boolean ready;
    public boolean finished;
    private Board board;
    private String Winner;
    private String startTime;
    private String endTime;


    public Game (String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.ready = false;
        this.finished = false;
        this.startTime = "";
        this.endTime = "";
        this.Winner = "";
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

    public void setStartTimeToNow(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        this.startTime = time;
    }
    public void setEndTimeToNow(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        this.endTime = time;
    }

    public void setWinner(String Winner){
        this.Winner = Winner;
    }

    @Override
    public String toString () {
        return "Game Id: " + id + ", Status: " + ready + "\nPlayers: " + p1 + ", "
                + p2 + "\n" + this.board;
    }

    public Board getBoard() {return this.board;}
}
