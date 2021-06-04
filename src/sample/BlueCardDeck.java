package sample;

import java.util.ArrayList;
import java.util.Random;

public class BlueCardDeck extends Deck {
    /**
     * constructor for the BlueCardDeck
     * It creates an ArrayList of 7 objects then adds 7 objects of HouseCards
     *
     */
    public BlueCardDeck () {
        cards = new ArrayList<Card>(7);

        BlueCard init;  // This variable will be utilized in initializing the set of 50

        for (int i = 0; i < 7; i++) {
            init = new BlueCard(); // i of the param is the cardNumber, to differentiate the cards
            cards.add(init); // Add to ArrayList<Card> Card
        }
        generateCard();
    }

    /**
     * method for generating the cards (fixed)
     *
     */

    @Override
    public void generateCard() {
        String[] cardNames = {"Lawsuit", "Salary Tax Due", "Ski Accident", "Computer Repair", "World Cup", "F1 Race", "Tip the " +
                "Server"};

        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).setName(cardNames[i]);
            if (i == 0)
            {
                ((BlueCard) cards.get(i)).setMax(((BlueCard) cards.get(i)).generateAmount());
            }
        }
        shuffleCards();
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
    public Card getCard(int i)
    {
        return null;
    }
}