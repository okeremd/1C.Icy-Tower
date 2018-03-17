import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javax.swing.*;


public class DisplayFrame {

	private final int FRAME_HEIGHT = 600;
	private final int FRAME_WIDTH = 600;
	private JFXPanel Layout;
	JFrame frame;
	Stage stage;
	Scene menuscene, creditscene, howtoscene, scorescene;

	public DisplayFrame() {

		//CreditsLayout
		VBox creditsLayout = new VBox(20);
		Button backbutton = new Button("Back to Menu");
		Label label1 = new Label("Credits: \n1c");
		creditsLayout.getChildren().addAll(label1, backbutton);
		creditscene = new Scene(creditsLayout,200,200);

		VBox menulayout = new VBox(20);
		Button playbutton = new Button("Play Game");
		Button scorebutton = new Button("High Scores");
		Button howtobutton = new Button("How to Play");
		Button settingsbutton = new Button("Settings");
		Button creditsbutton = new Button("Credits");
		Button exitbutton = new Button("Exit");
		menulayout.getChildren().addAll(playbutton,scorebutton,howtobutton,settingsbutton,creditsbutton,exitbutton);
		menuscene = new Scene(menulayout,200,200);
		throw new UnsupportedOperationException();
	}
	public static void main(String []args){
		new DisplayFrame();
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