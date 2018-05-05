package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * Barextender bonus which increase the length of the bars for a while when it is collected
 */
public class BarExtender extends Collectible {

    /**
     * Constructor for Collectible item BarExtender
     */
    public BarExtender(){

        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/barextender.png").toUri().toString());
        super.setImages(images);

    }
}
