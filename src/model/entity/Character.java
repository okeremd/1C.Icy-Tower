package model.entity;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.awt.*;

public class Character extends GameObject {

    public static final int JUMP_POWER = 30;
    private int verticalVelocity, horizontalVelocity;
	private int jumpPower;
	private final int IMAGE_NO = 7;
	private boolean movingLeft, movingRight, standing, comboJumping;

	public Character(){
	    jumpPower = JUMP_POWER;
	    horizontalVelocity = 1;
	    movingLeft = false;
	    movingRight = false;
	    standing = true;
	    comboJumping = false;
    }

    public Character(Image[] images) {
	    super(images);
        jumpPower = 30;
        horizontalVelocity = 10;
        movingLeft = false;
        movingRight = false;
        comboJumping = false;

    }

    public Image getCurrentImage(){
	    if(isComboJumping()){
	        return getImages()[6];
        }
	    else if(!isStanding() && isMovingRight())
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

    public boolean isComboJumping() {
        return comboJumping;
    }

    public void setComboJumping(boolean comboJumping) {
        this.comboJumping = comboJumping;
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