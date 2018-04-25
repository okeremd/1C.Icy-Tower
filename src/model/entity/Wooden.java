package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class Wooden extends Bar {

    private double breaktime;
    private final int IMAGE_NUM = 3;

    public Wooden(){
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
    public void remove() {

    }


    public double getBreaktime() {
        return breaktime;
    }

    public void setBreaktime(double breaktime) {
        this.breaktime = breaktime;
    }

    public int getIMAGE_NUM() {
        return IMAGE_NUM;
    }

}