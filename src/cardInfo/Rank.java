package cardInfo;

public enum Rank {
    ACE(1, "Ace"), TWO(2, "02"), THREE(3, "03"), FOUR(4, "04"),
    FIVE(5, "05"), SIX(6, "06"), SEVEN(7, "07"), EIGHT(8, "08"),
    NINE(9, "09"), TEN(10, "10"), JACK(10, "Jack"), QUEEN(10, "Queen"),
    KING(10, "King");

    // Card's value and number
    private final int value;
    private final String number;

    private Rank(int value, String number) {
        this.value = value;
        this.number = number;
    }

    public int getValue() {
        return value;
    }

    public String getNumber() {
        return number;
    }
}
