package sample;

import java.util.ArrayList;
/** class BlueSpace
 *
 * <p> This is the blue space </p>
 */
public class BlueSpace extends Space {
    BlueSpace() {

        setColor("blue");
        setEventName("Blue Space");
    }
    @Override
    public void triggerEvent (ArrayList<Player> players, BlueCardDeck BlueDeck, int curr, int other1, int other2,  Bank bank)
    {
        players.get(curr).pickCard(BlueDeck);
        if ( players.get(curr).getBlueCard().isSameCareer(players.get(curr), players.get(other1), players.get(other2))) {
            players.get(curr).addMoney(15000);
        }
        else
            players.get(curr).payBank(15000, bank);
    }
    @Override
    public void triggerEvent (ArrayList<Player> players, BlueCardDeck BlueDeck, int curr, int other1, Bank bank)
    {
        players.get(curr).pickCard(BlueDeck);
        if ( players.get(curr).getBlueCard().isSameCareer(players.get(curr), players.get(other1))) {
            players.get(curr).addMoney(15000);
        }
        else
            players.get(curr).payBank(15000, bank);
    }

}
