package model.logic;

import model.entity.Bar;
import model.entity.Character;
import model.entity.GameObject;

import java.util.ArrayList;

public class CollisionManager {
    Bar current;
	public CollisionManager(ArrayList<GameObject> gameObjects) {
        current = (Bar) gameObjects.get(1);
	}


	public void checkCollision(ArrayList<GameObject> gameObjects) {
	    Character character = (Character) gameObjects.get(0);
	    if(!character.isStanding()) {
            for (int i = 1; i < gameObjects.size(); i++) {
                if (gameObjects.get(i) instanceof Bar) {
                    Bar looper = (Bar) gameObjects.get(i);
                    if (looper.getPosY() < character.getPosY() - character.getImages()[0].getHeight() + 10
                            && looper.getPosY() > character.getPosY() - character.getImages()[0].getHeight() - 10
                            && ((looper.getPosX() - 50 <= character.getPosX())
                            && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                            && character.getVerticalVelocity() <= 0)) {
                        character.setStanding(true);
                        character.setVerticalVelocity(0);
                        character.setPosY(looper.getPosY() + (int) character.getImages()[0].getHeight());
                        current = looper;
                        break;
                    }
                }
            }
        }
        else{
	        if(!((current.getPosX() - 50 <= character.getPosX()) && (current.getPosX() + (current.getWidth()) * current.getImages()[0].getWidth() >= character.getPosX()))){
	            System.out.println(current.getPosX() + " " + character.getPosX());
	            character.setStanding(false);
            }
        }

	}




}