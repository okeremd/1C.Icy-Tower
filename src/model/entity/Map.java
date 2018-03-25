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
	private int force;

	private int characterMoveSpeed = INITIAL_CHARACTER_SPEED;

    public Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		gameCharacter = new Character();
		gameCharacter.setPosX(280);
		level = 1;
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
		int numOfBar = rand.nextInt(3) + 1;
		if(level % 100 < 25){
			createLevel(1, numOfBar);
		}
		else if(level % 100 < 50){
			createLevel(2, numOfBar);
		}
		else if(level % 100 < 75){
			createLevel(3, numOfBar);
		}
		else{
			createLevel(4, numOfBar);
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void updateCharacter() {
		//gravity
		if(gameCharacter.getPosY()>0 || force>0)
		{
			System.out.println(gameCharacter.getPosY());
			gameCharacter.setPosY(gameCharacter.getPosY()-10+force);
			System.out.println(gameCharacter.getPosY());
		}

		force-=30;
	}

	public void createLevel(int type, int numOfBars){
		Bar bars[] = new Bar[numOfBars];
		Bar bar;
		int current = 0;
		double width = 0;
		while(current < numOfBars) {
			if (type == 1) {
				bar = new Icy();
			}
			else if (type == 2) {
				bar = new Sticky();
			}
			else if (type == 3) {
				bar = new Wooden();
			}
			else{
				bar = new HardlyVisible();
			}
			width = rand.nextDouble() % 5;
			bar.setWidth(4 + (int) width);
			bar.setPosX(rand.nextInt(550) + 50);
			bar.setPosY(50 * level);
			gameObjects.add(bar);
			bars[current] = bar;
			current++;
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

		force=100;



	}

}