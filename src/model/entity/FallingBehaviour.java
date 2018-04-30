package model.entity;

public class FallingBehaviour implements MovingBehaviour {
    @Override
    public void react(Bar bar) {
        Map.getInstance().fall(bar);
    }
}
