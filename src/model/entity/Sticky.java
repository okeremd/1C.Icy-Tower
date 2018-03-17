package model.entity;

import javafx.scene.image.Image;

public class Sticky extends Bar {

	private double stickyness;
	private final int IMAGE_NO = 1;

	public Sticky(){}

    public Sticky(Image[] images) {
        super(images);
    }

    public double getStickyness() {
        return stickyness;
    }

    public void setStickyness(double stickyness) {
        this.stickyness = stickyness;
    }

    public int getIMAGE_NO() {
        return IMAGE_NO;
    }
}