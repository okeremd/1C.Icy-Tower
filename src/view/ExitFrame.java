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

public class ExitFrame{

        public void ExitFrame(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Icy Tower");


            VBox exitlayout = new VBox(20);
            Button yesbutton = new Button("Yes");
            yesbutton.setMinSize(70, 50);
            yesbutton.setTranslateX(190);
            yesbutton.setTranslateY(290);
            Button nobutton = new Button("No");
            nobutton.setMinSize(70, 50);
            nobutton.setTranslateX(280);
            nobutton.setTranslateY(290);
            Text text = new Text("Do you want exit?");
            text.setTranslateX(228);
            text.setTranslateY(230);
            text.setFont(Font.font("Do you want exit?", FontWeight.BOLD, 30));


            StackPane pane = new StackPane();
            Image image = new Image(Paths.get("images/background/icon.png").toUri().toString(),true);
            ImageView img = new ImageView();
            img.setImage(image);
            img.setFitWidth(200);
            img.setFitHeight(180);
            img.setTranslateX(235);
            img.setTranslateY(100);
            pane.getChildren().addAll(text, yesbutton, nobutton);
            pane.getChildren().add(exitlayout);
            pane.getChildren().add(img);
            pane.setAlignment(Pos.CENTER);

            Image exitimage = new Image(Paths.get("images/background/backgrounds.png").toUri().toString(),true);
            Pane bigpane = new Pane();
            bigpane.getChildren().add(pane);
            Scene scene = new Scene(bigpane,700, 500);
            bigpane.setBackground(new Background(new BackgroundImage(exitimage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(scene.getWidth(), scene.getHeight(), true, true, true, true))));


            primaryStage.setScene(scene);
            primaryStage.show();


        }
    }


