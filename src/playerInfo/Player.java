package playerInfo;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Integer> handsCard;
    
    public Player(String name, ArrayList<Integer> handsCard) {
        this.name = name;
        this.handsCard = handsCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getHandsCard() {
        return handsCard;
    }

    public void setHandsCard(ArrayList<Integer> handsCard) {
        this.handsCard = handsCard;
    }
}
