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
	private Scanner sc;
	private File file;

	public Image[] ReadCharacterPreviews() throws FileNotFoundException{
		
		Image[] images = new Image[NUMBER_OF_CHARACTERS];
		for(int i = 0; i < NUMBER_OF_CHARACTERS ; i++){
			images[i] = (new Image(Paths.get(PATH + "src/prev" + i).toUri().toString()));
		}
		return images;
	}

	/**
	 * 
	 * @param index
	 */
	public Image[] ReadOneCharacter(int index) {
		// TODO - implement FileManager.ReadOneCharacter
		throw new UnsupportedOperationException();
	}

	public AudioClip[] ReadMusics() {
		// TODO - implement FileManager.ReadMusics
		throw new UnsupportedOperationException();
	}

}