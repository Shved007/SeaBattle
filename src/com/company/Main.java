package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static String[][] pcSea = new String[10][10];
    public static String[][] playerSea = new String[10][10];
    public static String[][] seaToChek = new String[10][10];
    public static boolean battleChek = true;
    public static PlayersInfo playerInfo = new PlayersInfo("Гравець", 0, 5);
    public static PlayersInfo compInfo = new PlayersInfo("Компютер", 0, 5);
    public static SeaBattle player = new Player(playerInfo);
    public static SeaBattle comp = new Computer(compInfo);
    public static Audio startGame = new Audio("sounds/startGame.wav", 0.60);

    public static void main(String[] args) throws InterruptedException {

        String playerChoose = startGameAgreement();
        boolean canStartGame = validatePlayerChoose(playerChoose);
        System.out.println(player);
        System.out.println(comp);
        while(battleChek) {
            if (canStartGame) {
                player.sea(seaToChek);
                player.playerBattlefield(playerSea);
                player.playerShipCoordinate(playerSea);
                player.playerBattlefieldWithShip(playerSea);
                player.seaOpponent(seaToChek);
                System.out.println("---------------");
                System.out.println();
                comp.pcBattlefield(pcSea);
                comp.pcShipCoordinate(pcSea);
            } else break;
            battle();
        }
    }

    public static void battle() throws InterruptedException {
        while(battleChek) {
            player.playerShots(pcSea, compInfo.getName(), compInfo.getScore(), seaToChek);
            comp.pcShots(playerSea, playerInfo.getName(), playerInfo.getScore());
            player.seaOpponent(seaToChek);
            player.playerBattlefieldWithShip(playerSea);
            if (playerInfo.getScore() == 5) {
                System.out.println("Гру завершено\n" +
                        "Переміг " + playerInfo.getName());
                System.out.println("Очки " + playerInfo.getName() + " :" + playerInfo.getScore());
                System.out.println("Очки " + compInfo.getName() + " :" + compInfo.getScore());
                comp.pcBattlefieldWithShip(pcSea);
                player.playerBattlefieldWithShip(playerSea);
                battleChek = false;
            } else if (compInfo.getScore() == 5) {
                System.out.println("Гру завершено\n" +
                        "Переміг " + compInfo.getName());
                System.out.println("Очки " + playerInfo.getName() + " :" + playerInfo.getScore());
                System.out.println("Очки " + compInfo.getName() + " :" + compInfo.getScore());
                comp.pcBattlefieldWithShip(pcSea);
                player.playerBattlefieldWithShip(playerSea);
                battleChek = false;
            }
        }
    }

    public static boolean validatePlayerChoose(String playerChoose) {
        if (playerChoose.equalsIgnoreCase("start")) {
            return true;
        } else if (playerChoose.equalsIgnoreCase("Exit")) {
            System.out.println("Бувай. пограємо наступного разу");
            return false;
        } else {
            System.out.println("Невідома команда.. Error");
            return false;
        }
    }

    public static String startGameAgreement() {
        startGame.sound();
        startGame.setVolume();
        System.out.println("===Welcome to the SEA BATTLE===");
        System.out.println("Якщо Ви хочете зіграти в ігру  введіть Start");
        System.out.println("Якщо Ви хочете зіграти в ігру іншим разом введіть Exit");
        String chooseStart = sc.nextLine();
        return chooseStart;
    }
}
