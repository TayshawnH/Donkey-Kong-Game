/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongmodel;

/**
 *
 * @author CCannon
 */
public class PlayerProfile {
    private String playerName;
    private int highScore;
    private int totalScore;
    private int gamesPlayed;
    private int levelsWon;

    public PlayerProfile(String playerName) {
        this.playerName = playerName;
        this.highScore = this.totalScore = this.gamesPlayed = this.levelsWon = 0;
    }
    
    /**
     * Create a comma-separated String representation of the PlayerProfile in the following format:
     * playerName, highScore, totalScore, gamesPlayed, levelsWon
     * @return String representation of this PlayerProfile object
     */
    public String toString() {
        return String.format("%-1s, %-1d, %-1d, %-1d, %-1d", playerName, highScore, totalScore, gamesPlayed, levelsWon);
    }
    
    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the highScore
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * @param highScore the highScore to set
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return the gamesPlayed
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * @param gamesPlayed the gamesPlayed to set
     */
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * @return the levelsWon
     */
    public int getLevelsWon() {
        return levelsWon;
    }

    /**
     * @param levelsWon the levelsWon to set
     */
    public void setLevelsWon(int levelsWon) {
        this.levelsWon = levelsWon;
    }
}
