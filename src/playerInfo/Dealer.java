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
}
