package sample;

import java.util.*;
/** Abstract class
 *
 *
 *
 */
abstract public class Deck {

    protected ArrayList<Card> cards;
    protected int counter = 0;

    public void shuffleCards() {
        Collections.shuffle(cards);
    }
    public int getCounter ()
    {
        return counter;
    }
    public void setCounter (int i)
    {
        counter = i;
    }
    abstract public void generateCard();
    abstract public Card getCard();
    abstract public Card getCard(int i);
}
