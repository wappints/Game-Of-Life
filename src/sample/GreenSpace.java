package sample;


import java.util.Random;
/** class for green space
 *
 */
public class GreenSpace extends Space {
    /** Constructor for green space
     *
     * <p> Initializes either pay raise or pay day</p>
     */
    GreenSpace() {

        String [] events = {"Pay Raise", "Pay Day"};
        Random random = new Random();

        setColor("green");
        setEventName(events[random.nextInt(events.length)]);
    }
    /** payDay method, player gets salary from Bank
     *
     */
    public void payDay (Player player, Bank bank)
    {
        player.collectFromBank(player.getSalary(), bank);
    }

    /** payRaise method, player gets higher pay raise, then gets salary
     *
     */
    public void payRaise (Player player, Bank bank)
    {
            if (player.getPayRaise() != player.getMinRaise()) {
                player.setSalary(player.getSalary() + 10000);
                player.setPayRaise(player.getPayRaise() + 1);
                player.collectFromBank(player.getSalary(), bank);
                player.addTaxDue(2000);
            }
            else
            {
                System.out.println("Player has reached maximum payRaise");
            }


    }
    /** triggerEvent for payRaise or payDay when player reaches this space
     *
     */
    public void triggerEvent(Player player, Bank bank){
        if (getEventName().equals("Pay Raise"))
            payDay(player, bank);
        else if (getEventName().equals("Pay Day"))
            payRaise(player, bank);

    }

}

