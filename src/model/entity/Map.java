package model.entity;

import javafx.scene.image.Image;
import model.logic.CollisionManager;
import model.logic.GameEngine;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Iterator;
import java.util.Random;

import java.util.ArrayList;


/**
 * Generates and manages the game objects.
 */
public class Map {

    private enum BARTYPE{
        WOODEN,
        STICKY,
        ICY,
        HARDLYVISIBLE
    }

    private static final int GAME_LEFT_LIMIT = 50;
    private static final int GAME_RIGHT_LIMIT = 630;
    private static final int CHARACTER_INITIAL_POSX = 280;
    private static final int CHARACTER_INITIAL_POSY = 50;
    private static final int BASE_INITIAL_POSY = -78;
    private static final int BASE_INITIAL_POSX = 0;
    private static Map instance;

    private ArrayList<GameObject> gameObjects;
    private Character gameCharacter;
    private int level;
    private int passedLevel;
    int altitude;
    private Random rand;
    private int gravity;
    private CollisionManager collisionManager;
    private int difficulty;
	/**
	 * Singleton Pattern for Map.
	 * Generate and use only one Map Object.
	 * @return Map
	 */
	public static Map getInstance(){
		if(instance==null)
			instance = new Map();
		return instance;
	}

	private Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		gameCharacter = new Character();
		gameCharacter.setPosX(CHARACTER_INITIAL_POSX);
		gameCharacter.setPosY(CHARACTER_INITIAL_POSY);
		level = 0;
		altitude = 0;
		gameObjects.add(gameCharacter);
		gravity = 2;
		Base init = new Base();

		init.setPosX(BASE_INITIAL_POSX);
        init.setPosY(BASE_INITIAL_POSY);
		gameObjects.add(init);
		collisionManager = new CollisionManager(gameObjects);
		//setDifficulty(1);
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
	 *
	 */
	public void createNextAltitudeObjects() {
		if(level % 100 < 25){
			createLevel(BARTYPE.WOODEN);
		}
		else if(level % 100 < 50){
			createLevel(BARTYPE.STICKY);
		}
		else if(level % 100 < 75){
			createLevel(BARTYPE.ICY);
		}
		else if(level < 99){
			createLevel(BARTYPE.HARDLYVISIBLE);
		}
		else{
			createFullWidthLevel();
		}
	}

	public Character getGameCharacter() {
		return gameCharacter;
	}

	public void createCollectible(){

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
			if(obj.getPosY() < 60)
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
				gameCharacter.setScore(gameCharacter.getScore() + (int)(0.11*(Math.sqrt(altitude) + GameEngine.getInstance().getComboCounter()*25)));
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
			{
				if(gameCharacter.getVerticalVelocity()!=0 && gameCharacter.getHorizontalVelocity()<0)
				{
					gameCharacter.setHorizontalVelocity(-gameCharacter.getHorizontalVelocity());
					gameCharacter.setVerticalVelocity(gameCharacter.getVerticalVelocity()*1.0);
				}
				else
					gameCharacter.setPosX(GAME_LEFT_LIMIT);
			}

		} else if (gameCharacter.isMovingRight()) {
			if (gameCharacter.getPosX() + gameCharacter.getHorizontalVelocity() < GAME_RIGHT_LIMIT)
				gameCharacter.setPosX(gameCharacter.getPosX() + (int)gameCharacter.getHorizontalVelocity());
			else
			{
				if(gameCharacter.getVerticalVelocity()!=0 && gameCharacter.getHorizontalVelocity()>0)
				{
					System.out.println("he");
					gameCharacter.setHorizontalVelocity(-gameCharacter.getHorizontalVelocity());
					gameCharacter.setVerticalVelocity(gameCharacter.getVerticalVelocity()*1.0);
				}
				else
					gameCharacter.setPosX(GAME_RIGHT_LIMIT);
			}
		}
	}

	public void createLevel(BARTYPE type){
		Bar bar;
			if (type == BARTYPE.WOODEN) {
				bar = new Wooden();
			}
			else if (type == BARTYPE.STICKY) {
				bar = new Sticky();
			}
			else if (type == BARTYPE.ICY) {
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

	public void fall(Bar bar) {
		bar.setPosY(bar.getPosY()-10);

		if(collisionManager.isColliding(bar))
		{
			gameCharacter.setPosY(gameCharacter.getPosY()-10);
		}
	}
	public void slide(Bar bar)
	{
		bar.setPosX(bar.getPosX()+5);
		if(collisionManager.isColliding(bar))
		{
			gameCharacter.setPosX(gameCharacter.getPosX()+5);
		}
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