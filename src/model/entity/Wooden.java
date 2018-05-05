package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * Wooden type of bar with no special feature
 */
public class Wooden extends Bar {

    private final int IMAGE_NUM = 3;

    public Wooden(){
        super();
        Image[] images = new Image[IMAGE_NUM];
        images[0] = new Image(Paths.get("./images/gameObject/bar_l2.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m2.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r2.png").toUri().toString());
        super.setImages(images);
    }

    public Wooden(Image[] images) {
        super(images);
    }

    @Override
    /**
     * Wooden bar has the sliding behaviour. After a while, it starts to move right
     */
    public void move() {
        SlidingBehaviour breakable = new SlidingBehaviour();
        breakable.react(this);
    }


}