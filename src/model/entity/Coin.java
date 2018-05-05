package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Coin bonus which increase the score when it is collected
 */
public class Coin extends Collectible {

    private final int VALUE=60;   //value of the coin is 60 points

    /**
     * Constructor for Collectible item Coin
     */
    public Coin(){
        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/coin.png").toUri().toString());
        super.setImages(images);
    }

    public int getVALUE() {
        return VALUE;
    }
}
