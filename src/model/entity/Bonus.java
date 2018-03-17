package model.entity;

public class Bonus extends GameObject {

	private final int IMAGE_NO = 3;
	private double boost;
	private double time;

    public Bonus() {

    }

    public int getIMAGE_NO() {
        return IMAGE_NO;
    }

    public double getBoost() {
        return boost;
    }

    public void setBoost(double boost) {
        this.boost = boost;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}