package model.logic;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.entity.*;
import view.GameFrame;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Starts the game, updates the game objects and checks the game is over or not.
 */
public class GameEngine {

	private MapGenerator mapGenerator;
	private boolean gamePaused;
	private boolean firstTimeSettings;
	boolean firstTime;
	private boolean comboJumpInitial;
	private boolean comboJump;
	private static int barIdIncreaseSpeed;
	private static int barIdDecreaseSpeed;

	private int activeBonusCount;

	public boolean isDecreaseGameSpeed() {
		return decreaseGameSpeed;
	}

	public void setDecreaseGameSpeed(boolean decreaseGameSpeed) {
		this.decreaseGameSpeed = decreaseGameSpeed;
	}

	private boolean decreaseGameSpeed;

	public boolean isIncreaseGameSpeed() {
		return increaseGameSpeed;
	}

	public void setIncreaseGameSpeed(boolean increaseGameSpeed) {
		this.increaseGameSpeed = increaseGameSpeed;
	}

	private boolean increaseGameSpeed;
	/**
	 * pane holds game screen and textfields on gamescreen
	 */
	private Pane pane;

	/**
	 * counts combo jumps
	 */
	private int comboCounter;

	/**
	 * Counts how much width one Bar Extender bonus adds to the bars
	 */
	private static final int barExtend= 5;


	private static Rectangle innerRectangle;

	/**
	 * Singleton instance
	 */
	private static GameEngine instance;

	/**
	 *
	 * @param difficulty
	 */
	public static void init(int difficulty){
        Map.getInstance().setDifficulty(difficulty);
    }

	/**
	 * Singleton Instance for GameEngine
	 * @return this
	 */
	public static GameEngine getInstance(){
		if(instance == null)
		{
			instance = new GameEngine();
			innerRectangle = new Rectangle();
		}
		return instance;
	}

	/**
	 * Default constructor
	 */
	private GameEngine() {
		pane = new Pane();
		BackgroundImage backgroundImage = new BackgroundImage(
				new Image(Paths.get( "./images/gameObject/gameBack.png")
						.toUri().toString()),
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(backgroundImage));
		mapGenerator = new MapGenerator(Map.getInstance());
		mapGenerator.createNextGameObjects();
		firstTime=true;
		increaseGameSpeed=false;
		activeBonusCount = 0;
	}


	/**
	 * Put images of the object in order, add textviews before adding it to stage
	 * @return
	 */
	public Pane convertMapToPane(){
	    if(!gamePaused) {

	    	//Clean the pane at every frame first
	    	pane.getChildren().clear();

	    	//Rectangle for combo box
	    	Rectangle outerRectangle = genereateRectangle(140, 60, 700, 90, Color.DARKGRAY);
			pane.getChildren().add(outerRectangle);

			//If combo jump occurs, the inner rectangle should be created and start decreasing.
			if(comboJump)
			{
				//Create text to show how many floor is passed with combo
				Text comboCount = new Text(comboCounter + "Floors!");
				comboCount.setFont(Font.font("adas",FontWeight.BOLD,30));
				comboCount.setTranslateX(650);
				comboCount.setTranslateY(270);
				comboCount.setFill(Color.LIGHTBLUE);

				//If it's the initial state of combo jump, create the inner rectangle
				if(comboJumpInitial)
				{
					comboJumpInitial = false;
					innerRectangle = genereateRectangle(120, 50, 705, 100, Color.RED);
				}

				pane.getChildren().add(comboCount);
				pane.getChildren().add(innerRectangle);
				//Decrease rectangle anytime if user not making a combo jump
				innerRectangle.setHeight(innerRectangle.getHeight()-1);
			}
			//Combo jump ends if user not able to do it until inner rectangle ends
			if(innerRectangle.getHeight()==0)
				comboJump=false;

			Text scoreText = new Text("score");
			scoreText.setFont(Font.font("score", FontWeight.BOLD, 35));
			scoreText.setTranslateY(40);
			scoreText.setTranslateX(700);
			scoreText.setFill(Color.ORANGE);

			Text tscore = new Text(""+Map.getInstance().getGameCharacter().getScore());
			tscore.setFont(Font.font("score", FontWeight.BOLD, 35));
			tscore.setTranslateY(77);
			tscore.setTranslateX(690);
			tscore.setFill(Color.ORANGE);

			pane.getChildren().addAll(scoreText,tscore);

			for(GameObject g: Map.getInstance().getGameObjects()){
				int xsofar = 0;
				//Add game character to the pane
				if(g instanceof model.entity.Character){
					ImageView add = new ImageView(((model.entity.Character) g).getCurrentImage());
					add.setTranslateX(g.getPosX() + xsofar);
					add.setTranslateY(500 - g.getPosY());
					pane.getChildren().add(add);
				}
				else {
					for (int i = 0; i < g.getImages().length; i++) {
						ImageView add = new ImageView(g.getImages()[i]);
						add.setTranslateX(g.getPosX() + xsofar);
						xsofar += g.getImages()[i].getWidth();
						add.setTranslateY(500 - g.getPosY());
						pane.getChildren().add(add);
						if (g instanceof Bar && i == 0) {
							for (int j = 0; j < ((Bar) g).getWidth() ; j++) {
								add = new ImageView(g.getImages()[1]);
								add.setTranslateX(g.getPosX() + xsofar);
								xsofar += g.getImages()[1].getWidth();
								add.setTranslateY(500 - g.getPosY());
								if (g instanceof HardlyVisible) {
									add.setOpacity(0.3);
								}
								pane.getChildren().add(add);
							}
								if(
										Map.getInstance().isBarExtendTaken() &&
										(Map.getInstance().getBarExtendTakenBar() != -1 &&
										((Bar) g).getId()>Map.getInstance().getBarExtendTakenBar() &&
										((Bar) g).getId() < Map.getInstance().getBarExtendTakenBar() + 10) || ((Bar)g).isExtended())
								{
									if(!((Bar) g).isExtended())
										((Bar) g).setWidth(((Bar) g).getWidth()+10);
									((Bar) g).setExtended();

								}
							i++;
						}
						else if(g instanceof Base && i == 0){
							for (int j = 0; j < ((Base) g).getWidth(); j++) {
								add = new ImageView(g.getImages()[1]);
								add.setTranslateX(g.getPosX() + xsofar);
								xsofar += g.getImages()[1].getWidth();
								add.setTranslateY(500 - g.getPosY());
								pane.getChildren().add(add);
							}
							i++;
						}

					}
				}
			}
			deActivateDecreaseGameSpeed();
			deActivateIncraseGameSpeed();
			Map.getInstance().incrementScore();
			Map.getInstance().updateCharacter();
			Map.getInstance().moveBars();
			if (Map.getInstance().getLevel() - (Map.getInstance().getAltitude() / 50) < 15) {
				mapGenerator.createNextGameObjects();
			}

		}
		else{
			if(firstTimeSettings)
				createSettingsPane();
		}
		//map.changeImages();
		if(Map.getInstance().gameOver()){
	    	Bar.resetId();
			createGameOverPane();
			return pane;
		}

		return pane;
	}

	private Rectangle genereateRectangle(int height, int width, int xpos, int ypos, Color red) {
		Rectangle innerRectangleCombo = new Rectangle();
		innerRectangleCombo.setHeight(height);
		innerRectangleCombo.setWidth(width);
		innerRectangleCombo.setTranslateX(xpos);
		innerRectangleCombo.setTranslateY(ypos);
		innerRectangleCombo.setFill(red);
		return innerRectangleCombo;

	}

	private void createSettingsPane() {
		firstTimeSettings=false;
		Rectangle rectangle = new Rectangle();
		rectangle.setX(170);
		rectangle.setY(50);
		rectangle.setWidth(400);
		rectangle.setHeight(400);
		rectangle.setFill(Color.LIGHTSALMON);
		Text pausetext = new Text("Pause Menu");
		pausetext.setTranslateX(250);
		pausetext.setTranslateY(100);
		pausetext.setFont(Font.font("PauseMenu", FontWeight.BOLD, 35));
		Text resumetext = new Text(">>");
		resumetext.setTranslateX(200);
		resumetext.setTranslateY(300);
		resumetext.setFont(Font.font("resume", FontWeight.BOLD, 25));
		Button resume = new Button("Resume Game");
		resume.setTranslateX(260);
		resume.setTranslateY(290);
		resume.setMinSize(20, 20);

		Button restart = new Button("Restart Game");
		restart.setTranslateX(360);
		restart.setTranslateY(290);
		restart.setMinSize(20, 20);

		restart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameFrame.stopSong();
				instance = null;
				Map.setMapNull();
				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

				GameFrame gameFrame = new GameFrame((int)Map.getInstance().getDifficulty());
				primaryStage.setScene(gameFrame.start());
			}
		});

		resume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                continueGame();
            }
        });
		Text voltext = new Text("Volume");
		voltext.setTranslateX(200);
		voltext.setTranslateY(155);
		voltext.setFont(Font.font("vol", FontWeight.BOLD, 15));
		Slider volume = new Slider();
		volume.setTranslateX(260);
		volume.setTranslateY(150);
		volume.setShowTickMarks(true);
		volume.setMin(0);
		volume.setMax(200);
		volume.setMajorTickUnit(50);
		volume.setValue((int)(SoundManager.getInstance().getVolume() * 200));
		volume.valueProperty().addListener((ov, old_val, new_val) -> {

            int newvolume = new_val.intValue();
            double volumeNormalized = newvolume / 200.0;
            SoundManager.getInstance().setVolume(volumeNormalized);
            GameFrame.changeVolume();
        });
		Text songtext = new Text("Songs");
		songtext.setTranslateX(200);
		songtext.setTranslateY(220);
		songtext.setFont(Font.font("song", FontWeight.BOLD, 15));
		ChoiceBox songlist = new ChoiceBox(FXCollections.observableArrayList("Requiem for a dream", "Never gonna give you up", "Light my fire"));
		songlist.setTranslateX(260);
		songlist.setTranslateY(210);
		songlist.getSelectionModel().select(SoundManager.getInstance().getSong());

		songlist.setOnAction(event -> {
			int songNo = songlist.getSelectionModel().getSelectedIndex();
			SoundManager.getInstance().setSong(songNo);
			GameFrame.stopSong();
			GameFrame.playSong();
		});


		pane.getChildren().addAll(rectangle, pausetext, resumetext, resume, volume, voltext, songtext, songlist,restart);
	}

	/**
	 * Creates the end screen of the game, that still holds the game screen and additionally shows score
	 */
	private void createGameOverPane() {

		int score = Map.getInstance().getGameCharacter().getScore();

		Button restart = new Button("Restart Game");
		restart.setTranslateX(550);
		restart.setTranslateY(550);


		Button backToMenu = new Button("Back to Menu");
		backToMenu.setTranslateY(550);
		backToMenu.setTranslateX(650);

		Text highScoreText = new Text("");
		highScoreText.setFont(Font.font("HighScore", FontWeight.BOLD, 30));
		highScoreText.setFill(Color.YELLOW);
		highScoreText.setTranslateY(320);
		highScoreText.setTranslateX(-380);

		Button saveScore = new Button("Save score!");
		TextField nameField = new TextField("Write Name");


		if(FileManager.getInstance().isHighScore(score) )
		{
			highScoreText.setText("New HighScore!!");

			nameField.setTranslateX(250);
			nameField.setTranslateY(450);

			saveScore.setTranslateX(390);
			saveScore.setTranslateY(450);
			pane.getChildren().addAll(nameField,saveScore);
		}

		restart.setOnMouseClicked(event -> {

			instance = null;
			Map.setMapNull();
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

			GameFrame gameFrame = new GameFrame((int)Map.getInstance().getDifficulty());
			primaryStage.setScene(gameFrame.start());


		});

		saveScore.setOnMouseClicked(event ->  {
			try {
				FileManager.getInstance().saveNewHighScore(nameField.getText(),score);
			} catch (IOException e) {
				e.printStackTrace();
			}
			saveScore.visibleProperty().set(false);
		});

		backToMenu.setOnMouseClicked(event -> {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(MainController.getInstance().getMainMenuScene());
            instance = null; // terminate the gameEngine for that game
			Map.setMapNull();
        });
		TextFlow textflow = new TextFlow();
		Text text1 = new Text("Game Over");
		text1.setFont(Font.font("Game Over", FontWeight.BOLD, 100));
		text1.setFill(Color.PALEGREEN);
		text1.setTranslateX(100);
		text1.setTranslateY(150);
		Text text2 = new Text("Score: "+ Map.getInstance().getGameCharacter().getScore());
		text2.setFont(Font.font("Score: ", FontWeight.BOLD, 60));
		text2.setFill(Color.PALETURQUOISE);
		text2.setTranslateX(-350);
		text2.setTranslateY(270);
		textflow.getChildren().addAll(text1,text2,highScoreText);
		pane.getChildren().addAll(backToMenu,textflow,restart);
	}

	/**
	 * Prepares the images of the character that chosen by player
	 * @param images
	 */
	public void loadCurrentCharactersImages(Image[] images) {
		Map.getInstance().loadCurrentCharactersImages(CharacterManager.getInstance().getCharacterImages());
	}

	/**
	 * signals map to move character left
	 */
	public void moveCharacterLeft(){

		Map.getInstance().moveLeft();
	}


	/**
	 * signals map to move character right
	 */
	public void moveCharacterRight(){

		Map.getInstance().moveRight();
	}


	/**
	 * signals map to jump character
	 */
	public void jumpCharacter() {

		Map.getInstance().jump();
	}


	/**
	 * signals map to stop moving character left
	 */
	public void stopMoveCharacterLeft(){

		Map.getInstance().stopMoveLeft();
	}

	/**
	 * signals map to stop moving character right
	 */
	public void stopMoveCharacterRight(){

		Map.getInstance().stopMoveRight();
	}

	public void updateScore() {
		// TODO - implement GameEngine.updateScore
		throw new UnsupportedOperationException();
	}

	public boolean isGameOver() {
		// TODO - implement GameEngine.isGameOver
		throw new UnsupportedOperationException();
	}

	public boolean isGamePaused() {
		return this.gamePaused;
	}

	public void pauseGame() {
	    firstTimeSettings=true;
		gamePaused = !gamePaused;
	}

	public void continueGame() {
		gamePaused = false;
	}

	public Map getMap(){
		return Map.getInstance();
	}

	public void setComboJump(boolean comboJump) {
		if(comboJump)
			comboJumpInitial = true;

		this.comboJump = comboJump;
	}

	public void setComboCounter(int comboCounter) {
		this.comboCounter = comboCounter;
	}

	public int getComboCounter() {
		return comboCounter;
	}

	public void increaseGameSpeed() {
		increaseGameSpeed = true;
		activeBonusCount++;
	}

	public void decreaseGameSpeed() {
		decreaseGameSpeed = true;
		activeBonusCount--;
	}

	public boolean deActivateIncraseGameSpeed() {
		if(CollisionManager.getPrevBarId() > barIdIncreaseSpeed + 12 && activeBonusCount > 0)
		{
			activeBonusCount--;
			return true;
		}
		return false;
	}

	public boolean deActivateDecreaseGameSpeed() {

		if(CollisionManager.getPrevBarId() > barIdDecreaseSpeed + 12 && activeBonusCount < 0)
		{
			activeBonusCount++;
			return true;
		}
		return false;
	}

	public void setPrevBarDecreaseGameSpeed(int prevBarId) {
		barIdDecreaseSpeed=prevBarId;
	}

	public void setPrevBarIncreaseGameSpeed(int prevBarId) {
		barIdIncreaseSpeed = prevBarId;
	}
}