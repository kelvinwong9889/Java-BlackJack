package playerInfo;

public class Dealer extends Person {

    private final String name;

    public Dealer() {
        this.name = "Dealer";
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String showFirstRoundCards() {
        return name + "'s Hand: " + super.showFirstRoundCards();
    }

    @Override
    public String showCards() {
        return name + "'s Hand: " + super.showCards();
    }
}
