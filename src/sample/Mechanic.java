package sample;

import java.util.ArrayList;
/**
 *  Mechanism class for getting the highest number from the number of players
 */
public class Mechanic {

    Mechanic(){ }
    int curr;
    int[] num = new int[3]; // list of random numbers from players 1 - 3
    /**
     *  @return int value of the supposed current player
     */
    public int highestNumFromPlayers(ArrayList<Player> players) {
        if (players.size() == 3) {
            do {
                num[0] = players.get(0).pressRandomNum();
                num[1] = players.get(1).pressRandomNum();
                num[2] = players.get(2).pressRandomNum();

                if (num[0] > num[1]) {
                    if (num[2] > num[0])
                        curr = 2;
                    else
                        curr = 0;
                } else if (num[2] > num[1])
                    curr = 2;

                else
                    curr = 1;

            } while ((num[0] == num[1]) || (num[1] == num[2]) || (num[0] == num[2]));
        }
        else
        {
            num[0] = players.get(0).pressRandomNum();
            num[1] = players.get(1).pressRandomNum();

        if (num[0] > num[1])
            curr = 0;
        else
            curr = 1;
        }

        return curr;
    }
}


