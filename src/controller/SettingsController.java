package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.logic.FileManager;
import java.io.IOException;

/**
 * Controller class for Settings Menu
 */
public class SettingsController extends MainController {

    /**
     * If sound settings button is pressed, it opens Sound Settings
     * @param actionEvent default input controller of java
     */
    public void openSoundSettings(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSoundSettingsScene());
    }

    /**
     * If character settings button is pressed, it opens Character Settings
     * @param actionEvent default input controller of java
     */
    public void openCharacterSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getCharacterSettingsScene());
    }

    /**
     * If button settings button is pressed, it opens Button Settings
     * @param actionEvent default input controller of java
     */
    public void openButtonSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getButtonSettingsScene());
    }

    /**
     * Resets the high scores list if the reset button is pressed
     * @param actionEvent default input controller of java
     * @throws IOException in order to interact with files, it throws this exception
     */
    public void resetHighScore(ActionEvent actionEvent) throws IOException {
        FileManager.getInstance().resetHighScores();

    }

    /**
     * Opens the Settings menu if backtosettings button is pressed
     * @param actionEvent default input controller of java
     */
    public void backToSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSettingsScene());
    }
}
