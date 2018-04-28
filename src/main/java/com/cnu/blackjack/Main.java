package com.cnu.blackjack;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck(1);
        Game game = new Game(deck);l

        game.addPlayer("been", 5000);
        game.placeBet("been", 1000);

        game.addPlayer("in", 5000);
        game.placeBet("in", 1000);

        System.out.println("--Game Start--");
        game.start();
        Evaluator evaluator = new Evaluator(game.getPlayerList());
        evaluator.start();
    }
}