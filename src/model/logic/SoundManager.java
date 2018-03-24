package model.logic;


import javafx.scene.media.Media;

import java.nio.file.Paths;
import java.util.ArrayList;

public class SoundManager {
    private int currentsong;
    private int currentvolume;
    private ArrayList<Media> sounds;
    private final int SOUND_NO = 2;

    public SoundManager(){
        sounds = new ArrayList<>();
    }

    public ArrayList<Media> getSounds() {
        for(int no = 0; no < SOUND_NO; no++){
            sounds.add(new Media(Paths.get("music/audio" + no + ".mp3").toUri().toString()));
        }
        return sounds;
    }

}