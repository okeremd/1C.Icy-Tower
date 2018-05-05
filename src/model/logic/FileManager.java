package model.logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Responsible for storing high scores in a txt file.
 */
public class FileManager {

    public static final int TOTAL_HIGHSCORE = 10;
    public static final String HIGH_SCORE_FILE = "highScores.txt";
    public static final String DEFAULT_SCORE = "0";
    public static final String DEFAULT_NAME = "none";
    private String highScoreNames[];
    private String highScoreScores[];


    private FileManager(){
		highScoreScores = new String[TOTAL_HIGHSCORE];
		highScoreNames = new String[TOTAL_HIGHSCORE];
	}

	private static FileManager instance;

	/**
	 * Singleton pattern
	 * @return FileManager
	 */
	public static FileManager getInstance() {
		if(instance == null) {
			instance = new FileManager();
		}
		return instance;
	}

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

	/**
	 * Reads the highScore.txt and stores the names and scores in an array
	 * @throws IOException
	 */
	public void readHighScoreLines() throws IOException {


    	File file = new File(HIGH_SCORE_FILE);
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

	/**
	 * Checks if the players score a high score
	 * If it's higher than the lowest score on the list, it is high score.
	 * @param score
	 * @return boolean
	 */
    public boolean isHighScore(int score) {

    	if(score > getLowestScoreOnList())
        {
            return  true;
        }
    	return false;

	}

	/**
	 * Chekcs if the user's score is higher than the lowest score
	 * @return
	 */
	private int getLowestScoreOnList(){

	    return Integer.parseInt(highScoreScores[TOTAL_HIGHSCORE-1]);
    }

	/**
	 * Finds the placing for the new high score and stores it on the array, also saves it to txt.
	 * @param text
	 * @param score
	 * @throws IOException
	 */
	public void saveNewHighScore(String text, int score) throws IOException {

		int placingOfNewHighScore = 0;
		while(score < Integer.parseInt(highScoreScores[placingOfNewHighScore])){
			placingOfNewHighScore++;
		}
		int j =TOTAL_HIGHSCORE-1;
		while(j >placingOfNewHighScore )
		{
			highScoreScores[j] = highScoreScores[j-1];
			highScoreNames[j] = highScoreNames[j-1];
			j--;
		}
		highScoreNames[placingOfNewHighScore] = text;
		highScoreScores[placingOfNewHighScore] = score+"";

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("highScores.txt"));
		for(int index = 0; index< 10; index++)
		{
			bufferedWriter.write(highScoreNames[index] + "\n" +highScoreScores[index]);
			bufferedWriter.write("\n");
		}

		bufferedWriter.close();

	}

	/**
	 * Sets all scores to 0.
	 * @throws IOException
	 */
    public void resetHighScores() throws IOException {

		for(int i = 0; i<10; i++){
			highScoreScores[i] = DEFAULT_SCORE;
			highScoreNames[i] = DEFAULT_NAME;
		}
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE));
		for(int index = 0; index< 10; index++)
		{
			bufferedWriter.write(highScoreNames[index] + "\n" +highScoreScores[index]);
			bufferedWriter.write("\n");
		}

		bufferedWriter.close();
    }
}

