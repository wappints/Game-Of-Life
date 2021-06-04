package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOfLifeController {


    @FXML
    void exitApp(ActionEvent event) {
    System.exit(0);
    }

    @FXML
    void threePlayerSystem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));

        Stage stage = new Stage();
        stage.sizeToScene();
        stage.setResizable(true);
        stage.setTitle("That's Life (3)");
        stage.setScene(new Scene(root, 1529, 830));
        stage.show();
    }

    @FXML
    void twoPlayerSystem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View2.fxml"));

        Stage stage = new Stage();
        stage.sizeToScene();
        stage.setResizable(true);
        stage.setTitle("That's Life (2)");
        stage.setScene(new Scene(root, 1529, 830));
        stage.show();

    }

}
