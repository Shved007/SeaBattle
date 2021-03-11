package com.company;

import java.util.Random;

public class Computer extends SeaBattle {
    public PlayersInfo playersInfo;
    public static Audio alarm;
    public static Random random = new Random();

    public Computer(PlayersInfo playersInfo) {
        this.playersInfo = playersInfo;
    }

    @Override
    void pcBattlefield(String[][] pcSea) {
        for (int ryad = 0; ryad < pcSea.length; ryad++) {
            for (int stovp = 0; stovp < pcSea.length; stovp++) {
                pcSea[ryad][stovp] = "*";
            }
        }
        pcSea[0][0] = " ";
        pcSea[0][1] = "1";
        pcSea[1][0] = "1";
        pcSea[0][2] = "2";
        pcSea[2][0] = "2";
        pcSea[0][3] = "3";
        pcSea[3][0] = "3";
        pcSea[0][4] = "4";
        pcSea[4][0] = "4";
        pcSea[0][5] = "5";
        pcSea[5][0] = "5";
        pcSea[0][6] = "6";
        pcSea[6][0] = "6";
        pcSea[0][7] = "7";
        pcSea[7][0] = "7";
        pcSea[0][8] = "8";
        pcSea[8][0] = "8";
        pcSea[0][9] = "9";
        pcSea[9][0] = "9";
    }

    @Override
    void pcBattlefieldWithShip(String[][] pcSea) {
        System.out.println("Поле бою Компютера");
        for (int ryad = 0; ryad < pcSea.length; ryad++) {
            for (int stovp = 0; stovp < pcSea.length; stovp++) {
                System.out.print(" " + pcSea[ryad][stovp] + " ");
            }
            System.out.println();
        }
    }

    @Override
    void pcShipCoordinate(String[][] pcSea) {
        int ryad, ryad2, ryad3, ryad4, ryad5;
        int stovp, stovp2, stovp3, stovp4, stovp5;
        boolean checkPcCoords2 = false;
        boolean checkPcCoords3 = false;
        boolean checkPcCoords4 = false;
        boolean checkPcCoords5 = false;
        ryad = getRandomNumber();
        stovp = getRandomNumber();
        pcSea[ryad][stovp] = "P";

        do {
            ryad2 = getRandomNumber();
            stovp2 = getRandomNumber();
            if (ryad2 != ryad || stovp2 != stovp) {
                pcSea[ryad2][stovp2] = "P";
                checkPcCoords2 = true;
            }
        } while(!checkPcCoords2);

        do {
            ryad3 = getRandomNumber();
            stovp3 = getRandomNumber();
            if (ryad3 != ryad2 || stovp3 != stovp2) {
                if (ryad3 != ryad || stovp3 != stovp)
                    pcSea[ryad3][stovp3] = "P";
                checkPcCoords3 = true;
            }
        } while(!checkPcCoords3);

        do {
            ryad4 = getRandomNumber();
            stovp4 = getRandomNumber();
            if (ryad4 != ryad3 || stovp4 != stovp3) {
                if (ryad4 != ryad2 || stovp4 != stovp2) {
                    if (ryad4 != ryad || stovp4 != stovp) {
                        pcSea[ryad4][stovp4] = "P";
                        checkPcCoords4 = true;
                    }
                }
            }
        } while(!checkPcCoords4);

        do {
            ryad5 = getRandomNumber();
            stovp5 = getRandomNumber();
            if (ryad5 != ryad4 || stovp5 != stovp4) {
                if (ryad5 != ryad3 || stovp5 != stovp3) {
                    if (ryad5 != ryad2 || stovp5 != stovp2) {
                        if (ryad5 != ryad || stovp5 != stovp) {
                            pcSea[ryad5][stovp5] = "P";
                            checkPcCoords5 = true;
                        }
                    }
                }
            }
        } while(!checkPcCoords5);
    }

    @Override
    void pcShots(String[][] playerSea, String name, int score) {
        alarm = new Audio("sounds/Truvoga.wav", 0.60);
        boolean check = false;
        do {
            int pcShotCoord1 = getRandomNumber();
            int pcShotCoord2 = getRandomNumber();
            if (playerSea[pcShotCoord1][pcShotCoord2].equals("*")) {
                System.out.println("Вистріл робить " + this.playersInfo.getName());
                if (playerSea[pcShotCoord1][pcShotCoord2].equals("P")) {
                    alarm.sound();
                    alarm.setVolume();
                    playerSea[pcShotCoord1][pcShotCoord2] = "X";
                    System.out.println("Корабель " + name + " ЗНИЩЕНО!");
                    int newScore = this.playersInfo.getScore() + 1;
                    this.playersInfo.setScore(newScore);
                    check = true;
                } else {
                    System.out.println("ПРОМАХ!");
                    playerSea[pcShotCoord1][pcShotCoord2] = "O";
                    check = true;
                }

            } else if (playerSea[pcShotCoord1][pcShotCoord2].equals("P")) {
                if (playerSea[pcShotCoord1][pcShotCoord2].equals("P")) {
                    alarm.sound();
                    alarm.setVolume();
                    playerSea[pcShotCoord1][pcShotCoord2] = "X";
                    System.out.println("Корабель " + name + " ЗНИЩЕНО!");
                    int newScore = this.playersInfo.getScore() + 1;
                    this.playersInfo.setScore(newScore);
                } else {
                    playerSea[pcShotCoord1][pcShotCoord2] = "O";
                }
                check = true;
            }

        } while(!check);

    }

    public static int getRandomNumber() {
        int max = 9;
        int min = 1;
        return random.nextInt(max - min) + min;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "playersInfo=" + playersInfo +
                '}';
    }
}
