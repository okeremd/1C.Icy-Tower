package model.logic;

import javafx.scene.input.KeyCode;

public class ButtonManager {

	private KeyCode[] buttons;
	private static ButtonManager buttonManager;

	public ButtonManager(){
		buttons = new KeyCode[4];

	}
	public static ButtonManager getInstance(){
		if(buttonManager== null)
			buttonManager = new ButtonManager();
		return buttonManager;

	}
	public void setButtons(KeyCode[] keys) {
		buttons = keys;
	}

	public KeyCode[] getButtons() {

		return buttons;
	}

}