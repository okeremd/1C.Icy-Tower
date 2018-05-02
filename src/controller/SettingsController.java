package controller;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.logic.FileManager;

import javax.swing.*;
import java.io.IOException;


public class SettingsController extends MainController {

    public void openSoundSettings(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSoundSettingsScene());
    }

    public void openCharacterSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getCharacterSettingsScene());
    }

    public void openButtonSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getButtonSettingsScene());
    }

    public void resetHighScore(ActionEvent actionEvent) throws IOException {
        FileManager.getInstance().resetHighScores();

    }


    public void backToSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSettingsScene());
    }
}
