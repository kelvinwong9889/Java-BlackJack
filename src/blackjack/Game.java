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
    private final Rule rule;
    private final Scanner sc;
    private boolean isFinalResult = false;

    public Game(int numOfPlayer, Person dealer, Deck deck, Rule rule, Scanner sc) {
        for (int i = 0; i < numOfPlayer; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
        this.dealer = dealer;
        this.deck = deck;
        this.rule = rule;
        this.sc = sc;
    }

    // Game process
    public void start() {
        initialize();
        playerRound();
        dealerRound();
        finalResult();
    }

    // Initialize players and dealer with two cards
    public void initialize() {
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
                System.out.println(players.get(i).showFirstRoundCards());
            }
            System.out.println(dealer.showFirstRoundCards());
        } catch (Exception e) {
            System.out.println("Can not initalize person hand");
        }
    }

    // Player's round
    public void playerRound() {
        int action;

        System.out.println();
        System.out.println("Players' Round (" + players.size() + " players)");
        System.out.println("======================================");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).showCards() + " | " + playerMessage(players.get(i), dealer));

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
                                System.out.println(players.get(i).showCards() + " | " + playerMessage(players.get(i), dealer));
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

    // Dealer's round
    public void dealerRound() {
        try {
            int numOfFinishGame = 0;

            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getTotalPoint() >= 21) {
                    numOfFinishGame++;
                }
            }

            System.out.println();
            System.out.println("Dealer's Round (" + players.size() + " players)");
            System.out.println("======================================");

            if (numOfFinishGame == players.size()) {
                System.out.println("All players have won or lost the game!");
            } else {
                System.out.println(dealer.showCards() + " | Point: " + dealer.getTotalPoint());

                if (dealer.getTotalPoint() < 17) {
                    System.out.println("Lower than 17, add new cards!");
                    dealer.addCard(deck.giveCard());
                    System.out.println(dealer.showCards() + " | Point: " + dealer.getTotalPoint());
                }
            }
        } catch (Exception e) {
            System.out.println("Uh...There is no card in the deck now...");
        }
    }

    // Final result
    public void finalResult() {
        isFinalResult = true;

        System.out.println();
        System.out.println("Final Result (" + players.size() + " players)");
        System.out.println("======================================");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).showCards() + " | Point: " + players.get(i).getTotalPoint() + " | " + playerMessage(players.get(i), dealer));
        }
        System.out.println(dealer.showCards() + " | Point: " + dealer.getTotalPoint());
    }

    // Show status message for player
    public String playerMessage(Person player, Person dealer) {
        int playerTotalPoint = player.getTotalPoint();
        int dealerTotalPoint = dealer.getTotalPoint();

        String status = "";
        if (isFinalResult) {
            if (rule.isLose(playerTotalPoint, dealerTotalPoint) && !rule.isBust(dealerTotalPoint)) {
                status = "Lose!";
            } else if (rule.isPush(playerTotalPoint, dealerTotalPoint) && !rule.isBust(dealerTotalPoint)) {
                status = "Push!";
            } else if (rule.isWin(playerTotalPoint, dealerTotalPoint) || rule.isBust(dealerTotalPoint)) {
                status = "Win!";
            }
        } else {
            if (rule.isPoint21(playerTotalPoint) && player.getHandLength() == 2) {
                status = "BlackJack!";
            } else if (rule.isBust(playerTotalPoint)) {
                status = "Bust!";
            }
        }
        return status;
    }
}
