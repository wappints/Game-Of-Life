package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("GameOfLife.fxml"));
        primaryStage.setTitle("Game Of Life Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.sizeToScene();
        primaryStage.setResizable(true);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
