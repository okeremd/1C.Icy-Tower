package model.entity;

public class SlidingBehaviour implements MovingBehaviour {
    @Override
    public void react(Bar bar) {
        Map.getInstance().slide(bar);
    }
}
