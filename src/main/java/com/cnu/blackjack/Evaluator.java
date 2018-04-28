package com.cnu.blackjack;

import java.util.Map;

public class Evaluator {
    private Map<String, Player> playerMap;
    private Dealer dealer;

    public Evaluator(Map<String, Player> playerMap) {
        this.playerMap = playerMap;
        dealer = new Dealer();
        dealCardToPlayers();
    }

    public void start() {
        int dealerScore = dealer.getScore();
        playerMap.forEach((name, player) -> {
            System.out.println(name+" player's money : "+(player.getBalance()+player.getCurrentBet()));
            System.out.println(name+" player's betting money : "+player.getCurrentBet());
            boolean result=false;
            while(true) {
                if(dealerScore==21){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Blackjack!! Dealer win.");
                    result=true;
                    break;
                }
                if(dealerScore > 21){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Dealer's score is over 21. "+name+" player win.");
                    player.returnBet();
                    result=true;
                    break;
                }
                if(player.getHand().sumRank() > 21){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println(name + " player's score is over 21. Dealer win.");
                    result=true;
                    break;
                }
                if(dealerScore > 21 && player.getHand().sumRank() > 21){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Both score is over 21. Draw.");
                    player.returnBet();
                    result=true;
                    break;
                }
                if(dealerScore == 21 && player.getHand().sumRank() == 21){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Both score is 21. Draw.");
                    player.returnBet();
                    result=true;
                    break;
                }
                if (player.getHand().sumRank() == 21) {
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Blackjack!! "+name+" player win.");
                    player.blackjackBet();
                    result=true;
                    break;
                }
                if (player.getHand().sumRank() <= 16) {
                    player.hitCard();
                    continue;
                }
                if (player.getHand().sumRank() >= 17) {
                    break;
                }
            }
            if(result==false) {
                if(player.getHand().sumRank()>21){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println(name+" player's score is over 21. Dealer win.");
                }
                else if (21-player.getHand().sumRank() < 21-dealerScore) {
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println(name+" player win.");
                    player.returnBet();
                }else if(player.getHand().sumRank() == dealerScore){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Draw.");
                    player.returnBet();
                }else if (21-player.getHand().sumRank() > 21-dealerScore){
                    System.out.println("dealer's score : "+dealerScore);
                    System.out.println(name+" player's score : "+player.getHand().sumRank());
                    System.out.println("Dealer win.");
                }
            }
            System.out.println(name+" player's money : "+player.getBalance());

        });
    }

    private void dealCardToPlayers() {
        playerMap.forEach((name, player) -> {
            player.hitCard();
            player.hitCard();
        });
    }
    
}
