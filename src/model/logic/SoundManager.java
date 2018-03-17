package model.logic;

import javafx.scene.media.AudioClip;

public class SoundManager {

	private int volume;
	private AudioClip[] musics;
	private int current;


	/**
	 * 
	 * @param musics
	 */
	public void setMusics(AudioClip[] musics) {
		this.musics = musics;
	}

	/**
	 * 
	 * @param index
	 */
	public void setCurrent(int index) {
		// TODO - implement SoundManager.setCurrent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param volume
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

}