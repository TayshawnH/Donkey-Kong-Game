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
public class BarrelData {
    public static final int VIEW_MIN_X_INDEX = 0;
    public static final int VIEW_MIN_Y_INDEX = 1;
    public static final int VIEW_WIDTH_INDEX = 2;
    public static final int VIEW_HEIGHT_INDEX = 3;
    
    private double startingX;
    private double startingY;
    private double startingDirection;
    private double startingSpeed;
    private String imageFilePath;
    private double[] horizontalValues;
    private double[] rollingValuesOne;
    private double[] rollingValuesTwo;
    private double[] rollingValuesThree;
    private double[] rollingValuesFour;
    
    public BarrelData(double startingX, double startingY, double startingDirection, double startingSpeed, String imageFilePath){
      this.startingX = startingX;
      this.startingY = startingY;
      this.startingDirection = startingDirection;
      this.startingSpeed = startingSpeed;
      this.imageFilePath = imageFilePath;
      this.horizontalValues = new double[4];
      this.rollingValuesOne = new double[4];
      this.rollingValuesTwo = new double[4];
      this.rollingValuesThree = new double[4];
      this.rollingValuesFour = new double[4];
      setHorizontalValues(0.0, 0.0, 0.0, 0.0);
      setRollingValuesOne(0.0, 0.0, 0.0, 0.0);
      setRollingValuesTwo(0.0, 0.0, 0.0, 0.0);
      setRollingValuesThree(0.0, 0.0, 0.0, 0.0);
      setRollingValuesFour(0.0, 0.0, 0.0, 0.0);
    }
    
    /**
     * Returns a String representation of this object in the following format:
     * startingX, startingY, startingDirection, startingSpeed, imageFilePath
     * horizontalValues 0-3
     * rollingValuesOne 0-3
     * rollingValuesTwo 0-3
     * rollingValuesThree 0-3
     * rollingValuesFour 0-3
     * @return String representation of BarrelData
     */
    public String toString() {
        String lineOne = String.format("%-1.1f, %-1.1f, %-1.1f, %-1.1f, %-1s", getStartingX(), getStartingY(), getStartingDirection(), getStartingSpeed(), getImageFilePath());
        String horizontal = "";
        for(int i = 0; i < horizontalValues.length; i++) {
            horizontal += horizontalValues[i] + " ";
        }
        String rollingOne = "";
        for(int i = 0; i < rollingValuesOne.length; i++) {
            rollingOne += rollingValuesOne[i] + " ";
        }
        String rollingTwo = "";
        for(int i = 0; i < rollingValuesTwo.length; i++) {
            rollingTwo += rollingValuesTwo[i] + " ";
        }
        String rollingThree = "";
        for(int i = 0; i < rollingValuesThree.length; i++) {
            rollingThree += rollingValuesThree[i] + " ";
        }
        String rollingFour = "";
        for(int i = 0; i < rollingValuesFour.length; i++) {
            rollingFour += rollingValuesFour[i] + " ";
        }
        return lineOne + System.lineSeparator() + rollingOne + System.lineSeparator() + rollingOne + System.lineSeparator() + rollingTwo + System.lineSeparator() + rollingThree + System.lineSeparator() + rollingFour;
    }

    public void setHorizontalValues(double minX, double minY, double width, double height) {
        horizontalValues[BarrelData.VIEW_MIN_X_INDEX] = minX;
        horizontalValues[BarrelData.VIEW_MIN_Y_INDEX] = minY;
        horizontalValues[BarrelData.VIEW_WIDTH_INDEX] = width;
        horizontalValues[BarrelData.VIEW_HEIGHT_INDEX] = height;
    }

    public void setRollingValuesOne(double minX, double minY, double width, double height) {
        rollingValuesOne[BarrelData.VIEW_MIN_X_INDEX] = minX;
        rollingValuesOne[BarrelData.VIEW_MIN_Y_INDEX] = minY;
        rollingValuesOne[BarrelData.VIEW_WIDTH_INDEX] = width;
        rollingValuesOne[BarrelData.VIEW_HEIGHT_INDEX] = height;
    }

    public void setRollingValuesTwo(double minX, double minY, double width, double height) {
        rollingValuesTwo[BarrelData.VIEW_MIN_X_INDEX] = minX;
        rollingValuesTwo[BarrelData.VIEW_MIN_Y_INDEX] = minY;
        rollingValuesTwo[BarrelData.VIEW_WIDTH_INDEX] = width;
        rollingValuesTwo[BarrelData.VIEW_HEIGHT_INDEX] = height;
    }

    public void setRollingValuesThree(double minX, double minY, double width, double height) {
        rollingValuesThree[BarrelData.VIEW_MIN_X_INDEX] = minX;
        rollingValuesThree[BarrelData.VIEW_MIN_Y_INDEX] = minY;
        rollingValuesThree[BarrelData.VIEW_WIDTH_INDEX] = width;
        rollingValuesThree[BarrelData.VIEW_HEIGHT_INDEX] = height;
    }

    public void setRollingValuesFour(double minX, double minY, double width, double height) {
        rollingValuesFour[BarrelData.VIEW_MIN_X_INDEX] = minX;
        rollingValuesFour[BarrelData.VIEW_MIN_Y_INDEX] = minY;
        rollingValuesFour[BarrelData.VIEW_WIDTH_INDEX] = width;
        rollingValuesFour[BarrelData.VIEW_HEIGHT_INDEX] = height;
    }
    
    public double getHorizontalValue(int index){
        return this.horizontalValues[index];
    }
    
    public double getRollingValueOne(int index){
        return this.rollingValuesOne[index];
    }
    
    public double getRollingValueTwo(int index){
        return this.rollingValuesTwo[index];
    }
    
    public double getRollingValueThree(int index){
        return this.rollingValuesThree[index];
    }
    
    public double getRollingValueFour(int index){
        return this.rollingValuesFour[index];
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
}
