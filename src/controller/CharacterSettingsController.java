package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import model.logic.CharacterManager;

import java.nio.file.Paths;

/**
 * Controller for the Character Settings Menu
 */
public class CharacterSettingsController extends SettingsController {

    @FXML Button ch1;
    @FXML Button ch2;
    @FXML Button ch3;
    private Image chr1;
    private Image chr2;
    private Image chr3;

    @FXML
    /**
     * According to the user's choice, it sends the selected image to CharacterManager with its id number
     */
    public void initialize(){

        chr1 = new Image(Paths.get(("./images/mainCharacter/character1_0.gif")).toUri().toString());
        chr2 = new Image(Paths.get(("./images/mainCharacter/character2_0.gif")).toUri().toString());
        chr3 = new Image(Paths.get(("./images/mainCharacter/dance.gif")).toUri().toString());

        ch1.setOnAction(event -> CharacterManager.getInstance().setCharacterImages(1));
        ch2.setOnAction(event -> CharacterManager.getInstance().setCharacterImages(2));
        ch3.setOnAction(event -> CharacterManager.getInstance().setCharacterImages(3));
    }
}
