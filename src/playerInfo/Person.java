package playerInfo;

import cardInfo.Card;
import java.util.ArrayList;

public abstract class Person {

    private ArrayList<Card> personHand;

    public Person() {
        personHand = new ArrayList<>();
    }

    public abstract String getName();

    public void getCard(Card card) {
        personHand.add(card);
    }

    public String showCards() {
        String message = "[ ";
        for (Card card : personHand) {
            message += card + " ";
        }
        message += "]";
        return message;
    }
}
