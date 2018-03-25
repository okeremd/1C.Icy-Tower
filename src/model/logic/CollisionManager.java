package model.logic;

import model.entity.Bar;
import model.entity.Character;

public class CollisionManager {

    Bar bar;
    Character character;


	public CollisionManager() {
		// TODO - implement CollisionManager.CollisionManager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pos1x
	 * @param pos1y
	 * @param pos2x
	 * @param pos2y
	 */
	public boolean checkCollision(int pos1x, int pos1y, int pos2x, int pos2y) {
		int fromX = Math.min(pos1x,pos2x);
		int fromY = Math.min(pos1y,pos2y);
		int toX = Math.max(pos1x,pos2x);
		int toY = Math.max(pos1y,pos2y);

		for(int y=fromY; y<=toY; y++){
		    for(int x=fromX; x<toX; x++){

            }
		}

        return false;
	}


}