package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * Hardly Visible bar which is hardly seen because of its opacity
 */
public class HardlyVisible extends Bar {


	private final int IMAGE_NUM = 3;

    /**
     * Constructor for the HardyVisible bar
     */
	public HardlyVisible(){
	    super();
        Image[] images = new Image[IMAGE_NUM];
        images[0] = new Image(Paths.get("./images/gameObject/bar_l1.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m1.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r1.png").toUri().toString());
        super.setImages(images);
    }

    /**
     * It has falling behaviour. After a while hardyvisible bars will fall down
     */
    @Override
    public void move() {
        FallingBehaviour FallingBehaviour = new FallingBehaviour();
        FallingBehaviour.react(this);
    }

}