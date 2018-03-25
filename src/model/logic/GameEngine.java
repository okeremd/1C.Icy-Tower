package model.logic;

import java.io.File;
import java.nio.file.Paths;
import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import model.entity.*;

public class GameEngine {

	private MapGenerator mapgen;
	private PauseManager pm;
	//private GameFrame gf;
	private CollisionManager cm;
	private Camera camera;
	private Timer timer;
	private int currentAltitude;
	private int currentScore;
	private boolean gameFinished;
	private boolean gamePaused;
	private int difficulty;
	private Map map;
	private Pane pane;
	//TODO this class should initialize a display and then maintain the game process
	//TODO let game engine initialize a game character, map that contains game objects
	//TODO then let view module display it.
	//TODO then process should continue throughout the gametime

	public GameEngine() {
		map = new Map();
		pane = new Pane();
		BackgroundImage backgroundImage = new BackgroundImage(new Image(Paths.get( "./images/gameObject/gameBack.png").toUri().toString()), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(backgroundImage));
		mapgen = new MapGenerator(map);
		mapgen.initializeMap();
	}

	public Pane convertMapToPane(){
		map.updateCharacter();
		pane.getChildren().clear();
		for(GameObject g: map.getGameObjects()){
			int xsofar = 0;
			for(int i = 0; i < g.getImages().length; i++) {
				ImageView add = new ImageView(g.getImages()[i]);
				add.setTranslateX(g.getPosX()+ xsofar);
				xsofar += g.getImages()[i].getWidth();
				add.setTranslateY(500 - g.getPosY());
				pane.getChildren().add(add);
				if(g instanceof Bar && i == 0){
					for(int j = 0; j < ((Bar) g).getWidth(); j++ ){
						add = new ImageView(g.getImages()[1]);
						add.setTranslateX(g.getPosX()+ xsofar);
						xsofar += g.getImages()[1].getWidth();
						add.setTranslateY(500 - g.getPosY());
						pane.getChildren().add(add);
					}
					i++;
				}
			}
		}
		return pane;
	}
	public GameEngine(int difficulty, KeyCode[] buttons) {

	}

	/**
	 * 
	 * @param images
	 */
	public void setCurrentCharactersImages(Image[] images) {
		map.setCurrentCharactersImages(images);
	}

	public void moveCharacterLeft(){

		map.moveLeft();
	}

	public void moveCharacterRight(){

		map.moveRight();
	}
	public void jumpCharacter() {

		map.jump();
	}


	public void stopMoveCharacterLeft(){

		map.stopMoveLeft();
	}

	public void stopMoveCharacterRight(){

		map.stopMoveRight();
	}

	public void stopJump(){

		map.stopMoveJump();
	}

	/**
	 * 
	 * @param buttons
	 */
	public void setGameButtons(char[] buttons) {
		// TODO - implement GameEngine.setGameButtons
		throw new UnsupportedOperationException();
	}

	public void updateScore() {
		// TODO - implement GameEngine.updateScore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param diff
	 */
	public void initializeMap(int diff) {
		// TODO - implement GameEngine.initializeMap
		throw new UnsupportedOperationException();
	}

	public void followCharactersAltitude() {
		// TODO - implement GameEngine.followCharactersAltitude
		throw new UnsupportedOperationException();
	}

	public boolean isGameOver() {
		// TODO - implement GameEngine.isGameOver
		throw new UnsupportedOperationException();
	}

	public boolean isGamePaused() {
		return this.gamePaused;
	}

	public void startGame() {
		// TODO
		// intialize the game here
		// initializeMap()
		//
		throw new UnsupportedOperationException();
	}

	public void finishGame() {
		// TODO - implement GameEngine.finishGame
		throw new UnsupportedOperationException();
	}

	public void pauseGame() {
		// TODO - implement GameEngine.pauseGame
		throw new UnsupportedOperationException();
	}

	public void continueGame() {
		// TODO - implement GameEngine.continueGame
		throw new UnsupportedOperationException();
	}

	public void exitGame() {
		// TODO - implement GameEngine.exitGame
		throw new UnsupportedOperationException();
	}

	public void changeVolume() {
		// TODO - implement GameEngine.changeVolume
		throw new UnsupportedOperationException();
	}

	public void changeMusic() {
		// TODO - implement GameEngine.changeMusic
		throw new UnsupportedOperationException();
	}

	public Map getMap(){
		return map;
	}

}