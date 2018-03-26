package model.logic;

import model.entity.Bar;
import model.entity.Character;
import model.entity.GameObject;

import java.util.ArrayList;

public class CollisionManager {

	public CollisionManager() {

	}


	public GameObject checkCollision(ArrayList<GameObject> gameObjects) {
	    Character c = (Character) gameObjects.get(0);
		for(int i = 1; i < gameObjects.size(); i++){
		    if(gameObjects.get(i) instanceof Bar){
		        Bar current = (Bar)gameObjects.get(i);
                //if((current.getPosY() + current.getImages()[0].getHeight() <= 10 - c.getImages()[0].getHeight() + (c.getPosY())) && (current.getPosY() + current.getImages()[0].getHeight() >= (c.getPosY() - c.getImages()[0].getHeight() - 10)) && ((current.getPosX() <= c.getPosX() )&& (current.getPosX() + (current.getWidth()) * current.getImages()[0].getWidth() >= c.getPosX()) && c.getVerticalVelocity() <= 0)){
                if(current.getPosY() < c.getPosY() - c.getImages()[0].getHeight() + 10 && current.getPosY() > c.getPosY() -c.getImages()[0].getHeight() - 10 && ((current.getPosX() <= c.getPosX() )&& (current.getPosX() + (current.getWidth()) * current.getImages()[0].getWidth() >= c.getPosX()) && c.getVerticalVelocity() <= 0)){
                    System.out.println((current.getPosY() + (int)current.getImages()[0].getHeight()));
                    c.setStanding(true);
                    c.setVerticalVelocity(0);
                    c.setPosY(current.getPosY() + (int)c.getImages()[0].getHeight());
                    return gameObjects.get(i);
                }
            }

		}
		return null;
	}




}