package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import model.logic.CharacterManager;

import java.nio.file.Paths;

public class CharacterSettingsController extends SettingsController {

    @FXML Button ch1;
    @FXML Button ch2;
    @FXML Button ch3;
    private Image[] chr1;
    private Image[] chr2;
    private Image[] chr3;

    @FXML
    public void initialize(){

        chr1 = new Image[1];
        chr2 = new Image[1];
        chr3 = new Image[1];

        chr1[0] = new Image(Paths.get(("./images/mainCharacter/mainCharacter1.PNG")).toUri().toString());
        chr2[0] = new Image(Paths.get(("./images/mainCharacter/mainCharacter1.PNG")).toUri().toString());
        chr3[0] = new Image(Paths.get(("./images/mainCharacter/character2.PNG")).toUri().toString());

        ch1.setOnAction(event -> CharacterManager.getInstance().setCurrent(chr1));
        ch2.setOnAction(event -> CharacterManager.getInstance().setCurrent(chr2));
        ch3.setOnAction(event -> CharacterManager.getInstance().setCurrent(chr3));
    }
}
