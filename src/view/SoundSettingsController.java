package view;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import model.logic.SoundManager;

import java.util.ArrayList;

public class SoundSettingsController extends SettingsController  {
    private int volume;
    private int current;
    private ComboBox<String> musichoice;
    view.GameFrame gameframe;
    @FXML private Slider vslider;
    SoundManager sounds;
    private ArrayList<Media> songsmedia;

    public SoundSettingsController(){
        sounds = new SoundManager();
        songsmedia = sounds.getSounds();
    }
    //combo box
    public void musicChoices() {
        musichoice = new ComboBox<String>();
        musichoice.getItems().addAll("Song1","Song2", "Song3");
        musichoice.valueProperty().addListener((observable, oldValue, newValue) -> setMusic(newValue));
    }
    private void setMusic(String song) {
        if(song.equals("Song 1"))
            gameframe.setSong("audio0");
        else if (song.equals("Song 2"))
            gameframe.setSong("audio1");
        else
            gameframe.setSong("audio2");
    }


    public void initialize() {
        vslider.valueProperty().addListener((ov, old_val, new_val) -> {
            int newvolume = new_val.intValue();
            vslider.setValue(newvolume);
            view.GameFrame.mediaplayer.setVolume(newvolume);

        });
    }



}
