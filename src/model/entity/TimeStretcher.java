package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class TimeStretcher extends Collectible {

    private final double STRETCH_RATE = 1.5; //game screen speed will be slower with the rate of 1.5

    /**
     * Constructor for Collectible item TimeStretcher
     */
    public TimeStretcher(){

        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/timestrechter.png").toUri().toString());
        super.setImages(images);
    }
}
