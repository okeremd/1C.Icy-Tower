package model.logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    private final String PATH = "~/";
	private final int NUMBER_OF_CHARACTERS = 5;
	private final int IMGS_OF_ONE_CHARACTER = 20;
	private final int NUM_AUDIOS = 3;
    private final int NUM_GAME_IMAGES = 33;

	public Image[] ReadCharacterPreviews(){
		Image[] images = new Image[NUMBER_OF_CHARACTERS];
		for(int i = 0; i < NUMBER_OF_CHARACTERS ; i++){
			images[i] = (new Image(Paths.get(PATH + "/images/prev" + i + ".png").toUri().toString()));
		}
		return images;
	}
	
	public Image[] ReadOneCharacter(int index) {
		Image[] images = new Image[IMGS_OF_ONE_CHARACTER];
		for(int i = 0; i < IMGS_OF_ONE_CHARACTER; i++){
		    images[i] = new Image(Paths.get(PATH + "/images/character" + index + "_" + i + ".png").toUri().toString());
        }
        return images;
	}

	public AudioClip[] ReadMusics() {
		AudioClip[] audioClips = new AudioClip[NUM_AUDIOS];
		for(int i = 0; i < NUM_AUDIOS; i++){
		    audioClips[i] = new AudioClip(Paths.get(PATH + "/sounds/audio" + i + ".wav").toUri().toString());
        }
        return audioClips;
	}

	public Image[] ReadGameImages(){
	    Image[] images = new Image[NUM_GAME_IMAGES];
	    for(int i = 0; i < NUM_GAME_IMAGES; i++){
	        images[i] = new Image(Paths.get(PATH + "gameImage" + i + ".png").toUri().toString());
        }
	    return images;
    }
}

