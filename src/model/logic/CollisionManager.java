package model.logic;

import model.entity.*;
import model.entity.Character;

import java.util.ArrayList;

public class CollisionManager {

    Bar current;
    Collectible currentbonus;  //bonus which is taken currently by the character
    private Character character;  //game character

    /**
     * Constructor for CollisionManager
     * @param gameObjects list of game objects in the game
     */
	public CollisionManager(ArrayList<GameObject> gameObjects) {
	    character = (Character) gameObjects.get(0);
	}

    public static int getPrevBarId() {
        return prevBarId;
    }

    public void setPrevBarId(int prevBarId) {
        CollisionManager.prevBarId = prevBarId;
    }

    public static int prevBarId = 0;

    /**
     * Checks collisions between character and other game objects
     * @param gameObjects all objects on the map
     */
	public void checkCollision(ArrayList<GameObject> gameObjects) {

	    // If character was not on a bar, checks all bars to determine whether character is on a bar now
	    if(!character.isStanding()) {
            for (int i = 1; i < gameObjects.size(); i++) {
                if (gameObjects.get(i) instanceof Bar) {
                    Bar looper = (Bar) gameObjects.get(i);
                    if (looper.getPosY() < character.getPosY() - character.getImages()[0].getHeight() + Math.abs(character.getVerticalVelocity())
                            && looper.getPosY() > character.getPosY() - character.getImages()[0].getHeight() - Math.abs(character.getVerticalVelocity())
                            && ((looper.getPosX() - 50 <= character.getPosX())
                            && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                            && character.getVerticalVelocity() <= 0)) {
                        current = looper;
                        if(prevBarId<looper.getId()-1)
                        {
                            GameEngine.getInstance().setComboJump(true);
                            GameEngine.getInstance().setComboCounter(GameEngine.getInstance().getComboCounter()+looper.getId()-prevBarId);
                        }
                        else {
                            GameEngine.getInstance().setComboJump(false);
                            GameEngine.getInstance().setComboCounter(0);
                        }
                        prevBarId=looper.getId();
                        if(current instanceof Sticky){
                            character.setCurrentAccelleration(Character.getACCELERATION() * ((Sticky) current).getStickyness());
                        }
                        else if(current instanceof Icy){
                            character.setCurrentAccelleration(Character.getACCELERATION() * ((Icy) current).getSlipperiness());
                        }
                        character.setStanding(true);
                        character.setComboJumping(false);
                        character.setVerticalVelocity(0);
                        character.setPosY(looper.getPosY() + (int) character.getImages()[0].getHeight());
                        break;
                    }
                }

            }
	    }
        else{
            if(current instanceof Bar && !((current.getPosX() - 50 <= character.getPosX()) && (current.getPosX() + (current.getWidth()) * current.getImages()[0].getWidth() >= character.getPosX()))){
                character.setStanding(false);
                current = null;
                character.setCurrentAccelleration(Character.getACCELERATION());
            }
        }

        // Checks collectibles and character to determine if character is in a position to collect a bonus
        for (int i = 1; i < gameObjects.size(); i++) {
	        if(gameObjects.get(i) instanceof Collectible){
	            currentbonus = (Collectible) gameObjects.get(i);
	            if((character.getPosX()+character.getImages()[0].getWidth() >= currentbonus.getPosX())
                        && (character.getPosX() <= currentbonus.getPosX() + currentbonus.getImages()[0].getWidth())
                        && (currentbonus.getPosY() - currentbonus.getImages()[0].getHeight() <= character.getPosY())
                        && (currentbonus.getPosY() >= character.getPosY() - character.getImages()[0].getHeight())){

	                //if the bonus is a coin, its value is added to the score
	                if (currentbonus instanceof Coin) {
	                    character.setScore(character.getScore() + ((Coin) currentbonus).getVALUE());
	                    gameObjects.remove(currentbonus);
	                    Map.getInstance().extraPoints();
	                }
	                //if the bonus is a balloon, character goes up easily for a while with the balloon
                    else if (currentbonus instanceof Balloon) {
                        if(!((Balloon)currentbonus).isTouched()){
                            character.setComboJumping(false);
                            ((Balloon)currentbonus).setVelocity(Math.sqrt(Map.getInstance().getAltitude()/50)+8);
                            ((Balloon)currentbonus).setTouched();
                            ((Balloon)currentbonus).setStartingAltitude(Map.getInstance().getAltitude());
                        }
                        character.setVerticalVelocity(((Balloon)currentbonus).getVelocity());
                        currentbonus.setPosX(character.getPosX() + (int)(character.getCurrentImage().getWidth() - currentbonus.getImages()[0].getWidth())/2);
                        currentbonus.setPosY(character.getPosY() + (int)currentbonus.getImages()[0].getHeight() - 10);

                        if(((Balloon)currentbonus).isPassed(Map.getInstance().getAltitude(), 60)){
                                gameObjects.remove(currentbonus);
                            }
                     //if the bonus is a timestretcher, the game screen speed decreases for a while
                    } else if (currentbonus instanceof TimeStretcher) {

                        gameObjects.remove(currentbonus);
                        GameEngine.getInstance().decreaseGameSpeed();
                        GameEngine.getInstance().setPrevBarDecreaseGameSpeed(prevBarId);

                     //if the bonus is a timesqueezer, the game screen increases for a while
                    } else if (currentbonus instanceof TimeSqueezer) {
                        gameObjects.remove(currentbonus);
                        GameEngine.getInstance().increaseGameSpeed();
                        GameEngine.getInstance().setPrevBarIncreaseGameSpeed(prevBarId);

                     //bonus is barextender and it increases the lenght of the bars
                    } else {

                        Map.getInstance().extendBar(prevBarId);
                        gameObjects.remove(currentbonus);
                    }
	            }
	        }
	    }
	}

    /**
     * Checks whether the character is standing on the given bar
     * @param looper is the bar that checked
     * @return true if character stands on the given bar
     */
	public Boolean isColliding(Bar looper){
        return looper.getPosY() < character.getPosY() && looper.getPosY() > character.getPosY() - 150
                && ((looper.getPosX() - 50 <= character.getPosX())
                && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                && character.getVerticalVelocity() <= 0);

    }
}