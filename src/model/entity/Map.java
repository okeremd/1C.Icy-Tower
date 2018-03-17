package model.entity;

import javafx.scene.image.Image;
import javafx.geometry.Point2D;
import java.util.Random;

import java.util.ArrayList;

public class Map {

	private ArrayList<GameObject> gameObjects;
	private Character character;
	private int level;
	private Random rand;

    public Map() {
		gameObjects = new ArrayList<>();
		rand = new Random();
		character = new Character();
		level = 0;
    }

    public Map(Map map){
    	this.gameObjects = map.gameObjects;
    	this.character = map.character;
    	this.level = map.level;
	}
    /**
	 * 
	 * @param images
	 */
	public void setCurrentCharactersImages(Image[] images) {
		character.setImages(images);
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

}