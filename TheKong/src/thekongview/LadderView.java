/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import thekongmodel.LadderData;

/**
 *
 * @author CCannon
 */
public class LadderView extends Rectangle{
    
    private LadderData ladderData;
    
    public LadderView(LadderData ladderData){
        this.ladderData = ladderData;
        this.setX(ladderData.getMinX());
        this.setY(ladderData.getMinY());
        this.setWidth(ladderData.getWidth());
        this.setHeight(ladderData.getHeight());
        Image ladderImg = new Image(ladderData.getImageFileName());
        this.setFill(new ImagePattern(ladderImg));
    }

    /**
     * @return the ladderData
     */
    public LadderData getLadderData() {
        return ladderData;
    }
}
