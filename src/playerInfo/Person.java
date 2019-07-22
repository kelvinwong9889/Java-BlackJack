package playerInfo;

import cardInfo.Card;
import java.util.ArrayList;

public abstract class Person {

    private ArrayList<Card> personHand;

    public Person() {
        personHand = new ArrayList<>();
    }

    public abstract String getName();

    public void showCards(ArrayList<Card> playerHand) {

    }

    public void getCard(Card card) {

    }
}
