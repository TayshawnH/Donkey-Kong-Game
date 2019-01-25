/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

/**
 *
 * @author CCannon
 */
public interface Movable {
    public double getCenterX();
    public double getCenterY();
    public double getBoundingRadius();
    public void move();
}
