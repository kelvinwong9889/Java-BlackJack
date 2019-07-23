package blackjack;

import cardInfo.Card;
import deck.Deck;
import java.util.ArrayList;
import java.util.Scanner;
import playerInfo.Dealer;
import playerInfo.Person;
import playerInfo.Player;

public class Main {

    // Global declaration for Scanner
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("\nShuffle Deck!!!");
        deck.printCards();
        
        Person player1 = new Player("Player 1");
        Person player2 = new Player("Player 2");
        Person dealer = new Dealer();
        
        player1.getCard(deck.giveCard());
        player2.getCard(deck.giveCard());
        dealer.getCard(deck.giveCard());
        
        System.out.println(player1.showCards());
        System.out.println(player2.showCards());
        System.out.println(dealer.showCards());
    }
}
