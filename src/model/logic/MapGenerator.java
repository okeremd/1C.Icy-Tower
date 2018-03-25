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

	public void initializeMap() {
        for(int i = 0; i < 10; i++){
            map.createNextAltitudeObjects(1);
            map.setLevel(i+1);
        }
	}

	public void updateMap(){
        map.createNextAltitudeObjects(map.getLevel() % 25);
    }


}