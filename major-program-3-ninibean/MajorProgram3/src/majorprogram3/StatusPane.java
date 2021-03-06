/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author patte
 */
public class StatusPane extends HBox {
    private Label statusLabel;
    private int points;
    private Label pointsLabel;
    
    public StatusPane() {
        int points = 0;
        statusLabel = new Label ("Points: " + points);
        statusLabel.setTextFill(Color.WHITE);
        this.getChildren().add(statusLabel);
    }

    /**
     * @return the statusLabel
     */
    public Label getStatusLabel() {
        return statusLabel;
    }

    /**
     * @param statusLabel the statusLabel to set
     */
    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }
}
