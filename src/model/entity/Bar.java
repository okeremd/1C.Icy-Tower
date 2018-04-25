package model.entity;

import javafx.scene.image.Image;

public abstract class Bar extends GameObject {

	private int width;

	public Bar(){ }

    public Bar(Image[] images) {
        super(images);
    }

    public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	abstract public void remove();

}