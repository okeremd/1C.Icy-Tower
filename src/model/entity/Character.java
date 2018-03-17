package model.entity;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.awt.*;

public class Character extends GameObject {

	private Point2D velocity;
	private int jumpPower;
	private final int IMAGE_NO = 5;

    public Character(Image[] images) {
        super(images);
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
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
}