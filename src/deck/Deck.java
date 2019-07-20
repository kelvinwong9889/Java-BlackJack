package deck;

import cardInfo.Card;
import cardInfo.CardNum;
import cardInfo.CardSuit;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    
    public Deck() {
        cards = new ArrayList<Card>();
    }
    
    public void createDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardNum num : CardNum.values()) {
                this.cards.add(new Card(suit, num));
            }
        }
    }
    
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
    
    public void printCards() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }
}
