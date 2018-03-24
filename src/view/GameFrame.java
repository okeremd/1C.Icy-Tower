package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.nio.file.Paths;


public class GameFrame {

    private static ImageView gameCharacter;
    private ImageView bar;
    private ImageView wall;
    public static MediaPlayer mediaplayer;

    public static Scene getScene() {

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 800, 600);

        anchorPane.setStyle("-fx-background-color: #b0e0ff");

        gameCharacter = new ImageView(
                new Image(GameFrame.class.getResourceAsStream("/images/character1.PNG")));

        setGameCharacterProperties();

        anchorPane.getChildren().add(gameCharacter);

        return scene;
    }

    private static void setGameCharacterProperties() {
        gameCharacter.setLayoutX(400);
        gameCharacter.setLayoutY(500);
        gameCharacter.setFitHeight(80);
        gameCharacter.setFitWidth(50);
    }

    public static void setSong(String song){

        Media media = new Media(Paths.get("music/" + song + ".mp3").toUri().toString());
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setAutoPlay(true);

        mediaplayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaplayer.seek(Duration.ZERO);
            }
        });
        mediaplayer.play();
    }
}
