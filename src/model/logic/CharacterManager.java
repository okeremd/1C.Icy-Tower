package model.logic;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class CharacterManager{

	private Image[] current;
	private final int CHARACTER_IMAGE_NUM = 7;
	private static CharacterManager characterManager;

    public CharacterManager() {
        current = new Image[CHARACTER_IMAGE_NUM];
        setCharacterImages(1);
    }

    public static CharacterManager getInstance(){
        if(characterManager== null)
            characterManager = new CharacterManager();
        return characterManager;
    }

    public Image[] getCharacterImages() {
        return current;
    }

    public void setCharacterImages(int characterNo) {
        for(int i = 0; i < CHARACTER_IMAGE_NUM - 3; i++){
            current[i] = new Image(Paths.get(("./images/character_images/character" + characterNo + "_" + (i) + ".gif")).toUri().toString());
        }
        for (int i = 3; i<6; i++)
            current[i] = new Image(Paths.get(("./images/character_images/character" + characterNo+ "_" + i + ".png")).toUri().toString());

        current[6] = new Image(Paths.get(("./images/character_images/character" + characterNo+ "_6.gif")).toUri().toString());

    }
}