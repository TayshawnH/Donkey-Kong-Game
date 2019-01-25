/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author CCannon
 */
public class StatusView extends HBox{
    private Label playerNameLabel;
    private Label scoreTitleLabel;
    private Label scoreValueLabel;
    private Label highScoreTitleLabel;
    private Label highScoreValueLabel;;
    private Label levelTitleLabel;
    private Label levelValueLabel;

    public StatusView(String playerName, int highScore){
        this.playerNameLabel = new Label(playerName);
        this.scoreTitleLabel = new Label("Score: ");
        this.scoreValueLabel = new Label("0");
        this.highScoreTitleLabel = new Label("High Score: ");
        this.highScoreValueLabel = new Label(highScore + "");
        this.levelTitleLabel = new Label("Level: ");
        this.levelValueLabel = new Label("1");
        this.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        this.setSpacing(10.0);
        this.getChildren().addAll(this.playerNameLabel, this.scoreTitleLabel, this.scoreValueLabel, this.highScoreTitleLabel,
                this.highScoreValueLabel, this.levelTitleLabel, this.levelValueLabel);
    }

    /**
     * @return the playerNameLabel
     */
    public Label getPlayerNameLabel() {
        return playerNameLabel;
    }

    /**
     * @param playerNameLabel the playerNameLabel to set
     */
    public void setPlayerNameLabel(Label playerNameLabel) {
        this.playerNameLabel = playerNameLabel;
    }

    /**
     * @return the scoreTitleLabel
     */
    public Label getScoreTitleLabel() {
        return scoreTitleLabel;
    }

    /**
     * @param scoreTitleLabel the scoreTitleLabel to set
     */
    public void setScoreTitleLabel(Label scoreTitleLabel) {
        this.scoreTitleLabel = scoreTitleLabel;
    }

    /**
     * @return the scoreValueLabel
     */
    public Label getScoreValueLabel() {
        return scoreValueLabel;
    }

    /**
     * @param scoreValueLabel the scoreValueLabel to set
     */
    public void setScoreValueLabel(Label scoreValueLabel) {
        this.scoreValueLabel = scoreValueLabel;
    }

    /**
     * @return the highScoreTitleLabel
     */
    public Label getHighScoreTitleLabel() {
        return highScoreTitleLabel;
    }

    /**
     * @param highScoreTitleLabel the highScoreTitleLabel to set
     */
    public void setHighScoreTitleLabel(Label highScoreTitleLabel) {
        this.highScoreTitleLabel = highScoreTitleLabel;
    }

    /**
     * @return the highScoreValueLabel
     */
    public Label getHighScoreValueLabel() {
        return highScoreValueLabel;
    }

    /**
     * @param highScoreValueLabel the highScoreValueLabel to set
     */
    public void setHighScoreValueLabel(Label highScoreValueLabel) {
        this.highScoreValueLabel = highScoreValueLabel;
    }

    /**
     * @return the levelTitleLabel
     */
    public Label getLevelTitleLabel() {
        return levelTitleLabel;
    }

    /**
     * @param levelTitleLabel the levelTitleLabel to set
     */
    public void setLevelTitleLabel(Label levelTitleLabel) {
        this.levelTitleLabel = levelTitleLabel;
    }

    /**
     * @return the levelValueLabel
     */
    public Label getLevelValueLabel() {
        return levelValueLabel;
    }

    /**
     * @param levelValueLabel the levelValueLabel to set
     */
    public void setLevelValueLabel(Label levelValueLabel) {
        this.levelValueLabel = levelValueLabel;
    }
}
