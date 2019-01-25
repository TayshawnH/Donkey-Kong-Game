/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import java.util.List;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;

/**
 *
 * @author Tay
 */
public class LoginView extends ChoiceDialog<String> {

    public LoginView(List<String> choices) {
        super(choices.get(0), choices);

        this.setTitle("Donkey Kong");
        this.setHeaderText("Look, a Choice Dialog");
        this.setContentText("Choose your player:");
    }

    public String displayLoginView() {
        Optional<String> tay = this.showAndWait();
        if (tay.isPresent()) {
            return tay.get();
        }
        return "";
    }
}
