package com.ap.model;

import javafx.scene.shape.Circle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {




    private ScoreCard scoreCard;


    private int earnedCherries;





    public Player() {
        }

    public Player(ScoreCard scoreCard, int earnedCherries) {
        this.scoreCard = scoreCard;
        this.earnedCherries = earnedCherries;


    }


    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }






    public int getEarnedCherries() {
        return earnedCherries;
    }

    public void setEarnedCherries(int earnedCherries) {
        this.earnedCherries = earnedCherries;
    }
}
