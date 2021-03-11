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
        int ryad, ryad2, ryad3, ryad4, ryad5;
        int stovp, stovp2, stovp3, stovp4, stovp5;
        boolean checkCoords = false;
        boolean checkCoords2 = false;
        boolean checkCoords3 = false;
        boolean checkCoords4 = false;
        boolean checkCoords5 = false;

        System.out.println("Введіть координати Корабля №1 через ПРОБІЛ, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            ryad = scanner.nextInt();
            stovp = scanner.nextInt();
            if (ryad >= 1 && ryad <= 9 && stovp >= 1 && stovp <= 9) {
                playerSea[ryad][stovp] = "P";
                playerBattlefieldWithShip(playerSea);
                checkCoords = true;
            } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
        } while(!checkCoords);


        System.out.println("Введіть координати Корабля №2 через ПРОБІЛ, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            ryad2 = scanner.nextInt();
            stovp2 = scanner.nextInt();
            if (ryad2 >= 1 && ryad2 <= 9 && stovp2 >= 1 && stovp2 <= 9) {
                if (ryad2 != ryad || stovp2 != stovp) {
                    playerSea[ryad2][stovp2] = "P";
                    playerBattlefieldWithShip(playerSea);
                    checkCoords2 = true;
                } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
            } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
        } while(!checkCoords2);


        System.out.println("Введіть координати Корабля №3 через ПРОБІЛ, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            ryad3 = scanner.nextInt();
            stovp3 = scanner.nextInt();
            if (ryad3 >= 1 && ryad3 <= 9 && stovp3 >= 1 && stovp3 <= 9) {
                if (ryad3 != ryad2 || stovp3 != stovp2) {
                    if (ryad3 != ryad || stovp3 != stovp) {
                        playerSea[ryad3][stovp3] = "P";
                        playerBattlefieldWithShip(playerSea);
                        checkCoords3 = true;
                    } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
                } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
            } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
        } while(!checkCoords3);


        System.out.println("Введіть координати Корабля №4 через ПРОБІЛ, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            ryad4 = scanner.nextInt();
            stovp4 = scanner.nextInt();
            if (ryad4 >= 1 && ryad4 <= 9 && stovp4 >= 1 && stovp4 <= 9) {
                if (ryad4 != ryad3 || stovp4 != stovp3) {
                    if (ryad4 != ryad2 || stovp4 != stovp2) {
                        if (ryad4 != ryad || stovp4 != stovp) {
                            playerSea[ryad4][stovp4] = "P";
                            playerBattlefieldWithShip(playerSea);
                            checkCoords4 = true;
                        } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
                    } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
                } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
            } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
        } while(!checkCoords4);


        System.out.println("Введіть координати Корабля №5 через ПРОБІЛ, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            ryad5 = scanner.nextInt();
            stovp5 = scanner.nextInt();
            if (ryad5 >= 1 && ryad5 <= 9 && stovp5 >= 1 && stovp5 <= 9) {
                if (ryad5 != ryad4 || stovp5 != stovp4) {
                    if (ryad5 != ryad3 || stovp5 != stovp3) {
                        if (ryad5 != ryad2 || stovp5 != stovp2) {
                            if (ryad5 != ryad || stovp5 != stovp) {
                                playerSea[ryad5][stovp5] = "P";
                                playerBattlefieldWithShip(playerSea);
                                checkCoords5 = true;
                            } else
                                System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
                        } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
                    } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
                } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
            } else System.out.println("Вибране розміщення не може бути використане... Спробуйте ще раз:");
        } while(!checkCoords5);


    }

    @Override
    public void playerShots(String[][] pcSea, String pcName, int score, String[][] seaToChek) throws InterruptedException {
        boolean shotsCheck = false;
        shot = new Audio("sounds/shot.wav", 0.60);
        explosion = new Audio("sounds/boom.wav", 0.8);
        shotOnTarget = new Audio("sounds/est-probitie.wav", 0.8);
        System.out.println("Вистріл робить: " + this.playersInfo.getName());
        System.out.println("Введіть координати вистрілу через ПРОБІЛ, введіть рядок(від 1-9) і введіть стовпчик(від 1-9)");
        do {
            int playerShotCoord1 = scanner.nextInt();
            int playerShotCoord2 = scanner.nextInt();

            if (playerShotCoord1 >= 0 && playerShotCoord1 < pcSea.length && playerShotCoord2 >= 0 && playerShotCoord2 < pcSea.length && pcSea[playerShotCoord1][playerShotCoord2].equals("*")) {
                shot.sound();
                shot.setVolume();
                Thread.sleep(1500);
                if (pcSea[playerShotCoord1][playerShotCoord2].equals("P")) {
                    shot.sound();
                    shot.setVolume();
                    Thread.sleep(1500);
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
                    shot.sound();
                    shot.setVolume();
                    Thread.sleep(1500);
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
