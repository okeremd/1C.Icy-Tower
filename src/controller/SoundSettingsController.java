package controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import model.logic.SoundManager;
import java.util.ArrayList;

public class SoundSettingsController extends SettingsController  {

    public static final double SLIDERLIMIT = 200.0;
    @FXML
    private ChoiceBox<FXCollections> selectSongBox;  //choicebox for list of songs
    @FXML
    private Slider soundSlider;  //volume slider

    /**
     * Default constructor for SoundSetingsController
     */
    public SoundSettingsController(){

    }

    @FXML
    /**
     * Initializes the volume on the slider
     */
    public void initialize() {
        soundSlider.valueProperty().addListener((ov, old_val, new_val) -> {

            int newvolume = new_val.intValue();
            double volumeNormalized = newvolume/ SLIDERLIMIT;
            SoundManager.getInstance().setVolume(volumeNormalized);
        });
    }

    /**
     * According to user's choice, it sends the selected song to SoundManager
     */
    public void changeSelectedSong(ActionEvent actionEvent){

        int selectedSong = selectSongBox.getSelectionModel().getSelectedIndex();
        SoundManager.getInstance().setSong(selectedSong);
    }


}
