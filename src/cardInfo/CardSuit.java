package cardInfo;

public enum CardSuit {
    HEART("Heart"),
    CLUB("Club"),
    DIAMOND("Diamond"),
    SPADE("Spade");

    // Card's suit
    private final String cardSuit;

    private CardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public String getCardSuit() {
        return cardSuit;
    }
}
