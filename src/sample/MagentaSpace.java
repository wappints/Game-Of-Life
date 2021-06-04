package sample;

import java.util.ArrayList;
import java.util.Random;
/** class Magenta space
 *
 * <p> Space where players have to stop despite having excessive movements </p>
 */
public class MagentaSpace extends Space {

    Random random = new Random();
    int[] numbers = {1, 2};
    private int num = random.nextInt(numbers.length);

    /** constructor of the Magenta Space (fixed)
     *
     */
    MagentaSpace(String event) {

        setColor("magenta");
        setEventName(event);
    }

    /** method for CollegeCareerChoice
     * @param player
     * @param CCDeck
     * @param SCDeck
     * @param num
     */
    public void CollegeCareerChoice(Player player, CareerCardDeck CCDeck, SalaryCardDeck SCDeck, int num) {
        ArrayList<CareerCard> cc = new ArrayList<>(2);
        ArrayList<SalaryCard> sc = new ArrayList<>(2);
        ArrayList<Card> CC = new ArrayList<Card>(4);

        cc.add((CareerCard) CCDeck.getCard());
        cc.add((CareerCard) CCDeck.getCard());
        sc.add((SalaryCard) SCDeck.getCard());
        sc.add((SalaryCard) SCDeck.getCard());
        CC.addAll(cc);
        CC.addAll(sc);
        if (num % 2 == 0) {
            player.pickCard(CCDeck);
            player.pickCard(CCDeck);
            player.getCareerCard().triggerEvent();
            CCDeck.setCounter(CCDeck.getCounter() - 2);
            player.pickCard(SCDeck);
            player.pickCard(SCDeck);
            player.getCareerCard().triggerEvent();
            CCDeck.setCounter(CCDeck.getCounter() - 2);
        } else {
            player.pickCard(CCDeck);
            player.pickCard(SCDeck);
            CCDeck.setCounter(CCDeck.getCounter() - 1);
            SCDeck.setCounter(CCDeck.getCounter() - 1);
        }

    }

    /** method for jobSearch
     * @param player
     * @param CCDeck
     * @param SCDeck
     * @param choice
     * @return Card
     */
    public Card jobSearch(Player player, CareerCardDeck CCDeck, SalaryCardDeck SCDeck, boolean choice) {


        if (choice == true) {
            player.pickCard(CCDeck);
            player.getCareerCard().triggerEvent();
            player.pickCard(SCDeck);
            player.getSalaryCard().triggerEvent();
            player.setMinRaise(0);
        }
        // if condition for player when clicked button
        // if condition if player choose career
        player.setPayRaise(0);
        return null;
    }

    /** method for buyAHouse
     * @param player
     * @param bank
     * @param HCDeck
     * @return HouseCard
     */
    public void buyAHouse (Player player, Bank bank, HouseCardDeck HCDeck) {
        // if condition for button when buying a house
        player.pickCard(HCDeck);
    }
    /** method for CollegeCareerChoice
     * @param player
     */
    public void graduationDay(Player player) {
        player.setCareerDegree(true);
    }
    /** method for getMarried
     * @param player
     */
    public void getMarried(Player player, int num) {
        player.setMarried(true);
        System.out.println("ACTIVATE");
        if (num % 2 == 0)
            player.addMoney(10000);
        else
            player.addMoney(5000);
    }
    /** method for haveChild
     * @param player
     */
    public void haveChild(Player player) {

        if (player.isMarried()) {
            player.setChildren(player.getChildren() + getNum());
            player.addMoney(5000 * player.getChildren());
        }
        System.out.println("Player has children " + player.getChildren());

    }
    /** method for Triggering event of magenta space
     * @param player
     */
    public void triggerEvent(Player player) {
        switch (getEventName()) {
            case "Get Married": getMarried(player, getNum()); break;
            case "College Career Choice": ;break;
            case "Have Child": haveChild(player); break;
            case "Job Search": ; break;
            case "Buy A House": ; break;
            case "Graduation Day": graduationDay(player); break;

        }
    }
    /** retrieving num of Card
     *
     * @return num - fixed value of the space upon generation
     */
    public int getNum() {
        return num;
    }


}
