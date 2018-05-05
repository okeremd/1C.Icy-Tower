package model.logic;

import model.entity.Map;

/**
 * Generates a map and creates bars and collectibles
 */
public class MapGenerator {

    public static final int BARS_TO_BE_CREATED = 30;
    public static final double BONUS_CREATING_RANDOM = 0.1;
    private Map map;

    public MapGenerator(Map map) {
        this.map = map;
    }

    /**
     * Creates next 30 bars and some collectibles
     */
	public void createNextGameObjects(){
        for(int i = 0; i < BARS_TO_BE_CREATED; i++){
           if(Math.random() < BONUS_CREATING_RANDOM){
                map.createCollectible();
            }
            map.setLevel(map.getLevel() + 1);
            map.createNextBar();
        }
    }
}