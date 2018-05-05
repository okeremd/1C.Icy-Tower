package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import model.logic.ButtonManager;

/**
 * The controller for the Button Settings Menu.
 * User can change the button configurations for the game.
 */
public class ButtonSettingsController extends SettingsController {

    @FXML
    private TextArea ButtonText;
    @FXML Button arrows;
    @FXML Button awd;
    KeyCode[] buttonset1;
    KeyCode[] buttonset2;

    @FXML
    /**
     * According to the user's choice, it sends the control keys to the ButtonManager
     */
    public void initialize(){

        buttonset1 = new KeyCode[4];
        buttonset1[0] = KeyCode.LEFT;
        buttonset1[1] = KeyCode.RIGHT;
        buttonset1[2] = KeyCode.SPACE;
        buttonset1[3] = KeyCode.P;

        buttonset2 = new KeyCode[4];
        buttonset2[0] = KeyCode.A;
        buttonset2[1] = KeyCode.D;
        buttonset2[2] = KeyCode.W;
        buttonset2[3] = KeyCode.P;

        ButtonText.setEditable(false);
        arrows.setOnAction(event -> ButtonManager.getInstance().setButtons(buttonset1));
        awd.setOnAction(event -> ButtonManager.getInstance().setButtons(buttonset2));
    }
}
