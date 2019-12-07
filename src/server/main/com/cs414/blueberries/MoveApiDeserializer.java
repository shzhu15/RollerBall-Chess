package com.cs414.blueberries;

public class MoveApiDeserializer {
    private int id, newX, newY, oldX, oldY;
    private String player;

    public MoveApiDeserializer(int id, int newX, int newY, int oldX, int oldY, String player){
        this.id = id;
        this.newX = newX;
        this.newY = newY;
        this.oldX = oldX;
        this.oldY = oldY;
        this.player = player;
    }

    public int getId() {
        return id;
    }
    public int getOldX() {
        return oldX;
    }
    public int getOldY() {
        return oldY;
    }
    public int getNewX() {
        return newX;
    }
    public int getNewY() {
        return newY;
    }
    public String getPlayer(){return player;}
}
