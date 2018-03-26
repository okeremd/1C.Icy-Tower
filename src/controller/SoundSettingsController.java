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
    private ChoiceBox<FXCollections> selectSongBox;

    @FXML
    private Slider soundSlider;

    SoundManager sounds;
    private ArrayList<Media> songsmedia;

    public SoundSettingsController(){

    }

    @FXML
    public void initialize() {
        soundSlider.valueProperty().addListener((ov, old_val, new_val) -> {

            int newvolume = new_val.intValue();
            double volumeNormalized = newvolume/ SLIDERLIMIT;
            SoundManager.getInstance().setVolume(volumeNormalized);
        });
    }

    public void changeSelectedSong(ActionEvent actionEvent){

        int selectedSong = selectSongBox.getSelectionModel().getSelectedIndex();
        System.out.println(selectedSong);
        SoundManager.getInstance().setSong(selectedSong);
    }


}
