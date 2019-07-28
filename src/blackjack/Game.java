package blackjack;

import deck.Deck;
import java.util.ArrayList;
import java.util.Scanner;
import playerInfo.Person;
import playerInfo.Player;

public class Game {

    private final ArrayList<Person> players = new ArrayList<>();
    private final Person dealer;
    private final Deck deck;
    private final Scanner sc;

    public Game(int numOfPlayer, Person dealer, Deck deck, Scanner sc) {
        for (int i = 0; i < numOfPlayer; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
        this.dealer = dealer;
        this.deck = deck;
        this.sc = sc;
    }

    public void start() {
        initializePersonHand();
        playerRound();
        dealerRound();
        finalResult();
    }

    public void initializePersonHand() {
        try {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).addCard(deck.giveCard());
                players.get(i).addCard(deck.giveCard());
            }
            dealer.addCard(deck.giveCard());
            dealer.addCard(deck.giveCard());

            System.out.println("Game Start! (" + players.size() + " players)");
            System.out.println("======================================");

            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).showFirstRoundCards() + " | Point: " + players.get(i).getTotalPoint());
            }
            System.out.println(dealer.showFirstRoundCards() + " | Point: " + dealer.getTotalPoint());
        } catch (Exception e) {
            System.out.println("Can not initalize person hand");
        }
    }

    // player's round
    public void playerRound() {
        int action;

        System.out.println();
        System.out.println("Players' Round (" + players.size() + " players)");
        System.out.println("======================================");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).showCards() + " | Point: " + players.get(i).getTotalPoint() + " | " + players.get(i).statusMessage());

            loop:
            while (true) {
                try {
                    if (players.get(i).getTotalPoint() < 21) {
                        System.out.print(players.get(i).getName() + ", do you want to Stand or Hit (0-Stand, 1-Hit)?");
                        action = sc.nextInt();

                        switch (action) {
                            case 0:
                                System.out.println("Stand!!!");
                                break loop;
                            case 1:
                                players.get(i).addCard(deck.giveCard());
                                System.out.println(players.get(i).showCards() + " | Point: " + players.get(i).getTotalPoint() + " | " + players.get(i).statusMessage());
                                break loop;
                            default:
                                System.out.println("You must input the number of player between 0 and 1.");
                        }
                    } else {
                        break loop;
                    }
                } catch (Exception e) {
                    System.out.println("You must input the number of player between 0 and 1.");
                    sc.next();
                }
            }
        }
    }

    // dealer's round
    public void dealerRound() {
        try {
            System.out.println();
            System.out.println("Dealer's Round (" + players.size() + " players)");
            System.out.println("======================================");
            System.out.println(dealer.showCards() + " | Point: " + dealer.getTotalPoint());

            if (dealer.getTotalPoint() < 17) {
                System.out.println("Lower than 17, add new cards!");
                dealer.addCard(deck.giveCard());
                System.out.println(dealer.showCards() + " | Point: " + dealer.getTotalPoint());
            }
        } catch (Exception e) {
            System.out.println("Uh...There is no card in the deck now...");
        }
    }

    // Final result
    public void finalResult() {
        System.out.println();
        System.out.println("Final Result (" + players.size() + " players)");
        System.out.println("======================================");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).showCards() + " | Point: " + players.get(i).getTotalPoint() + " | " + players.get(i).statusMessage());
        }
        System.out.println(dealer.showCards() + " | Point: " + dealer.getTotalPoint() + " | " + dealer.statusMessage());
    }
}
