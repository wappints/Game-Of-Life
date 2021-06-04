package sample;
import java.util.ArrayList;
/**
 *  Class Board that contains the backend
 */
public class Board {

    private Bank bank;
    private CareerCardDeck CareerDeck;
    private SalaryCardDeck SalaryDeck;
    private HouseCardDeck HouseDeck;
    private ActionCardDeck ActionDeck;
    private BlueCardDeck BlueDeck;
    private ArrayList<Player> players;

    private CareerPath CareerRoad;
    private CollegePath CollegeRoad;
    private ChangeCareerPath ChangeCareerRoad;
    private FamilyPath FamilyRoad;
    private NormalPath NormalRoad;
    private NormalPathTwo NormalRoadTwo;
    private LastPath LastRoad;

    public Board (ArrayList<Player> players)
    {
        int i;
        bank = new Bank();
        this.players = new ArrayList<Player>(players.size());
        BlueDeck = new BlueCardDeck();
        ActionDeck = new ActionCardDeck();
        HouseDeck = new HouseCardDeck();
        SalaryDeck = new SalaryCardDeck();
        CareerDeck = new CareerCardDeck();
        CareerRoad = new CareerPath();
        CollegeRoad = new CollegePath();
        ChangeCareerRoad = new ChangeCareerPath();
        FamilyRoad = new FamilyPath();
        NormalRoad = new NormalPath();
        NormalRoadTwo = new NormalPathTwo();
        LastRoad = new LastPath();

        for (i = 0; i < players.size(); i++) {
            this.players.add(players.get(i));
            this.players.get(i).setPlayerOrder(i + 1);
        }
    }

    public Bank getBank() {return this.bank;}
    public CareerCardDeck getCareerDeck() {return this.CareerDeck;}
    public ActionCardDeck getActionDeck() {return this.ActionDeck;}
    public BlueCardDeck getBlueDeck() { return this.BlueDeck; }
    public SalaryCardDeck getSalaryDeck() {return this.SalaryDeck;}
    public HouseCardDeck getHouseDeck() {return this.HouseDeck;}
    public ArrayList<Player> getPlayers() {return this.players; }
    public CareerPath getCareerRoad() {return this.CareerRoad; }
    public CollegePath getCollegeRoad() {return this.CollegeRoad; }
    public ChangeCareerPath getChangeCareerRoad() {return this.ChangeCareerRoad; }
    public FamilyPath getFamilyRoad(){return this.FamilyRoad; }
    public NormalPath getNormalRoad(){return this.NormalRoad; }
    public NormalPathTwo getNormalRoadTwo(){return this.NormalRoadTwo; }
    public LastPath getLastRoad () {return this.LastRoad; }

}
