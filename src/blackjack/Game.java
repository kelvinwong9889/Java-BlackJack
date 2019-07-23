package blackjack;

import deck.Deck;
import java.util.ArrayList;
import playerInfo.Person;
import playerInfo.Player;

public class Game {

    private final ArrayList<Person> persons = new ArrayList<>();
    private final Deck deck;

    public Game(int numOfPlayer, Person dealer, Deck deck) {
        for (int i = 0; i < numOfPlayer; i++) {
            persons.add(new Player("Player " + (i + 1)));
        }
        persons.add(dealer);
        this.deck = deck;
    }

//    public void addPerson(Person person) {
//        persons.add(person);
//    }
//
//    public Person getPerson(int index) {
//        return persons.get(index);
//    }
//
//    public ArrayList<Person> getPersons() {
//        return persons;
//    }

    public void start() throws Exception {
        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).getCard(deck.giveCard());
        }
        
        System.out.println("Game Start! (3 players)");
        System.out.println("======================================");

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i).showCards());
        }
    }

    // player's round
    // dealer's round
}
