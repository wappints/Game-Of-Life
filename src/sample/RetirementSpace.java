package sample;
/** class RetirementSpace
 *
 * <p> This is the last space </p>
 */
public class RetirementSpace extends Space {
    /** constructor for retirement space
     *
     */
    public RetirementSpace()
    {
        setColor("Red");
        setEventName("Retirement");
    }
    /** The last triggerEvent of the Game
     *
     */
    public void triggerEvent(Player player, Bank bank, int first) {
        if (first == 1)
            player.addMoney(100000);

        else if (first == 2)
            player.addMoney(50000);

        else if (first == 3)
            player.addMoney(20000);

        player.getHouseCard().getHousePrice();
        player.collectFromBank(player.getChildren() * 10000, bank);
        player.payBank(player.getBankLoan(), bank);
        player.setPlace(first);
    }

}
