package model.logic;

import java.io.File;
import java.lang.Character;
import java.nio.file.Paths;
import java.util.Timer;

import controller.MainController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.entity.*;

public class GameEngine {

	private MapGenerator mapgen;
	private PauseManager pm;
	//private GameFrame gf;
	private CollisionManager cm;
	private Timer timer;
	private int currentAltitude;
	private int currentScore;
	private boolean gameFinished;
	private boolean gamePaused;
	private int difficulty;
	private Map map;
	private Pane pane;
	int mapLevel;

	public GameEngine() {
		currentAltitude = 0;
		map = new Map();
		pane = new Pane();
		BackgroundImage backgroundImage = new BackgroundImage(new Image(Paths.get( "./images/gameObject/gameBack.png").toUri().toString()), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(backgroundImage));
		mapgen = new MapGenerator(map);
		mapgen.createNextLevels();
	}

	public Pane convertMapToPane(){
		map.updateCharacter();
		map.updateObjects();
		if(map.getLevel() - (map.getAltitude() / 50) < 15){
			mapgen.createNextLevels();
		}
		//map.changeImages();
		if(map.gameOver()){
			createGameOverPane();

			return pane;
		}

		pane.getChildren().clear();
		for(GameObject g: map.getGameObjects()){
			int xsofar = 0;
			if(g instanceof model.entity.Character){
				ImageView add = new ImageView(((model.entity.Character) g).getCurrentImage());
				add.setTranslateX(g.getPosX() + xsofar);
				add.setTranslateY(500 - g.getPosY());
				pane.getChildren().add(add);
			}
			else {
				for (int i = 0; i < g.getImages().length; i++) {
					ImageView add = new ImageView(g.getImages()[i]);
					add.setTranslateX(g.getPosX() + xsofar);
					xsofar += g.getImages()[i].getWidth();
					add.setTranslateY(500 - g.getPosY());
					pane.getChildren().add(add);
					if (g instanceof Bar && i == 0) {
						for (int j = 0; j < ((Bar) g).getWidth(); j++) {
							add = new ImageView(g.getImages()[1]);
							add.setTranslateX(g.getPosX() + xsofar);
							xsofar += g.getImages()[1].getWidth();
							add.setTranslateY(500 - g.getPosY());
							pane.getChildren().add(add);
						}
						i++;
					}
				}
			}
		}
		return pane;
	}

	private void createGameOverPane() {
		Button b = new Button("Back to Menu");
		b.setTranslateY(550);
		b.setTranslateX(650);
		b.setOnMouseClicked(event -> {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(MainController.getInstance().getMainMenuScene());
        });
		TextFlow textflow = new TextFlow();
		Text text1 = new Text("Game Over");
		text1.setFont(Font.font("Game Over", FontWeight.BOLD, 100));
		text1.setFill(Color.AQUAMARINE);
		text1.setTranslateX(100);
		text1.setTranslateY(150);
		Text text2 = new Text("Score: ");
		text2.setFont(Font.font("Score: ", FontWeight.BOLD, 60));
		text2.setFill(Color.GREENYELLOW);
		text2.setTranslateX(-350);
		text2.setTranslateY(270);
		textflow.getChildren().addAll(text1,text2);
		pane.getChildren().addAll(b,textflow);
	}

	public GameEngine(int difficulty, KeyCode[] buttons) {

	}

	/**
	 * 
	 * @param images
	 */
	public void setCurrentCharactersImages(Image[] images) {
		map.setCurrentCharactersImages(CharacterManager.getInstance().getCharacterImages());
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