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
	//private Character Character.getInstance();
	private int level;
	private int passedLevel;
	int altitude;
	private Random rand;
	private int gravity;
	CollisionManager collisionManager;

    private Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		//Character.getInstance() = new Character();
		Character.getInstance().setPosX(280);
		Character.getInstance().setPosY(50);
		level = 0;
		altitude = 0;
		gameObjects.add(Character.getInstance());
		gravity = 2;
		Base init = new Base();
		init.setPosY(-78);
		init.setPosX(0);
		gameObjects.add(init);
		collisionManager = new CollisionManager(gameObjects);
    }

    public Map(Map map){
    	this.gameObjects = map.gameObjects;
    	//this.Character.getInstance() = map.Character.getInstance();
    	this.level = map.level;
	}
    /**
	 * 
	 * @param images
	 */
	public void loadCurrentCharactersImages(Image[] images) {
		Character.getInstance().setImages(images);
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
		else{
			createLevel(4);
		}
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
		// TODO - implement Map.createFullWidthLevel
		throw new UnsupportedOperationException();
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void updateObjects() {
		Iterator<GameObject> iter = gameObjects.iterator();
		int decrease = level/30 - 1;
		if(Character.getInstance().getPosY() > 540){
			decrease = Character.getInstance().getPosY() - 540;
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
				obj.setPosY(obj.getPosY() - decrease);
			}
		}
		altitude+= decrease;
		if(Character.getInstance().getVerticalVelocity() > 0){
			if(Character.getInstance().isComboJumping())
				Character.getInstance().setScore(Character.getInstance().getScore()+(int)(0.3*(int)Math.sqrt(Math.sqrt(altitude))));
			else
				Character.getInstance().setScore(Character.getInstance().getScore()+(int)(0.2*(int)Math.sqrt(altitude)));
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
		if (!Character.getInstance().isStanding()) {
			Character.getInstance().setVerticalVelocity(Character.getInstance().getVerticalVelocity() - gravity);
		}

		Character.getInstance().setPosY(Character.getInstance().getPosY() + (int)Character.getInstance().getVerticalVelocity());
		Character.getInstance().accelerate();
		if (Character.getInstance().isMovingLeft()) {
			if (Character.getInstance().getPosX() + Character.getInstance().getHorizontalVelocity() > GAME_LEFT_LIMIT)
				Character.getInstance().setPosX(Character.getInstance().getPosX() + (int)Character.getInstance().getHorizontalVelocity());
			else
				Character.getInstance().setPosX(GAME_LEFT_LIMIT);

		} else if (Character.getInstance().isMovingRight()) {
			if (Character.getInstance().getPosX() + Character.getInstance().getHorizontalVelocity() < GAME_RIGHT_LIMIT)
				Character.getInstance().setPosX(Character.getInstance().getPosX() + (int)Character.getInstance().getHorizontalVelocity());
			else
				Character.getInstance().setPosX(GAME_RIGHT_LIMIT);
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
			bar.setPosY(120 * level - altitude + rand.nextInt(50));
			gameObjects.add(bar);
	}

	public void moveLeft(){
		Character.getInstance().setMovingLeft(true);
	}

	public void moveRight(){

		Character.getInstance().setMovingRight(true);
	}

	public void stopMoveRight(){
		Character.getInstance().setHorizontalVelocity(0);
		Character.getInstance().setMovingRight(false);
	}

	public void stopMoveLeft(){
		Character.getInstance().setHorizontalVelocity(0);
		Character.getInstance().setMovingLeft(false);
	}
	public void stopMoveJump(){

	}

	public void jump(){
		if(Character.getInstance().isStanding()){
			if(Math.abs(Character.getInstance().getHorizontalVelocity()) > 15){
				Character.getInstance().setComboJumping(true);
				Character.getInstance().setVerticalVelocity(Character.getInstance().getJumpPower() + Math.abs(Character.getInstance().getHorizontalVelocity()));
				Character.getInstance().setStanding(false);
			}
			else {
				Character.getInstance().setVerticalVelocity(Character.getInstance().getJumpPower());
				Character.getInstance().setStanding(false);
			}
		}
	}
	public boolean gameOver(){
		if(Character.getInstance().getPosY()<-30)
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

	}

	public static void setMapNull() {
		instance = null;
	}
}