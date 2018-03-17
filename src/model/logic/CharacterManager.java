package model.logic;

import javafx.scene.image.Image;

public class CharacterManager{

	private Image[] CharacterPrevs;
	private Image[] current;
	private int CHARPAGE_BUTTON_NO;

    public CharacterManager() {
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