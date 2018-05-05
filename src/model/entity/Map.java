package model.entity;

import javafx.scene.image.Image;
import model.logic.CollisionManager;
import model.logic.GameEngine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


/**
 * Generates and manages the game objects.
 */
public class Map {

	private static final int GAME_BOTTOM_LIMIT = -120;
    private static final int GRAVITY_INITIAL = 2;
	private static final int ALTITUDE_INITIAL = 0;
	private static final int LEVEL_INITIAL = 0;
	public static final double SCORE_MULTIPLIER_COMBO = 0.11;
	public static final double SCORE_MULTIPLIER_DEFAULT = 0.09;
    public static final int INCREMENT_SPEED = 3;
    public static final int DECREMENT_SPEED = 2;
	public static final int GAME_OVER_LEFT_LIMIT = 780;
	public static final int GAME_OVER_RIGHT_LIMIT = 780;


	private enum BarType {
        WOODEN,
        STICKY,
        ICY,
        HARDLYVISIBLE
    }

	private static final int GAME_LEFT_LIMIT = 0;
    private static final int GAME_RIGHT_LIMIT = 720;
    private static final int CHARACTER_INITIAL_POSX = 280;
    private static final int CHARACTER_INITIAL_POSY = 50;
    private static final int BASE_INITIAL_POSY = -78;
    private static final int BASE_INITIAL_POSX = 0;

	/**
	 * Singleton instance
	 */
	private static Map instance;

	/**
	 * ArrayList that holds all GameObjects shown
	 */
    private ArrayList<GameObject> gameObjects;

	/**
	 * Character that controlled by the player
	 */
	private Character gameCharacter;

	/**
	 * The number of levels that created by Map Generator so far
	 */
    private int level;

	/**
	 * The number of levels that passed by Character so far
	 */
	private int passedLevel;

	/**
	 * The total number of pixels that character travelled vertically
	 */
    private int altitude;

	/**
	 * Random generator
	 */
	private Random rand;

	/**
	 * The acceleration of the character downwards
	 */
    private int gravity;

	/**
	 * collision manager attribute
	 */
	private CollisionManager collisionManager;

	/**
	 * The difficulty that determined by player
	 */
    private double  difficulty;
    private boolean speedIncreaseBonusTaken;
    private int speedBonusActivatedBar;
    private boolean slowIncreaseBonusTaken;
    private int slowBonusActivatedBar;
	private boolean barExtendTaken;
    private int barExtendTakenBar;
	/**
	 * Singleton Pattern for Map.
	 * Generate and use only one Map Object.
	 * @return Map
	 */
	public static Map getInstance(){

		if(instance==null){
			instance = new Map();
		}

		return instance;
	}

	/**
	 * Default constructor
	 */
	private Map() {

		rand = new Random();

		gameObjects = new ArrayList<>();

		gameCharacter = new Character();
		gameCharacter.setPosX(CHARACTER_INITIAL_POSX);
		gameCharacter.setPosY(CHARACTER_INITIAL_POSY);

		gameObjects.add(gameCharacter);

		level = LEVEL_INITIAL;
		altitude = ALTITUDE_INITIAL;
		gravity = GRAVITY_INITIAL;

		Base base = new Base();
		base.setPosX(BASE_INITIAL_POSX);
        base.setPosY(BASE_INITIAL_POSY);
        gameObjects.add(base);

        barExtendTakenBar=0;

        collisionManager = new CollisionManager(gameObjects);
	}

    /**
	 * Loads the selected Character's images.
	 * @param images
	 */
	public void loadCurrentCharactersImages(Image[] images) {
		gameCharacter.setImages(images);
	}

	/**
	 * Creates the bars as the height increases.
	 *
	 */
	public void createNextBar() {
		if(level % 100 < 25){
			createBar(BarType.WOODEN);
		}
		else if(level % 100 < 50){
			createBar(BarType.STICKY);
		}
		else if(level % 100 < 75){
			createBar(BarType.ICY);
		}
		else if(level < 99){
			createBar(BarType.HARDLYVISIBLE);
		}
		else{
			createFullWidthLevel();
		}
	}

	public Character getGameCharacter() {

		return gameCharacter;

	}

	/**
	 * Creates collectibles as character increases
	 */
	public void createCollectible(){

		int bonustype = (int)(Math.random()*5);
		Collectible bonus = new Collectible();
		switch (bonustype)
		{
			case 0: bonus = new BarExtender(); break;
			case 1: bonus = new TimeSqueezer(); break;
			case 2: bonus = new TimeStretcher(); break;
			case 3: bonus = new Balloon(); break;
			case 4: bonus = new Coin(); break;
			default:
		}

		bonus.setPosY(120 * level - altitude);
		bonus.setPosX((int)(Math.random()*590) + 50);

		gameObjects.add(bonus);

	}

	/**
	 * Creates a level that fits in the length of screen
	 */
	public void createFullWidthLevel() {
		Base fullWidth = new Base();
		fullWidth.setPosY(120 * level - altitude);
		fullWidth.setPosX(0);
		gameObjects.add(fullWidth);
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	/**
	 * the increasing visual is provided with decreasing bar altitudes
	 */
	public void moveBars() {

		Iterator<GameObject> iter = gameObjects.iterator();
		double decrease = (level/30 - 1)*difficulty;
		if(gameCharacter.getPosY() > 400){
			decrease = gameCharacter.getPosY() - 400;
		}
		while(iter.hasNext()){
			GameObject obj = iter.next();
			if(obj.getPosY() < 60)
			{
				if(obj instanceof Bar)
				{
					Bar bar =(Bar) obj;
					bar.move();
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

	}

	/**
	 * Increments player's score
	 */
	public void incrementScore(){
		if(gameCharacter.getVerticalVelocity() > 0){
			if(gameCharacter.isComboJumping()){
				gameCharacter.setScore(gameCharacter.getScore() + (int)(SCORE_MULTIPLIER_COMBO *(Math.sqrt(altitude) + GameEngine.getInstance().getComboCounter()*25)));
			}
			else{
				gameCharacter.setScore(gameCharacter.getScore() + (int)(SCORE_MULTIPLIER_DEFAULT *(Math.sqrt(altitude))));
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

	/**
	 * Checks the collisions of the character and updates locations
	 */
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
					gameCharacter.setHorizontalVelocity(-gameCharacter.getHorizontalVelocity());
					gameCharacter.setVerticalVelocity(gameCharacter.getVerticalVelocity()*1.0);
				}
				else
					gameCharacter.setPosX(GAME_RIGHT_LIMIT);
			}
		}
		deActivateBonus();
	}

	/**
	 * Creates a bar with given type at predetermined altitude
	 * @param type one of four types from Bars
	 */
	public void createBar(BarType type){
		Bar bar;
			if (type == BarType.WOODEN) {
				bar = new Wooden();
			}
			else if (type == BarType.STICKY) {
				bar = new Sticky();
			}
			else if (type == BarType.ICY) {
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

	public void jump(){
		gameCharacter.setCurrentAccelleration(Character.getACCELERATION());
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

	/**
	 * Ends the game
	 * @return whether the game ended
	 */
	public boolean gameOver(){
		return gameCharacter.getPosY() < GAME_BOTTOM_LIMIT || gameCharacter.getPosX() < GAME_LEFT_LIMIT || gameCharacter.getPosX() > GAME_OVER_RIGHT_LIMIT;
	}

	public int getPassedLevel() {
		return passedLevel;
	}

	public void setPassedLevel(int passedLevel) {
		this.passedLevel = passedLevel;
	}

	/**
	 * Provides the falling effect of some types of bars
	 * @param bar
	 */
	public void fall(Bar bar) {
		bar.setPosY(bar.getPosY()-10);

		if(collisionManager.isColliding(bar))
		{
			gameCharacter.setPosY(gameCharacter.getPosY()-10);
		}
	}

	/**
	 * Provides the sliding effect of some types of bars
	 * @param bar
	 */
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


	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

    public void extraPoints() {
        getGameCharacter().setScore(getGameCharacter().getScore()+500);
    }
    public void deActivateBonus(){
	    if(speedIncreaseBonusTaken && CollisionManager.getPrevBarId() > speedBonusActivatedBar + 4)
        {
            speedIncreaseBonusTaken = false;
            speedBonusActivatedBar = 0;
            setDifficulty((getDifficulty() - INCREMENT_SPEED));
        }

        if(slowIncreaseBonusTaken && CollisionManager.getPrevBarId() > slowBonusActivatedBar + 4)
        {
            slowIncreaseBonusTaken = false;
            slowBonusActivatedBar = 0;
            setDifficulty((getDifficulty() * DECREMENT_SPEED));
        }
		if(barExtendTaken && CollisionManager.getPrevBarId() > barExtendTakenBar + 10)
		{
			barExtendTaken = false;
			barExtendTakenBar = -1;
			//GameEngine.setBarExtend(0);
		}
    }


    public void increaseSpeed(int activatedBar) {
	    if(!speedIncreaseBonusTaken)
        {
            speedIncreaseBonusTaken = true;
            speedBonusActivatedBar = activatedBar;
        }

	    setDifficulty(getDifficulty()+ INCREMENT_SPEED);
    }

    public void decreaseSpeed(int activatedBar) {
        if(!speedIncreaseBonusTaken)
        {
            slowIncreaseBonusTaken = true;
            slowBonusActivatedBar = activatedBar;
        }

        setDifficulty(getDifficulty()/ DECREMENT_SPEED);
    }

	public void extendBar(int activatedBar) {
			barExtendTaken=true;
			barExtendTakenBar= activatedBar;

	}
	public boolean isBarExtendTaken(){
		return barExtendTaken;
	}
	public int getBarExtendTakenBar(){
		return barExtendTakenBar;
	}
}