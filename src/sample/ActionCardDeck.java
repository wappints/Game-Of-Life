package sample;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
/** implements the Deck of the Action Card
 *
 * <p>it inherits the attributes and methods of the Deck Class</p>
 *
 */
public class ActionCardDeck extends Deck {

    /**
     * constructor for the ActionCardDeck
     * It creates an ArrayList of 50 objects then adds 50 objects of ActionCards
     *
     */
    public ActionCardDeck() {
        cards = new ArrayList<Card>(50);
        ActionCard init;  // This variable will be utilized in initializing the set of 50

        for (int i = 0; i < 50; i++) {
            init = new ActionCard(); // i of the param is the cardNumber, to differentiate the cards
            cards.add(init); // Add to ArrayList<Card> Card
        }
        generateCard();
    }
    /**
     * Overriding the generateCard from the abstract class Deck
     * generates the card names and custom names of this deck
     *
     * <p> 10% of the cards name: PayThePlayer</p>
     * <p> 10% of the cards name: CollectFromPlayer</p>
     * <p> 40% of the cards name: CollectFromBank</p>
     * <p> 40% of the cards name: PayTheBank</p>
     *
     * <p> custom name or custom event per action card type is randomly generated</p>
     *
     * <p> after generation, it shuffles the deck. </p>
     *
     */
    @Override
    public void generateCard() {
        Random random = new Random();

        String[] cardNames = {"CollectFromBank", "PayTheBank", "PayThePlayer", "CollectFromPlayer"};
        String[] bankCollectTypes = {"Tax refund", "Sell an item", "Bonus payday", "Setup school", "Write a Book"};
        String[] payBankTypes = {"Buy an Item", "Visit a Place", "Hiking", "Watching a show", "Win a Competition", "Traffic Violation"};
        String[] payPlayerTypes = {"Lawsuit", "Christmas Bonus"};
        String[] playerCollectTypes = {"File a Lawsuit", "It's your Birthday!"};

        for (int i = 0; i < cards.size(); i++) {
            if (i < 5) {  // 10% of PayThePlayer
                cards.get(i).setName(cardNames[2]);
                ((ActionCard) cards.get(i)).setEventDescript(payPlayerTypes[random.nextInt(payPlayerTypes.length)]);
            } else if (i < 10) { // 10% of CollectFromPlayer
                cards.get(i).setName(cardNames[3]);
                ((ActionCard) cards.get(i)).setEventDescript(playerCollectTypes[random.nextInt(playerCollectTypes.length)]);
            } else if (i < 30) { // 40% of CollectFromBank
                cards.get(i).setName(cardNames[0]);
                ((ActionCard) cards.get(i)).setEventDescript(bankCollectTypes[random.nextInt(bankCollectTypes.length)]);
            } else { // 40% of PayTheBank
                cards.get(i).setName(cardNames[1]);
                ((ActionCard) cards.get(i)).setEventDescript(payBankTypes[random.nextInt(payBankTypes.length)]);
            }
        }

        shuffleCards();
    }

    /** get the first index / topmost card of the Deck
     * <p> it shuffles once players will get the first card of the next supposed shuffled Deck</p>
     *
     * @return ActionCard the card of the ActionCardDeck
     */
    @Override
    public Card getCard() {
        int i = counter;
        counter++; // Counter is the number of times that players have picked from the deck
        // System.out.println("Counter is now: " + counter); Debugging

        if (counter == 51) { // 51 symbolizes the first card of the new deck, shuffle before player picks card.
            counter = 0;
            shuffleCards();
            i = 0;
            return cards.get(i);
        }
        else
            return cards.get(i);
    }
    /** Overriding method from Deck
     *
     */
    @Override
    public Card getCard(int i) {
        return null;
    }
    /**
     * @param i - choice number of player
     * @return ActionCard - gets the description of the card
     */
    public String getCardDescript(int i) {

        return ((ActionCard)cards.get(i)).getEventDescript();
    }
}
