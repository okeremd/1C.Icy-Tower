package model.entity;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.awt.*;

public class Character extends GameObject {

	private int verticalVelocity;
	private int jumpPower;
	private final int IMAGE_NO = 5;
	private boolean standing;

	public Character(){
	    standing = true;
	    jumpPower = 30;
    }

    public Character(Image[] images) {
	    super(images);
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

    public boolean isStanding(){
        return standing;
    }

    public void setStanding(boolean standing){
	    this.standing = standing;
    }
}