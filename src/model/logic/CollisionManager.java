package model.logic;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.entity.*;
import model.entity.Character;

import java.util.ArrayList;

public class CollisionManager {
    Bar current;
    private Character character;
	public CollisionManager(ArrayList<GameObject> gameObjects) {
	    character = (Character) gameObjects.get(0);
	}


	public void checkCollision(ArrayList<GameObject> gameObjects) {

	    if(!character.isStanding()) {
            for (int i = 1; i < gameObjects.size(); i++) {
                if (gameObjects.get(i) instanceof Bar) {
                    Bar looper = (Bar) gameObjects.get(i);
                    if (looper.getPosY() < character.getPosY() - character.getImages()[0].getHeight() + Math.abs(character.getVerticalVelocity())
                            && looper.getPosY() > character.getPosY() - character.getImages()[0].getHeight() - Math.abs(character.getVerticalVelocity())
                            && ((looper.getPosX() - 50 <= character.getPosX())
                            && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                            && character.getVerticalVelocity() <= 0)) {
                        if(current instanceof Sticky){
                            character.setCurrentAccelleration(character.getACCELERATION() * ((Sticky) current).getStickyness());
                        }
                        else if(current instanceof Icy){
                            character.setCurrentAccelleration(character.getACCELERATION() * ((Icy) current).getSlipperiness());
                        }
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
	            character.setCurrentAccelleration(character.getACCELERATION());
            }
        }
	}

	public Boolean isColliding(Bar looper){
        if (looper.getPosY() < character.getPosY() - character.getImages()[0].getHeight() + Math.abs(character.getVerticalVelocity())
                && looper.getPosY() > character.getPosY() - character.getImages()[0].getHeight() - Math.abs(character.getVerticalVelocity())
                && ((looper.getPosX() - 50 <= character.getPosX())
                && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                && character.getVerticalVelocity() <= 0))
        {
            System.out.println("hey");
            return true;
        }

        return false;
    }
}