package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class Wall extends GameObject {

    public Wall() {
        Image[] images = new Image[1]; // wall has 1 image
        images[0] = new Image(Paths.get("./images/gameObject/wall.png").toUri().toString());
        super.setImages(images);
    }
}