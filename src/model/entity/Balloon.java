package model.entity;

import javafx.scene.image.Image;
import java.nio.file.Paths;

public class Balloon extends Collectible {

    /**
     * Constructor for Collectible item Balloon
     */
    public Balloon(){

        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/balloon.png").toUri().toString());
        super.setImages(images);
    }
}
