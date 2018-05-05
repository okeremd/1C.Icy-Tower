package model.logic;


import javafx.scene.media.Media;

import java.nio.file.Paths;
import java.util.ArrayList;

public class SoundManager {
    public static final double DEFAULT_VOLUME = 0.5;
    private int currentsong;
    private double currentvolume;
    private ArrayList<Media> sounds;
    private final int SOUND_NO = 3;

    private static SoundManager soundManager;

    /**
     * Constructor for SoundManager, loads the mp3 files for songs, and sets the default volume.
     */
    private SoundManager() {
        sounds = new ArrayList<>();
        for (int no = 0; no < SOUND_NO; no++) {
            sounds.add(new Media(Paths.get("music/audio" + no + ".mp3").toUri().toString()));
        }
        currentvolume = DEFAULT_VOLUME;
    }

    /**
     * Singleton SoundManager object
     * @return this
     */
    public static SoundManager getInstance() {
        if (soundManager == null) {
            soundManager = new SoundManager();
        }
        return soundManager;
    }

    public ArrayList<Media> getSounds() {

        return sounds;
    }

    public void setVolume(double volume) {

        currentvolume = volume;
    }

    public Media getSelectedSong() {
        return sounds.get(currentsong);
    }

    public double getVolume() {
        return currentvolume;
    }

    public void setSong(int song) {
        currentsong = song;
    }

    public int getSong(){
        return currentsong;
    }

}