package cardInfo;

public class Card {

    // Card's information
    private final CardSuit suit;
    private final CardNum num;

    public Card(CardSuit suit, CardNum num) {
        this.suit = suit;
        this.num = num;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardNum getNum() {
        return num;
    }
    
    public String toString() {
        return suit.getCardSuit() + ":" + num.getCardNum();
    }
}
