package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * TimeSqueezzer bonus to increase the game screen speed for a while when it is collected
 */
public class TimeSqueezer extends Collectible {

    /**
     * Constructor for Collectible item TimeSqueezer
     */
    public TimeSqueezer(){
        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/timesqueezer.png").toUri().toString());
        super.setImages(images);
    }
}
