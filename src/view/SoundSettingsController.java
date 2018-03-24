package view;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import model.logic.SoundManager;

import java.util.ArrayList;

public class SoundSettingsController extends SettingsController  {
    private int volume;
    private int current;
    private ComboBox<String> musichoice;
    view.GameFrame gameframe;
    @FXML
    private Slider soundSlider;

    SoundManager sounds;
    private ArrayList<Media> songsmedia;

    public SoundSettingsController(){

    }
    //combo box
    public void musicChoices() {
        musichoice = new ComboBox<String>();
        musichoice.getItems().addAll("Song1","Song2", "Song3");
        musichoice.valueProperty().addListener((observable, oldValue, newValue) -> setMusic(newValue));
    }
    private void setMusic(String song) {

    }


    public void initialize() {
        soundSlider.valueProperty().addListener((ov, old_val, new_val) -> {

            int newvolume = new_val.intValue();
            double volumeNormalized = newvolume/200.0;
            SoundManager.getInstance().setVolume(volumeNormalized);
        });
    }



}
