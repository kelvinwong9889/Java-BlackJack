package blackjack;

import deck.Deck;
import java.util.ArrayList;
import java.util.Scanner;
import playerInfo.Person;
import playerInfo.Player;

public class Game {

    private final ArrayList<Person> persons = new ArrayList<>();
    private final Deck deck;
    private final Scanner sc;

    public Game(int numOfPlayer, Person dealer, Deck deck, Scanner sc) {
        for (int i = 0; i < numOfPlayer; i++) {
            persons.add(new Player("Player " + (i + 1)));
        }
        persons.add(dealer);
        this.deck = deck;
        this.sc = sc;
    }

    public void start() throws Exception {
        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).addCard(deck.giveCard());
            persons.get(i).addCard(deck.giveCard());
        }

        System.out.println("Game Start! (" + (persons.size() - 1) + " players)");
        System.out.println("======================================");

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i).showFirstRoundCards() + " | Point: " + persons.get(i).getTotalPoint());
        }

        playerRound();
        dealerRound();
        finalResult();
    }

    // player's round
    public void playerRound() {
        int action;

        System.out.println();
        System.out.println("Players' Round (" + (persons.size() - 1) + " players)");
        System.out.println("======================================");
        for (int i = 0; i < persons.size() - 1; i++) {
            System.out.println(persons.get(i).showCards() + " | Point: " + persons.get(i).getTotalPoint());

            loop:
            while (true) {
                try {
                    if (persons.get(i).getTotalPoint() < 21) {
                        System.out.print(persons.get(i).getName() + ", do you want to Stand or Hit (0-Stand, 1-Hit)?");
                        action = sc.nextInt();

                        switch (action) {
                            case 0:
                                System.out.println("Stand!!!");
                                break loop;
                            case 1:
                                persons.get(i).addCard(deck.giveCard());
                                System.out.println(persons.get(i).showCards() + " | Point: " + persons.get(i).getTotalPoint());
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
        System.out.println();
        System.out.println("Dealer's Round (" + (persons.size() - 1) + " players)");
        System.out.println("======================================");
        System.out.println(persons.get(persons.size() - 1).showCards() + " | Point: " + persons.get(persons.size() - 1).getTotalPoint());
        try {
            if (persons.get(persons.size() - 1).getTotalPoint() < 17) {
                System.out.println("Lower than 17, add new cards!");
                persons.get(persons.size() - 1).addCard(deck.giveCard());
                System.out.println(persons.get(persons.size() - 1).showCards() + " | Point: " + persons.get(persons.size() - 1).getTotalPoint());
            }
        } catch (Exception e) {
            System.out.println("Uh...There is no card in the deck now...");
        }
        System.out.println();
    }

    // Final result
    public void finalResult() {
        System.out.println();
        System.out.println("Final Result (" + (persons.size() - 1) + " players)");
        System.out.println("======================================");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i).showCards() + " | Point: " + persons.get(i).getTotalPoint());
        }
    }

    // Show status message for player
    public void statusMessage() {
    }
}
