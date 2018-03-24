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
        //Set background via css
        mainMenuScene.getStylesheets().add(this.getClass().getResource("styleMainMenu.css").toExternalForm());

        Scene howToPlayScene = initializeScene("how_to_play.fxml");
        howToPlayScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene creditsScene = initializeScene("credits.fxml");
        creditsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene exitScene = initializeScene("exit.fxml");
        exitScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene settingsScene = initializeScene("settings.fxml");
        settingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene highScoreScene = initializeScene("high_scores.fxml");
        highScoreScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene soundSettingsScene = initializeScene("sound_settings.fxml");
        soundSettingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene buttonSettingsScene = initializeScene("button_settings.fxml");
        buttonSettingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        Scene characterSettingsScene = initializeScene("character_settings.fxml");
        characterSettingsScene.getStylesheets().add(this.getClass().getResource("styleOtherMenus.css").toExternalForm());

        //Scene playScene = GameFrame.getScene();

        MainController.getInstance().setMainMenuScene(mainMenuScene);
        MainController.getInstance().setHowToPlayScene(howToPlayScene);
        MainController.getInstance().setCreditsScene(creditsScene);
        MainController.getInstance().setSettingsScene(settingsScene);
        MainController.getInstance().setHighScoreScene(highScoreScene);
        MainController.getInstance().setExitScene(exitScene);
        MainController.getInstance().setSoundSettingsScene(soundSettingsScene);
        MainController.getInstance().setButtonSettingsScene(buttonSettingsScene);
        MainController.getInstance().setCharacterSettingsScene(characterSettingsScene);

        //MainController.getInstance().setPlayScene(playScene);
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