package model.entity;

/**
 * Falling Behaviour for bars to make them fall
 */
public class FallingBehaviour implements MovingBehaviour {
    @Override
    public void react(Bar bar) {
        Map.getInstance().fall(bar);
    }
}
