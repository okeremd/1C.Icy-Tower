package model.entity;

import javafx.scene.image.Image;

public class HardlyVisible extends Bar {

	private double opacity;
	private final int IMAGE_NO = 2;

	public HardlyVisible(){}

    public HardlyVisible(Image[] images) {
        super(images);
    }

    @Override
    public void remove() {

    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public int getIMAGE_NO() {
        return IMAGE_NO;
    }

}