package sample;

import java.util.*;

public class BlueCard extends Card implements Generator, Lawsuit {

    private int max;

    public BlueCard() {}

    public boolean isSameCareer(Player giver, Player recipient1, Player recipient2) {

            if (giver.getCareer().equals(this.name))
                return true;

            else if (recipient1.getCareer().equals(this.name)) {
                giver.payPlayer(recipient1, 15000);
            }
            else if (recipient2.getCareer().equals(this.name)) {
                giver.payPlayer(recipient2, 15000);
            }
            return
                false;
    }

    public boolean isSameCareer(Player giver, Player recipient1) {

        if (giver.getCareer().equals(this.name))
            return true;

        else if (recipient1.getCareer().equals(this.name)) {
            giver.payPlayer(recipient1, 15000);
        }
        return
                false;
    }
    @Override
    public int generateAmount() {
        Random random = new Random();
        int[] numbers = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int num;

        num = numbers[random.nextInt(numbers.length)];
        return num * 10000;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

    public void lawsuit (Player giver, Player recipient1) {

        giver.payPlayer(recipient1, max);
    }



}