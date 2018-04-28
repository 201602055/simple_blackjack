package com.cnu.blackjack;
import org.junit.Test;

public class EvaluatorTest {
    @Test
    public void 게임시작() {
        Deck deck=new Deck(1);
        Game game = new Game(deck);

        game.addPlayer("hello", 5000);
        game.placeBet("hello", 1000);
        Evaluator evaluator = new Evaluator(game.getPlayerList());
        evaluator.start();
    }
}
