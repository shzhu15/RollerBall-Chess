package com.cs414.blueberries;

import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Game {
    private int id;
    private int turn;
    private String p1; // White
    private String p2; // Black
    private String p1Name;
    private String p2Name;
    public boolean ready;
    public boolean finished;
    private Board board;
    private String Winner;
    private String startTime;
    private String endTime;


    public Game (String p1, String p2, String p1Name, String p2Name) {
        this.p1 = p1;
        this.p2 = p2;
        this.p1Name = p1Name;
        this.p2Name = p2Name;
        this.ready = false;
        this.finished = false;
        this.startTime = "";
        this.endTime = "";
        this.Winner = "";
        this.turn = 0;
        Random random = new Random();
        this.id = Math.abs(random.nextInt());

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

    public void incrementTurn(){this.turn++;}

    public PieceColor getColorFromString(String playerName){
        if(playerName.equals(p1)){
            return PieceColor.WHITE;
        }
        else if(playerName.equals(p2)){
            return PieceColor.BLACK;
        }
        else{
            return null;
        }
    }

    public boolean isTurnOfPlayer(String player){
        if(!this.p1.equals(player) && !this.p2.equals(player)){
            //System.out.println("Player Not In Game");
            return false;
        }

        if(this.turn % 2 == 0 && this.p1.equals(player)){
            return true;
        }
        else if(this.turn % 2 == 1 && this.p2.equals(player)){
            return true;
        }
        return false;
    }

    public String getP1Name(){return p1Name;};

    public String getP2Name(){return p2Name;};

    public int getTurn(){ return this.turn;}

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
