package model.entity;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.awt.*;

public class Character extends GameObject {

	private int verticalVelocity, horizontalVelocity;
	private int jumpPower;
	private final int IMAGE_NO = 6;
	private boolean movingLeft, movingRight, standing;

	public Character(){
	    jumpPower = 30;
	    horizontalVelocity = 1;
	    movingLeft = false;
	    movingRight = false;
	    standing = true;
    }

    public Character(Image[] images) {
	    super(images);
        jumpPower = 30;
        horizontalVelocity = 10;
        movingLeft = false;
        movingRight = false;
    }

    public Image getCurrentImage(){
	    if(!isStanding() && isMovingRight())
        {
            return getImages()[4];
        }
        else if(!isStanding() && isMovingLeft())
        {
            return  getImages()[5];
        }
	    else if(isMovingLeft()){
            return getImages()[2];
        }
        else if(isMovingRight()){
            return getImages()[1];
        }
        else if(isStanding()){
            return getImages()[0];
        }
        else{
	        return getImages()[3];
        }
    }

    public int getVerticalVelocity() {
        return verticalVelocity;
    }

    public void setVerticalVelocity(int verticalVelocity) {
        this.verticalVelocity = verticalVelocity;
    }

    public int getJumpPower() {
        return jumpPower;
    }

    public void setJumpPower(int jumpPower) {
        this.jumpPower = jumpPower;
    }

    public int getIMAGE_NO() {
        return IMAGE_NO;
    }

    public void setStanding(boolean standing){
	    this.standing = standing;
    }

    public boolean isStanding(){
        return standing;
    }

    public boolean isMovingLeft() {
	    return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public int getHorizontalVelocity() {
        return horizontalVelocity;
    }

    public void setHorizontalVelocity(int horizontalVelocity) {
        this.horizontalVelocity = horizontalVelocity;
    }
}