package model.entity;

import javafx.scene.image.Image;

public abstract class Bar extends GameObject {

	/**
	 * Holds how many images this bar will hold (horizontal)
	 */
	private int width;
	/**
	 * Holds the id of this bar
	 */
	private  int id;
	/**
	 * Holds whether the is extended by BarExtender Bonus
	 */
	private boolean extended;
	private static int idCounter=0;
	public Bar(){
		this.id=idCounter++;
	}

    public Bar(Image[] images) {
        super(images);
        extended=false;
    }

    public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 *
	 */
	abstract public void move();

	public int getId() {
		return id;
	}
	public static void resetId(){
		idCounter=0;
	}

	public boolean isExtended() {
		return extended;
	}
	public void setExtended(){
		extended=true;
	}
}