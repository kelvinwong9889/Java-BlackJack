package cardInfo;

public enum CardNum {
    ACE(1, "Ace"), TWO(2, "02"), THREE(3, "03"), FOUR(4, "04"),
    FIVE(5, "05"), SIX(6, "06"), SEVEN(7, "07"), EIGHT(8, "08"),
    NINE(9, "09"), TEN(10, "10"), JACK(10, "Jack"), QUEEN(10, "Queen"),
    KING(10, "King");

    // Card's value
    private final int cardValue;
    private final String cardNum;

    private CardNum(int cardValue, String cardNum) {
        this.cardValue = cardValue;
        this.cardNum = cardNum;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardNum() {
        return cardNum;
    }
}
