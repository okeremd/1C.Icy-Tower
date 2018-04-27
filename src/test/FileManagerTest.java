package test;

import model.logic.FileManager;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

class FileManagerTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        assertThat(FileManager.getInstance(),equalTo(FileManager.getInstance()));
    }

    @org.junit.jupiter.api.Test
    void readHighScoreNames() {
    }

    @org.junit.jupiter.api.Test
    void readHighScoreScores() {
    }

    @org.junit.jupiter.api.Test
    void readHighScoreLines() throws IOException {
        FileManager instance = FileManager.getInstance();
        instance.readHighScoreLines();
        String[] names = instance.getHighScoreNames();
        String[] scores = instance.getHighScoreScores();
        assertThat(names[0], equalTo("Ahmet"));
        assertThat(scores[0], equalTo("60"));
    }

    @org.junit.jupiter.api.Test
    void saveHighScoreScores() {
    }
}