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

    public boolean isHighScore(int score) {

    	if(score > Integer.parseInt(highScoreScores[9]))
    		return  true;
    	return false;
	}

	public void saveNewHighScore(String text, int score) throws IOException {
		
		int i = 0;
		while(score < Integer.parseInt(highScoreScores[i])){
			i++;
		}
		int j =9;
		while(j >i )
		{
			highScoreScores[j] = highScoreScores[j-1];
			highScoreNames[j] = highScoreNames[j-1];
			j--;
		}
		highScoreNames[i] = text;
		highScoreScores[i] = score+"";

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("highScores.txt"));
		for(int index = 0; index< 10; index++)
		{
			bufferedWriter.write(highScoreNames[index] + "\n" +highScoreScores[index]);
			bufferedWriter.write("\n");
		}

		bufferedWriter.close();

	}
}

