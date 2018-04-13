package view;

import controller.GameController;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.logic.ButtonManager;
import model.logic.CharacterManager;
import model.logic.GameEngine;
import model.logic.SoundManager;


public class GameFrame {


    private GameEngine gameEngine;
    private GameController gameController;
    private AnimationTimer timer;
    Scene scene;
    Timeline timeline;
    private Scene gameScene;
    boolean stopped;

    public MediaPlayer mediaplayer;

    public Scene start() {

        playSong();
        stopped = false;
        KeyCode[] kc = createKeycode();


        gameEngine = new GameEngine();

        Image[] charIms = CharacterManager.getInstance().getCharacterImages();

        gameEngine.setCurrentCharactersImages(charIms);

        gameScene = new Scene(gameEngine.convertMapToPane(), 800, 600);

        gameController = new GameController(gameScene, kc, gameEngine);

        timeline = new Timeline(new KeyFrame(
                Duration.millis(50),
                ae -> updateFrame()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        return gameScene;
    }

    private KeyCode[] createKeycode() {

        KeyCode[] kc = ButtonManager.getInstance().getButtons();
        return kc;
    }

    public void playSong(){

        Media media = SoundManager.getInstance().getSelectedSong();
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(SoundManager.getInstance().getVolume());
        mediaplayer.setOnEndOfMedia(() -> mediaplayer.seek(Duration.ZERO));
        mediaplayer.play();
    }

    private void updateFrame(){
        gameEngine.convertMapToPane();
        if(gameEngine.getMap().gameOver())
        {
            timeline.stop();
            mediaplayer.stop();
            stopped = true;
        }

    }

    public boolean isStopped(){
        return stopped;
    }
}
