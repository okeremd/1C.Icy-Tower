package view;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javax.swing.*;
import java.nio.file.Paths;

public class DisplayFrame extends Application {

	private final int FRAME_HEIGHT = 700;
	private final int FRAME_WIDTH = 500;
	private JFXPanel Layout;
	JFrame frame;

	Stage stage;
	Scene menuscene, creditscene, howtoscene, scorescene;

	public static void main(String[] args) {
		launch(args);
	}

	public DisplayFrame() {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Icy Tower");

		//MenuLayout
		VBox menulayout = new VBox(10);
		Button playbutton = new Button("Play Game");
		playbutton.setMinSize(80,50);
		Button scorebutton = new Button("High Scores");
        scorebutton.setMinSize(80,50);
		Button howtobutton = new Button("How to Play");
        howtobutton.setMinSize(80,50);
		Button settingsbutton = new Button("Settings");
        settingsbutton.setMinSize(80,50);
		Button creditsbutton = new Button("Credits");
        creditsbutton.setMinSize(80,50);
		Button exitbutton = new Button("Exit");
        exitbutton.setMinSize(80,50);
//		menulayout.getChildren().addAll(playbutton,scorebutton,howtobutton,settingsbutton,creditsbutton,exitbutton);
//		menulayout.setAlignment(Pos.CENTER);

		GridPane pane = new GridPane();
		Image menuimage = new Image(Paths.get("images/background/menu.jpg").toUri().toString(),true);

		//ImageView view1 = new ImageView(menuimage);
		//pane.getChildren().add(view1);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.add(playbutton, 0, 0);
        pane.add(scorebutton, 0, 1);
        pane.add(howtobutton, 0, 2);
        pane.add(settingsbutton, 1, 0);
        pane.add(creditsbutton, 1, 1);
        pane.add(exitbutton, 1, 2);
        Pane bigpane = new Pane();
        bigpane.getChildren().add(pane);
        Scene scene = new Scene(bigpane, FRAME_HEIGHT, FRAME_WIDTH);
        bigpane.setBackground(new Background(new BackgroundImage(menuimage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(scene.getWidth(), scene.getHeight(), true, true, true, true))));
        pane.setLayoutX(scene.getWidth() - 200);
        pane.setLayoutY(scene.getHeight() - 300);
        primaryStage.setScene(scene);
		primaryStage.show();



	}
	/**
	 * 
	 * @param buttonCount
	 */
	public DisplayFrame(int buttonCount) {
		// TODO - implement DisplayFrame.DisplayFrame
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param layout
	 */
	public void setDisplayLayout(JFXPanel layout) {
		// TODO - implement DisplayFrame.setDisplayLayout

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param buttonId
	 * @param posX
	 * @param posY
	 */
	public void setButtonPos(int buttonId, int posX, int posY) {
		// TODO - implement DisplayFrame.setButtonPos
		throw new UnsupportedOperationException();
	}

	public void getSettingsData() {
		// TODO - implement DisplayFrame.getSettingsData
		throw new UnsupportedOperationException();
	}

	public void getCharacterData() {
		// TODO - implement DisplayFrame.getCharacterData
		throw new UnsupportedOperationException();
	}

	public void getSoundData() {
		// TODO - implement DisplayFrame.getSoundData
		throw new UnsupportedOperationException();
	}

	public void getButtonData() {
		// TODO - implement DisplayFrame.getButtonData
		throw new UnsupportedOperationException();
	}

}