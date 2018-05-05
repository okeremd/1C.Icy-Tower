package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.logic.FileManager;
import view.Display;
import view.GameFrame;

import java.io.IOException;

/**
 * Controller for main menu
 */
public class MainMenuController extends MainController {

    /**
     * Opens how to play page if howtoplay button is pressed
     * @param actionEvent default input controller of java
     */
    public void openHowToPlayScene(ActionEvent actionEvent) {

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getHowToPlayScene());
    }
    /**
     * Opens credits page if credits button is pressed
     * @param actionEvent default input controller of java
     */
    public void openCreditsScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getCreditsScene());
    }

    /**
     * Opens settings page if settings button is pressed
     * @param actionEvent default input controller of java
     */
    public void openSettingsScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSettingsScene());
    }

    /**
     * Opens high scores page if highscores button is pressed
     * @param actionEvent default input controller of java
     */
    public void openHighScoreScene(ActionEvent actionEvent) throws IOException {
        //Update high score
        try {
            FileManager.getInstance().readHighScoreLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene highScoreScene = MainController.getHighScoreScene();
        Display display = new Display();
        //reinitalize high score scene for new high scores
        highScoreScene = display.initializeScene("high_scores.fxml");
        highScoreScene.getStylesheets().add(this.getClass().getResource("../view/styleOtherMenus.css").toExternalForm());
        MainController.getInstance().setHighScoreScene(highScoreScene);
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getHighScoreScene());
    }

    /**
     * Opens exit page if exit button is pressed
     * @param actionEvent default input controller of java
     */
    public void openExitScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getExitScene());
    }
    /**
     * Opens difficulty page if playgame button is pressed
     * @param actionEvent default input controller of java
     */
    public void openDifficultyScene(ActionEvent actionEvent){

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getDifficultyScene());

    }



}