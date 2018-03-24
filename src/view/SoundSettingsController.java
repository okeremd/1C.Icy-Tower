package view;

import javafx.beans.value.ChangeListener ;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    //private ArrayList<Media> songsmedia;

    public SoundSettingsController(){
        
    }
    //combo box
    public void musicChoices() {
        musichoice = new ComboBox<String>();
        musichoice.getItems().addAll("Song1","Song2", "Song3");
        musichoice.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setMusic(newValue);
            }
        });
    }
    private void setMusic(String song) {
        if(song.equals("Song 1"))
            gameframe.setSong("audio0");
        else if (song.equals("Song 2"))
            gameframe.setSong("audio1");
        else
            gameframe.setSong("audio2");
    }

    public void volumeSlider() {

        vslider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int newvolume = newValue.intValue();
            vslider.setValue(newvolume);
            GameFrame.mediaplayer.setVolume(newvolume);});
        /*vslider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                int newvolume = new_val.intValue();
                vslider.setValue(newvolume);
                view.GameFrame.mediaplayer.setVolume(newvolume);

            }
        });*/
    }



}
