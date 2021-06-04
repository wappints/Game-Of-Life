package sample;

import java.util.Random;
/** implement's player object. As player is affected in most situations or mechanisms, it has a lot of methods.
 *
 */
public class Player {

    private String name;
    private int money = 200000;
    private int salary = 0;
    private int minRaise = 0;
    private int payRaise = 0;
    private String career = "None";
    private int taxDue = 0;
    private int bankLoan = 0;
    private int playerOrder;
    private boolean careerDegree = false;
    private ActionCard actionCard;
    private CareerCard careerCard;
    private SalaryCard salaryCard;
    private BlueCard blueCard;
    private HouseCard houseCard;
    private String pathTaken = "Empty";
    private int randomNum = 0;
    private boolean spouse = false;
    private int children = 0;
    private int currentMovesForPath = 0;
    private boolean playerTurn = false;
    private boolean retired = false;
    private int moves = 0;
    private boolean isMoving = false;
    public String house = "Empty";
    private int place;
    private int choice;

    public Player() {}
    public Player(String name) {
        this.name = name;
    }
    public int getChoice() {return this.choice;}
    public void setChoice(int num) {this.choice = num; }
    public void setCurrentMovesForPath(int i) {this.currentMovesForPath = i;}
    public int getCurrentMovesForPath(){return currentMovesForPath; }
    public int getPlayerOrder() {
        return this.playerOrder;
    }
    public int getMoves(){ return moves;}
    public void setMoves(int moves){this.moves = moves; }
    public String getCareer(){
        return career;
    }
    public void setCareer (String career) {this.career = career; }
    public int getPlace () {return place;}
    public  void setPlace(int i) {this.place = i;}
    public boolean getCareerDegree(){
        return careerDegree;
    }
    public void setPlayerOrder(int order) {
        this.playerOrder = order;
    }
    public void setCareerDegree(boolean choice) { this.careerDegree = choice; }
    public int getSalary() {
        return this.salary;
    }
    public void setSalary(int sal) {
        this.salary = sal;
    }
    public int getTaxDue() {
        return this.taxDue;
    }
    public void setTaxDue(int taxDue) {
        this.taxDue = taxDue;
    }
    public void addTaxDue(int taxDue) {
        this.taxDue += taxDue;
    }
    public int getPayRaise() {
        return this.payRaise;
    }
    public void setPayRaise(int payRaise ) {
        this.payRaise = payRaise;
    }
    public int getMinRaise() {
        return this.minRaise;
    }
    public void setMinRaise(int minRaise ) {
        this.minRaise = minRaise;
    }
    public String getName() {
        return this.name;
    }
    public int getMoney() {
        return money;
    }
    public boolean getRetired() { return retired; }
    public void setRetired(boolean retired)
    {
        this.retired = retired;
    }
    public int  getBankLoan()
    {
        return bankLoan;
    }
    public void setBankLoan(int amt)
    {
        this.bankLoan = amt;
    }
    public void addMoney (int money)
    {
        this.money += money;
        System.out.println("Money is now " + this.money + " added from " + money);
    }
    /** player will pay the required amount of money to the bank
     * <p>Before doing transaction, system will check player's ability to pay the required amount of money.</p>
     * <p>If cannot pay, player has to call loanFromBank if false. </p>
     *
     * @param money amount of money needed to collect from the Bank
     */
    public void subMoney(int money)
    {

        System.out.println("Money is now " + this.money + " subtract from " + money);
        this.money -= money;
    }
    /** player will loan 20000 from the bank.
     *  <p>player will have increments of 25000, 20000 being the principal and 5000 as the interest</p>
     *
     */
    public void loanFromBank()
    {
        addMoney(20000);
        bankLoan += 25000;
    }
    /** player will pay the required amount of money to the bank
     * <p>Before doing transaction, system will check player's ability to pay the required amount of money.</p>
     * <p>If cannot pay, player has to call loanFromBank if false. </p>
     *
     * @param money amount of money needed to collect from the Bank
     * @param bank Bank object of the Game
     */
    public void payBank (int money, Bank bank) { subMoney(money);bank.collectMoney(money); }
    /** player will collect the given money from the bank
     *
     * @param money amount of money needed to collect from the Bank
     * @param bank Bank object of the Game
     *
     */
    public void collectFromBank (int money, Bank bank) { addMoney(bank.giveMoney(money)); }
    /** collect money from other player
     *
     *
     * @param money amount of money to be collected
     * @param player player to receive money from
     *
     */
    public void collectFromPlayer (int money, Player player) { player.subMoney(money);addMoney(money); }
    /** pay money to other player
     * <p> it first checks if this player can play the other player with their current money </p>
     * <p> if not, call bankLoan method.
     *
     * @param money amount of money to be paid
     * @param player player to pay money to
     *
     */
    public void payPlayer (Player player, int money) {

        subMoney(money);
        player.addMoney(money);
    }
    public String getPathTaken() { return this.pathTaken; }
    public void setPathTaken(String pathTaken) { this.pathTaken = pathTaken; }
    public void pickCard(ActionCardDeck ActionDeck) { this.actionCard = (ActionCard) ActionDeck.getCard(); }
    public void pickCard(CareerCardDeck CardDeck) { this.careerCard = (CareerCard) CardDeck.getCard(); }
    public void pickCard(SalaryCardDeck SalaryDeck) { this.salaryCard = (SalaryCard) SalaryDeck.getCard(); }
    public void pickCard(BlueCardDeck BlueDeck) { this.blueCard = (BlueCard) BlueDeck.getCard(); }
    public void pickCard(HouseCardDeck HouseDeck) { this.houseCard = (HouseCard) HouseDeck.getCard(); }
    public ActionCard getActionCard() { return this.actionCard; }
    public BlueCard getBlueCard() { return this.blueCard; }
    public SalaryCard getSalaryCard() { return this.salaryCard; }
    public CareerCard getCareerCard() { return this.careerCard; }
    public HouseCard getHouseCard() { return this.houseCard; }
    public String getHouseName() { return this.house; }
    public boolean isMarried() { return this.spouse; }
    public void setMarried(boolean choice) { this.spouse = choice; }
    /** checks if the player can pay the amount of money.
     *
     * @param amt the value of the player's money
     * @param toPay the value of the amount to be paid
     *
     * @return true if player can pay the certain amount, otherwise, false.
     *
     */
    public boolean canPay (int amt, int toPay) { if ((amt - toPay) < 0) return false; return true; }
    public int getChildren() { return this.children; }
    public void setChildren (int num) { this.children = num; }
    /** player will get a random number
     *
     * @return int value ranging from 1 - 10
     *
     */
    public int pressRandomNum ( ) {
        Random rn = new Random();
        int num = rn.nextInt(10 - 1 + 1) + 1;
        System.out.println("Player " + getPlayerOrder() + " gets random number: " + num);
        this.randomNum = num;
        return num;
    }
}