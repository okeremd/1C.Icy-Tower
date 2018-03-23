package view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SoundSettingsController extends MainController {

    public void backToSettings(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainController.getInstance().getSettingsScene());
    }
}
