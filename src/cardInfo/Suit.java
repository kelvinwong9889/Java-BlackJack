package cardInfo;

public enum Suit {
    HEART("Heart"),
    CLUB("Club"),
    DIAMOND("Diamond"),
    SPADE("Spade");

    // Card's suit
    private final String suit;

    private Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
