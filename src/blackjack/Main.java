package blackjack;

import deck.Deck;
import java.util.Scanner;

public class Main {

    // Global declaration for Scanner
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.createDeck();
        deck.printCards();
        
        System.out.println("\nShuffle Deck!!!");
        deck.shuffleDeck();
        deck.printCards();

//        TestMode testMode = new TestMode();
//        
//        // Decide go to test mode or play game mode
//        if (testMode.isTestMode()) {
//            System.out.println("Test mode");
//        } else {
//            System.out.println("Play game mode");
//        }
    }
}
