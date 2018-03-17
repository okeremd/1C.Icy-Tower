package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class CharacterSettingsFrame{

    Button select1, select2;

    public CharacterSettingsFrame(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Icy Tower");


        VBox characterlayout = new VBox(40);
        select1 = new Button("Select");
        select1.setMinSize(70, 50);
        select1.setTranslateX(200);
        select1.setTranslateY(200);
        select2 = new Button("Select");
        select2.setMinSize(70, 50);
        select2.setTranslateX(280);
        select2.setTranslateY(200);
        Text text = new Text("Character Settings");
        text.setTranslateX(228);
        text.setTranslateY(20);
        text.setFont(Font.font("Character Settings", FontWeight.BOLD, 30));


        StackPane pane = new StackPane();
        Image image1 = new Image(Paths.get("images/mainCharacter/character2.PNG").toUri().toString(),true);
        Image image2 = new Image(Paths.get("images/mainCharacter/mainCharacter1.PNG").toUri().toString(),true);
        ImageView img1 = new ImageView();
        img1.setImage(image1);
        img1.setFitWidth(50);
        img1.setFitHeight(120);
        img1.setTranslateX(200);
        img1.setTranslateY(100);
        ImageView img2 = new ImageView();
        img2.setImage(image2);
        img2.setFitWidth(50);
        img2.setFitHeight(120);
        img2.setTranslateX(270);
        img2.setTranslateY(100);
        pane.getChildren().addAll(text, select1, select2);
        pane.getChildren().add(characterlayout);
        pane.getChildren().addAll(img1,img2);
        pane.setAlignment(Pos.CENTER);

        Image exitimage = new Image(Paths.get("images/background/backgrounds.png").toUri().toString(),true);
        Pane bigpane = new Pane();
        bigpane.getChildren().add(pane);
        Scene scene = new Scene(bigpane,700, 500);
        bigpane.setBackground(new Background(new BackgroundImage(exitimage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(scene.getWidth(), scene.getHeight(), true, true, true, true))));


        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public Button getSelect1() {
        return select1;
    }

    public Button getSelect2() {
        return select2;
    }
}
