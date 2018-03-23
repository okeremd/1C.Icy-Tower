package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HowToPlayController extends MainController {

    @FXML
    private TextArea HowToPlayText;

    @FXML
    public void initialize() {
        HowToPlayText.setEditable(false);
    }
}
