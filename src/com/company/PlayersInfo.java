package com.company;

public class PlayersInfo {
    private String name;
    private int score;
    private int numberOfShip;

    public PlayersInfo() {
    }

    public PlayersInfo(String name, int score, int numberOfShip) {
        this.name = name;
        this.score = score;
        this.numberOfShip = numberOfShip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfShip() {
        return numberOfShip;
    }

    public void setNumberOfShip(int numberOfShip) {
        this.numberOfShip = numberOfShip;
    }

    @Override
    public String toString() {
        return "PlayersInfo{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", numberOfShip=" + numberOfShip +
                '}';
    }
}
