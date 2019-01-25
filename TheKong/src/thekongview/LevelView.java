/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import thekongmodel.LevelData;

/**
 *
 * @author CCannon
 */
public class LevelView extends Pane{
    private LevelData levelData;
    private ArrayList<LadderView> ladders;
    private ArrayList<PlatformView> platforms;
    
    public LevelView(LevelData levelData){
        ladders = new ArrayList<>();
        platforms = new ArrayList<>();
        this.levelData = levelData;
        this.setPrefSize(levelData.getWidth(),levelData.getHeight());
        this.setBackground(new Background(new BackgroundImage(new Image(levelData.getBackgroundImageFileName()),
                BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        for(int i = 0; i < levelData.getNumLadders(); i++) {
            LadderView newLadder = new LadderView(levelData.getLadderData(i));
            this.getChildren().add(newLadder);
            ladders.add(newLadder);
        }
        for(int i = 0; i < levelData.getNumPlatforms(); i++) {
            PlatformView newPlatform = new PlatformView(levelData.getPlatformData(i));
            this.getChildren().add(newPlatform);
            platforms.add(newPlatform);
        }
    }
    
    public int getNumLadders() {
        return ladders.size();
    }
    
    public void addLadder(LadderView ladder) {
        ladders.add(ladder);
        this.getChildren().add(ladder);
    }
    
    public void setLadder(int index, LadderView ladder) {
        ladders.set(index, ladder);
        this.getChildren().set(index, ladder);
    }
    
    public LadderView getLadder(int index) {
        return ladders.get(index);
    }
    
    public LadderView deleteLadder(int index) {
        this.getChildren().remove(index);
        return ladders.remove(index);
    }
    
    public int getNumPlatforms() {
        return platforms.size();
    }
    
    public void addPlatform(PlatformView platform) {
        platforms.add(platform);
        this.getChildren().add(platform);
    }
    
    public void setPlatform(int index, PlatformView platform) {
        platforms.set(index, platform);
        this.getChildren().set(index, platform);
    }
    
    public PlatformView getPlatformView(int index) {
        return platforms.get(index);
    }
    
    public PlatformView deletePlatformView(int index) {
        this.getChildren().remove(index);
        return platforms.remove(index);
    }
}
