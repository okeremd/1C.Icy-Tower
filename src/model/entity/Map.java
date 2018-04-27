package model.entity;

import javafx.scene.image.Image;
import model.logic.CollisionManager;

import java.util.Iterator;
import java.util.Random;

import java.util.ArrayList;


public class  Map {
	private static Map instance;
	public static Map getInstance(){
		if(instance==null)
			instance = new Map();
		return instance;
	}
	public static final int GAME_LEFT_LIMIT = 50;
	public static final int GAME_RIGHT_LIMIT = 630;
	private ArrayList<GameObject> gameObjects;
	private Character gameCharacter;
	private int level;
	private int passedLevel;
	int altitude;
	private Random rand;
	private int gravity;
	CollisionManager collisionManager;
	private int difficulty;

    private Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		gameCharacter = new Character();
		gameCharacter.setPosX(280);
		gameCharacter.setPosY(50);
		level = 0;
		altitude = 0;
		gameObjects.add(gameCharacter);
		gravity = 2;
		Base init = new Base();
		init.setPosY(-78);
		init.setPosX(0);
		gameObjects.add(init);
		collisionManager = new CollisionManager(gameObjects);
		setDifficulty(1);
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
		if(level % 100 < 25){
			createLevel(1);
		}
		else if(level % 100 < 50){
			createLevel(2);
		}
		else if(level % 100 < 75){
			createLevel(3);
		}
		else if(level < 99){
			createLevel(4);
		}
		else{
			createFullWidthLevel();
		}
	}

	public Character getGameCharacter() {
		return gameCharacter;
	}

	public void createCollectible(int diff){

		int bonustype = (int)(Math.random()*5);
		Collectible bonus;
		if(bonustype==0){
			bonus = new BarExtender();
		}
		else if(bonustype==1){
			bonus = new TimeSqueezer();
		}
		else if(bonustype==2){
			bonus = new TimeStretcher();
		}
		else if(bonustype==3){
			bonus = new Balloon();
		}
		else{
			bonus = new Coin();
		}
		bonus.setPosY(120 * level - altitude);
		bonus.setPosX((int)(Math.random()*590) + 50);
		gameObjects.add(bonus);

	}

	public void createFullWidthLevel() {
		Base fullWidth = new Base();
		fullWidth.setPosY(120 * level - altitude);
		fullWidth.setPosX(0);
		gameObjects.add(fullWidth);
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void updateObjects() {
		Iterator<GameObject> iter = gameObjects.iterator();
		double decrease = (level/30 - 1)*difficulty;
		if(gameCharacter.getPosY() > 540){
			decrease = gameCharacter.getPosY() - 540;
		}
		while(iter.hasNext()){
			GameObject obj = iter.next(); //TODO bonus falan gelirse buralar değişmeli!!!
			if(obj.getPosY() < 20)
			{
				if(obj instanceof Bar)
				{
					Bar bar =(Bar) obj;
					bar.remove();
				}
			}
			if(obj.getPosY() < -130){
				iter.remove();
			}
			else {
				obj.setPosY((int)(obj.getPosY() - decrease));
			}
		}
		altitude+= decrease;
		if(gameCharacter.getVerticalVelocity() > 0){
			if(gameCharacter.isComboJumping()){
				gameCharacter.setScore(gameCharacter.getScore() + (int)(0.11*(Math.sqrt(altitude))));
			}
			else{
				gameCharacter.setScore(gameCharacter.getScore() + (int)(0.09*(Math.sqrt(altitude))));
			}
		}
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
		collisionManager.checkCollision(gameObjects);
		if (!gameCharacter.isStanding()) {
			gameCharacter.setVerticalVelocity(gameCharacter.getVerticalVelocity() - gravity);
		}

		gameCharacter.setPosY(gameCharacter.getPosY() + (int)gameCharacter.getVerticalVelocity());
		gameCharacter.accelerate();
		if (gameCharacter.isMovingLeft()) {
			if (gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity() > GAME_LEFT_LIMIT)
				gameCharacter.setPosX(gameCharacter.getPosX() + (int)gameCharacter.getHorizontalVelocity());
			else
				gameCharacter.setPosX(GAME_LEFT_LIMIT);

		} else if (gameCharacter.isMovingRight()) {
			if (gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity() < GAME_RIGHT_LIMIT)
				gameCharacter.setPosX(gameCharacter.getPosX() + (int)gameCharacter.getHorizontalVelocity());
			else
				gameCharacter.setPosX(GAME_RIGHT_LIMIT);
		}
	}

	public void createLevel(int type){
		Bar bar;
			if (type == 1) {
				bar = new Wooden();
			}
			else if (type == 2) {
				bar = new Sticky();
			}
			else if (type == 3) {
				bar = new Icy();
			}
			else{
				bar = new HardlyVisible();
			}
			bar.setWidth(12 + rand.nextInt(5));
			bar.setPosX(rand.nextInt(400) + 50);
			bar.setPosY(120 * level - altitude - rand.nextInt(50));
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
			if(Math.abs(gameCharacter.getHorizontalVelocity()) > 15){
				gameCharacter.setComboJumping(true);
				gameCharacter.setVerticalVelocity(gameCharacter.getJumpPower() + Math.abs(gameCharacter.getHorizontalVelocity()));
				gameCharacter.setStanding(false);
			}
			else {
				gameCharacter.setVerticalVelocity(gameCharacter.getJumpPower());
				gameCharacter.setStanding(false);
			}
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

	public void remove(Bar bar) {
		bar.setPosY(bar.getPosY()-10);
		if(collisionManager.isColliding(bar))
			gameCharacter.setPosY(gameCharacter.getPosY()-10);
	}

	public static void setMapNull() {
		instance = null;
	}


	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}