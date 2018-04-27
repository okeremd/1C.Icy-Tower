package model.logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileManager {

	private FileManager(){
		highScoreScores = new String[10];
		highScoreNames = new String[10];
	}

	private static FileManager instance;

	public static FileManager getInstance() {
		if(instance == null) {
			instance = new FileManager();
		}
		return instance;
	}


	private final String PATH = "~/";
	private final int MAX_HIGH_SCORE = 10;

	public String[] getHighScoreNames() {
		return highScoreNames;
	}

	public void setHighScoreNames(String[] highScoreNames) {
		this.highScoreNames = highScoreNames;
	}

	public String[] getHighScoreScores() {
		return highScoreScores;
	}

	public void setHighScoreScores(String[] highScoreScores) {
		this.highScoreScores = highScoreScores;
	}

	private String highScoreNames[];
	private String highScoreScores[];





	public void readHighScoreLines() throws IOException {


    	File file = new File("highScores.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		int i = 0;
		while( (line = bufferedReader.readLine()) != null)
		{
			highScoreNames[i] = line;
			highScoreScores[i] = bufferedReader.readLine();
			i=i+1;
		}
	}

	public int[] readHighScoreScores(){
    	return null;
	}

	public void saveHighScoreNames(String names[]){

	}

	public void saveHighScoreScores(int scores[]){

	}
}

