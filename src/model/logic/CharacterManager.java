package model.logic;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class CharacterManager{

	private Image[] CharacterPrevs;
	private Image[] current;
	private final int CHARACTER_NUMBER = 1;
	private final int CHARACTER_IMAGE_NUM = 4;
	private static CharacterManager characterManager;

    public CharacterManager() {
        current = new Image[CHARACTER_IMAGE_NUM];
        CharacterPrevs = new Image[CHARACTER_NUMBER];
        setCharacterImages(1);
    }

    public static CharacterManager getInstance(){
        if(characterManager== null)
            characterManager = new CharacterManager();
        return characterManager;
    }

    public Image[] getCharacterPrevs() {
        return CharacterPrevs;
    }

    public Image[] getCharacterImages() {
        return current;
    }

    public void setCharacterImages(int characterNo) {
        for(int i = 0; i < CHARACTER_IMAGE_NUM - 1; i++){
            current[i] = new Image(Paths.get(("./images/mainCharacter/character" + characterNo + "_" + (i) + ".gif")).toUri().toString());
        }
        current[CHARACTER_IMAGE_NUM - 1] = new Image(Paths.get(("./images/mainCharacter/character" + characterNo+ "_3.png")).toUri().toString());
    }
}