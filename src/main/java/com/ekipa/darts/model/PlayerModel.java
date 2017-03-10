package com.ekipa.darts.model;

/**
 * @author urandumani
 *
 */
public class PlayerModel {

    private String name;
    private Integer currentScore;
    private Integer currentThrow;

    public PlayerModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }

    public Integer getCurrentThrow() {
        return currentThrow;
    }

    public void setCurrentThrow(Integer currentThrow) {
        this.currentThrow = currentThrow;
    }
}