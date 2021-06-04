package sample;

import java.util.ArrayList;
/** implements the Deck of the Salary Card
 *
 * <p>it inherits the attributes and methods of the Deck Class</p>
 *
 */
public class SalaryCardDeck extends Deck {
    /** constructor of the Class
     *
     * It creates an ArrayList of 15 objects then adds 15 objects of ActionCards
     *
     */
    public SalaryCardDeck () {
        cards = new ArrayList<Card>(15);
        SalaryCard init;

        for (int i = 0; i < 15; i++) {
            init = new SalaryCard();
            cards.add(init);
        }
        generateCard();
    }
    /**
     * Overriding the generateCard from the abstract class Deck
     * generates the card salary and tax of this deck
     *
     *
     */
    @Override
    public void generateCard() {
        for (int i = 0; i < cards.size(); i++) {
            ((SalaryCard) cards.get(i)).setSalary(((SalaryCard) cards.get(i)).generateMaxMultipleSalary());
            ((SalaryCard) cards.get(i)).setTaxDue(((SalaryCard) cards.get(i)).generateMaxMultipleTax());
        }
        shuffleCards();
    }


    public int getTaxDue (int i)
    {
        return ((SalaryCard) cards.get(i)).getSalary();
    }
    public int getSalaryTax (int i)
    {
        return ((SalaryCard) cards.get(i)).getTaxDue();
    }
    @Override
    public Card getCard() {
        int i = counter;
        counter++; // Counter is the number of times that players have picked from the deck
        // System.out.println("Counter is now: " + counter); Debugging

        if (counter == 16) { // 16 symbolizes the first card of the new deck, shuffle before player picks card.
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
        SalaryCard sc;

        sc = ((SalaryCard)cards.get(i));
        if (counter == 16) { // 16 symbolizes the first card of the new deck, shuffle before player picks card.
            counter = 0;
            shuffleCards();
        }

        return sc;
    }
}