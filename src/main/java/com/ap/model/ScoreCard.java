package com.ap.model;

import java.io.Serializable;

public class ScoreCard implements Serializable {
    private int score=0;

    public ScoreCard(int score) {
        this.score = score;
    }

    public ScoreCard() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
