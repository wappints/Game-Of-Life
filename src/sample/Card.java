package sample;
/**
 *  Abstract Class of all Cards
 */
abstract public class Card {
    protected String name;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return this;
    }

    public void triggerEvent()
    {

    }

}