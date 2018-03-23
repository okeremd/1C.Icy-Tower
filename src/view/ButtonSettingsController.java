package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ButtonSettingsController extends SettingsController {

    @FXML
    private TextArea ButtonText;

    @FXML
    public void initialize(){
        ButtonText.setEditable(false);
    }
}
