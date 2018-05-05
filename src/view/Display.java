package view;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Display extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    private Scene mainMenuScene, howToPlayScene, creditsScene, exitScene, settingsScene, highScoreScene,
            soundSettingsScene, buttonSettingsScene, characterSettingsScene, difficultyScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image(Paths.get("images/background/icon.png").toUri().toString()));

        mainMenuScene = initializeScene("main_menu.fxml");
        //Set background via css
        mainMenuScene.getStylesheets().add(this.getClass().getResource("styleMainMenu.css").toExternalForm());

        howToPlayScene = initializeScene("how_to_play.fxml");
        howToPlayScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        creditsScene = initializeScene("credits.fxml");
        creditsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        exitScene = initializeScene("exit.fxml");
        exitScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        settingsScene = initializeScene("settings.fxml");
        settingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        highScoreScene = initializeScene("high_scores.fxml");
        highScoreScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        soundSettingsScene = initializeScene("sound_settings.fxml");
        soundSettingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        buttonSettingsScene = initializeScene("button_settings.fxml");
        buttonSettingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        characterSettingsScene = initializeScene("character_settings.fxml");
        characterSettingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        difficultyScene = initializeScene("difficulty_screen.fxml");
        difficultyScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());


        MainController.getInstance().setMainMenuScene(mainMenuScene);
        MainController.getInstance().setHowToPlayScene(howToPlayScene);
        MainController.getInstance().setCreditsScene(creditsScene);
        MainController.getInstance().setSettingsScene(settingsScene);
        MainController.getInstance().setHighScoreScene(highScoreScene);
        MainController.getInstance().setExitScene(exitScene);
        MainController.getInstance().setSoundSettingsScene(soundSettingsScene);
        MainController.getInstance().setButtonSettingsScene(buttonSettingsScene);
        MainController.getInstance().setCharacterSettingsScene(characterSettingsScene);
        MainController.getInstance().setDifficultyScene(difficultyScene);
        //MainController.getInstance().setPlayScene(playScene);
        primaryStage.setTitle("Icy Tower");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    public Scene initializeScene(String fxmlName) throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent base = fxmlLoader.load();
        return new Scene(base, SCENE_WIDTH, SCENE_HEIGHT);
    }
}