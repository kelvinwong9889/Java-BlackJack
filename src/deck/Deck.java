package deck;

import cardInfo.Card;
import cardInfo.Rank;
import cardInfo.Suit;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // Define cards list
    private final ArrayList<Card> cards;

    // Create the deck for BlackJack game
    public Deck() {
        cards = new ArrayList<>();

        // Create 52 cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }

        // Shuffle all the cards
        Collections.shuffle(cards);
    }

    // Give card to player or dealer
    public Card giveCard() throws Exception {
        if (cards.size() > 0) {
            Card card = cards.remove(cards.size() - 1);
//            System.out.println("Card Size: " + cards.size());
            return card;
        } else {
            throw new Exception();
        }
    }

    // TESTING
    public void printCards() {
        cards.forEach((card) -> {
            System.out.println(card.toString());
        });
    }
}
