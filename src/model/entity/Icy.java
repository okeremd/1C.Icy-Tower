package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class Icy extends Bar {

	private double slipperiness;
	private final int IMAGE_NUM = 3;

	public Icy(){
	    Image[] images = new Image[IMAGE_NUM];
	    images[0] = new Image(Paths.get("./images/gameObject/bar_l1.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m1.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r1.png").toUri().toString());
        super.setImages(images);
    }

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
        return IMAGE_NUM;
    }
}