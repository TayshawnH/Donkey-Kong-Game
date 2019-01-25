/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author chris
 */
public class GameView extends BorderPane{
    public GameView(StatusView statusView, PlayAreaView playAreaView, CommandView commandView) {
        this.setTop(statusView);
        this.setCenter(playAreaView);
        this.setBottom(commandView);
    }
}
