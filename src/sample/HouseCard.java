package sample;
/** implements the HouseCard extending Card
 *
 *
 */
public class HouseCard extends Card {
    private int housePrice;

    /**
     * default constructor for HouseCard
     */
    public HouseCard() {

    }
    public HouseCard(String name) {
    this.name = name;
    housePrice = 0;
    }
    /**
     * gets the price of the house
     * @return the price of the house
     */
    public String getName() {
        return this.name;
    }
    public int getHousePrice() {
        return this.housePrice;
    }

    public void setHousePrice(int amt) {
        this.housePrice = amt;
    }


}
