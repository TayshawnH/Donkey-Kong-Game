/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongmodel;

import java.util.ArrayList;

/**
 *
 * @author CCannon
 */
public class PlayerProfileCollection {
    private String playerProfileConfigFileName;
    private PlayerProfile activeProfile;
    private PlayerProfile highScoreProfile;
    private ArrayList<PlayerProfile> playerProfiles;
    
    public PlayerProfileCollection(String playerProfileConfigFileName) {
        this.playerProfileConfigFileName = playerProfileConfigFileName;
        this.activeProfile = new PlayerProfile("");
        this.highScoreProfile = new PlayerProfile("");
        this.playerProfiles = new ArrayList<>();
    }
    
    /**
     * Creates and returns a String representation of the PlayerProfileCollection in the following format:
     * playerProfileConfigFileName
     * activeProfile playerName, highScoreProfile playerName
     * player0 data
     * player1 data
     * player3 data
     * ...
     * playerN data
     * @return A String representation of a PlayerProfileCollection
     */
    public String toString() {
        String profilesString = "";
        for(int i = 0; i < this.getNumPlayerProfiles(); i++) {
            profilesString += this.getPlayerProfile(i);
            if(i < this.getNumPlayerProfiles() - 1) {
                profilesString += System.lineSeparator();
            }
        }
        return String.format("%-1s, %-1s", activeProfile.getPlayerName(), highScoreProfile.getPlayerName())  + System.lineSeparator() + profilesString;
    }

    /**
     * @return the playerProfileConfigFileName
     */
    public String getPlayerProfileConfigFileName() {
        return playerProfileConfigFileName;
    }

    /**
     * @param playerProfileConfigFileName the playerProfileConfigFileName to set
     */
    public void setPlayerProfileConfigFileName(String playerProfileConfigFileName) {
        this.playerProfileConfigFileName = playerProfileConfigFileName;
    }
    
    /**
     * @return the activeProfile
     */
    public PlayerProfile getActiveProfile() {
        return activeProfile;
    }

    /**
     * @param activeProfile the activeProfile to set
     */
    public void setActiveProfile(PlayerProfile activeProfile) {
        this.activeProfile = activeProfile;
    }

    /**
     * @return the highScoreProfile
     */
    public PlayerProfile getHighScoreProfile() {
        return highScoreProfile;
    }

    /**
     * @param highScoreProfile the highScoreProfile to set
     */
    public void setHighScoreProfile(PlayerProfile highScoreProfile) {
        this.highScoreProfile = highScoreProfile;
    }
    
    public void addPlayerProfile(PlayerProfile profile) {
        this.playerProfiles.add(profile);
        this.updateHighScoreProfile();
    }
    
    public void setPlayerProfile(PlayerProfile profile, int index) {
        this.playerProfiles.set(index, profile);
        this.updateHighScoreProfile();
    }
     
    public int getNumPlayerProfiles() {
        return this.playerProfiles.size();
    }
    
    public PlayerProfile getPlayerProfile(int index) {
        return this.playerProfiles.get(index);
    }
    
    public PlayerProfile deletePlayerProfile(int index) {
        PlayerProfile removedPlayerProfile = this.playerProfiles.remove(index);
        this.updateHighScoreProfile();
        return removedPlayerProfile;
    }
    
    public void updateHighScoreProfile() {
        int highScore = this.getHighScoreProfile().getHighScore();
        for(int i = 0; i < this.playerProfiles.size(); i++) {
            if(this.getPlayerProfile(i).getHighScore() > highScore) {
                this.setHighScoreProfile(this.getPlayerProfile(i));
                highScore = this.getHighScoreProfile().getHighScore();
            }
        }
    }
}
