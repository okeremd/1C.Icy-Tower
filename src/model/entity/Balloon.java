package model.entity;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * Balloon bonus which makes the character to go up easily for a while when it is collected
 */
public class Balloon extends Collectible {


    private  double velocity; //Holds the vertical velocity of the balloon
    private int startingAltitude; //Holds the initial altitude of the balloon
    private Boolean touched; //Determines whether the character has touched the balloon yet

    /**
     * Constructor for Collectible item Balloon
     */
    public Balloon(){
        touched = false;
        startingAltitude = 0;
        velocity = 5;
        Image[] images = new Image[1];
        images[0] = new Image(Paths.get("./images/bonus/balloon.png").toUri().toString());
        super.setImages(images);
    }

    /**
     *
     * @return
     */
    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     * collects the altitude when balloon collected
     * @param startingAltitude
     */
    public void setStartingAltitude(int startingAltitude){
        this.startingAltitude = startingAltitude;
    }

    /**
     * checks whether the limited amount of levels were passed with balloon
     * @param altitude the current altitude of the balloon
     * @param betweenBarDistance the average distance between each bar
     * @return returns the when limited amount of levels were passed with balloon
     */
    public boolean isPassed(int altitude, int betweenBarDistance){
        return (altitude - startingAltitude)/betweenBarDistance > 10;
    }

    public Boolean isTouched(){
        return touched;
    }

    public void setTouched(){
        touched = true;
    }
}
