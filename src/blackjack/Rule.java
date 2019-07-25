package blackjack;

public class Rule {

    // Blackjack
    public boolean isBlackJack(int personPoint) {
        return (personPoint == 21);
    }

    // Bust
    public boolean isBust(int personPoint) {
        return (personPoint > 21);
    }

    // Win
    public boolean isWin(int playerPoint, int dealerPoint) {
        return (playerPoint > dealerPoint);
    }

    // Push
    public boolean isPush(int playerPoint, int dealerPoint) {
        return (playerPoint == dealerPoint);
    }

    // Lose
    public boolean isLose(int playerPoint, int dealerPoint) {
        return (playerPoint < dealerPoint);
    }
}
