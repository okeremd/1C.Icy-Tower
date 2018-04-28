package model.entity;

public class Collectible extends GameObject {

	private double time;
	private int width;

    public Collectible() {
        // ToDo implement Collectibles

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }


}