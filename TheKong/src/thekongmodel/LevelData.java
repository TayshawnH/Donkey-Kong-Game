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
public class LevelData {
    private ArrayList<LadderData> ladderDataCollection;
    private ArrayList<PlatformData> platformDataCollection;
    private String backgroundImageFileName;
    private double width;
    private double height;

    public LevelData(double width, double height, String backgroundImageFileName){
        this.backgroundImageFileName = backgroundImageFileName;
        this.width = width;
        this.height = height;
        this.ladderDataCollection = new ArrayList<>();
        this.platformDataCollection = new ArrayList<>();
    }
    
    public String toString() {
        String platformString = "";
        String ladderString = "";
        for(int i = 0; i < this.getNumLadders(); i++) {
            ladderString += this.getLadderData(i);
            if(i < (this.getNumLadders() - 1)) {
                ladderString += System.lineSeparator();
            }
        }
        for(int i = 0; i < this.getNumPlatforms(); i++) {
            platformString += this.getPlatformData(i);
            if(i < (this.getNumPlatforms() - 1)) {
                platformString += System.lineSeparator();
            }
        }
        return String.format("%-1.1f, %-1.1f, %-1s", this.width, this.height, this.backgroundImageFileName) + System.lineSeparator() + ladderString +
                System.lineSeparator() + "*" + System.lineSeparator() + platformString + System.lineSeparator() + "*";
    }
    
    public void addLadderData(LadderData ld) {
        this.ladderDataCollection.add(ld);
    }
    
    public void setLadderData(LadderData ld, int index) {
        this.ladderDataCollection.set(index, ld);
    }
    
    public int getNumLadders(){
        return this.ladderDataCollection.size();
    }
    
    public LadderData getLadderData(int index) {
        return this.ladderDataCollection.get(index);
    }
    
    public LadderData deleteLadderData(int index) {
        return this.ladderDataCollection.remove(index);
    }
    
    public void addPlatformData(PlatformData pd) {
        this.platformDataCollection.add(pd);
    }
    
    public void setPlatformData(PlatformData pd, int index) {
        this.platformDataCollection.set(index, pd);
    }
    
    public int getNumPlatforms() {
        return this.platformDataCollection.size();
    }
    
    public PlatformData getPlatformData(int index) {
        return this.platformDataCollection.get(index);
    }
    
    public PlatformData deletePlatformData(int index) {
        return this.platformDataCollection.remove(index);
    }
    
    /**
     * @return the backgroundImageFileName
     */
    public String getBackgroundImageFileName() {
        return backgroundImageFileName;
    }

    /**
     * @param backgroundImageFileName the backgroundImageFileName to set
     */
    public void setBackgroundImageFileName(String backgroundImageFileName) {
        this.backgroundImageFileName = backgroundImageFileName;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
