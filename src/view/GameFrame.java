package view;

import controller.GameController;
import javafx.animation.Animation;
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
    private GameFrame instance;
    private GameFrame(){

    }
    public GameFrame getInstance(){
        if(instance == null)
        {
            instance = new GameFrame();
        }
        return  instance;
    }
    /**
     * GameController instance that will take input from user
     */
    private GameController gameController;
    /**
     * Timeline will controll the time between each frame
     */
    Timeline timeline;
    /**
     * The Scene that will be shown is held in gameScene
     */
    private Scene gameScene;
    /**
     * MediaPlayer instance will play the musics in game
     */
    public static MediaPlayer mediaplayer;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    private int difficulty;



    private int gameSpeed;


    public GameFrame(int difficulty){
        this.difficulty = difficulty;
        gameSpeed = 40;
        timeline = new Timeline(new KeyFrame(
                Duration.millis(gameSpeed),
                ae -> updateFrame()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public Scene start() {

        playSong();
        KeyCode[] kc = createKeycode();

        Image[] charIms = CharacterManager.getInstance().getCharacterImages();

        GameEngine.init(difficulty);


        GameEngine.getInstance().loadCurrentCharactersImages(charIms);
        gameScene = new Scene(GameEngine.getInstance().convertMapToPane(), 800, 600);

        gameController = new GameController(gameScene, kc, GameEngine.getInstance());




        return gameScene;
    }

    /**
     * This method gets the game buttons from the ButtonManager and pass them to GameEngine
     * @return KeyCode
     */
    private KeyCode[] createKeycode() {

        KeyCode[] kc = ButtonManager.getInstance().getButtons();
        return kc;
    }

    /**
     * This method gets the sound settings from SoundManager and plays them
     *
     */
    public static MediaPlayer  playSong(){

        Media media = SoundManager.getInstance().getSelectedSong();
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(SoundManager.getInstance().getVolume());
        mediaplayer.setOnEndOfMedia(() -> mediaplayer.seek(Duration.ZERO));
        mediaplayer.play();
        return mediaplayer;
    }

    /**
     * This method updates the frame at each timer instance
     *
     */
    private void updateFrame(){
        GameEngine.getInstance().convertMapToPane();
        if(GameEngine.getInstance().getMap().gameOver())
        {
            timeline.stop();
            mediaplayer.stop();
        }
        if(GameEngine.getInstance().isIncreaseGameSpeed())
        {
            timeline.setRate(timeline.getCurrentRate() * (1.25));
            GameEngine.getInstance().setIncreaseGameSpeed(false);
        }
        if(GameEngine.getInstance().isDecreaseGameSpeed())
        {
                timeline.setRate(timeline.getCurrentRate() * (0.8));
                GameEngine.getInstance().setDecreaseGameSpeed(false);
        }
        if(GameEngine.getInstance().deActivateIncraseGameSpeed())
        {
            timeline.setRate(timeline.getRate() * 0.8);
        }
        if(GameEngine.getInstance().deActivateDecreaseGameSpeed())
        {
            timeline.setRate(timeline.getRate() * 1.25);
        }
    }

    public static void changeVolume() {
        mediaplayer.setVolume(SoundManager.getInstance().getVolume());
    }

    public static void stopSong() {
        mediaplayer.stop();
    }


    public  void setRate(double rate){
        timeline.setRate(rate);
        System.out.println(timeline.getRate());
    }
}
