package sample;

import java.util.ArrayList;
import java.util.Collections;
/** implements the Deck of the Career Card Deck
 *
 * <p>it inherits the attributes and methods of the Deck Class, including implementing the generator </p>
 *
 */
public class CareerCardDeck extends Deck {
    /**
     * constructor for the CareerCardDeck
     * It creates an ArrayList of 7 objects then adds 7 objects of HouseCards
     *
     */
    public CareerCardDeck() {
        cards = new ArrayList<Card>(7);
        CareerCard init;  // This variable will be utilized in initializing the set of 50

        for (int i = 0; i < 7; i++) {
            init = new CareerCard(); // i of the param is the cardNumber, to differentiate the cards
            cards.add(init); // Add to ArrayList<Card> Card
        }
        generateCard();
    }

    @Override
    public void generateCard() {
        for(int i = 0; i < cards.size(); i++) {
            cards.get(i).setName(((CareerCard)cards.get(i)).generateCareer(i));
            ((CareerCard) cards.get(i)).setPayRaise(cards.get(i).getName());
            ((CareerCard) cards.get(i)).setDegree(cards.get(i).getName());
        }
        shuffleCards();
    }

    public int getSalaryTax (int i)
    {
        return ((CareerCard) cards.get(i)).getPayRaise();
    }
    @Override
    public Card getCard() {
        int i = counter;
        counter++; // Counter is the number of times that players have picked from the deck
        // System.out.println("Counter is now: " + counter); Debugging

        if (counter == 8) { // 8 symbolizes the first card of the new deck, shuffle before player picks card.
            counter = 0;
            shuffleCards();
            i = 0;
            return cards.get(i);
        }
        else
            return cards.get(i);
    }

    @Override
    public Card getCard(int i) {
        counter++; // Counter is the number of times that players have picked from the deck
        // System.out.println("Counter is now: " + counter); Debugging
        CareerCard cc;

        cc = ((CareerCard)cards.get(i));
        if (counter == 8) { // 16 symbolizes the first card of the new deck, shuffle before player picks card.
            counter = 0;
            shuffleCards();
        }

        return cc;
    }
}