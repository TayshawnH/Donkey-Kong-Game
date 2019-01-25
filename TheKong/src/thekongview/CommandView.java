/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author CCannon
 */
 public class CommandView extends HBox {
   private Button startButton;
   private Button endButton;

   public CommandView() {
     startButton = new Button("start");
     endButton = new Button("end");

     this.getChildren().addAll(startButton, endButton);
   }

   public Button getStartButton() {
     return startButton;
   }

   public Button getEndButton() {
     return endButton;
   }
 }
