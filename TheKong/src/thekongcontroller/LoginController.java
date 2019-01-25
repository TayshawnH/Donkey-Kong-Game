/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import thekongmodel.PlayerProfile;
import thekongmodel.PlayerProfileCollection;
import thekongview.LoginView;

/**
 *
 * @author Tay
 */
public class LoginController {

    private PlayerProfileCollection profiles;

    public LoginController(PlayerProfileCollection profiles) {
        this.profiles = (profiles);
    }

    public PlayerProfile getLoginProfile() {
        ArrayList<String> choices = new ArrayList<>();
        for (int i = 0; i < profiles.getNumPlayerProfiles(); i++) {
            choices.add(profiles.getPlayerProfile(i).getPlayerName());

        }
        choices.add("Create New User");

        LoginView lv = new LoginView(choices);

        Optional<String> result = lv.showAndWait();

        if (result.isPresent()) {
            String name = result.get();
            PlayerProfile tay;

            for (int i = 0; i < profiles.getNumPlayerProfiles(); i++) {
                tay = profiles.getPlayerProfile(i);
                if (name.equals(tay.getPlayerName())) {
                    return tay;
                }
            }
            if (name.equals("Create New User")) {
                PlayerProfile newTay = new PlayerProfile("");
                profiles.addPlayerProfile(newTay);
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Text Input Dialog");
                dialog.setHeaderText("Look, a Text Input Dialog");
                dialog.setContentText("Please enter your name:");

                Optional<String> newResult = dialog.showAndWait();
                if (newResult.isPresent()) {
                    newTay.setPlayerName(newResult.get());
                }
                   IOController.writePlayerProfiles(profiles);
                return newTay;
            }
            return null;
        } else {
            showLoginErrorAndExit();
            return null;
        }
    }

    public void showLoginErrorAndExit() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
        System.exit(0);
    }
}
