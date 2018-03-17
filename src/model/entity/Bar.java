package model.entity;

import javafx.scene.image.Image;

public class Bar extends GameObject {

	private int width;

	public Bar(){ }

    public Bar(Image[] images) {
        super(images);
    }

    public int getWidth() {
		return this.width;
	}
	/**
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}