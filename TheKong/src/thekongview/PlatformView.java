/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import thekongmodel.PlatformData;

/**
 *
 * @author CCannon
 */
public class PlatformView extends Rectangle{
    private PlatformData platformData;
    
    public PlatformView(PlatformData platformData){
        this.platformData = platformData;
        this.setX(platformData.getMinX());
        this.setY(platformData.getMinY());
        this.setWidth(platformData.getWidth());
        this.setHeight(platformData.getHeight());
        Image platformImg = new Image(platformData.getImageFileName());
        this.setFill(new ImagePattern(platformImg));
    }

    /**
     * @return the ladderData
     */
    public PlatformData getPlatformData() {
        return platformData;
    }
}
