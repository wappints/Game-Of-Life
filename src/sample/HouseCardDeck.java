package sample;

import java.util.ArrayList;
import java.util.Random;
/** implements the Deck of the House Card
 *
 * <p>it inherits the attributes and methods of the Deck Class, including implementing the generator </p>
 *
 */
public class HouseCardDeck extends Deck implements Generator {

    /**
     * constructor for the HouseCardDeck
     * It creates an ArrayList of 4 objects then adds 4 objects of HouseCards
     *
     */
    public HouseCardDeck() {
        cards = new ArrayList<Card>(4);

        HouseCard init;  // This variable will be utilized in initializing the set of 50

        for (int i = 0; i < 4; i++) {
            init = new HouseCard(); // i of the param is the cardNumber, to differentiate the cards
            cards.add(init); // Add to ArrayList<Card> Card
        }
        generateCard ();
    }
    /**
     * method for generating the cards (fixed)
     *
     */

    @Override
    public void generateCard () {
        String[] names = {"Summer Side Villa", "Country Cottage", "Creek Side Manor", "Royal Condominiums"};

        for (int i = 0; i < cards.size(); i++) {
            this.cards.get(i).setName(names[i]);
            ((HouseCard) cards.get(i)).setHousePrice(generateAmount());
        }
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public Card getCard (int i) {
        return ((HouseCard)cards.get(i));
    }

    public String getHouseName (int i)
    {
        return ((HouseCard)cards.get(i)).getName();
    }
    public int getHousePrice (int i)
    {
        return ((HouseCard)cards.get(i)).getHousePrice();
    }
    /**
     * method for generating the amount of the cards (fixed)
     * @return int value of the Card
     *
     */
    @Override
    public int generateAmount () {
        Random random = new Random();
        int[] numbers = {15, 16, 17, 18, 19, 20};

        return numbers[random.nextInt(numbers.length)] * 100000;
    }

}