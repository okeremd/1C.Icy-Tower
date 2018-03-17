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

public class HowToPlayFrame {
    Button backbutton;

    public HowToPlayFrame(Stage primaryStage)throws Exception {
        primaryStage.setTitle("Icy Tower");


        VBox howtolayout = new VBox(20);
        backbutton = new Button("Back to Menu");
        backbutton.setMinSize(30, 30);
        backbutton.setTranslateX(450);
        backbutton.setTranslateY(320);
        Text text = new Text("How to play");
        text.setTranslateX(230);
        text.setTranslateY(-10);
        text.setFont(Font.font("How To Play", FontWeight.BOLD, 40));
        Text rules = new Text("Jump to the bars without falling down to the space!!\n" +
                "Hit the wall and jump at the same time\n" +
                "you'll go higher!!\n" +
                "You must be fast!! unless you'll die!!\n" +
                "If you saw a balloon, go and take it\n " +
                "you'll go up easily!!\n" +
                "If you saw a bomb, run away!!It will try to kill you\n" +
                "For control,check out the button settings\n" +
                "You can change the music and character too\n" +
                "go and check the settings !!\n" +
                "If you're in top ten, it asks your name for recording. \n" +
                "Type a name and see your sorting \n" +
                "Good Luck!!");
        rules.setTranslateX(200);
        rules.setTranslateY(150);
        rules.setFont(new Font(15));

        GridPane pane = new GridPane();
        Image image = new Image(Paths.get("images/background/icon.png").toUri().toString(), true);
        ImageView img = new ImageView();
        img.setImage(image);
        img.setFitWidth(60);
        img.setFitHeight(50);
        img.setTranslateX(475);
        img.setTranslateY(-5);
        pane.setHgap(10);
        pane.setVgap(10);
        //pane.add(backbutton, 300, 300);
        pane.getChildren().addAll(text,rules,backbutton);
        pane.getChildren().add(howtolayout);
        pane.getChildren().add(img);
        pane.setAlignment(Pos.CENTER);

        Image howtoimage = new Image(Paths.get("images/background/backgrounds.png").toUri().toString(), true);
        Pane bigpane = new Pane();
        bigpane.getChildren().add(pane);
        Scene scene = new Scene(bigpane, 700, 500);
        bigpane.setBackground(new Background(new BackgroundImage(howtoimage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(scene.getWidth(), scene.getHeight(), true, true, true, true))));


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Button getBackbutton() {
        return backbutton;
    }
}