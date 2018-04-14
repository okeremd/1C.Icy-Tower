package model.logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    private final String PATH = "~/";
	private final int MAX_HIGH_SCORE = 10;
	private String highScoreNames[];
	private int highScoreScores[];

    public FileManager(){

	}

	public String[] readHighScoreNames(){
    	return null;
	}

	public int[] readHighScoreScores(){
    	return null;
	}

	public void saveHighScoreNames(String names[]){

	}

	public void saveHighScoreScores(int scores[]){

	}
}

