package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.logic.FileManager;
import view.GameFrame;

import java.io.IOException;

public class MainMenuController extends MainController {

    //HighScoresController highScoresController;



    public void openHowToPlayScene(ActionEvent actionEvent) {

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getHowToPlayScene());
    }

    public void openCreditsScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getCreditsScene());
    }

    public void openSettingsScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSettingsScene());
    }

    public void openHighScoreScene(ActionEvent actionEvent) throws IOException {
        //Update high score
        System.out.println("updated");
        try {
            FileManager.getInstance().readHighScoreLines();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getHighScoreScene());
    }

    public void openExitScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getExitScene());
    }
    public void openPlayScene(ActionEvent actionEvent){
        // ToDo add startController Scene
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //primaryStage.close();
        //primaryStage = new Stage();
        GameFrame gameFrame = new GameFrame();
        primaryStage.setScene(gameFrame.start());
    }



}