package model.logic;

import model.entity.Map;

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

    /**
     * Creates next 30 bars and less amount of collectibles
     */
	public void createNextGameObjects(){
        for(int i = 0; i < 30; i++){
           if(Math.random() < 0.2){
                map.createCollectible();
            }
            map.setLevel(map.getLevel() + 1);
            map.createNextBar();
        }
    }
}