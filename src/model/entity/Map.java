package model.entity;

import javafx.scene.image.Image;
import javafx.geometry.Point2D;
import java.util.Random;

import java.util.ArrayList;

public class Map {

	public static final int GAME_LEFT_LIMIT = 50;
	public static final int GAME_RIGHT_LIMIT = 630;
	public static final int ACCELERATION = 10;
	public static final int INITIAL_CHARACTER_SPEED = 20;

	private ArrayList<GameObject> gameObjects;
	private Character gameCharacter;
	private int level;
	private Random rand;

	private int characterMoveSpeed = INITIAL_CHARACTER_SPEED;

    public Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		gameCharacter = new Character();
		gameCharacter.setPosX(280);
		gameCharacter.setPosY(450);
		level = 0;
		gameObjects.add(gameCharacter);
    }

    public Map(Map map){
    	this.gameObjects = map.gameObjects;
    	this.gameCharacter = map.gameCharacter;
    	this.level = map.level;
	}
    /**
	 * 
	 * @param images
	 */
	public void setCurrentCharactersImages(Image[] images) {
		gameCharacter.setImages(images);
	}

	/**
	 * 
	 * @param diff
	 */
	public void createNextAltitudeObjects(int diff) {
		if(level % 100 < 25){
			createBar(1);
		}
		else if(level % 100 < 50){
			createBar(2);
		}
		else if(level % 100 < 75){
			createBar(3);
		}
		else{
			createBar(4);
		}
	}

	public void createFullWidthLevel() {
		// TODO - implement Map.createFullWidthLevel
		throw new UnsupportedOperationException();
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void createBonus() {
		// TODO - implement Map.createBonus
		throw new UnsupportedOperationException();
	}

	public void updateObjects() {
		for(GameObject obj: gameObjects){
			if(obj.getPosY() < level){
				gameObjects.remove(obj);
			}
		}
	}

	public void updateCharacter() {
		// TODO - implement Map.updateCharacter
		throw new UnsupportedOperationException();
	}

	public void createBar(int type){
		Bar bar;
		double possibility = rand.nextDouble() % (Math.pow(30, (1/(level))));
		if(type == 1){
			if(possibility < 3){
				bar = new Icy();
				possibility = rand.nextDouble() % 5;
				bar.setWidth(4 + (int)possibility);
				gameObjects.add(bar);
			}
		}
		if(type == 2){
			if(possibility < 3){
				bar = new Sticky();
				possibility = rand.nextDouble() % 5;
				bar.setWidth(4 + (int)possibility);
				gameObjects.add(bar);
			}
		}
		if(type == 3) {
			if (possibility < 3) {
				bar = new Wooden();
				possibility = rand.nextDouble() % 5;
				bar.setWidth(4 + (int) possibility);
				gameObjects.add(bar);
			}
		}
		if(type == 4){
			if(possibility < 3){
				bar = new HardlyVisible();
				possibility = rand.nextDouble() % 5;
				bar.setWidth(4 + (int)possibility);
				gameObjects.add(bar);
			}
		}
	}

	public void moveLeft(){
		characterMoveSpeed += ACCELERATION;
		if(gameCharacter.getPosX() - characterMoveSpeed> GAME_LEFT_LIMIT)
			gameCharacter.setPosX(gameCharacter.getPosX() - characterMoveSpeed);
		else
			gameCharacter.setPosX(GAME_LEFT_LIMIT);
	}

	public void moveRight(){
		characterMoveSpeed += ACCELERATION;
		if(gameCharacter.getPosX() + characterMoveSpeed< GAME_RIGHT_LIMIT)
			gameCharacter.setPosX(gameCharacter.getPosX() + characterMoveSpeed);
		else
			gameCharacter.setPosX(GAME_RIGHT_LIMIT);
	}

	public void stopMoveRight(){
		characterMoveSpeed = 0;
	}

	public void stopMoveLeft(){
		characterMoveSpeed = 0;
	}
	public void stopMoveJump(){

	}
	public void jump(){

	}

}