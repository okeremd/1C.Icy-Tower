package view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.entity.Character;
import model.logic.SoundManager;

import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;


public class GameFrame extends Application{
    private enum DIRECTION{
        LEFT,
        RIGHT,
        UP,
        NONE
    }

    private static Character character;
    private static ImageView gameCharacter;
    private ImageView bar;
    private ImageView wall;
    public static MediaPlayer mediaplayer;


    public void start(Stage gameStage) {

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 800, 600);
        playSong();

        character = new Character();

        //TODO initialize game character


        anchorPane.setStyle("-fx-background-color: #b0e0ff");

        gameCharacter = new ImageView(
                new Image(GameFrame.class.getResourceAsStream("/images/character1.PNG")));

        setGameCharacterProperties();

        DIRECTION direction = DIRECTION.NONE;
        Timeline moveCharacterLeft = new Timeline(new KeyFrame(
                Duration.millis(500),
                ae -> moveCharacterLeft(gameCharacter)));
        moveCharacterLeft.setCycleCount(Animation.INDEFINITE);



        anchorPane.getChildren().add(gameCharacter);

        scene.setOnKeyPressed((KeyEvent e) -> {
            KeyCode keyPress = e.getCode();

            if(keyPress == KeyCode.LEFT)
            {

                System.out.println("left");
                moveCharacterLeft.play();
            }
        });
        scene.setOnKeyReleased((KeyEvent e) -> {
            moveCharacterLeft.stop();
        });

        gameStage.setScene(scene);
        gameStage.setTitle("Icy Tower");
        gameStage.show();
    }

    private static void setGameCharacterProperties() {
        gameCharacter.setLayoutX(400);
        gameCharacter.setLayoutY(500);
        gameCharacter.setFitHeight(80);
        gameCharacter.setFitWidth(50);
    }

    public static void playSong(){

        Media media = SoundManager.getInstance().getSelectedSong();
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(SoundManager.getInstance().getVolume());
        mediaplayer.setOnEndOfMedia(() -> mediaplayer.seek(Duration.ZERO));
        mediaplayer.play();
    }

    private static void moveCharacterLeft(ImageView gameCharacter){
        gameCharacter.setTranslateX(gameCharacter.getTranslateX()- 10);
    }
}
