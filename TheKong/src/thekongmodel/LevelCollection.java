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
public class LevelCollection {
    private ArrayList<LevelData> levels;
    private String objectConfigFileName;
    
    public LevelCollection(String objectConfigFileName){
        this.objectConfigFileName = objectConfigFileName;
        this.levels = new ArrayList<>();
    }
    
    public String toString() {
        String levelString = "";
        for(int i = 0; i < this.getNumLevels(); i++) {
            levelString += this.getLevel(i);
            if(i < (this.getNumLevels() - 1)) {
                levelString += System.lineSeparator();
            }
        }
        
        return levelString;
    }

    /**
     * @return the objectConfigFileName
     */
    public String getObjectConfigFileName() {
        return objectConfigFileName;
    }

    /**
     * @param objectConfigFileName the objectConfigFileName to set
     */
    public void setObjectConfigFileName(String objectConfigFileName) {
        this.objectConfigFileName = objectConfigFileName;
    }
    
    public void addLevel(LevelData level) {
        levels.add(level);
    }
    
    public void setLevel(LevelData level, int index) {
        levels.set(index, level);
    }
    
    public int getNumLevels() {
        return levels.size();
    }
    
    public LevelData getLevel(int index) {
        return levels.get(index);
    }
    
    public LevelData deleteLevel(int index) {
        return levels.remove(index);
    }
}
