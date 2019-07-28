package playerInfo;

import blackjack.Rule;
import cardInfo.Card;
import cardInfo.Rank;
import java.util.ArrayList;

public abstract class Person {

    private final ArrayList<Card> personHand;
    private final Rule rule;

    public Person() {
        personHand = new ArrayList<>();
        this.rule = new Rule();
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

            if (card.getRank().equals(Rank.ACE) && totalPoint <= 11) {
                totalPoint += 10;
            }
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

    // Show status message for player
    public String statusMessage() {
        int totalPoint = getTotalPoint();

        if (rule.isPoint21(totalPoint) && personHand.size() == 2) {
            return " BlackJack!";
        } else if (rule.isBust(totalPoint)) {
            return " Bust!";
        } else {
            return "";
        }
    }
}
