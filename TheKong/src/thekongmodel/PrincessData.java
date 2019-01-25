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
public class PrincessData {
    public static final int VIEW_MIN_X_INDEX = 0;
    public static final int VIEW_MIN_Y_INDEX = 1;
    public static final int VIEW_WIDTH_INDEX = 2;
    public static final int VIEW_HEIGHT_INDEX = 3;
    
    private double startingX;
    private double startingY;
    private double startingDirection;
    private double startingSpeed;
    private String imageFilePath;
    private double[] walkingLeftValuesOne;
    private double[] walkingLeftValuesTwo;
    private double[] walkingRightValuesOne;
    private double[] walkingRightValuesTwo;
    
    public PrincessData(double startingX, double startingY, double startingDirection, double startingSpeed, String imageFilePath){
      this.startingX = startingX;
      this.startingY = startingY;
      this.startingDirection = startingDirection;
      this.startingSpeed = startingSpeed;
      this.imageFilePath = imageFilePath;
      this.walkingLeftValuesOne = new double[4];
      this.walkingLeftValuesTwo = new double[4];
      this.walkingRightValuesOne = new double[4];
      this.walkingRightValuesTwo = new double[4];
      setWalkingLeftValuesOne(0.0, 0.0, 0.0, 0.0);
      setWalkingLeftValuesTwo(0.0, 0.0, 0.0, 0.0);
      setWalkingRightValuesOne(0.0, 0.0, 0.0, 0.0);
      setWalkingRightValuesTwo(0.0, 0.0, 0.0, 0.0);
    }
    
    /**
     * Returns a String representation of this object in the following format:
     * startingX, startingY, startingDirection, startingSpeed, imageFilePath
     * walkingLeftValuesOne 0-3
     * walkingLeftValuesTwo 0-3
     * walkingRightValuesOne 0-3
     * walkingRightValuesTwo 0-3
     * @return String representation of PrincessData
     */
    public String toString() {
        String lineOne = String.format("%-1.1f, %-1.1f, %-1.1f, %-1.1f, %-1s", getStartingX(), getStartingY(), getStartingDirection(), getStartingSpeed(), getImageFilePath());
        String walkingLeftOne = "";
        for(int i = 0; i < walkingLeftValuesOne.length; i++) {
            walkingLeftOne += walkingLeftValuesOne[i] + " ";
        }
        String walkingLeftTwo = "";
        for(int i = 0; i < walkingLeftValuesTwo.length; i++) {
            walkingLeftTwo += walkingLeftValuesTwo[i] + " ";
        }
        String walkingRightOne = "";
        for(int i = 0; i < walkingRightValuesOne.length; i++) {
            walkingRightOne += walkingRightValuesOne[i] + " ";
        }
        String walkingRightTwo = "";
        for(int i = 0; i < walkingRightValuesTwo.length; i++) {
            walkingRightTwo += walkingRightValuesTwo[i] + " ";
        }
        return lineOne + System.lineSeparator() + walkingLeftTwo + System.lineSeparator() + walkingLeftTwo + System.lineSeparator() + walkingRightOne + System.lineSeparator() + walkingRightTwo;
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
     * @return the imageFilePath
     */
    public String getImageFilePath() {
        return imageFilePath;
    }

    /**
     * @param imageFilePath the imageFilePath to set
     */
    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    /**
     * Set the values for a ViewPort that will show Princess walking to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setWalkingLeftValuesOne(double minX, double minY, double width, double height) {
        this.walkingLeftValuesOne[PrincessData.VIEW_MIN_X_INDEX] = minX;
        this.walkingLeftValuesOne[PrincessData.VIEW_MIN_Y_INDEX] = minY;
        this.walkingLeftValuesOne[PrincessData.VIEW_WIDTH_INDEX] = width;
        this.walkingLeftValuesOne[PrincessData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Princess walking to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setWalkingLeftValuesTwo(double minX, double minY, double width, double height) {
        this.walkingLeftValuesTwo[PrincessData.VIEW_MIN_X_INDEX] = minX;
        this.walkingLeftValuesTwo[PrincessData.VIEW_MIN_Y_INDEX] = minY;
        this.walkingLeftValuesTwo[PrincessData.VIEW_WIDTH_INDEX] = width;
        this.walkingLeftValuesTwo[PrincessData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Princess walking to the right
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setWalkingRightValuesOne(double minX, double minY, double width, double height) {
        this.walkingRightValuesOne[PrincessData.VIEW_MIN_X_INDEX] = minX;
        this.walkingRightValuesOne[PrincessData.VIEW_MIN_Y_INDEX] = minY;
        this.walkingRightValuesOne[PrincessData.VIEW_WIDTH_INDEX] = width;
        this.walkingRightValuesOne[PrincessData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Princess walking to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setWalkingRightValuesTwo(double minX, double minY, double width, double height) {
        this.walkingRightValuesTwo[PrincessData.VIEW_MIN_X_INDEX] = minX;
        this.walkingRightValuesTwo[PrincessData.VIEW_MIN_Y_INDEX] = minY;
        this.walkingRightValuesTwo[PrincessData.VIEW_WIDTH_INDEX] = width;
        this.walkingRightValuesTwo[PrincessData.VIEW_HEIGHT_INDEX] = height;
    }
    
    /**
     * Get a value from the walkingLeftValuesOne array. The indeces are defined
     * by public, static constants of the PrincessData Class
     * @param index the index of the desired value from movingLeftValues,
     * preferable defined by a public, static constant of PrincessData
     * @return the double value used to define a ViewPort
     */
    public double getWalkingLeftValueOne(int index){
        return this.walkingLeftValuesOne[index];
    }
    
    /**
     * Get a value from the walkingLeftValuesTwo array. The indeces are defined
     * by public, static constants of the PrincessData Class
     * @param index the index of the desired value from walkingLeftValuesTwo,
     * preferable defined by a public, static constant of PrincessData
     * @return the double value used to define a ViewPort
     */
    public double getWalkingLeftValueTwo(int index) {
        return this.walkingLeftValuesTwo[index];
    }
    
    /**
     * Get a value from the walkingRightValuesOne array. The indeces are defined
     * by public, static constants of the PrincessData Class
     * @param index the index of the desired value from walkingRightValuesOne,
     * preferable defined by a public, static constant of PrincessData
     * @return the double value used to define a ViewPort
     */
    public double getWalkingRightValueOne(int index) {
        return this.walkingRightValuesOne[index];
    }
    
    /**
     * Get a value from the walkingRightValuesTwo array. The indeces are defined
     * by public, static constants of the PrincessData Class
     * @param index the index of the desired value from walkingRightValuesTwo,
     * preferable defined by a public, static constant of PrincessData
     * @return the double value used to define a ViewPort
     */
    public double getWalkingRightValueTwo(int index) {
        return this.walkingRightValuesTwo[index];
    }
}
