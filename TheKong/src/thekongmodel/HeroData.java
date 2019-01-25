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
public class HeroData {
    public static final int VIEW_MIN_X_INDEX = 0;
    public static final int VIEW_MIN_Y_INDEX = 1;
    public static final int VIEW_WIDTH_INDEX = 2;
    public static final int VIEW_HEIGHT_INDEX = 3;
    
    private double startingX;
    private double startingY;
    private double startingDirection;
    private double startingSpeed;
    private String imageFilePath;
    private double[] runningLeftValuesOne;
    private double[] runningLeftValuesTwo;
    private double[] facingLeftValues;
    private double[] facingRightValues;
    private double[] runningRightValuesOne;
    private double[] runningRightValuesTwo;
    
    public HeroData(double startingX, double startingY, double startingDirection, double startingSpeed, String imageFilePath){
      this.startingX = startingX;
      this.startingY = startingY;
      this.startingDirection = startingDirection;
      this.startingSpeed = startingSpeed;
      this.imageFilePath = imageFilePath;
      runningLeftValuesOne = new double[4];
      runningLeftValuesTwo = new double[4];
      facingLeftValues = new double[4];
      facingRightValues = new double[4];
      runningRightValuesOne = new double[4];
      runningRightValuesTwo = new double[4];
      setRunningLeftValuesOne(0.0, 0.0, 0.0, 0.0);
      setRunningLeftValuesTwo(0.0, 0.0, 0.0, 0.0);
      setFacingLeftValues(0.0, 0.0, 0.0, 0.0);
      setFacingRightValues(0.0, 0.0, 0.0, 0.0);
      setRunningRightValuesOne(0.0, 0.0, 0.0, 0.0);
      setRunningRightValuesTwo(0.0, 0.0, 0.0, 0.0);
    }
    
    /**
     * Returns a String representation of this object in the following format:
     * startingX, startingY, startingDirection, startingSpeed, imageFilePath
     * runningLeftValuesOne 0-3
     * runningLeftValuesTwo 0-3
     * facingLeftValues 0-3
     * facingRightValues 0-3
     * runningRightValuesOne 0-3
     * runningRightValuesTwo 0-3
     * @return 
     */
    public String toString() {
        String lineOne = String.format("%-1.1f, %-1.1f, %-1.1f, %-1.1f, %-1s", getStartingX(), getStartingY(), getStartingDirection(), getStartingSpeed(), getImageFilePath());
        String runningLeftOne = "";
        for(int i = 0; i < runningLeftValuesOne.length; i++) {
            runningLeftOne += runningLeftValuesOne[i] + " ";
        }
        String runningLeftTwo = "";
        for(int i = 0; i < runningLeftValuesTwo.length; i++) {
            runningLeftTwo += runningLeftValuesTwo[i] + " ";
        }
        String facingLeft = "";
        for(int i = 0; i < facingLeftValues.length; i++) {
            facingLeft += facingLeftValues[i] + " ";
        }
        String facingRight = "";
        for(int i = 0; i < facingRightValues.length; i++) {
            facingRight += facingRightValues[i] + " ";
        }
        String runningRightOne = "";
        for(int i = 0; i < runningRightValuesOne.length; i++) {
            runningRightOne += runningRightValuesOne[i] + " ";
        }
        String runningRightTwo = "";
        for(int i = 0; i < runningRightValuesTwo.length; i++) {
            runningRightTwo += runningRightValuesTwo[i] + " ";
        }
        return lineOne + System.lineSeparator() + runningLeftOne + System.lineSeparator() + runningLeftTwo + System.lineSeparator() + facingLeft + System.lineSeparator() + facingRight + System.lineSeparator() + runningRightOne + System.lineSeparator() + runningRightTwo;
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
     * Set the values for a ViewPort that will show Hero running to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setRunningLeftValuesOne(double minX, double minY, double width, double height) {
        this.runningLeftValuesOne[HeroData.VIEW_MIN_X_INDEX] = minX;
        this.runningLeftValuesOne[HeroData.VIEW_MIN_Y_INDEX] = minY;
        this.runningLeftValuesOne[HeroData.VIEW_WIDTH_INDEX] = width;
        this.runningLeftValuesOne[HeroData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Hero running to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setRunningLeftValuesTwo(double minX, double minY, double width, double height) {
        this.runningLeftValuesTwo[HeroData.VIEW_MIN_X_INDEX] = minX;
        this.runningLeftValuesTwo[HeroData.VIEW_MIN_Y_INDEX] = minY;
        this.runningLeftValuesTwo[HeroData.VIEW_WIDTH_INDEX] = width;
        this.runningLeftValuesTwo[HeroData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Hero standing facing to the left
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setFacingLeftValues(double minX, double minY, double width, double height) {
        this.facingLeftValues[HeroData.VIEW_MIN_X_INDEX] = minX;
        this.facingLeftValues[HeroData.VIEW_MIN_Y_INDEX] = minY;
        this.facingLeftValues[HeroData.VIEW_WIDTH_INDEX] = width;
        this.facingLeftValues[HeroData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Hero standing facing to the right
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setFacingRightValues(double minX, double minY, double width, double height) {
        this.facingRightValues[HeroData.VIEW_MIN_X_INDEX] = minX;
        this.facingRightValues[HeroData.VIEW_MIN_Y_INDEX] = minY;
        this.facingRightValues[HeroData.VIEW_WIDTH_INDEX] = width;
        this.facingRightValues[HeroData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Hero running to the right
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setRunningRightValuesOne(double minX, double minY, double width, double height) {
        this.runningRightValuesOne[HeroData.VIEW_MIN_X_INDEX] = minX;
        this.runningRightValuesOne[HeroData.VIEW_MIN_Y_INDEX] = minY;
        this.runningRightValuesOne[HeroData.VIEW_WIDTH_INDEX] = width;
        this.runningRightValuesOne[HeroData.VIEW_HEIGHT_INDEX] = height;
    }

    /**
     * Set the values for a ViewPort that will show Hero running to the right
     * @param minX The x-coordinate of the upper left hand corner of the ViewPort
     * @param minY The y-coordinate of the upper left hand corner of the ViewPort
     * @param width The width of the ViewPort in pixels
     * @param height The height of the ViewPort in pixels
     */
    public void setRunningRightValuesTwo(double minX, double minY, double width, double height) {
        this.runningRightValuesTwo[HeroData.VIEW_MIN_X_INDEX] = minX;
        this.runningRightValuesTwo[HeroData.VIEW_MIN_Y_INDEX] = minY;
        this.runningRightValuesTwo[HeroData.VIEW_WIDTH_INDEX] = width;
        this.runningRightValuesTwo[HeroData.VIEW_HEIGHT_INDEX] = height;
    }
    
    /**
     * Get a value from the RunningLeftValuesOne array. The indeces are defined
     * by public, static constants of the HeroData Class
     * @param index the index of the desired value from RunningLeftValuesOne,
     * preferable defined by a public, static constant of HeroData
     * @return the double value used to define a ViewPort
     */
    public double getRunningLeftValueOne(int index){
        return this.runningLeftValuesOne[index];
    }
    
    /**
     * Get a value from the RunningLeftValuesTwo array. The indeces are defined
     * by public, static constants of the HeroData Class
     * @param index the index of the desired value from RunningLeftValuesTwo,
     * preferable defined by a public, static constant of HeroData
     * @return the double value used to define a ViewPort
     */
    public double getRunningLeftValueTwo(int index) {
        return this.runningLeftValuesTwo[index];
    }
    
    /**
     * Get a value from the FacingLeftValues array. The indeces are defined
     * by public, static constants of the HeroData Class
     * @param index the index of the desired value from FacingLeftValues,
     * preferable defined by a public, static constant of HeroData
     * @return the double value used to define a ViewPort
     */
    public double getFacingLeftValue(int index) {
        return this.facingLeftValues[index];
    }
    
    /**
     * Get a value from the FacingRightValues array. The indeces are defined
     * by public, static constants of the HeroData Class
     * @param index the index of the desired value from FacingRightValues,
     * preferable defined by a public, static constant of HeroData
     * @return the double value used to define a ViewPort
     */
    public double getFacingRightValue(int index) {
        return this.facingRightValues[index];
    }
    
    /**
     * Get a value from the RunningRightValuesOne array. The indeces are defined
     * by public, static constants of the HeroData Class
     * @param index the index of the desired value from RunningRightValuesOne,
     * preferable defined by a public, static constant of HeroData
     * @return the double value used to define a ViewPort
     */
    public double getRunningRightValueOne(int index) {
        return this.runningRightValuesOne[index];
    }
    
    /**
     * Get a value from the RunningRightValuesTwo array. The indeces are defined
     * by public, static constants of the HeroData Class
     * @param index the index of the desired value from RunningRightValuesTwo,
     * preferable defined by a public, static constant of HeroData
     * @return the double value used to define a ViewPort
     */
    public double getRunningRightValueTwo(int index) {
        return this.runningRightValuesTwo[index];
    }
}
