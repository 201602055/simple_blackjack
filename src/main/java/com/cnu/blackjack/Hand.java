package com.cnu.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private Deck deck;
    private final List<Card> cardList ;

    public Hand(Deck deck) {
        this.deck = deck;
        this.cardList=new ArrayList<>();
    }

    public Card drawCard() {
        Card card = deck.drawCard();
        cardList.add(card);
        return card;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int sumRank(){
        int sum = 0;
        for(int i=0;i<cardList.size();i++){
            sum+=cardList.get(i).getRank();
        }
        return sum;
    }
}