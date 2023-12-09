package com.ap.model;

import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {


    private List<Pillar> pillars = new ArrayList<Pillar>();
    private List<Stick> sticks = new ArrayList<Stick>();


    private Stick movingStick;

    private Stick displayStick;

    public List<Pillar> getPillars() {
        return pillars;
    }

    public void setPillars(List<Pillar> pillars) {
        this.pillars = pillars;
    }

    public List<Stick> getSticks() {
        return sticks;
    }

    public void setSticks(List<Stick> sticks) {
        this.sticks = sticks;
    }

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Stick getMovingStick() {
        return movingStick;
    }

    public void setMovingStick(Stick movingStick) {
        this.movingStick = movingStick;
    }

    public Stick getDisplayStick() {
        return displayStick;
    }

    public void setDisplayStick(Stick displayStick) {
        this.displayStick = displayStick;
    }
}
