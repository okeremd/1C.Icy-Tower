package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import model.logic.GameEngine;

/**
 * Controller for user inputs for character
 */
public class GameController{
	Scene sc;
	GameEngine gameEngine;

	/**
	 * Constructor for GameController class
	 * Due to the control buttons that user selected, it gives that buttons moving feature
	 */
    public GameController(Scene scene, KeyCode[] keyCode, GameEngine gameEngine) {
    	sc = scene;
    	this.gameEngine = gameEngine;
    	sc.setOnKeyPressed(event -> {
    		if(event.getCode() == keyCode[0]){
    			moveLeft();
			}
			else if(event.getCode() == keyCode[1]){
				moveRight();
			}
			else if(event.getCode() == keyCode[2]){
				jump();
			}
			else if(event.getCode() == keyCode[3]){
				pause();
			}
		});

    	sc.setOnKeyReleased(event -> {
			if(event.getCode() == keyCode[0]){
				stopMoveLeft();
			}
			else if(event.getCode() == keyCode[1]){
				stopMoveRight();
			}

		});

    }

    public void moveLeft() {
		gameEngine.moveCharacterLeft();
	}

	public void moveRight() {
		gameEngine.moveCharacterRight();
	}

	public void stopMoveLeft(){
    	gameEngine.stopMoveCharacterLeft();
	}

	public void stopMoveRight(){
    	gameEngine.stopMoveCharacterRight();
	}

	public void jump() {
		gameEngine.jumpCharacter();
	}

	public void pause() {
    	gameEngine.pauseGame();
	}


}