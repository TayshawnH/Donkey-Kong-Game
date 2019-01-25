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
public class KongData {
    public static final int VIEW_MIN_X_INDEX = 0;
    public static final int VIEW_MIN_Y_INDEX = 1;
    public static final int VIEW_WIDTH_INDEX = 2;
    public static final int VIEW_HEIGHT_INDEX = 3;
    
    private double startingX;
    private double startingY;
    private double startingDirection;
    private double startingSpeed;
    private String imageFilePath;
    private double[] movingLeftValues;
    private double[] movingRightValues;
    private double[] facingForwardValues;
    private double[] throwingBarrelValues;
    
    public KongData(double startingX, double startingY, double startingDirection, double startingSpeed, String imageFilePath){
      this.startingX = startingX;
      this.startingY = startingY;
      this.startingDirection = startingDirection;
      this.startingSpeed = startingSpeed;
      this.imageFilePath = imageFilePath;
      movingLeftValues = new double[4];
      movingRightValues = new double[4];
      facingForwardValues = new double[4];
      throwingBarrelValues = new double[4];
      setMovingLeftValues(0.0, 0.0, 0.0, 0.0);
      setMovingRightValues(0.0, 0.0, 0.0, 0.0);
      setFacingForwardValues(0.0, 0.0, 0.0, 0.0);
      setThrowingBarrelValues(0.0, 0.0, 0.0, 0.0);
    }
    
    /**
     * Returns a String representation of this object in the following format:
     * startingX, startingY, startingDirection, startingSpeed, imageFilePath
     * movingLeftValues 0-3
     * movingRightValues 0-3
     * facingForwardValues 0-3
     * throwingBarrelValues 0-3
     * @return String representation of KongData
     */
    public String toString() {
        String lineOne = String.format("%-1.1f, %-1.1f, %-1.1f, %-1.1f, %-1s", getStartingX(), getStartingY(), getStartingDirection(), getStartingSpeed(), getImageFilePath());
        String movingRight = "";
        for(int i = 0; i < movingLeftValues.length; i++) {
            movingRight += movingLeftValues[i] + " ";
        }
        String movingLeft = "";
        for(int i = 0; i < movingRightValues.length; i++) {
            movingLeft += movingRightValues[i] + " ";
        }
        String facingForward = "";
        for(int i = 0; i < facingForwardValues.length; i++) {
            facingForward += facingForwardValues[i] + " ";
        }
        String throwingBarrel = "";
        for(int i = 0; i < throwingBarrelValues.length; i++) {
            throwingBarrel += throwingBarrelValues[i] + " ";
        }
        return lineOne + System.lineSeparator() + movingRight + System.lineSeparator() + movingLeft + System.lineSeparator() + facingForward + System.lineSeparator() + throwingBarrel;
    }

    /**
     * @return the startingX
     */
    public double getStartingX() {
        return startingX;
    }

    /**
     * @param startingX the startingX to set
     */
    public void setStartingX(double startingX) {
        this.startingX = startingX;
    }

    /**
     * @return the startingY
     */
    public double getStartingY() {
        return startingY;
    }

    /**
     * @param startingY the startingY to set
     */
    public void setStartingY(double startingY) {
        this.startingY = startingY;
    }

    /**
     * @return the startingDirection
     */
    public double getStartingDirection() {
        return startingDirection;
    }

    /**
     * @param startingDirection the startingDirection to set
     */
    public void setStartingDirection(double startingDirection) {
        this.startingDirection = startingDirection;
    }

    /**
     * @return the startingSpeed
     */
    public double getStartingSpeed() {
        return startingSpeed;
    }

    /**
     * @param startingSpeed the startingSpeed to set
     */
    public void setStartingSpeed(double startingSpeed) {
        this.startingSpeed = startingSpeed;
    }

    /**
     * @return the imageFileName
     */
    public String getImageFilePath() {
        return imageFilePath;
    }

    /**
     * @param imageFileName the imageFileName to set
     */
    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    /**
     * Set the values for a ViewPort that will show Kong moving to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setMovingLeftValues(double minX, double minY, double width, double height) {
        this.movingLeftValues[KongData.VIEW_MIN_X_INDEX] = minX;
        this.movingLeftValues[KongData.VIEW_MIN_Y_INDEX] = minY;
        this.movingLeftValues[KongData.VIEW_WIDTH_INDEX] = width;
        this.movingLeftValues[KongData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Kong moving to the right
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setMovingRightValues(double minX, double minY, double width, double height) {
        this.movingRightValues[KongData.VIEW_MIN_X_INDEX] = minX;
        this.movingRightValues[KongData.VIEW_MIN_Y_INDEX] = minY;
        this.movingRightValues[KongData.VIEW_WIDTH_INDEX] = width;
        this.movingRightValues[KongData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Kong facing forward
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setFacingForwardValues(double minX, double minY, double width, double height) {
        this.facingForwardValues[KongData.VIEW_MIN_X_INDEX] = minX;
        this.facingForwardValues[KongData.VIEW_MIN_Y_INDEX] = minY;
        this.facingForwardValues[KongData.VIEW_WIDTH_INDEX] = width;
        this.facingForwardValues[KongData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Kong throwing a barrel
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setThrowingBarrelValues(double minX, double minY, double width, double height) {
        this.throwingBarrelValues[KongData.VIEW_MIN_X_INDEX] = minX;
        this.throwingBarrelValues[KongData.VIEW_MIN_Y_INDEX] = minY;
        this.throwingBarrelValues[KongData.VIEW_WIDTH_INDEX] = width;
        this.throwingBarrelValues[KongData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Get a value from the movingLeftValues array. The indeces are defined
     * by public, static constants of the KongData Class
     * @param index the index of the desired value from movingLeftValues,
     * preferable defined by a public, static constant of KongData
     * @return the double value used to define a ViewPort
     */
    public double getMovingLeftValue(int index){
        return this.movingLeftValues[index];
    }
    
    /**
     * Get a value from the movingRightValues array. The indeces are defined
     * by public, static constants of the KongData Class
     * @param index the index of the desired value from movingRightValues,
     * preferable defined by a public, static constant of KongData
     * @return the double value used to define a ViewPort
     */
    public double getMovingRightValue(int index) {
        return this.movingRightValues[index];
    }
    
    /**
     * Get a value from the facingForwardValues array. The indeces are defined
     * by public, static constants of the KongData Class
     * @param index the index of the desired value from facingForwardValues,
     * preferable defined by a public, static constant of KongData
     * @return the double value used to define a ViewPort
     */
    public double getFacingForwardValue(int index) {
        return this.facingForwardValues[index];
    }
    
    /**
     * Get a value from the throwingBarrelValues array. The indeces are defined
     * by public, static constants of the KongData Class
     * @param index the index of the desired value from throwingBarrelValues,
     * preferable defined by a public, static constant of KongData
     * @return the double value used to define a ViewPort
     */
    public double getThrowingBarrelValues(int index) {
        return this.throwingBarrelValues[index];
    }
    
    
}
