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
public class SpriteDataCollection {
    private HeroData heroData;
    private KongData kongData;
    private PrincessData princessData;
    private BarrelData barrelData;
    
    public SpriteDataCollection() {
        heroData = new HeroData(0.0, 0.0, 0.0, 0.0, "");
        kongData = new KongData(0.0, 0.0, 0.0, 0.0, "");
        princessData = new PrincessData(0.0, 0.0, 0.0, 0.0, "");
        barrelData = new BarrelData(0.0, 0.0, 0.0, 0.0, "");
    }
    
    public String toString(){
        return getHeroData().toString() + System.lineSeparator() + getKongData().toString() + System.lineSeparator() + getPrincessData().toString() + System.lineSeparator() + getBarrelData().toString();
    }

    /**
     * @return the heroData
     */
    public HeroData getHeroData() {
        return heroData;
    }

    /**
     * @param heroData the heroData to set
     */
    public void setHeroData(HeroData heroData) {
        this.heroData = heroData;
    }

    /**
     * @return the kongData
     */
    public KongData getKongData() {
        return kongData;
    }

    /**
     * @param kongData the kongData to set
     */
    public void setKongData(KongData kongData) {
        this.kongData = kongData;
    }

    /**
     * @return the princessData
     */
    public PrincessData getPrincessData() {
        return princessData;
    }

    /**
     * @param princessData the princessData to set
     */
    public void setPrincessData(PrincessData princessData) {
        this.princessData = princessData;
    }

    /**
     * @return the barrelData
     */
    public BarrelData getBarrelData() {
        return barrelData;
    }

    /**
     * @param barrelData the barrelData to set
     */
    public void setBarrelData(BarrelData barrelData) {
        this.barrelData = barrelData;
    }
}
