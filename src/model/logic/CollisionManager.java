package model.logic;

import model.entity.Bar;
import model.entity.Character;
import model.entity.GameObject;

import java.util.ArrayList;

public class CollisionManager {
    Bar current, looper;
	public CollisionManager(ArrayList<GameObject> gameObjects) {
        current = (Bar) gameObjects.get(1);
	}


	public void checkCollision(ArrayList<GameObject> gameObjects) {
	    Character c = (Character) gameObjects.get(0);
	    if(!c.isStanding()) {
            for (int i = 1; i < gameObjects.size(); i++) {
                if (gameObjects.get(i) instanceof Bar) {
                    Bar looper = (Bar) gameObjects.get(i);
                    if (looper.getPosY() < c.getPosY() - c.getImages()[0].getHeight() + 10 && looper.getPosY() > c.getPosY() - c.getImages()[0].getHeight() - 10 && ((looper.getPosX() - 50 <= c.getPosX()) && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= c.getPosX()) && c.getVerticalVelocity() <= 0)) {
                        c.setStanding(true);
                        c.setVerticalVelocity(0);
                        c.setPosY(looper.getPosY() + (int) c.getImages()[0].getHeight());
                        current = looper;
                        break;
                    }
                }
            }
        }
        else{
	        if(!((current.getPosX() - 50 <= c.getPosX()) && (current.getPosX() + (current.getWidth()) * current.getImages()[0].getWidth() >= c.getPosX()))){
	            System.out.println(current.getPosX() + " " + c.getPosX());
	            c.setStanding(false);
            }
        }

	}




}