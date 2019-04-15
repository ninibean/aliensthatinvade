/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

/**
 *
 * @author patte
 */
public class ActionPane extends Pane {
    private CmdCenter cmdCenter;
            
    public ActionPane() {
        this.setWidth(550);
        this.setHeight(600);
       cmdCenter = new CmdCenter(this);
       this.getChildren().add(cmdCenter);
    }
}
