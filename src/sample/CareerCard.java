package sample;

import java.util.*;
/**
 *  Class of CareerCard extending Card
 */
public class CareerCard extends Card  {
    private int payRaise;
    private boolean needsDegree;

    /**
     * default constructor for CareerCard
     */
    public CareerCard () { }

    public int getPayRaise () {
        return this.payRaise;
    }

    public void setPayRaise (String career) {
        this.payRaise = generateMaxMultiple(career);
    }

    public boolean getDegree () {
        return this.needsDegree;
    }
    /** sets degree for Career
     *
     * @param career
     */
    public void setDegree (String career) {
        this.needsDegree = isNeedsDegree(career);
    }
    /** generates the fixed career of the Card
     *
     * @return String of career
     */
    public String generateCareer (int i) {

        String[] careers = {"Lawyer", "Accountant", "Computer Consultant", "Doctor", "Server", "Racecar Driver", "Athlete"};

        return careers[i];


    }
    /** check if player has degree and if career card needs degree
     *
     * @param player
     *
     * @return boolean
     */
    public boolean checkPlayerDegree(Player player) {
        return player.getCareerDegree() && isNeedsDegree(this.name);
    }
    /** check if player has degree and if career card needs degree
     *
     * @param career - String value of the card
     *
     * @return int -
     */
    public int generateMaxMultiple(String career) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        Random random = new Random();
        int randomNum = random.nextInt(numbers.length);
        int num = 0;

        switch (career) {
            case "Lawyer":
            case "Doctor":
                if (numbers[randomNum] >= 5)
                    num = numbers[randomNum];
                break;
            case "Accountant":
                if (numbers[randomNum] >= 4 && numbers[randomNum] <= 7)
                    num = numbers[randomNum];
                break;
            case "Computer Consultant":
                if (numbers[randomNum] >= 3 && numbers[randomNum] <= 7)
                    num = numbers[randomNum];
                break;
            case "Server":
                if (numbers[randomNum] <= 4)
                    num = numbers[randomNum];
                break;
            case "Racecar Driver":
                if (numbers[randomNum] >= 2)
                    num = numbers[randomNum];
                break;
            case "Athlete":
                if (numbers[randomNum] <= 6)
                    num = numbers[randomNum];
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.name);
        }

        return num;
    }

    public boolean isNeedsDegree (String career) {
        boolean flag;
        switch (career) {
            case "Lawyer": case "Accountant": case "Doctor": case "Computer Consultant": flag = true;
            case "Server": case "Racecar Driver": case "Athlete": flag = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + career);
        }
        return flag;
    }
    public void triggerEvent (Player player)
    {
        player.setMinRaise(0);
        if (getDegree())
            if (checkPlayerDegree(player))
            {
                player.setPayRaise(getPayRaise());
                player.setMinRaise(0);
            }


    }
}