package blackjack;

import static blackjack.Main.sc;
import java.util.ArrayList;

public class TestMode {

    public boolean isTestMode() {
        int tMode;

        do {
            try {
                System.out.print("Go to Test Mode (0-No, 1-Yes): ");
                tMode = sc.nextInt();
                if (tMode == 0 || tMode == 1) {
                    break;
                } else {
                    System.out.println("You must write 0 or 1");
                }
            } catch (Exception e) {
                System.out.println("You must write 0 or 1");
                sc.next();
            }
        } while (true);

        // Decide go to test mode or play game mode
        if (tMode == 1) {
            return true;
        } else {
            return false;
        }
    }
    
//    public ArrayList<Integer> testMode() {
//        ArrayList<Integer> testCardSet = new ArrayList<Integer>();
//        int cardNum;
//        
//        while(true) {
//            System.out.print("Input Card1 in your deck (0 to end): ");
//            cardNum = sc.nextInt();
//            if () {
//                
//            }
//        }
//    }
}
