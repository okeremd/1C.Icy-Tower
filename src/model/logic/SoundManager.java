package model.logic;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.media.AudioClip;

public class SoundManager {

	private int volume;
	private int current;
	private Slider volumeslider;
	private ComboBox<String> musichoice;
	view.GameFrame gameframe;

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

	private void volumeSlider() {

		volumeslider = new Slider();
		volumeslider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				int newvolume = new_val.intValue();
				volumeslider.setValue(newvolume);
				gameframe.mediaplayer.setVolume(newvolume);

			}
		});
	}
	public int getVolume(){
		return volume;
	}

}