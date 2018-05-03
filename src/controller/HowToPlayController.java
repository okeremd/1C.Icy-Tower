package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Controller for How to Play menu
 */
public class HowToPlayController extends MainController {

    @FXML
    private TextArea HowToPlayText;

    @FXML
    /**
     * Prohibits the how to play text to be changed
     */
    public void initialize() {
        HowToPlayText.setEditable(false);
    }
}
