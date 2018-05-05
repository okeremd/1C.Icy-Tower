package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * Sticky bar which makes the character moves harder
 */
public class Sticky extends Bar {

    /**
     * The stickines decreases the acceleration of the character
     */
	private double stickyness;
	private final int IMAGE_NUM = 3;

	public Sticky(){
	    super();
        Image[] images = new Image[IMAGE_NUM];
        images[0] = new Image(Paths.get("./images/gameObject/bar_l1.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m1.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r1.png").toUri().toString());
        super.setImages(images);
        stickyness = 0.7;
    }

    public Sticky(Image[] images) {
        super(images);
    }

    @Override
    public void move() {
	    FallingBehaviour FallingBehaviour = new FallingBehaviour();
	    FallingBehaviour.react(this);
        }

    public double getStickyness() {
        return stickyness;
    }

    public void setStickyness(double stickyness) {
        this.stickyness = stickyness;
    }


}