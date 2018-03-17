import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    private final String PATH = "~/";
	private final int NUMBER_OF_CHARS = 5;
	private Scanner sc;
	private File file;

	public Image[] ReadCharacterPreviews() throws FileNotFoundException{
		// TODO - implement FileManager.ReadCharacterPreviews
		Image[] ims = new Image[NUMBER_OF_CHARS];
		for(int i = 0; i < NUMBER_OF_CHARS ; i++){
			ims[i] = (new Image(Paths.get(PATH + "src/prev" + i).toUri().toString()));
		}
		return ims;
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