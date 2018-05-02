package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class Base extends Bar{
    private final int IMAGE_NUM = 3;
    private Image[] images = new Image[IMAGE_NUM];
    private int width = 50;
    public Base(){
        images[0] = new Image(Paths.get("./images/gameObject/bar_l1.png").toUri().toString());
        images[1] = new Image(Paths.get("./images/gameObject/bar_m1.png").toUri().toString());
        images[2] = new Image(Paths.get("./images/gameObject/bar_r1.png").toUri().toString());
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void move() {
       StandingBehaviour standingBehaviour = new StandingBehaviour();
       standingBehaviour.react(this);
    }
}