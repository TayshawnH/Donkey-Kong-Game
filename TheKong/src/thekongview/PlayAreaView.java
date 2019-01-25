/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import thekongmodel.BarrelData;
import thekongmodel.LevelData;
import thekongmodel.SpriteDataCollection;

/**
 *
 * @author CCannon
 */
public class PlayAreaView extends Pane {

    // Model declarations
    private BarrelData barrelData;
    
    //Sprite declarations
    private HeroView hero;
    private PrincessView princess;
    private KongView kong;
    private ArrayList<BarrelView> barrels;

    //Object declarations
    private LevelView levelView;

    public PlayAreaView(SpriteDataCollection spriteData, LevelData levelData) {
        barrelData = spriteData.getBarrelData();
        barrels = new ArrayList<>();
        this.levelView = new LevelView(levelData);
        this.getChildren().add(levelView);
        hero = new HeroView(spriteData.getHeroData());
        princess = new PrincessView(spriteData.getPrincessData());
        kong = new KongView(spriteData.getKongData());
        this.getChildren().addAll(hero, princess, kong);
    }

    public void addBarrel(BarrelView barrelView) {
        this.barrels.add(barrelView);
        this.getChildren().add(barrelView);
    }

    public void setBarrel(BarrelView barrelView, int index) {
        this.barrels.set(index, barrelView);
    }

    public int getNumBarrels() {
        return this.barrels.size();
    }

    public BarrelView getBarrel(int index) {
        return this.barrels.get(index);
    }

    public BarrelView deleteBarrel(int index) {
        BarrelView deletedBarrel = this.barrels.remove(index);
        this.getChildren().remove(deletedBarrel);
        return deletedBarrel;
    }

    /**
     * @return the hero
     */
    public HeroView getHero() {
        return hero;
    }
    
    /**
     * @return the princess
     */
    public PrincessView getPrincess() {
        return princess;
    }
    
    /**
     * @return the kong
     */
    public KongView getKong() {
        return kong;
    }

    /**
     * @return the levelView
     */
    public LevelView getLevelView() {
        return levelView;
    }
    
    /**
     * @return the barrelData
     */
    public BarrelData getBarrelData() {
        return barrelData;
    }

    public void setLevelView(LevelData levelData) {
        this.levelView = new LevelView(levelData);
    }

    public void moveSprites() {
        if (barrels.size() > 0) {
            for (int i = 0; i < barrels.size(); i++) {
                barrels.get(i).move();
            }
        }
        hero.move();
        princess.move();
    }
}
