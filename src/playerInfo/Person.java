package playerInfo;

import cardInfo.Card;
import cardInfo.Rank;
import java.util.ArrayList;

public abstract class Person {

    private final ArrayList<Card> personHand;

    public Person() {
        personHand = new ArrayList<>();
    }

    public abstract String getName();

    public int getHandLength() {
        return personHand.size();
    }

    // Get card from the deck
    public void addCard(Card card) {
        personHand.add(card);
    }

    // Get total card point (player and dealer)
    public int getTotalPoint() {
        int totalPoint = 0;

        for (Card card : personHand) {
            totalPoint += card.getRank().getValue();

            if (card.getRank().equals(Rank.ACE) && totalPoint <= 11) {
                totalPoint += 10;
            }
        }

        return totalPoint;

        // TESTING ALL BLACKJACK
//        return 21;
        // TESTING ALL BUST
//        return 99;
        // TESTING ALL PUSH
//        return 10;
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
