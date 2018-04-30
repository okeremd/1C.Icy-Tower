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
    private KeyCode[] b1;
    private KeyCode[] b2;


    @FXML
    public void initialize(){

        KeyCode[] b1 = new KeyCode[4];
        b1[0] = KeyCode.LEFT;
        b1[1] = KeyCode.RIGHT;
        b1[2] = KeyCode.SPACE;
        b1[3] = KeyCode.P;

        KeyCode[] b2 = new KeyCode[4];
        b2[0] = KeyCode.A;
        b2[1] = KeyCode.D;
        b2[2] = KeyCode.W;
        b2[3] = KeyCode.P;

        ButtonText.setEditable(false);
        arrows.setOnAction(event -> ButtonManager.getInstance().setButtons(b1));
        awd.setOnAction(event -> ButtonManager.getInstance().setButtons(b2));
    }
}
