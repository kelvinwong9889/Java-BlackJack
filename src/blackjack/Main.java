package blackjack;

import deck.Deck;
import java.util.Scanner;
import playerInfo.Dealer;
import playerInfo.Person;

public class Main {

    // Global declaration for Scanner
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                int numOfPlayer;

                // Create a number of players
                System.out.print("How many players (1-4)? ");
                numOfPlayer = sc.nextInt();

                if (numOfPlayer >= 1 && numOfPlayer <= 4) {
                    // Create dealer
                    Person dealer = new Dealer();
                    // Create deck and shuffle 52 cards
                    Deck deck = new Deck();

                    // Start blackjack game once only
                    Game game = new Game(numOfPlayer, dealer, deck, sc);
                    game.start();
                    break;
                } else {
                    System.out.println("You must input the number of player between 1 and 4.");
                }
            } catch (Exception e) {
                e.printStackTrace();
//                System.out.println("You must input the number of player between 1 and 4.");
                sc.next();
            }
        }
    }
}
