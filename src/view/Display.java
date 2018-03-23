package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Display extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene mainMenuScene = initializeScene("main_menu.fxml");
        mainMenuScene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

        Scene howToPlayScene = initializeScene("how_to_play.fxml");
        Scene creditsScene = initializeScene("credits.fxml");
        Scene exitScene = initializeScene("exit.fxml");
        Scene settingsScene = initializeScene("settings.fxml");
        Scene highScoreScene = initializeScene("high_scores.fxml");
        Scene soundSettingsScene = initializeScene("sound_settings.fxml");
        Scene buttonSettingsScene = initializeScene("button_settings.fxml");
        Scene characterSettingsScene = initializeScene("character_settings.fxml");


        MainController.getInstance().setMainMenuScene(mainMenuScene);
        MainController.getInstance().setHowToPlayScene(howToPlayScene);
        MainController.getInstance().setCreditsScene(creditsScene);
        MainController.getInstance().setSettingsScene(settingsScene);
        MainController.getInstance().setHighScoreScene(highScoreScene);
        MainController.getInstance().setExitScene(exitScene);
        MainController.getInstance().setSoundSettingsScene(soundSettingsScene);
        MainController.getInstance().setButtonSettingsScene(buttonSettingsScene);
        MainController.getInstance().setCharacterSettingsScene(characterSettingsScene);

        primaryStage.setTitle("Icy Tower");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    private Scene initializeScene(String fxmlName) throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent base = fxmlLoader.load();
        return new Scene(base, SCENE_WIDTH, SCENE_HEIGHT);
    }
}