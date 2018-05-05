package model.entity;

/**
 * Sliding Behaviour for bars to make them move
 */
public class SlidingBehaviour implements MovingBehaviour {
    @Override
    public void react(Bar bar) {
        Map.getInstance().slide(bar);
    }
}
