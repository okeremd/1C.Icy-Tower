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

    public static final int GAME_LEFT_LIMIT = -280;
    public static final int GAME_RIGHT_LIMIT = 280;
    public static final int ACCELERATION = 10;
    public static final int INITIAL_CHARACTER_SPEED = 20;

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
    private int characterMoveSpeed= INITIAL_CHARACTER_SPEED;

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
                Duration.millis(70),
                ae -> moveCharacterLeft(gameCharacter)));
        moveCharacterLeft.setCycleCount(Animation.INDEFINITE);

        Timeline moveCharacterRight = new Timeline(new KeyFrame(
                Duration.millis(70),
                ae -> moveCharacterRight(gameCharacter)));
        moveCharacterLeft.setCycleCount(Animation.INDEFINITE);


        anchorPane.getChildren().add(gameCharacter);

        scene.setOnKeyPressed((KeyEvent e) -> {
            KeyCode keyPress = e.getCode();

            if(keyPress == KeyCode.LEFT)
            {
                moveCharacterLeft.play();
            }
            else if(keyPress == KeyCode.RIGHT)
            {
                moveCharacterRight.play();
            }
        });
        scene.setOnKeyReleased((KeyEvent e) -> {
            KeyCode keyPress = e.getCode();
            if(keyPress == KeyCode.LEFT)
            {
                moveCharacterLeft.stop();
            }
            if(keyPress == KeyCode.RIGHT)
            {
                moveCharacterRight.stop();
            }

            characterMoveSpeed=INITIAL_CHARACTER_SPEED;
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

    private void moveCharacterLeft(ImageView gameCharacter){
        characterMoveSpeed += ACCELERATION;
        if(gameCharacter.getTranslateX() - characterMoveSpeed> GAME_LEFT_LIMIT)
            gameCharacter.setTranslateX(gameCharacter.getTranslateX() - characterMoveSpeed);
        else
            gameCharacter.setTranslateX(GAME_LEFT_LIMIT);
    }
    private void moveCharacterRight(ImageView gameCharacter){
        characterMoveSpeed += ACCELERATION;
        if(gameCharacter.getTranslateX() + characterMoveSpeed < GAME_RIGHT_LIMIT)
            gameCharacter.setTranslateX(gameCharacter.getTranslateX() + characterMoveSpeed);
        else
            gameCharacter.setTranslateX(GAME_RIGHT_LIMIT);
    }
}
