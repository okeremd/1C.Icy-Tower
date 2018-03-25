package controller;

import controller.MainController;
import javafx.fxml.FXML;

import java.awt.*;

public class ExitController extends MainController {

    @FXML
    private TextField textField;

    public void quitGame(){
    System.exit(0);
    }
}
