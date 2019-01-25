/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.scene.image.ImageView;

/**
 *
 * @author CCannon
 */
public abstract class MovingSprite extends ImageView implements Movable{
    private final double MAX_SPEED = 5.0;
    
    private double direction;
    private double speed;
    
    public MovingSprite(double startingX, double startingY, double startingDirection, double startingSpeed){
        this.setX(startingX);
        this.setY(startingY);
        this.direction = startingDirection;
        this.speed = startingSpeed;
    }
    
    public String toString() {
        return String.format("%-5d, %-5d, %-5d", getDirection(), getSpeed(), MAX_SPEED);
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
