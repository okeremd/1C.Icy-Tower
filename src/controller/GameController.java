package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import model.logic.GameEngine;

public class GameController{
	Scene sc;
	GameEngine gameEngine;
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
			else if(event.getCode() == keyCode[2]){
				stopJump();
			}
			else if(event.getCode() == keyCode[3]){
				pause();
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

	public void stopJump(){
    	gameEngine.stopJump();
	}

	public void jump() {
		gameEngine.jumpCharacter();
	}

	public void pause() {
		gameEngine.pauseGame();
	}


}