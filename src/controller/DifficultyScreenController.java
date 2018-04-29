package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.GameFrame;


public class DifficultyScreenController extends MainController{


    public void openPlaySceneEasy(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //GameFrame gameFrame = new GameFrame(1);
        //primaryStage.setScene(gameFrame.start(1));
        GameFrame gameFrame = new GameFrame();
        primaryStage.setScene(gameFrame.start());

    }
    public void openPlaySceneMedium(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //GameFrame gameFrame = new GameFrame(2);
        //primaryStage.setScene(gameFrame.start(2));
        GameFrame gameFrame = new GameFrame();
        primaryStage.setScene(gameFrame.start());

    }
    public void openPlaySceneHard(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //GameFrame gameFrame = new GameFrame(3);
        //primaryStage.setScene(gameFrame.start(3));
        GameFrame gameFrame = new GameFrame();
        primaryStage.setScene(gameFrame.start());

    }


}
