package model.logic;

import javafx.scene.input.KeyCode;

public class ButtonManager {

	private KeyCode[] Buttons;
	private final int BUTTONPAGE_BUTTON_NO = 2;

	/**
	 * 
	 * @param keys
	 */
	public void setButtons(KeyCode[] keys) {
		Buttons = keys;
	}

	public KeyCode[] getButtons() {
		return Buttons;
	}

}