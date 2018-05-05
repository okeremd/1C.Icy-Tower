package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for regulating all the menus for game
 */
public class MainController {

    private static Scene mainMenuScene;
    private static Scene howToPlayScene;
    private static Scene highScoreScene;
    private static Scene settingsScene;
    private static Scene creditsScene;
    private static Scene exitScene;
    private static Scene difficultyScene;
    // Setting scenes
    private static Scene soundSettingsScene;
    private static Scene buttonSettingsScene;
    private static Scene characterSettingsScene;

    public static HighScoresController getHighScoresController() {
        return highScoresController;
    }

    public static void setHighScoresController(HighScoresController highScoresController) {
        MainController.highScoresController = highScoresController;
    }

    private static HighScoresController highScoresController;

    //Singleton Pattern
    private static MainController mainController;
    protected MainController() {

    }

    public static MainController getInstance() {

        if (mainController == null) {

            mainController = new MainController();
        }

        return mainController;
    }


    public static Scene getHowToPlayScene() {

        return howToPlayScene;
    }

    public static void setHowToPlayScene(Scene scene) {

        MainController.howToPlayScene = scene;
    }

    public void setMainMenuScene(Scene scene) {

        mainMenuScene = scene;
    }

    public Scene getMainMenuScene(){

        return mainMenuScene;
    }

    public static Scene getCreditsScene() {
        return creditsScene;
    }

    public static void setCreditsScene(Scene creditsScene) {
        MainController.creditsScene = creditsScene;
    }

    public void openMainMenuScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getMainMenuScene());
    }

    public static Scene getSettingsScene() {
        return settingsScene;
    }

    public static void setSettingsScene(Scene settingsScene) {
        MainController.settingsScene = settingsScene;
    }

    public static Scene getHighScoreScene() {
        return highScoreScene;
    }
    public static void setHighScoreScene(Scene highScoreScene) {
        MainController.highScoreScene = highScoreScene;
    }

    public static Scene getExitScene() {
        return exitScene;
    }

    public static void setExitScene(Scene exitScene) {
        MainController.exitScene = exitScene;
    }

    public static Scene getSoundSettingsScene() {
        return soundSettingsScene;
    }

    public static void setSoundSettingsScene(Scene soundSettingsScene) {
        MainController.soundSettingsScene = soundSettingsScene;
    }

    public static Scene getButtonSettingsScene() {
        return buttonSettingsScene;
    }

    public static void setButtonSettingsScene(Scene buttonSettingsScene) {
        MainController.buttonSettingsScene = buttonSettingsScene;
    }

    public static Scene getCharacterSettingsScene() {
        return characterSettingsScene;
    }

    public static void setCharacterSettingsScene(Scene characterSettingsScene) {
        MainController.characterSettingsScene = characterSettingsScene;
    }

    public static Scene getDifficultyScene() {
        return difficultyScene;
    }

    public static void setDifficultyScene(Scene difficultyScene) {
        MainController.difficultyScene = difficultyScene;
    }

}
