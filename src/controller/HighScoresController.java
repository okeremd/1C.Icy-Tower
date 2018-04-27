package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import model.logic.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class HighScoresController extends MainController {


    @FXML
    private Text name1;
    @FXML
    private Text name2;
    @FXML
    private Text name3;
    @FXML
    private Text name4;
    @FXML
    private Text name5;
    @FXML
    private Text name6;
    @FXML
    private Text name7;
    @FXML
    private Text name8;
    @FXML
    private Text name9;
    @FXML
    private Text name10;
    @FXML
    private  Text score1;
    @FXML
    private  Text score2;
    @FXML
    private  Text score3;
    @FXML
    private  Text score4;
    @FXML
    private  Text score5;
    @FXML
    private  Text score6;
    @FXML
    private  Text score7;
    @FXML
    private  Text score8;
    @FXML
    private  Text score9;
    @FXML
    private Text score10;
    @FXML
    public void initialize() throws IOException {
        FileManager instance = FileManager.getInstance();
        instance.readHighScoreLines();
        String[] names=instance.getHighScoreNames();
        String[] scores = instance.getHighScoreScores();
        score1.setText(scores[0]);
        score2.setText(scores[1]);
        score3.setText(scores[2]);
        score4.setText(scores[3]);
        score5.setText(scores[4]);
        score6.setText(scores[5]);
        score7.setText(scores[6]);
        score8.setText(scores[7]);
        score9.setText(scores[8]);
        score10.setText(scores[9]);
        name1.setText(names[0]);
        name2.setText(names[1]);
        name3.setText(names[2]);
        name4.setText(names[3]);
        name5.setText(names[4]);
        name6.setText(names[5]);
        name7.setText(names[6]);
        name8.setText(names[7]);
        name9.setText(names[8]);
        name10.setText(names[9]);

    }
}
