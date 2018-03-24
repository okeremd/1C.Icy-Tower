package model.logic;


import javafx.scene.media.Media;

import java.nio.file.Paths;
import java.util.ArrayList;

public class SoundManager {
    private int currentsong;
    private double currentvolume;
    private ArrayList<Media> sounds;
    private final int SOUND_NO = 2;

    private static SoundManager soundManager;

    private SoundManager(){
        sounds = new ArrayList<>();
        for(int no = 0; no < SOUND_NO; no++){
            sounds.add(new Media(Paths.get("music/audio" + no + ".mp3").toUri().toString()));
        }
        currentvolume = 0.5;
    }

    public static SoundManager getInstance(){
        if(soundManager == null)
        {
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
        return sounds.get(0);
    }

    public double getVolume() {
        return currentvolume;
    }
}