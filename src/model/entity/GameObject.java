package model.entity;

import javafx.scene.image.Image;

/**
 * GameObject class for getting images and positions of the game objects
 */
public abstract class GameObject {


    private Image[] images; //Holds the images of this object
    private int posX;   //Holds the horizontal position of this object
    private int posY; //Holds the vertical position of this object

    public GameObject() { }
	
    public GameObject(Image[] images) {
        this.images = images;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}