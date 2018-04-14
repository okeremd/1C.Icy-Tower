package model.logic;

import model.entity.Map;

import javafx.scene.image.Image;

public class MapGenerator {

	private Map map;
	private int difficulty;


    public MapGenerator() {
        // TODO - implement MapGenerator.MapGenerator
        throw new UnsupportedOperationException();
    }


    public MapGenerator(Map map) {
        this.map = map;
    }

	public void createNextLevels(){
        map.setPassedLevel(map.getPassedLevel());
        for(int i = 0; i < 30; i++){
            map.setLevel(map.getLevel() + 1);
            map.createNextAltitudeObjects(1);
        }
    }
}