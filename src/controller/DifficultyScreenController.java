package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.GameFrame;

/**
 * Controller class for the Difficulty Screen
 */
public class DifficultyScreenController extends MainController{

    /**
     * According to the user's difficulty choice it starts the game
     * @param actionEvent default input controller of java
     */
    public void openPlaySceneEasy(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        GameFrame gameFrame = new GameFrame(1);
        primaryStage.setScene(gameFrame.start());

    }
    public void openPlaySceneMedium(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        GameFrame gameFrame = new GameFrame(2);
        primaryStage.setScene(gameFrame.start());

    }
    public void openPlaySceneHard(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        GameFrame gameFrame = new GameFrame(3);
        primaryStage.setScene(gameFrame.start());

    }


}
