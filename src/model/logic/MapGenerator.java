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
        for(int i = 0; i < 30; i++){
           if(Math.random() < 0.2){
                map.createCollectible(1);
            }
            map.setLevel(map.getLevel() + 1);
            map.createNextAltitudeObjects(1);
        }
    }
}