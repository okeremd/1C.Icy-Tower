package model.logic;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class CharacterManager{

	private Image[] CharacterPrevs;
	private Image[] current;
	private int CHARPAGE_BUTTON_NO;
	private static CharacterManager characterManager;

    public CharacterManager() {
        current = new Image[1];
        current[0] = new Image(Paths.get(("./images/mainCharacter/character1.PNG")).toUri().toString());
    }

    public static CharacterManager getInstance(){
        if(characterManager== null)
            characterManager = new CharacterManager();
        return characterManager;

    }

    public void changeCharacterImageToJumpImage(){
        current[0] = new Image(Paths.get(("./images/mainCharacter/character_jump.PNG")).toUri().toString());
    }

    public void changeCharacterImageToStandingImage(){
        current[0] = new Image(Paths.get(("./images/mainCharacter/character1.PNG")).toUri().toString());
    }

    public Image[] getCharacterPrevs() {
        return CharacterPrevs;
    }

    public void setCharacterPrevs(Image[] characterPrevs) {
        CharacterPrevs = characterPrevs;
    }

    public Image[] getCurrent() {
        return current;
    }

    public void setCurrent(Image[] current) {
        this.current = current;
    }

    public int getCHARPAGE_BUTTON_NO() {
        return CHARPAGE_BUTTON_NO;
    }

    public void setCHARPAGE_BUTTON_NO(int CHARPAGE_BUTTON_NO) {
        this.CHARPAGE_BUTTON_NO = CHARPAGE_BUTTON_NO;
    }
}