package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.nio.file.Paths;


public class GameFrame {

    private static ImageView gameCharacter;
    private ImageView bar;
    private ImageView wall;

    public static Scene getScene() {

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 800, 600);

        anchorPane.setStyle("-fx-background-color: #b0e0ff");

        gameCharacter = new ImageView(
                new Image(Paths.get("images/mainCharacter/mainCharacter1.PNG").
                toUri().toString()));

        setGameCharacterProperties();

        anchorPane.getChildren().add(gameCharacter);

        return scene;
    }

    private static void setGameCharacterProperties() {
        gameCharacter.setLayoutX(400);
        gameCharacter.setLayoutY(500);
        gameCharacter.setFitHeight(80);
        gameCharacter.setFitWidth(50);
    }
}
