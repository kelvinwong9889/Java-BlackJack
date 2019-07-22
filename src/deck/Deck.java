package deck;

import cardInfo.Card;
import cardInfo.Rank;
import cardInfo.Suit;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // Define cards list
    private ArrayList<Card> cards;

    // Create the deck for BlackJack game
    public Deck() {
        cards = new ArrayList<Card>();

        // Create 52 cards from Card class
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    // Shuffle all the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    // Give two cards for first round

    // TESTING
    public void printCards() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }
}
