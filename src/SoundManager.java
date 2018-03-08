public class SoundManager {

	private int volume;
	private AudioFormat[] musics;

	/**
	 * 
	 * @param musics
	 */
	public void setMusics(AudioFormat[] musics) {
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