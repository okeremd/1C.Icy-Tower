package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;


public class HighScoreFrame extends Application{

    private Image backgroundImage;

    public void start(Stage primaryStage) throws Exception {

        backgroundImage = new Image(Paths.get("images/background/backgrounds.png").toUri().toString(),true);

        //primaryStage.setFullScreen(true);
        setStageUnResizable(primaryStage);

        Button backToSettingsButton = new Button("Back to Menu");

        backToSettingsButton.setTranslateX(160);
        backToSettingsButton.setTranslateY(200);

        TableView table = new TableView();
        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Name");
        TableColumn scoreCol = new TableColumn("Score");

        table.getColumns().addAll(nameCol,scoreCol);

        table.setMaxHeight(250);
        table.setMaxWidth(200);



        Text settings = new Text("High Scores");

        settings.setFont(Font.font("Credits", FontWeight.BOLD, 60));

        settings.setTranslateX(20);
        settings.setTranslateY(-170);

        StackPane pane = new StackPane();
        pane.setMinHeight(800);
        pane.setMinWidth(600);
        pane.setLayoutX(10);

        pane.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(800,600, true, true, true, true))));

        pane.getChildren().addAll(settings,backToSettingsButton,table);

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
