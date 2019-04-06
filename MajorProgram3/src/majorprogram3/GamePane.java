/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author patte
 */
public class GamePane extends BorderPane {
    private ActionPane actionPane;
    private CmdCenter cmdCenter;
    
    public GamePane() {
        actionPane = new ActionPane();
        this.setCenter(actionPane);
        
        cmdCenter = new CmdCenter(actionPane);
//        cmdCenter.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                switch (event.getCode()) {
//                    case LEFT: cmdCenter.relocate(cmdCenter.getLayoutX()-5, cmdCenter.getLayoutY()); break;
//                    case RIGHT: cmdCenter.relocate(cmdCenter.getLayoutX()+5, cmdCenter.getLayoutY()); break;
//                }
//            }
//            
//        });
    }
    
}
