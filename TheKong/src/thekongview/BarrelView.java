/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import thekongmodel.BarrelData;

/**
 *
 * @author CCannon
 */
public class BarrelView extends MovingSprite {

    private Rectangle2D horizontalViewPort;
    private Rectangle2D rollingViewPortOne;
    private Rectangle2D rollingViewPortTwo;
    private Rectangle2D rollingViewPortThree;
    private Rectangle2D rollingViewPortFour;
    private BarrelData barrelData;

    public BarrelView(BarrelData barrelData) {
        super(barrelData.getStartingX(), barrelData.getStartingY(), barrelData.getStartingDirection(), barrelData.getStartingDirection());
        this.barrelData = barrelData;
        this.instantiateViewPorts();
        this.setImage(new Image(barrelData.getImageFilePath()));
        this.setViewport(horizontalViewPort);
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
        this.horizontalViewPort = new Rectangle2D(this.getBarrelData().getHorizontalValue(BarrelData.VIEW_MIN_X_INDEX), this.getBarrelData().getHorizontalValue(BarrelData.VIEW_MIN_Y_INDEX), this.getBarrelData().getHorizontalValue(BarrelData.VIEW_WIDTH_INDEX), this.getBarrelData().getHorizontalValue(BarrelData.VIEW_HEIGHT_INDEX));
        this.rollingViewPortOne = new Rectangle2D(this.getBarrelData().getRollingValueOne(BarrelData.VIEW_MIN_X_INDEX), this.getBarrelData().getRollingValueOne(BarrelData.VIEW_MIN_Y_INDEX), this.getBarrelData().getRollingValueOne(BarrelData.VIEW_WIDTH_INDEX), this.getBarrelData().getRollingValueOne(BarrelData.VIEW_HEIGHT_INDEX));
        this.rollingViewPortTwo = new Rectangle2D(this.getBarrelData().getRollingValueTwo(BarrelData.VIEW_MIN_X_INDEX), this.getBarrelData().getRollingValueTwo(BarrelData.VIEW_MIN_Y_INDEX), this.getBarrelData().getRollingValueTwo(BarrelData.VIEW_WIDTH_INDEX), this.getBarrelData().getRollingValueTwo(BarrelData.VIEW_HEIGHT_INDEX));
        this.rollingViewPortThree = new Rectangle2D(this.getBarrelData().getRollingValueThree(BarrelData.VIEW_MIN_X_INDEX), this.getBarrelData().getRollingValueThree(BarrelData.VIEW_MIN_Y_INDEX), this.getBarrelData().getRollingValueThree(BarrelData.VIEW_WIDTH_INDEX), this.getBarrelData().getRollingValueThree(BarrelData.VIEW_HEIGHT_INDEX));
        this.rollingViewPortFour = new Rectangle2D(this.getBarrelData().getRollingValueFour(BarrelData.VIEW_MIN_X_INDEX), this.getBarrelData().getRollingValueFour(BarrelData.VIEW_MIN_Y_INDEX), this.getBarrelData().getRollingValueFour(BarrelData.VIEW_WIDTH_INDEX), this.getBarrelData().getRollingValueFour(BarrelData.VIEW_HEIGHT_INDEX));

    }

    /**
     * @return the horizontalViewPort
     */
    public Rectangle2D getHorizontalViewPort() {
        return horizontalViewPort;
    }

    /**
     * @return the rollingViewPortOne
     */
    public Rectangle2D getRollingViewPortOne() {
        return rollingViewPortOne;
    }

    /**
     * @return the rollingViewPortTwo
     */
    public Rectangle2D getRollingViewPortTwo() {
        return rollingViewPortTwo;
    }

    /**
     * @return the rollingViewPortThree
     */
    public Rectangle2D getRollingViewPortThree() {
        return rollingViewPortThree;
    }

    /**
     * @return the rollingViewPortFour
     */
    public Rectangle2D getRollingViewPortFour() {
        return rollingViewPortFour;
    }

    /**
     * @return the barrelData
     */
    public BarrelData getBarrelData() {
        return barrelData;
    }

}
