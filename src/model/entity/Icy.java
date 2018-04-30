package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class Icy extends Bar {

	private double slipperiness;
	private final int IMAGE_NUM = 3;

	public Icy(){
	    Image[] images = new Image[IMAGE_NUM];
	    images[0] = new Image(Paths.get("./images/gameObject/bar_l3.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m3.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r3.png").toUri().toString());
        super.setImages(images);
        slipperiness = 1.3;
    }

    public Icy(Image[] images) {
        super(images);
    }

    @Override
    public void remove() {
        FallingBehaviour FallingBehaviour = new FallingBehaviour();
        FallingBehaviour.react(this);
    }

    public double getSlipperiness() {
        return slipperiness;
    }

    public void setSlipperiness(double slipperiness) {
        this.slipperiness = slipperiness;
    }

    public int getIMAGE_NO() {
        return IMAGE_NUM;
    }

}