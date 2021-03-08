package com.company;

import java.util.Scanner;

public class Player extends SeaBattle {
    public PlayersInfo playersInfo;
    public static Scanner scanner = new Scanner(System.in);

    public Player(PlayersInfo playersInfo) {
        this.playersInfo = playersInfo;
    }

    public static Audio shot;
    public static Audio explosion;
    public static Audio shotOnTarget;

    @Override
    public void playerBattlefield(String[][] playerSea) {

        for (int ryad = 0; ryad < playerSea.length; ryad++) {
            for (int stovp = 0; stovp < playerSea.length; stovp++) {
                playerSea[ryad][stovp] = "*";
            }
        }
        playerSea[0][0] = " ";
        playerSea[0][1] = "1";
        playerSea[1][0] = "1";
        playerSea[0][2] = "2";
        playerSea[2][0] = "2";
        playerSea[0][3] = "3";
        playerSea[3][0] = "3";
        playerSea[0][4] = "4";
        playerSea[4][0] = "4";
        playerSea[0][5] = "5";
        playerSea[5][0] = "5";
        playerSea[0][6] = "6";
        playerSea[6][0] = "6";
        playerSea[0][7] = "7";
        playerSea[7][0] = "7";
        playerSea[0][8] = "8";
        playerSea[8][0] = "8";
        playerSea[0][9] = "9";
        playerSea[9][0] = "9";
        playerBattlefieldWithShip(playerSea);
    }

    @Override
    public void playerBattlefieldWithShip(String[][] playerSea) {
        System.out.println("Поле бою Гравця");
        for (int ryad = 0; ryad < playerSea.length; ryad++) {
            for (int stovp = 0; stovp < playerSea.length; stovp++) {
                System.out.print(" " + playerSea[ryad][stovp] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void playerShipCoordinate(String[][] playerSea) {
        System.out.println("Введіть координати Корабля №1, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        int ryad = scanner.nextInt();
        int stovp = scanner.nextInt();
        playerSea[ryad][stovp] = "P";
        playerBattlefieldWithShip(playerSea);

        System.out.println("Введіть координати Корабля №2, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        int ryad2 = scanner.nextInt();
        int stovp2 = scanner.nextInt();
        playerSea[ryad2][stovp2] = "P";
        playerBattlefieldWithShip(playerSea);

        System.out.println("Введіть координати Корабля №3, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        int ryad3 = scanner.nextInt();
        int stovp3 = scanner.nextInt();
        playerSea[ryad3][stovp3] = "P";
        playerBattlefieldWithShip(playerSea);

        System.out.println("Введіть координати Корабля №4, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        int ryad4 = scanner.nextInt();
        int stovp4 = scanner.nextInt();
        playerSea[ryad4][stovp4] = "P";
        playerBattlefieldWithShip(playerSea);

        System.out.println("Введіть координати Корабля №5, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        int ryad5 = scanner.nextInt();
        int stovp5 = scanner.nextInt();
        playerSea[ryad5][stovp5] = "P";
        playerBattlefieldWithShip(playerSea);
    }

    @Override
    public void playerShots(String[][] pcSea, String pcName, int score, String[][] seaToChek) throws InterruptedException {
        boolean shotsCheck = false;
        shot = new Audio("sounds/shot.wav", 0.60);
        explosion = new Audio("sounds/boom.wav", 0.8);
        shotOnTarget = new Audio("sounds/est-probitie.wav", 0.8);
        System.out.println("Вистріл робить: " + this.playersInfo.getName());
        System.out.println("Введіть координати вистрілу, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            int playerShotCoord1 = scanner.nextInt();
            int playerShotCoord2 = scanner.nextInt();
            shot.sound();
            shot.setVolume();
            Thread.sleep(1500);
            if (playerShotCoord1 >= 0 && playerShotCoord1 < pcSea.length && playerShotCoord2 >= 0 && playerShotCoord2 < pcSea.length && pcSea[playerShotCoord1][playerShotCoord2].equals("*")) {
                if (pcSea[playerShotCoord1][playerShotCoord2].equals("P")) {
                    shotOnTarget.sound();
                    shotOnTarget.setVolume();
                    pcSea[playerShotCoord1][playerShotCoord2] = "X";
                    seaToChek[playerShotCoord1][playerShotCoord2] = "X";
                    System.out.println("Корабель " + pcName + " ЗНИЩЕНО!");
                    int newScore = this.playersInfo.getScore() + 1;
                    this.playersInfo.setScore(newScore);
                } else {
                    System.out.println("ПРОМАХ!");
                    pcSea[playerShotCoord1][playerShotCoord2] = "O";
                    seaToChek[playerShotCoord1][playerShotCoord2] = "O";
                }
                System.out.println("Очки " + pcName + ":" + score);
                System.out.println("Очки " + this.playersInfo.getName() + ":" + this.playersInfo.getScore());
                shotsCheck = true;
            } else if (playerShotCoord1 >= 0 && playerShotCoord1 < pcSea.length && playerShotCoord2 >= 0 && playerShotCoord2 < pcSea.length && pcSea[playerShotCoord1][playerShotCoord2].equals("P")) {
                if (pcSea[playerShotCoord1][playerShotCoord2].equals("P")) {
                    shotOnTarget.sound();
                    shotOnTarget.setVolume();
                    pcSea[playerShotCoord1][playerShotCoord2] = "X";
                    seaToChek[playerShotCoord1][playerShotCoord2] = "X";
                    System.out.println("Корабель " + pcName + " ЗНИЩЕНО!");
                    int newScore = this.playersInfo.getScore() + 1;
                    this.playersInfo.setScore(newScore);
                } else {
                    System.out.println("ПРОМАХ!");
                    pcSea[playerShotCoord1][playerShotCoord2] = "O";
                    seaToChek[playerShotCoord1][playerShotCoord2] = "O";
                }
                System.out.println("Очки " + pcName + ":" + score);
                System.out.println("Очки " + this.playersInfo.getName() + ":" + this.playersInfo.getScore());
                shotsCheck = true;
            } else {
                System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
            }
        } while(!shotsCheck);

    }

    @Override
    public void sea(String[][] seaToChek) {
        for (int ryad = 0; ryad < seaToChek.length; ryad++) {
            for (int stovp = 0; stovp < seaToChek.length; stovp++) {
                seaToChek[ryad][stovp] = "*";
            }
        }
        seaToChek[0][0] = " ";
        seaToChek[0][1] = "1";
        seaToChek[1][0] = "1";
        seaToChek[0][2] = "2";
        seaToChek[2][0] = "2";
        seaToChek[0][3] = "3";
        seaToChek[3][0] = "3";
        seaToChek[0][4] = "4";
        seaToChek[4][0] = "4";
        seaToChek[0][5] = "5";
        seaToChek[5][0] = "5";
        seaToChek[0][6] = "6";
        seaToChek[6][0] = "6";
        seaToChek[0][7] = "7";
        seaToChek[7][0] = "7";
        seaToChek[0][8] = "8";
        seaToChek[8][0] = "8";
        seaToChek[0][9] = "9";
        seaToChek[9][0] = "9";
    }

    @Override
    public void seaOpponent(String[][] seaToChek) {
        System.out.println("Уявне поле Опонента");
        for (int ryad = 0; ryad < seaToChek.length; ryad++) {
            for (int stovp = 0; stovp < seaToChek.length; stovp++) {
                System.out.print(" " + seaToChek[ryad][stovp] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "playersInfo=" + playersInfo +
                '}';
    }


}
