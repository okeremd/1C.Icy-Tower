package model.entity;

import model.logic.GameEngine;

public class Breakable implements BreakingBehaviour {
    @Override
    public void react(Bar bar) {
        Map.getInstance().remove(bar);
    }
}
