/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author patte
 */
public class ControlPane extends HBox {
    //private ControlPane control;
    private Button start;
    private Button reset;
    private Button exit;
    
    public ControlPane() {
        start = new Button("Start");
        reset = new Button("Reset");
        exit = new Button("Exit");
        
        this.getChildren().addAll(start, reset, exit);
        this.setAlignment(Pos.CENTER);
    }
}
