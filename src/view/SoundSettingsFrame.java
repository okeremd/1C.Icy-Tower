package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.nio.file.Paths;


public class SoundSettingsFrame extends Application{

    private Image backgroundImage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        backgroundImage = new Image(Paths.get("images/background/backgrounds.png").toUri().toString(),true);

        //primaryStage.setFullScreen(true);
        setStageUnResizable(primaryStage);

        Button backToSettingsButton = new Button("Back to Settings");

        backToSettingsButton.setTranslateX(330);
        backToSettingsButton.setTranslateY(250);

        final ComboBox songBox = new ComboBox();
        songBox.getItems().addAll(
                "Song 1",
                "Song 2",
                "Song 3",
                "Song 4",
                "Song 5"
        );
        songBox.setTranslateX(30);
        songBox.setTranslateY(-120);

        Text settings = new Text("Sound Settings");

        settings.setFont(new Font(40));


        Text songs = new Text ("Songs");

        songs.setFont(new Font(30));

        Text volume = new Text("Volume");
        volume.setFont(new Font(30));
        volume.setTranslateY(-50);
        volume.setTranslateX(-120);

        songs.setTranslateX(-120);
        songs.setTranslateY(-120);

        Slider slider = new Slider();

        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(70);
        slider.setMaxWidth(200);

        slider.setTranslateX(60);
        slider.setTranslateY(-50);

        settings.setTranslateX(30);
        settings.setTranslateY(-200);

        StackPane pane = new StackPane();
        pane.setMinHeight(800);
        pane.setMinWidth(600);
        pane.setLayoutX(10);

        pane.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(800,600, true, true, true, true))));

        pane.getChildren().addAll(slider,settings,songBox,songs,volume,backToSettingsButton);

        Scene scene = new Scene(pane, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setStageUnResizable(Stage primaryStage) {
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
