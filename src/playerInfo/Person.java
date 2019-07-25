package playerInfo;

import cardInfo.Card;
import java.util.ArrayList;

public abstract class Person {

    private final ArrayList<Card> personHand;

    public Person() {
        personHand = new ArrayList<>();
    }

    public abstract String getName();

    // Get card from the deck
    public void addCard(Card card) {
        personHand.add(card);
    }

    // Get total card point (player and dealer)
    public int getTotalPoint() {
        int totalPoint = 0;

        for (Card card : personHand) {
            totalPoint += card.getRank().getValue();
        }

        return totalPoint;
    }

    // Show cards (only for first round)
    public String showFirstRoundCards() {
        String message = "[ Unknown ";
        message += personHand.get(1) + " ]";
        return message;
    }

    // Show all the cards
    public String showCards() {
        String message = "[ ";
        for (Card card : personHand) {
            message += card + " ";
        }
        message += "]";
        return message;
    }
}
