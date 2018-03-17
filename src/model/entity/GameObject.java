package model.entity;

import javafx.scene.image.Image;

public abstract class GameObject {

    private Image[] images;
    private int posX;
    private int posY;

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