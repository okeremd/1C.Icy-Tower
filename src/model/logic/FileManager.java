package model.logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileManager {

	private static FileManager instance;

	private final String PATH = "~/";
	private final int MAX_HIGH_SCORE = 10;
	private String highScoreNames[];
	private String highScoreScores[];

    private FileManager(){

	}

	public static FileManager getInstance() {
		if(instance == null) {
			instance = new FileManager();
		}
    	return instance;
	}

	public String[] readHighScoreNames() throws IOException {


    	File file = new File("highScores.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		int i = 0;
		while( (line = bufferedReader.readLine()) != null)
		{
			highScoreScores[i] = line;
			System.out.println(line);
		}

    	return highScoreScores;
	}

	public int[] readHighScoreScores(){
    	return null;
	}

	public void saveHighScoreNames(String names[]){

	}

	public void saveHighScoreScores(int scores[]){

	}
}

