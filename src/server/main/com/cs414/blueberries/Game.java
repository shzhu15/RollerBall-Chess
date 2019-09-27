package com.cs414.blueberries;

import java.util.Random;

public class Game {
    private int id;
    public Game () {
        Random random = new Random();
        this.id = random.nextInt();
    }

    public int getId () {
        return this.id;
    }

    @Override
    public String toString () {
        return "Game Id: " + id;
    }
}
