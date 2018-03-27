package model.entity;

import javafx.scene.image.Image;
import model.logic.CharacterManager;
import model.logic.CollisionManager;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Random;

import java.util.ArrayList;

public class  Map {

	public static final int GAME_LEFT_LIMIT = 50;
	public static final int GAME_RIGHT_LIMIT = 630;
	public static final int ACCELERATION = 10;
	public static final int INITIAL_CHARACTER_SPEED = 20;

	private ArrayList<GameObject> gameObjects;
	private Character gameCharacter;
	private int level;
	private Random rand;
	private int gravity;
	CollisionManager cm;

	private int characterMoveSpeed = INITIAL_CHARACTER_SPEED;

    public Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		gameCharacter = new Character();
		gameCharacter.setPosX(280);
		level = 1;
		gameObjects.add(gameCharacter);
		gravity = 2;
		cm = new CollisionManager();
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
		int numOfBar = rand.nextInt(1) + 1;
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
		Iterator<GameObject> iter = gameObjects.iterator();
		while(iter.hasNext()){
			GameObject obj = iter.next();

			//obj.setPosY(obj.getPosY()-1);
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
		Image[] image =new Image[1];
		if(!gameCharacter.isStanding()){
			gameCharacter.setVerticalVelocity(gameCharacter.getVerticalVelocity() - gravity);
			GameObject bar = cm.checkCollision(gameObjects);


/*			if(bar != null && bar instanceof Bar){
				gameCharacter.setVerticalVelocity(0);
				gameCharacter.setStanding(true);
			}
*/		}
		gameCharacter.setPosY(gameCharacter.getPosY() + gameCharacter.getVerticalVelocity());


		/*if(force>0)
		{
			//force decreases as the character goes up, physics 101
			gameCharacter.setPosY(gameCharacter.getPosY()-10+force);
			force-=30;
		}
		else{
			//if there is an object that the gameobject can land to
			for(GameObject gameObject : gameObjects)
			{
				if(gameObject != gameCharacter)
				{
					if(gameObject.getPosY() == gameCharacter.getPosY())
						force=0;
				}
			}
			//if there is force going down and the character is not at the bottom
			if(force!= 0 && gameCharacter.getPosY()!=0)
			{
				//let the gravity fall the character
				gameCharacter.setPosY(gameCharacter.getPosY()+force);
			}
		}*/


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
			bar.setWidth(12 + (int) width);
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

	public void changeImages() {
		if(gameCharacter.getVerticalVelocity()!=0) {
			Image image = new Image(Paths.get(("./images/mainCharacter/character_jump.PNG")).toUri().toString());
			Image[] imagejump = new Image[1];
			imagejump[0] = image;
			gameCharacter.setImages(imagejump);
		}
		else if(gameCharacter.getVerticalVelocity()== 0 && characterMoveSpeed == 0){
			Image image = new Image(Paths.get(("./images/mainCharacter/character1.PNG")).toUri().toString());
			Image[] imagestand = new Image[1];
			imagestand[0] = image;
			gameCharacter.setImages(imagestand);
		}
		if(characterMoveSpeed != 0){

			Image image = new Image(Paths.get(("./images/mainCharacter/character_left_small.GIF")).toUri().toString());
			Image[] imagestand = new Image[1];
			imagestand[0] = image;
			gameCharacter.setImages(imagestand);
		}
	}
}