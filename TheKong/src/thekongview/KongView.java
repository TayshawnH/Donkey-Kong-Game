/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import thekongmodel.KongData;

/**
 *
 * @author CCannon
 */
public class KongView extends MovingSprite{

    private Rectangle2D movingLeftViewPort;
    private Rectangle2D movingRightViewPort;
    private Rectangle2D facingForwardViewPort;
    private Rectangle2D throwingBarrelViewPort;
    private KongData kongData;
    
    public KongView(KongData kongData) {
        super(kongData.getStartingX(), kongData.getStartingY(), kongData.getStartingDirection(), kongData.getStartingSpeed());
        this.kongData = kongData;
        this.instantiateViewPorts();
        this.setImage(new Image(kongData.getImageFilePath()));
        this.setViewport(facingForwardViewPort);
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
        this.movingLeftViewPort = new Rectangle2D(getKongData().getMovingLeftValue(KongData.VIEW_MIN_X_INDEX), getKongData().getMovingLeftValue(KongData.VIEW_MIN_Y_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_WIDTH_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_HEIGHT_INDEX));
        this.movingRightViewPort = new Rectangle2D(getKongData().getMovingRightValue(KongData.VIEW_MIN_X_INDEX), getKongData().getMovingRightValue(KongData.VIEW_MIN_Y_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_WIDTH_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_HEIGHT_INDEX));
        this.facingForwardViewPort = new Rectangle2D(getKongData().getFacingForwardValue(KongData.VIEW_MIN_X_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_MIN_Y_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_WIDTH_INDEX), getKongData().getFacingForwardValue(KongData.VIEW_HEIGHT_INDEX));
        this.throwingBarrelViewPort = new Rectangle2D(getKongData().getThrowingBarrelValues(KongData.VIEW_MIN_X_INDEX), getKongData().getThrowingBarrelValues(KongData.VIEW_MIN_Y_INDEX), getKongData().getThrowingBarrelValues(KongData.VIEW_WIDTH_INDEX), getKongData().getThrowingBarrelValues(KongData.VIEW_HEIGHT_INDEX));
    }

    /**
     * @return the kongData
     */
    public KongData getKongData() {
        return kongData;
    }

    /**
     * @return the movingLeftViewPort
     */
    public Rectangle2D getMovingLeftViewPort() {
        return movingLeftViewPort;
    }

    /**
     * @return the movingRightViewPort
     */
    public Rectangle2D getMovingRightViewPort() {
        return movingRightViewPort;
    }

    /**
     * @return the facingForwardViewPort
     */
    public Rectangle2D getFacingForwardViewPort() {
        return facingForwardViewPort;
    }

    /**
     * @return the throwingBarrelViewPort
     */
    public Rectangle2D getThrowingBarrelViewPort() {
        return throwingBarrelViewPort;
    }

    
}
