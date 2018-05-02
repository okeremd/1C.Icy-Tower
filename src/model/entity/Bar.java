package model.entity;

import javafx.scene.image.Image;

public abstract class Bar extends GameObject {

	private int width;
	private  int id;
	private static int idCounter=0;
	public Bar(){
		this.id=idCounter++;
	}

    public Bar(Image[] images) {
        super(images);
    }

    public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	abstract public void move();

	public int getId() {
		return id;
	}
	public static void resetId(){
		idCounter=0;
	}
}