package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class Sticky extends Bar {

	private double stickyness;
	private final int IMAGE_NUM = 3;

	public Sticky(){
        Image[] images = new Image[IMAGE_NUM];
        images[0] = new Image(Paths.get("./images/gameObject/bar_l1.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m1.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r1.png").toUri().toString());
        super.setImages(images);
    }

    public Sticky(Image[] images) {
        super(images);
    }

    @Override
    public void remove() {
	    NotBreakable notBreakable = new NotBreakable();
	    notBreakable.react(this);
        }

    public double getStickyness() {
        return stickyness;
    }

    public void setStickyness(double stickyness) {
        this.stickyness = stickyness;
    }

    public int getIMAGE_NUM() {
        return IMAGE_NUM;
    }

}