package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Coin extends Collectible {

    private final int VALUE=20;

    public Coin(){
        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/coin.png").toUri().toString());
        super.setImages(images);
    }
}
