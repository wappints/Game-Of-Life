package sample;

import java.util.*;
/** Action Card as the subclass of the Card implementing interfaces Generator and Lawsuit
 *
 *
 */
public class ActionCard extends Card implements Generator, Lawsuit {

    private int value;
    private String eventDescript;


    public ActionCard ()
    {
        value = generateAmount();
    }

    public String getEventDescript()
    {
        return this.eventDescript;
    }

    public void setEventDescript (String eventDescript)
    {
        this.eventDescript = eventDescript;
    }
    /** generate the min number ranging from 1 to the max number generated from GenerateMaxMultiple
     *
     *
     * @return max - int value
     */
    public int generateAmount() {
        Random random = new Random();
        int num = random.nextInt(15); // generates a random number from 0 to 14
        return (num + 1) * 1000; // adding 1 makes the range of the random number from 1 to 15

    }
    /**
     *
     * @return int value of the certain Card
     *
     */
    public int getValue()
    {
        return value;
    }
    /** file a lawsuit against a player
     *
     * @param giver player that will give the money
     * @param recipient1 player that will receive the money
     *
     */
    public void lawsuit (Player giver, Player recipient1) {
        giver.payPlayer(recipient1, value);
    }
}