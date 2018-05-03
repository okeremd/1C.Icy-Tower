package model.logic;

import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.entity.*;
import model.entity.Character;

import java.nio.file.Paths;
import java.util.ArrayList;

public class CollisionManager {
    public static final int BAR_EXTEND_LENGTH = 5;
    Bar current;
    Collectible currentbonus;
    private Character character;
	public CollisionManager(ArrayList<GameObject> gameObjects) {
	    character = (Character) gameObjects.get(0);
	}

    public int getPrevBarId() {
        return prevBarId;
    }

    public void setPrevBarId(int prevBarId) {
        this.prevBarId = prevBarId;
    }

    public int prevBarId = 0;

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
        for (int i = 1; i < gameObjects.size(); i++) {
	        if(gameObjects.get(i) instanceof Collectible){
	            currentbonus = (Collectible) gameObjects.get(i);
	            if((character.getPosX()+character.getImages()[0].getWidth() >= currentbonus.getPosX())
                        && (character.getPosX() <= currentbonus.getPosX() + currentbonus.getImages()[0].getWidth())
                        && (currentbonus.getPosY() - currentbonus.getImages()[0].getHeight() <= character.getPosY())
                        && (currentbonus.getPosY() >= character.getPosY() - character.getImages()[0].getHeight())){

	                if (currentbonus instanceof Coin) {
	                    character.setScore(character.getScore() + ((Coin) currentbonus).getVALUE());
	                    gameObjects.remove(currentbonus);
	                    Map.getInstance().extraPoints();
	                }
                    else if (currentbonus instanceof Balloon) {

                        Image a = new Image(Paths.get("./images/bonus/balloon.png").toUri().toString());
                        Image b = new Image(Paths.get("./images/character_images/character1_3.png").toUri().toString());
                        ImageView top = new ImageView(a);
                        ImageView bottom = new ImageView(b);
                        top.setBlendMode(BlendMode.OVERLAY);
                        Group blend = new Group(top,bottom);


                    } else if (currentbonus instanceof TimeStretcher) {

                        gameObjects.remove(currentbonus);
                        Map.getInstance().decreaseSpeed(prevBarId);


                    } else if (currentbonus instanceof TimeSqueezer) {
                        gameObjects.remove(currentbonus);
                        Map.getInstance().increaseSpeed(prevBarId);

                    } else { //bar extender

                        Map.getInstance().extendBar(prevBarId);
                        gameObjects.remove(currentbonus);
                    }
	            }
	        }
	    }
	}

	public Boolean isColliding(Bar looper){
        if (looper.getPosY() < character.getPosY() && looper.getPosY()> character.getPosY()-150
                && ((looper.getPosX() - 50 <= character.getPosX())
                && (looper.getPosX() + (looper.getWidth()) * looper.getImages()[0].getWidth() >= character.getPosX())
                && character.getVerticalVelocity() <= 0))
        {
            return true;
        }

        return false;
    }
}