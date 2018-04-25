package model.entity;

import javafx.scene.image.Image;
import model.logic.CollisionManager;

import java.util.Iterator;
import java.util.Random;

import java.util.ArrayList;



public class  Map {
	public static final int GAME_LEFT_LIMIT = 50;
	public static final int GAME_RIGHT_LIMIT = 630;
	public static final int ACCELERATION = 1;
	private ArrayList<GameObject> gameObjects;
	private Character gameCharacter;
	private int level;
	private int passedLevel;
	int altitude;
	private Random rand;
	private int gravity;
	CollisionManager collisionManager;

    public Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		gameCharacter = new Character();
		gameCharacter.setPosX(280);
		level = 0;
		altitude = 0;
		gameObjects.add(gameCharacter);
		gravity = 2;
		Icy init = new Icy();
		init.setWidth(20);
		init.setPosY(0);
		init.setPosX(0);
		gameObjects.add(init);
		collisionManager = new CollisionManager(gameObjects);
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
	public void loadCurrentCharactersImages(Image[] images) {
		gameCharacter.setImages(images);
	}

	/**
	 * 
	 * @param diff
	 */
	public void createNextAltitudeObjects(int diff) {
		if(level % 100 < 125){
			createLevel(1);
		}
		else if(level % 100 < 50){
			createLevel(2);
		}
		else if(level % 100 < 75){
			createLevel(3);
		}
		else{
			createLevel(4);
		}
	}

	public void createCollectible(int diff){
		Collectible collectible = new Collectible();
		gameObjects.add(collectible);
	}

	public void createFullWidthLevel() {
		// TODO - implement Map.createFullWidthLevel
		throw new UnsupportedOperationException();
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void updateObjects() {
		Iterator<GameObject> iter = gameObjects.iterator();
		int decrease = level/30;
		if(gameCharacter.getPosY() > 540){
			decrease = 1 + gameCharacter.getPosY() - 540;
		}
		while(iter.hasNext()){
			GameObject obj = iter.next();
			if(obj.getPosY() < -130){
				iter.remove();
			}
			else {
				obj.setPosY(obj.getPosY() - decrease);
			}
		}
		altitude+= decrease;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAltitude() {
		return altitude;
	}

	public void updateCharacter() {
		System.out.println(gameCharacter.isStanding());

		collisionManager.checkCollision(gameObjects);
		if (!gameCharacter.isStanding()) {
			gameCharacter.setVerticalVelocity(gameCharacter.getVerticalVelocity() - gravity);
		}

		gameCharacter.setPosY(gameCharacter.getPosY() + gameCharacter.getVerticalVelocity());
		if (gameCharacter.isMovingRight() && gameCharacter.isMovingLeft()) {
			gameCharacter.setHorizontalVelocity(0);
		} else if (gameCharacter.isMovingLeft()) {
			gameCharacter.setHorizontalVelocity(gameCharacter.getHorizontalVelocity() - ACCELERATION);
			if (gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity() > GAME_LEFT_LIMIT)
				gameCharacter.setPosX(gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity());
			else
				gameCharacter.setPosX(GAME_LEFT_LIMIT);

		} else if (gameCharacter.isMovingRight()) {
			gameCharacter.setHorizontalVelocity(gameCharacter.getHorizontalVelocity() + ACCELERATION);
			if (gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity() < GAME_RIGHT_LIMIT)
				gameCharacter.setPosX(gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity());
			else
				gameCharacter.setPosX(GAME_RIGHT_LIMIT);
		}
	}

	public void createLevel(int type){
		Bar bar;
		double width = 0;
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
			bar.setWidth(12 + (int) width);
			bar.setPosX(rand.nextInt(550) + 50);
			bar.setPosY(50 * (level) - altitude);
			gameObjects.add(bar);
	}

	public void moveLeft(){
		gameCharacter.setMovingLeft(true);
	}

	public void moveRight(){

		gameCharacter.setMovingRight(true);
	}

	public void stopMoveRight(){
		gameCharacter.setHorizontalVelocity(0);
		gameCharacter.setMovingRight(false);
	}

	public void stopMoveLeft(){
		gameCharacter.setHorizontalVelocity(0);
		gameCharacter.setMovingLeft(false);
	}
	public void stopMoveJump(){

	}
	public void jump(){
		if(gameCharacter.isStanding()){
			gameCharacter.setVerticalVelocity(gameCharacter.getJumpPower());
			gameCharacter.setStanding(false);
		}
	}
	public boolean gameOver(){
		if(gameCharacter.getPosY()<-30)
		{
			return true;
		}
		return false;
	}

	public int getPassedLevel() {
		return passedLevel;
	}

	public void setPassedLevel(int passedLevel) {
		this.passedLevel = passedLevel;
	}
}