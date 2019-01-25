/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import thekongmodel.PrincessData;

/**
 *
 * @author CCannon
 */
public class PrincessView extends MovingSprite{

    private Rectangle2D walkingLeftViewPortOne;
    private Rectangle2D walkingLeftViewPortTwo;
    private Rectangle2D walkingRightViewPortOne;
    private Rectangle2D walkingRightViewPortTwo;
    private PrincessData princessData;
    
    public PrincessView(PrincessData princessData) {
        super(princessData.getStartingX(), princessData.getStartingY(), princessData.getStartingDirection(), princessData.getStartingSpeed());
        this.princessData = princessData;
        this.instantiateViewPorts();
        this.setImage(new Image(princessData.getImageFilePath()));
        this.setViewport(walkingRightViewPortOne);
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
        this.walkingLeftViewPortOne = new Rectangle2D(this.getPrincessData().getWalkingLeftValueOne(PrincessData.VIEW_MIN_X_INDEX), this.getPrincessData().getWalkingLeftValueOne(PrincessData.VIEW_MIN_Y_INDEX), this.getPrincessData().getWalkingLeftValueOne(PrincessData.VIEW_WIDTH_INDEX), this.getPrincessData().getWalkingLeftValueOne(PrincessData.VIEW_HEIGHT_INDEX));
        this.walkingLeftViewPortTwo = new Rectangle2D(this.getPrincessData().getWalkingLeftValueTwo(PrincessData.VIEW_MIN_X_INDEX), this.getPrincessData().getWalkingLeftValueTwo(PrincessData.VIEW_MIN_Y_INDEX), this.getPrincessData().getWalkingLeftValueTwo(PrincessData.VIEW_WIDTH_INDEX), this.getPrincessData().getWalkingLeftValueTwo(PrincessData.VIEW_HEIGHT_INDEX));
        this.walkingRightViewPortOne = new Rectangle2D(this.getPrincessData().getWalkingRightValueOne(PrincessData.VIEW_MIN_X_INDEX), this.getPrincessData().getWalkingRightValueOne(PrincessData.VIEW_MIN_Y_INDEX), this.getPrincessData().getWalkingRightValueOne(PrincessData.VIEW_WIDTH_INDEX), this.getPrincessData().getWalkingRightValueOne(PrincessData.VIEW_HEIGHT_INDEX));
        this.walkingRightViewPortTwo = new Rectangle2D(this.getPrincessData().getWalkingRightValueTwo(PrincessData.VIEW_MIN_X_INDEX), this.getPrincessData().getWalkingRightValueTwo(PrincessData.VIEW_MIN_Y_INDEX), this.getPrincessData().getWalkingRightValueTwo(PrincessData.VIEW_WIDTH_INDEX), this.getPrincessData().getWalkingRightValueTwo(PrincessData.VIEW_HEIGHT_INDEX));
    }

    /**
     * @return the princessData
     */
    public PrincessData getPrincessData() {
        return princessData;
    }

    /**
     * @return the walkingLeftViewPortOne
     */
    public Rectangle2D getWalkingLeftViewPortOne() {
        return walkingLeftViewPortOne;
    }

    /**
     * @return the walkingLeftViewPortTwo
     */
    public Rectangle2D getWalkingLeftViewPortTwo() {
        return walkingLeftViewPortTwo;
    }

    /**
     * @return the walkingRightViewPortOne
     */
    public Rectangle2D getWalkingRightViewPortOne() {
        return walkingRightViewPortOne;
    }

    /**
     * @return the walkingRightViewPortTwo
     */
    public Rectangle2D getWalkingRightViewPortTwo() {
        return walkingRightViewPortTwo;
    }
    
}
