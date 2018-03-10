import javafx.scene.image.Image;

public class Wooden extends Bar {

    private double breaktime;
    private final int IMAGE_NO = 1;


    public Wooden(Image[] images) {
        super(images);
    }


    public double getBreaktime() {
        return breaktime;
    }

    public void setBreaktime(double breaktime) {
        this.breaktime = breaktime;
    }

    public int getIMAGE_NO() {
        return IMAGE_NO;
    }
}