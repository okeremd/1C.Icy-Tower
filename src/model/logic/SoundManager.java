package model.logic;

import javafx.scene.media.AudioClip;

public class SoundManager {

	private int volume;
	private AudioClip[] musics;

	/**
	 * 
	 * @param musics
	 */
	public void setMusics(javafx.scene.media.AudioClip[] musics) {
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