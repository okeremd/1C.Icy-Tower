package test;

import model.logic.FileManager;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;


class FileManagerTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        assertNotNull(FileManager.getInstance());
    }

    @org.junit.jupiter.api.Test
    void readHighScoreNames() {
        assertNotNull(FileManager.getInstance().getHighScoreNames());
    }

    @org.junit.jupiter.api.Test
    void readHighScoreScores() {
        assertNotNull(FileManager.getInstance().getHighScoreScores());
    }

    @org.junit.jupiter.api.Test
    void readHighScoreLines() throws IOException {
        FileManager instance = FileManager.getInstance();
        instance.readHighScoreLines();
        String[] names = instance.getHighScoreNames();
        String[] scores = instance.getHighScoreScores();
        assertNotNull(names);
        assertNotNull(scores);
    }

    @org.junit.jupiter.api.Test
    void saveHighScoreScores() {
    }
}