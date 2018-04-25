package model.logic;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.entity.Bar;
import model.entity.Character;
import model.entity.GameObject;

import java.util.ArrayList;

public class CollisionManager {
    Bar current;
	public CollisionManager(ArrayList<GameObject> gameObjects) {

	}


	public void checkCollision(ArrayList<GameObject> gameObjects) {
	    Character character = (Character) gameObjects.get(0);
	    if(!character.isStanding()) {
            for (int i = 1; i < gameObjects.size(); i++) {
                if (gameObjects.get(i) instanceof Bar) {
                    Bar looper = (Bar) gameObjects.get(i);
                    if (looper.getPosY() < character.getPosY() - character.getImages()[0].getHeight() + Math.abs(character.getVerticalVelocity())
                            && looper.getPosY() > character.getPosY() - character.getImages()[0].getHeight() - Math.abs(character.getVerticalVelocity())
                            && ((looper.getPosX() - 50 <= character.getPosX())
                            && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                            && character.getVerticalVelocity() <= 0)) {
                        character.setStanding(true);
                        character.setComboJumping(false);
                        character.setVerticalVelocity(0);
                        character.setPosY(looper.getPosY() + (int) character.getImages()[0].getHeight());
                        current = looper;
                        break;
                    }
                }
            }
        }
        else{
	        if(current instanceof Bar && !((current.getPosX() - 50 <= character.getPosX()) && (current.getPosX() + (current.getWidth()) * current.getImages()[0].getWidth() >= character.getPosX()))){
	            character.setStanding(false);
	            current = null;
            }
        }
	}

	public Boolean isColliding(){
	    return current != null;
    }
}