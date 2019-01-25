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
public class LadderData {
    private String imageFileName;
    private double minX;
    private double minY;
    private double width;
    private double height;
    
    public LadderData(double minX, double minY, double width, double height, String imageFileName){
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
        this.imageFileName = imageFileName;
    }
    
    public String toString(){
        return String.format("%-1.1f, %-1.1f, %-1.1f, %-1.1f, %-1s", this.getMinX(), this.getMinY(), this.getWidth(), this.getHeight(), this.getImageFileName());
    }

    /**
     * @return the imageFileName
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * @param imageFileName the imageFileName to set
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the minX
     */
    public double getMinX() {
        return minX;
    }

    /**
     * @param minX the minX to set
     */
    public void setMinX(double minX) {
        this.minX = minX;
    }

    /**
     * @return the minY
     */
    public double getMinY() {
        return minY;
    }

    /**
     * @param minY the minY to set
     */
    public void setMinY(double minY) {
        this.minY = minY;
    }
}
