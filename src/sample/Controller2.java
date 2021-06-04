package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    public int i = 0;
    public int order = 0;
    public Board board;
    public Controller2() {

        initPlayers();
        curr = mechanism.highestNumFromPlayers(board.getPlayers());
        updateTurn();
    } // Constructor

    //Buttons for choosing paths
    @FXML Button changeCareerBtn;
    @FXML Button continuePathBtn;
    @FXML Button familyBtn;
    @FXML Button continuePathTwoBtn;
    @FXML public void familyButtonPushed(ActionEvent event) {
        updateTurn();

        board.getPlayers().get(curr).setPathTaken("family");
        board.getPlayers().get(curr).setCurrentMovesForPath(0);
        familyBtn.setDisable(true);
        continuePathTwoBtn.setDisable(true);

        randomBtn.setVisible(true);
        commandPrompt.setVisible(true);
        randomNumField.setVisible(true);
    }
    @FXML public void continueButtonTwoPushed(ActionEvent event) {
        updateTurn();
        board.getPlayers().get(curr).setPathTaken("normal");
        board.getPlayers().get(curr).setCurrentMovesForPath(0);
        familyBtn.setDisable(true);
        continuePathTwoBtn.setDisable(true);

        randomBtn.setVisible(true);
        commandPrompt.setVisible(true);
        randomNumField.setVisible(true);
    }
    @FXML public void continueButtonPushed(ActionEvent event) {
        updateTurn();

        board.getPlayers().get(curr).setPathTaken("continue");
        board.getPlayers().get(curr).setCurrentMovesForPath(0);
        continuePathBtn.setDisable(true);
        changeCareerBtn.setDisable(true);

        randomBtn.setVisible(true);
        commandPrompt.setVisible(true);
        randomNumField.setVisible(true);
    }
    @FXML public void careerButtonPushed(ActionEvent event) {
        updateTurn();
        board.getPlayers().get(curr).setPathTaken("changecareer");
        board.getPlayers().get(curr).setCurrentMovesForPath(0);
        continuePathBtn.setDisable(true);
        changeCareerBtn.setDisable(true);
        randomBtn.setVisible(true);
        commandPrompt.setVisible(true);
        randomNumField.setVisible(true);
    }

    // Player Mechanism
    ArrayList<Player> players = new ArrayList<>(); // List of Players


    int curr; // Current Player
    int other1; // First Opponent of Current Player

    // Board  Mechanism
    Mechanic mechanism = new Mechanic();

    // Main Window
    @FXML
    public TextArea commandPrompt; // Prompt of the Game
    public void updateTurn() {
        switch (curr) {
            case 0:
                curr = 1;
                other1 = 0;
                break;
            case 1:
                curr = 0;
                other1 = 1;
                break;
        }
    }
    public void printTextToPrompt(String Sentence) {
        commandPrompt.appendText(Sentence + "\n");
    } // prints String to the Prompt of the Game
    public void initPlayers() {

        Player player1 = new Player("Johnny");
        Player player2 = new Player("Sheriff");

        players.add(player1);
        players.add(player2);
        board = new Board(players);

    } // Initialize Number of Players (2 /3 )


    public void startGame() {
        initialize();
        continuePathBtn.setDisable(true);
        changeCareerBtn.setDisable(true);
        choosePath.setVisible(false);
        randomBtn.setVisible(true);
        commandPrompt.setVisible(true);
        randomNumField.setVisible(true);
        playerNumberForFirstPath.setVisible(false);
        firstChoice.setVisible(false);
        secondChoice.setVisible(false);
        pathImg.setVisible(false);
        choosePath.setVisible(false);
        continuePathTwoBtn.setDisable(true);
        familyBtn.setDisable(true);
    }

    private boolean isStop = false; // debugging

    // Relocation of Player Image (GUI players)
    @FXML public ImageView playerOne; // Image of Player One
    @FXML public ImageView playerTwo; // Image of Player Two

    @FXML void posX(int i) {
        switch (board.getPlayers().get(curr).getPlayerOrder()) {
            case 1:
                playerOne.relocate(playerOne.getLayoutX() + 38.13, playerOne.getLayoutY());
                break;
            case 2:
                playerTwo.relocate(playerTwo.getLayoutX() + 38.13, playerTwo.getLayoutY());
                break;
        }
    } // move Right
    @FXML void posY(int i) {
        switch (board.getPlayers().get(curr).getPlayerOrder()) {
            case 1:
                playerOne.relocate(playerOne.getLayoutX(), playerOne.getLayoutY() - 36.10);
                break;
            case 2:
                playerTwo.relocate(playerTwo.getLayoutX(), playerTwo.getLayoutY() - 36.10);
                break;
        }
    } // move Up
    @FXML void negX(int i) {
        switch (board.getPlayers().get(curr).getPlayerOrder()) {
            case 1:
                playerOne.relocate(playerOne.getLayoutX() - 38.13, playerOne.getLayoutY());
                break;
            case 2:
                playerTwo.relocate(playerTwo.getLayoutX() - 38.13, playerTwo.getLayoutY());
                break;
        }
    } // move Left
    @FXML void negY(int i) {
        switch (board.getPlayers().get(curr).getPlayerOrder()) {
            case 1:
                playerOne.relocate(playerOne.getLayoutX(), playerOne.getLayoutY() + 36.10);
                break;
            case 2:
                playerTwo.relocate(playerTwo.getLayoutX(), playerTwo.getLayoutY() + 36.10);
                break;
        }
    } // move Right

    // Movements
    @FXML public Button randomBtn;    // Button element for random moves of Player
    @FXML void getRandomNum() throws IOException {

        Random r = new Random();
        int num;
        num = r.nextInt(10 - 1) + 1;
        move(num);

        randomNumField.setText(String.valueOf(num));
        printTextToPrompt("Player " + board.getPlayers().get(curr).getPlayerOrder() + " moves " + num + " times");

        updateTurn();

    }  // ButtonAction for the random moves of Player
    @FXML void increment() throws IOException {
        int num;
        num = 1;
        move(num);
        printTextToPrompt("Player " + board.getPlayers().get(curr).getPlayerOrder() + " moves " + num + " times");
        updateTurn();
    }    // Debugging step-by-step
    @FXML public TextField randomNumField; // Element for showing number of moves
    // Choosing between Career or College Panel
    @FXML private Button startBtn; // Element for starting the whole game
    @FXML public AnchorPane choosePath; // Window itself
    @FXML public ImageView pathImg; // Background Image of the Window for Choosing either College or Career
    @FXML public Text playerNumberForFirstPath; // Player's Number as Element in Window for Choosing either College or Career

    @FXML public void promptCollegeCareerChoice() {

        playerNumberForFirstPath.setText(Integer.toString(board.getPlayers().get(curr).getPlayerOrder()));
        choosePath.setVisible(true);
        startBtn.setVisible(false);

        if (i == 2)
            choosePath.setVisible(false);

    } // Window for Choosing either College or Career
    @FXML private Button firstChoice; // Element for Career Choice
    @FXML public void careerChoice() {
        players.get(curr).setPathTaken("career");
        board.getPlayers().get(curr).setCurrentMovesForPath(0);
        updateTurn();
        playerNumberForFirstPath.setText(Integer.toString(board.getPlayers().get(curr).getPlayerOrder()));
        board.getPlayers().get(curr).pickCard(board.getCareerDeck());
        board.getPlayers().get(curr).pickCard(board.getSalaryDeck());
        i++;
        if (i == 2)
            startGame();
    } // Set Path of Player with Career

    @FXML private Button secondChoice; // Element for College Choice
    @FXML public void collegeChoice() {
        board.getPlayers().get(curr).setPathTaken("college");
        board.getPlayers().get(curr).setCurrentMovesForPath(0);
        updateTurn();
        board.getPlayers().get(curr).setBankLoan(40000);
        playerNumberForFirstPath.setText(Integer.toString(board.getPlayers().get(curr).getPlayerOrder()));
        i++;

        if (i == 2)
            startGame();


    } // Set Path of Player with College
    @FXML public void update() {

        playerOneMoney.setText(Integer.toString(board.getPlayers().get(0).getMoney()));
        playerTwoMoney.setText(Integer.toString(board.getPlayers().get(1).getMoney()));

        playerOneDebt.setText(Integer.toString(board.getPlayers().get(0).getBankLoan()));
        playerTwoDebt.setText(Integer.toString(board.getPlayers().get(1).getBankLoan()));

        playerOneMarried.setText(Boolean.toString(board.getPlayers().get(0).isMarried()));
        playerTwoMarried.setText(Boolean.toString(board.getPlayers().get(1).isMarried()));

        playerOneChildren.setText(Integer.toString(board.getPlayers().get(0).getChildren()));
        playerTwoChildren.setText(Integer.toString(board.getPlayers().get(1).getChildren()));

        playerOneHouse.setText(board.getPlayers().get(0).getHouseName());
        playerTwoHouse.setText(board.getPlayers().get(1).getHouseName());

        playerOneCareer.setText(board.getPlayers().get(0).getCareer());
        playerTwoCareer.setText(board.getPlayers().get(1).getCareer());

        playerOneDegree.setText(Boolean.toString(board.getPlayers().get(0).getCareerDegree()));
        playerTwoDegree.setText(Boolean.toString(board.getPlayers().get(1).getCareerDegree()));

        playerOneMinRaise.setText(Integer.toString(board.getPlayers().get(0).getMinRaise()));
        playerTwoMinRaise.setText(Integer.toString(board.getPlayers().get(1).getMinRaise()));

        playerOneMaxRaise.setText(Integer.toString(board.getPlayers().get(0).getPayRaise()));
        playerTwoMaxRaise.setText(Integer.toString(board.getPlayers().get(1).getPayRaise()));

        playerOneSalary.setText(Integer.toString(board.getPlayers().get(0).getSalary()));
        playerTwoSalary.setText(Integer.toString(board.getPlayers().get(1).getSalary()));

        playerOneTaxDue.setText(Integer.toString(board.getPlayers().get(0).getTaxDue()));
        playerTwoTaxDue.setText(Integer.toString(board.getPlayers().get(1).getTaxDue()));
    }

    // Update or Default Values of Players
    public void initialize() {
        playerOneName.setText(board.getPlayers().get(0).getName());
        playerTwoName.setText(board.getPlayers().get(1).getName());

        playerOneMoney.setText(Integer.toString(board.getPlayers().get(0).getMoney()));
        playerTwoMoney.setText(Integer.toString(board.getPlayers().get(1).getMoney()));

        playerOneDebt.setText(Integer.toString(board.getPlayers().get(0).getBankLoan()));
        playerTwoDebt.setText(Integer.toString(board.getPlayers().get(1).getBankLoan()));

        playerOneMarried.setText(Boolean.toString(board.getPlayers().get(0).isMarried()));
        playerTwoMarried.setText(Boolean.toString(board.getPlayers().get(1).isMarried()));

        playerOneChildren.setText(Integer.toString(board.getPlayers().get(0).getChildren()));
        playerTwoChildren.setText(Integer.toString(board.getPlayers().get(1).getChildren()));

        playerOneHouse.setText(board.getPlayers().get(0).getHouseName());
        playerTwoHouse.setText(board.getPlayers().get(1).getHouseName());

        playerOneCareer.setText(board.getPlayers().get(0).getCareer());
        playerTwoCareer.setText(board.getPlayers().get(1).getCareer());

        playerOneDegree.setText(Boolean.toString(board.getPlayers().get(0).getCareerDegree()));
        playerTwoDegree.setText(Boolean.toString(board.getPlayers().get(1).getCareerDegree()));

        playerOneMinRaise.setText(Integer.toString(board.getPlayers().get(0).getMinRaise()));
        playerTwoMinRaise.setText(Integer.toString(board.getPlayers().get(1).getMinRaise()));

        playerOneMaxRaise.setText(Integer.toString(board.getPlayers().get(0).getPayRaise()));
        playerTwoMaxRaise.setText(Integer.toString(board.getPlayers().get(1).getPayRaise()));

        playerOneSalary.setText(Integer.toString(board.getPlayers().get(0).getSalary()));
        playerTwoSalary.setText(Integer.toString(board.getPlayers().get(1).getSalary()));

        playerOneTaxDue.setText(Integer.toString(board.getPlayers().get(0).getTaxDue()));
        playerTwoTaxDue.setText(Integer.toString(board.getPlayers().get(1).getTaxDue()));

    }

    // Elements or Information of The Players (Top Left of the GUI)
    @FXML public TextField playerOneName;
    @FXML public TextField playerOneMoney;
    @FXML private TextField playerOneDebt;
    @FXML private TextField playerOneMarried;
    @FXML private TextField playerOneChildren;
    @FXML private TextField playerOneHouse;
    @FXML private TextField playerOneCareer;
    @FXML private TextField playerOneMinRaise;
    @FXML private TextField playerOneMaxRaise;
    @FXML private TextField playerOneSalary;
    @FXML private TextField playerOneTaxDue;
    @FXML private TextField playerTwoName;
    @FXML public TextField playerTwoMoney;
    @FXML private TextField playerTwoDebt;
    @FXML private TextField playerTwoMarried;
    @FXML private TextField playerTwoChildren;
    @FXML private TextField playerTwoHouse;
    @FXML private TextField playerTwoCareer;
    @FXML private TextField playerTwoMinRaise;
    @FXML private TextField playerTwoMaxRaise;
    @FXML private TextField playerTwoSalary;
    @FXML private TextField playerTwoTaxDue;

    @FXML private TextField playerOneDegree;
    @FXML private TextField playerTwoDegree;

    @FXML public ImageView background;
    @FXML void loanBank(ActionEvent event) { board.getPlayers().get(curr).loanFromBank(); initialize();}
    @FXML private Button loanBankbtn;

    public void move(int j) throws IOException {
        int i;
        int k = 0;
        int p;
        if (!(board.getPlayers().get(curr).getRetired() && board.getPlayers().get(other1).getRetired()))
            for (i = 0; i < j; i++)
            {
                printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + "has total of " + board.getPlayers().get(curr).getMoves());

                if ((board.getPlayers().get(curr).getMoves() == 42) ) {
                    board.getPlayers().get(curr).setPathTaken("normal");
                    board.getPlayers().get(curr).setCurrentMovesForPath(0);
                    if (board.getPlayers().get(curr).getPathTaken().equals("continue"))
                        posX(board.getPlayers().get(curr).getPlayerOrder());
                }

                if (board.getPlayers().get(curr).getMoves() == 16 && board.getPlayers().get(curr).getPathTaken().equals("career")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    posX(board.getPlayers().get(curr).getPlayerOrder());
                    j = k;
                    board.getCareerRoad().getFullPath().get(17).triggerEvent(board.getPlayers().get(curr));
                    printTextToPrompt("STOP!\n");

                }
                else if (board.getPlayers().get(curr).getMoves() == 7 && board.getPlayers().get(curr).getPathTaken().equals("college")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    posX(board.getPlayers().get(curr).getPlayerOrder());
                    board.getCollegeRoad().getFullPath().get(8).triggerEvent(board.getPlayers().get(curr));
                    j = k;
                    printTextToPrompt("STOP!\n");
                }
                else if (board.getPlayers().get(curr).getMoves() == 16 && board.getPlayers().get(curr).getPathTaken().equals("college")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    posY(board.getPlayers().get(curr).getPlayerOrder());
                    board.getCollegeRoad().getFullPath().get(17).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                    j = k;
                    printTextToPrompt("STOP!\n");

                }
                else if (board.getPlayers().get(curr).getMoves() == 21) {
                    if (board.getPlayers().get(curr).getPathTaken().equals("career"))
                        posX(board.getPlayers().get(curr).getPlayerOrder());

                    if (board.getPlayers().get(curr).getPathTaken().equals("college")) {
                        posY(board.getPlayers().get(curr).getPlayerOrder());
                    }

                    j = k;
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a junction!");
                    changeCareerBtn.setDisable(false);
                    continuePathBtn.setDisable(false);
                    randomBtn.setVisible(false);
                    commandPrompt.setVisible(false);
                    randomNumField.setVisible(false);

                }
                else if (board.getPlayers().get(curr).getMoves() == 31 &&  board.getPlayers().get(curr).getPathTaken().equals("changecareer")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    posY(board.getPlayers().get(curr).getPlayerOrder());
                    board.getChangeCareerRoad().getFullPath().get(9).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                    j = k;
                    printTextToPrompt("STOP!\n");
                }
                else if (board.getPlayers().get(curr).getMoves() == 73 &&  board.getPlayers().get(curr).getPathTaken().equals("family")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    System.out.println("GET MARRIED");
                    board.getFamilyRoad().getFullPath().get(14).triggerEvent(board.getPlayers().get(curr));
                    negX(board.getPlayers().get(curr).getPlayerOrder());
                    j = k;
                    printTextToPrompt("STOP!\n");
                }
                else if (board.getPlayers().get(curr).getMoves() == 80 && board.getPlayers().get(curr).getPathTaken().equals("family")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    posY(board.getPlayers().get(curr).getPlayerOrder());
                    board.getFamilyRoad().getFullPath().get(21).triggerEvent(board.getPlayers().get(curr));
                    System.out.println("HOUSE");
                    j = k;
                    printTextToPrompt("STOP!\n");
                }
                else if (board.getPlayers().get(curr).getMoves() == 84 && board.getPlayers().get(curr).getPathTaken().equals("family")) {
                    System.out.println("Player has space children for " + board.getPlayers().get(curr).getMoves());
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    negX(board.getPlayers().get(curr).getPlayerOrder());
                    board.getFamilyRoad().getFullPath().get(25).triggerEvent(board.getPlayers().get(curr));
                    System.out.println("GET CHILDREN");
                    j = k;
                    printTextToPrompt("STOP!\n");
                }
                else if (board.getPlayers().get(curr).getMoves() == 75 &&  board.getPlayers().get(curr).getPathTaken().equals("normal")) {
                    printTextToPrompt("Player " + (board.getPlayers().get(curr).getPlayerOrder()) + " reached a Magenta Space");
                    negX(board.getPlayers().get(curr).getPlayerOrder());
                    board.getNormalRoadTwo().getFullPath().get(9).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                    j = k;
                    printTextToPrompt("STOP!\n");
                }
                else if (board.getPlayers().get(curr).getMoves() == 58) { // Stop For Choosing Path
                    negY(board.getPlayers().get(curr).getPlayerOrder());
                    j = 0;
                    continuePathTwoBtn.setDisable(false);
                    familyBtn.setDisable(false);
                    randomBtn.setVisible(false);
                    commandPrompt.setVisible(false);
                    randomNumField.setVisible(false);
                    board.getPlayers().get(curr).setCurrentMovesForPath(0);
                }
                else if (board.getPlayers().get(curr).getMoves() == 86 && board.getPlayers().get(curr).getPathTaken().equals("family")) {
                    negX(board.getPlayers().get(curr).getPlayerOrder());
                    board.getPlayers().get(curr).setPathTaken("last");

                    board.getPlayers().get(curr).setCurrentMovesForPath(0);
                }
                else if (board.getPlayers().get(curr).getMoves() == 94 && board.getPlayers().get(curr).getPathTaken().equals("normal")) {
                    posX(board.getPlayers().get(curr).getPlayerOrder());
                    board.getPlayers().get(curr).setMoves(86);
                    board.getPlayers().get(curr).setPathTaken("last");
                    board.getPlayers().get(curr).setCurrentMovesForPath(0);
                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("college")) {
                    if (board.getPlayers().get(curr).getMoves() < 11)
                        posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 22)
                        posY(board.getPlayers().get(curr).getPlayerOrder());

                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("continue")) {
                    if (board.getPlayers().get(curr).getMoves() < 29)
                        posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 42)
                        posX(board.getPlayers().get(curr).getPlayerOrder());
                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("career")) {
                    if (board.getPlayers().get(curr).getMoves() < 11)
                        posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 23)
                        posX(board.getPlayers().get(curr).getPlayerOrder());
                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("changecareer")) {
                    if (board.getPlayers().get(curr).getMoves() < 30)
                        posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 32)
                        posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 34)
                        posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 43) {
                        switch (board.getPlayers().get(curr).getMoves()) { case 34, 36, 38, 40, 41, 42 : posY(board.getPlayers().get(curr).getPlayerOrder()); }
                        switch (board.getPlayers().get(curr).getMoves()) { case 35, 37, 39 : posX(board.getPlayers().get(curr).getPlayerOrder()); }
                    }

                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("normal")) {
                    if (board.getPlayers().get(curr).getMoves() < 51) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 59) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 61) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 65) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 69) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 71) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 73) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 75) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 79) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 82) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 84) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 89) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 91) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 92) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 94) posX(board.getPlayers().get(curr).getPlayerOrder());
                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("family")) {
                    if (board.getPlayers().get(curr).getMoves() < 69) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 74) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 76) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 77) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 79) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 80) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 81) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 82) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 84) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 87) negX(board.getPlayers().get(curr).getPlayerOrder());
                }
                else if (board.getPlayers().get(curr).getPathTaken().equals("last")) {
                    if (board.getPlayers().get(curr).getMoves() <89) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 90) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 91 ) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 95) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 100) negY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 104) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 106) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 108) posX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 110) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 112) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 113) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 115) negX(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() < 118) posY(board.getPlayers().get(curr).getPlayerOrder());
                    else if (board.getPlayers().get(curr).getMoves() == 118) {
                        j = 0;
                        board.getPlayers().get(curr).setRetired(true);
                        order++;
                    }
                }
                initialize();
                board.getPlayers().get(curr).setCurrentMovesForPath( board.getPlayers().get(curr).getCurrentMovesForPath() + 1);
                if (board.getPlayers().get(curr).getCurrentMovesForPath() == (j)) {
                    if (board.getPlayers().get(curr).getPathTaken().equals("college")) {
                        if (board.getPlayers().get(curr).getCurrentMovesForPath() != 7 || board.getPlayers().get(curr).getCurrentMovesForPath() != 16 && board.getPlayers().get(curr).getCurrentMovesForPath() < 19) {
                            printTextToPrompt("Player " + players.get(curr).getPlayerOrder() + "lands on Orange Space.\nThey pick an action card from the deck\n");
                            board.getCollegeRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                            // printTextToPrompt("Card is " + players.get(curr).getActionCard().getName() + "\nspecifically " + players.get(curr).getActionCard().getEventDescript() + "\n");
                        }
                        System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getCollegeRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                    }
                    else if (board.getPlayers().get(curr).getPathTaken() == "career") {
                        if (board.getPlayers().get(curr).getCurrentMovesForPath() != 16 && board.getPlayers().get(curr).getCurrentMovesForPath() < 19 ) {
                            printTextToPrompt("Player " + players.get(curr).getPlayerOrder() + "lands on Orange Space.\nThey pick an action card from the deck\n");
                            board.getCareerRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
//                            printTextToPrompt("Card is " + players.get(curr).getActionCard().getName() + "\nspecifically " + players.get(curr).getActionCard().getEventDescript() + "\n");
                        }
                        else if (board.getPlayers().get(curr).getCurrentMovesForPath() == 19)
                            board.getPlayers().get(curr).setCurrentMovesForPath(0);

                        System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getCareerRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                    }
                    else if (board.getPlayers().get(curr).getPathTaken() == "changecareer") {
                        System.out.println("HI " + board.getPlayers().get(curr).getCurrentMovesForPath());
                        p = board.getPlayers().get(curr).getCurrentMovesForPath();
                        switch (p) {

                            case 1, 2, 5, 7, 9, 10, 13, 16, 17, 19 : board.getChangeCareerRoad().getFullPath().get(p).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank()); printTextToPrompt("Player " + players.get(curr).getPlayerOrder() + "lands on Orange Space.\nThey pick an action card from the deck\n"); break;
                            case 3 : board.getChangeCareerRoad().getFullPath().get(3).triggerEvent(board.getPlayers(), board.getBlueDeck(), curr, other1,  board.getBank()); printTextToPrompt("Player " + players.get(curr).getPlayerOrder() + "lands on Blue Space.\nThey pick a blue  card from the deck\n");
                                //printTextToPrompt("Player has " + players.get(curr).getBlueCard().getName());break;
                            case 4, 6, 8, 12, 14, 15, 18 : board.getChangeCareerRoad().getFullPath().get(p).triggerEvent(board.getPlayers().get(curr), board.getBank());
                                printTextToPrompt("Player " + players.get(curr).getPlayerOrder() + "lands on Green Space.\nThey pick a salary card from the deck\n");
                                System.out.println("Player is p = " + p); break;


                        }
                        System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getChangeCareerRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                        System.out.println("JUMBOOOOOOO");
                    }
                    else if (board.getPlayers().get(curr).getPathTaken().equals("normal")) {
                        if (board.getPlayers().get(curr).getMoves() < 59)
                        {
                            board.getNormalRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                            System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getNormalRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                        }
                        else
                        {
                            board.getNormalRoadTwo().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                            System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getNormalRoadTwo().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                        }
                    }
                    else if (board.getPlayers().get(curr).getPathTaken().equals("family")) {
                        p = board.getPlayers().get(curr).getCurrentMovesForPath();
                        switch(p)
                        {
                            case 12: board.getFamilyRoad().getFullPath().get(11).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                            case 15: board.getFamilyRoad().getFullPath().get(14).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1,  board.getBank());
                            case 22: board.getFamilyRoad().getFullPath().get(21).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1,  board.getBank());
                            case 26: board.getFamilyRoad().getFullPath().get(25).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                            default: board.getFamilyRoad().getFullPath().get(p).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                        }
                        System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getFamilyRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());

                    }
                    else if (board.getPlayers().get(curr).getPathTaken().equals("last")) {
                        if (board.getPlayers().get(curr).getMoves() == 118)
                        {
                            board.getLastRoad().getFullPath().get(33).triggerEvent(board.getPlayers().get(curr), board.getBank(), order + 1);
                            System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getLastRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                        }
                        else {
                            board.getLastRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).triggerEvent(board.getPlayers(), board.getActionDeck(), curr, other1, board.getBank());
                            System.out.println("Path Taken: "  + board.getPlayers().get(curr).getPathTaken() + " " + board.getLastRoad().getFullPath().get(board.getPlayers().get(curr).getCurrentMovesForPath()).getEventName());
                        }
                    }
                    update();
                }


                board.getPlayers().get(curr).setMoves(board.getPlayers().get(curr).getMoves() + 1);
            }
        else if (!(board.getPlayers().get(0).getRetired() && board.getPlayers().get(1).getRetired()))
            updateTurn();

        else
            winCondition();
    } // Movement of the Players in the GUI

    public void winCondition()
    {
        if (board.getPlayers().get(0).getRetired() && board.getPlayers().get(1).getRetired()) {
            if (board.getPlayers().get(0).getMoney() > board.getPlayers().get(1).getMoney())
                printTextToPrompt("Player " + board.getPlayers().get(0).getPlayerOrder() + "WINS THE GAME");

            else
                printTextToPrompt("Player " + board.getPlayers().get(1).getPlayerOrder() + "WINS THE GAME");
        }


    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) { }
}



