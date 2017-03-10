package com.ekipa.darts.model;

/**
 * @author urandumani
 *
 */
public class PlayerModel {

    private String name;
    private Long currentScore;

    public PlayerModel(String name, Long currentScore) {
        this.name = name;
        this.currentScore = currentScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Long currentScore) {
        this.currentScore = currentScore;
    }
}