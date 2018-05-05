package controller;


import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.logic.FileManager;
import java.io.IOException;

/**
 * Controller for high score list
 */
public class HighScoresController extends MainController {

    public HighScoresController(){

    }

    public Text getName1() {
        return name1;
    }

    public void setName1(Text name1) {
        this.name1 = name1;
    }

    public Text getName2() {
        return name2;
    }

    public void setName2(Text name2) {
        this.name2 = name2;
    }

    public Text getName3() {
        return name3;
    }

    public void setName3(Text name3) {
        this.name3 = name3;
    }

    public Text getName4() {
        return name4;
    }

    public void setName4(Text name4) {
        this.name4 = name4;
    }

    public Text getName5() {
        return name5;
    }

    public void setName5(Text name5) {
        this.name5 = name5;
    }

    public Text getName6() {
        return name6;
    }

    public void setName6(Text name6) {
        this.name6 = name6;
    }

    public Text getName7() {
        return name7;
    }

    public void setName7(Text name7) {
        this.name7 = name7;
    }

    public Text getName8() {
        return name8;
    }

    public void setName8(Text name8) {
        this.name8 = name8;
    }

    public Text getName9() {
        return name9;
    }

    public void setName9(Text name9) {
        this.name9 = name9;
    }

    public Text getName10() {
        return name10;
    }

    public void setName10(Text name10) {
        this.name10 = name10;
    }

    public Text getScore1() {
        return score1;
    }

    public void setScore1(Text score1) {
        this.score1 = score1;
    }

    public Text getScore2() {
        return score2;
    }

    public void setScore2(Text score2) {
        this.score2 = score2;
    }

    public Text getScore3() {
        return score3;
    }

    public void setScore3(Text score3) {
        this.score3 = score3;
    }

    public Text getScore4() {
        return score4;
    }

    public void setScore4(Text score4) {
        this.score4 = score4;
    }

    public Text getScore5() {
        return score5;
    }

    public void setScore5(Text score5) {
        this.score5 = score5;
    }

    public Text getScore6() {
        return score6;
    }

    public void setScore6(Text score6) {
        this.score6 = score6;
    }

    public Text getScore7() {
        return score7;
    }

    public void setScore7(Text score7) {
        this.score7 = score7;
    }

    public Text getScore8() {
        return score8;
    }

    public void setScore8(Text score8) {
        this.score8 = score8;
    }

    public Text getScore9() {
        return score9;
    }

    public void setScore9(Text score9) {
        this.score9 = score9;
    }

    public Text getScore10() {
        return score10;
    }

    public void setScore10(Text score10) {
        this.score10 = score10;
    }

    @FXML
    private  Text name1;
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

    public void refresh() throws IOException {
        initialize();
    }

}
