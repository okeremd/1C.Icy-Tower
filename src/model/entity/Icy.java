package model.entity;

import javafx.scene.image.Image;

public class Icy extends Bar {

	private double slipperiness;
	private int IMAGE_NO;

    public Icy(Image[] images) {
        super(images);
    }

    public double getSlipperiness() {
        return slipperiness;
    }

    public void setSlipperiness(double slipperiness) {
        this.slipperiness = slipperiness;
    }

    public int getIMAGE_NO() {
        return IMAGE_NO;
    }

    public void setIMAGE_NO(int IMAGE_NO) {
        this.IMAGE_NO = IMAGE_NO;
    }
}