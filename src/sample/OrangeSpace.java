package sample;


import java.lang.reflect.Array;
import java.util.ArrayList;
/** class Orange Space
 *
 * <p> spaces that trigger Action Deck </p>
 */
public class OrangeSpace extends Space {


    public OrangeSpace() {

        setColor("Orange");
        setEventName("Picked An ActionCard");
    }

    // Might place in Card itself?
    /** trigger events for the orange space
     */
    @Override
    public void triggerEvent(ArrayList<Player> players, ActionCardDeck ActionDeck, int currentPlayer, int opponentOne, int opponentTwo, Bank bank) {

        players.get(currentPlayer).pickCard(ActionDeck);

            switch(players.get(currentPlayer).getActionCard().getName())
            {
             case "CollectFromBank" : {
                switch (players.get(currentPlayer).getActionCard().getEventDescript()) {
                    case "Tax refund":
                        players.get(currentPlayer).collectFromBank(players.get(currentPlayer).getTaxDue(), bank);
                        players.get(currentPlayer).setTaxDue(0);
                    case "Sell an item", "Bonus payday", "Setup school", "Write a Book":
                        players.get(currentPlayer).collectFromBank(players.get(currentPlayer).getActionCard().getValue(), bank);
                }

            }
            case "PayTheBank" : players.get(currentPlayer).collectFromBank(players.get(currentPlayer).getActionCard().getValue(), bank);
            case "PayThePlayer" : {
                switch (players.get(currentPlayer).getActionCard().getEventDescript())
                {
                    case "Lawsuit" : players.get(currentPlayer).getActionCard().lawsuit(players.get(currentPlayer), players.get(opponentOne));
                    case "Christmas Bonus" : players.get(currentPlayer).payPlayer(players.get(opponentOne), players.get(currentPlayer).getActionCard().getValue());
                }
            }
            case "CollectFromPlayer" : {
                    switch (players.get(currentPlayer).getActionCard().getEventDescript())
                    {
                        case "File a Lawsuit" : players.get(currentPlayer).getActionCard().lawsuit(players.get(opponentOne), players.get(currentPlayer));
                        case "It's your Birthday!" : players.get(currentPlayer).collectFromPlayer(players.get(currentPlayer).getActionCard().getValue(), players.get(opponentOne));
                    }
                }
        }
        }


}
