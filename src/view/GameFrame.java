package view;

import controller.GameController;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
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
import model.logic.GameEngine;
import model.logic.SoundManager;

import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;


public class GameFrame extends Application{


    private GameEngine gameEngine;
    private GameController gameController;
    private AnimationTimer timer;
    Scene scene;
    /*private static Character character;
    private static ImageView gameCharacter;
    private ImageView bar;
    private ImageView wall;
    */
    public static MediaPlayer mediaplayer;

    public void start(Stage gameStage) {
        //AnchorPane anchorPane = new AnchorPane();
        playSong();
        KeyCode[] kc = new KeyCode[4];
        kc[0] = KeyCode.LEFT;
        kc[1] = KeyCode.RIGHT;
        kc[2] = KeyCode.UP;
        kc[3] = KeyCode.P;
        gameEngine = new GameEngine();
        Image[] charIms = new Image[1];
        charIms[0] = new Image(Paths.get(("./images/mainCharacter/mainCharacter1.PNG")).toUri().toString());
        gameEngine.setCurrentCharactersImages(charIms);
        scene = new Scene(gameEngine.convertMapToPane(), 800, 600);
        gameController = new GameController(scene, kc, gameEngine);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateFrame();
            }
        };
        timer.start();

        gameStage.setScene(scene);
        gameStage.setTitle("Icy Tower");
        gameStage.show();
    }

/*    private static void setGameCharacterProperties() {
        gameCharacter.setLayoutX(400);
        gameCharacter.setLayoutY(500);
        gameCharacter.setFitHeight(80);
        gameCharacter.setFitWidth(50);
    }
*/
    public static void playSong(){

        Media media = SoundManager.getInstance().getSelectedSong();
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(SoundManager.getInstance().getVolume());
        mediaplayer.setOnEndOfMedia(() -> mediaplayer.seek(Duration.ZERO));
        mediaplayer.play();
    }

    private void updateFrame(){
        gameEngine.convertMapToPane();
    }

 /*   private void moveCharacterLeft(ImageView gameCharacter){
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
    }*/

}
