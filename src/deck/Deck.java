package deck;

import cardInfo.Card;
import cardInfo.Rank;
import cardInfo.Suit;
import java.util.ArrayList;
import java.util.Collections;
import playerInfo.Person;

public class Deck {

    // Define cards list
    private ArrayList<Card> cards;

    // Create the deck for BlackJack game
    public Deck() {
        cards = new ArrayList<>();

        // Create 52 cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    // Create 52 cards
//    public void createDeck() {
//        for (Suit suit : Suit.values()) {
//            for (Rank rank : Rank.values()) {
//                this.cards.add(new Card(suit, rank));
//            }
//        }
//    }
    // Shuffle all the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Give card to player or dealer
    public Card giveCard() {
        Card card = cards.remove(cards.size() - 1);
        System.out.println("Card Size: " + cards.size());
        return card;
    }

    // TESTING
    public void printCards() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }
}
