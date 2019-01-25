/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import thekongmodel.HeroData;

/**
 *
 * @author CCannon
 */
public class HeroView extends MovingSprite{

    private Rectangle2D runningLeftViewPortOne;
    private Rectangle2D runningLeftViewPortTwo;
    private Rectangle2D facingLeftViewPort;
    private Rectangle2D facingRightViewPort;
    private Rectangle2D runningRightViewPortOne;
    private Rectangle2D runningRightViewPortTwo;
    private HeroData heroData;
    
    public HeroView(HeroData heroData) {
        super(heroData.getStartingX(), heroData.getStartingY(), heroData.getStartingDirection(), heroData.getStartingSpeed());
        this.heroData = heroData;
        this.instantiateViewPorts();
        this.setImage(new Image(heroData.getImageFilePath()));
        this.setViewport(facingRightViewPort);
    }

    @Override
    public double getCenterX() {
        return this.getBoundsInParent().getMinX() + this.getBoundsInParent().getWidth()/2;
    }

    @Override
    public double getCenterY() {
        return this.getBoundsInParent().getMinY() + this.getBoundsInParent().getHeight()/2;
    }

    @Override
    public double getBoundingRadius() {
        return Math.max( this.getBoundsInParent().getHeight(), this.getBoundsInParent().getWidth())/2;
    }

    @Override
    public void move() {
        Double xVelocity = this.getSpeed() * Math.cos(this.getDirection() * Math.PI / 180.0);
        Double yVelocity = this.getSpeed() * Math.sin(this.getDirection() * Math.PI / 180.0);
        this.setX(this.getX() + xVelocity);
        this.setY(this.getY() + yVelocity);
    }

    private void instantiateViewPorts() {
        this.runningLeftViewPortOne = new Rectangle2D(getHeroData().getRunningLeftValueOne(HeroData.VIEW_MIN_X_INDEX), getHeroData().getRunningLeftValueOne(HeroData.VIEW_MIN_Y_INDEX), getHeroData().getRunningLeftValueOne(HeroData.VIEW_WIDTH_INDEX), getHeroData().getRunningLeftValueOne(HeroData.VIEW_HEIGHT_INDEX));
        this.runningLeftViewPortTwo = new Rectangle2D(getHeroData().getRunningLeftValueTwo(HeroData.VIEW_MIN_X_INDEX), getHeroData().getRunningLeftValueTwo(HeroData.VIEW_MIN_Y_INDEX), getHeroData().getRunningLeftValueTwo(HeroData.VIEW_WIDTH_INDEX), getHeroData().getRunningRightValueTwo(HeroData.VIEW_HEIGHT_INDEX));
        this.facingLeftViewPort = new Rectangle2D(getHeroData().getFacingLeftValue(HeroData.VIEW_MIN_X_INDEX), getHeroData().getFacingLeftValue(HeroData.VIEW_MIN_Y_INDEX), getHeroData().getFacingLeftValue(HeroData.VIEW_WIDTH_INDEX), getHeroData().getFacingLeftValue(HeroData.VIEW_HEIGHT_INDEX));
        this.facingRightViewPort = new Rectangle2D(getHeroData().getFacingRightValue(HeroData.VIEW_MIN_X_INDEX), getHeroData().getFacingRightValue(HeroData.VIEW_MIN_Y_INDEX), getHeroData().getFacingRightValue(HeroData.VIEW_WIDTH_INDEX), getHeroData().getFacingRightValue(HeroData.VIEW_HEIGHT_INDEX));
        this.runningRightViewPortOne = new Rectangle2D(getHeroData().getRunningRightValueOne(HeroData.VIEW_MIN_X_INDEX), getHeroData().getRunningRightValueOne(HeroData.VIEW_MIN_Y_INDEX), getHeroData().getRunningRightValueOne(HeroData.VIEW_WIDTH_INDEX), getHeroData().getRunningRightValueOne(HeroData.VIEW_HEIGHT_INDEX));
        this.runningRightViewPortTwo = new Rectangle2D(getHeroData().getRunningRightValueTwo(HeroData.VIEW_MIN_X_INDEX), getHeroData().getRunningRightValueTwo(HeroData.VIEW_MIN_Y_INDEX), getHeroData().getRunningRightValueTwo(HeroData.VIEW_WIDTH_INDEX), getHeroData().getRunningRightValueTwo(HeroData.VIEW_HEIGHT_INDEX));
    }

    /**
     * @return the heroData
     */
    public HeroData getHeroData() {
        return heroData;
    }

    /**
     * @return the runningLeftViewPortOne
     */
    public Rectangle2D getRunningLeftViewPortOne() {
        return runningLeftViewPortOne;
    }

    /**
     * @return the runningLeftViewPortTwo
     */
    public Rectangle2D getRunningLeftViewPortTwo() {
        return runningLeftViewPortTwo;
    }

    /**
     * @return the facingLeftViewPort
     */
    public Rectangle2D getFacingLeftViewPort() {
        return facingLeftViewPort;
    }

    /**
     * @return the facingRightViewPort
     */
    public Rectangle2D getFacingRightViewPort() {
        return facingRightViewPort;
    }

    /**
     * @return the runningRightViewPortOne
     */
    public Rectangle2D getRunningRightViewPortOne() {
        return runningRightViewPortOne;
    }

    /**
     * @return the runningRightViewPortTwo
     */
    public Rectangle2D getRunningRightViewPortTwo() {
        return runningRightViewPortTwo;
    }
    
}
