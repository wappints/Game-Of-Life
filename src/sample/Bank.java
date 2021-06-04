package sample;
/** class Bank
 *
 * <p> This is the bank class </p>
 */
public class Bank {

    private String name;
    private int money = 10000000;

    public Bank () {}

    public Bank (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int giveMoney (int amt) {
        return amt;
    }

    public int collectMoney (int amt) {
        return this.money += amt;
    }
}
