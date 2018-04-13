package controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.Display;

import java.nio.file.DirectoryStream;

public class GameOverController extends MainController{

    @Override
    public void openMainMenuScene(ActionEvent actionEvent) {
        System.out.println("hey");
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        try {
          primaryStage.setScene(MainController.getInstance().getMainMenuScene());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
