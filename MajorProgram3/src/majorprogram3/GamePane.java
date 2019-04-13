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
        this.setOnKeyPressed(new MyCmdHandler());
//        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                switch (event.getCode()) {
//                    case LEFT: 
//                        System.out.println("Left key pressed");
//                        cmdCenter.move(); 
//                        break;
//                    case RIGHT:
//                        System.out.println("Right key pressed");
//                        cmdCenter.move();
//                        break;
//                    case SPACE:
//                        System.out.println("Space key pressed");
//                        cmdCenter.fireProjectile();
//                        break;
//                }
//            }
//            
//        });
    }
    
    
    public class MyCmdHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            //CmdCenter cmd = (CmdCenter) event.getSource();
            switch (event.getCode()) {
                    case LEFT: 
                        //System.out.println("Left key pressed");
                        cmdCenter.move(); 
                        System.out.println("L");
                        break;
                    case RIGHT:
                        //System.out.println("Right key pressed");
                        cmdCenter.move();
                        System.out.println("R");
                        break;
                    case SPACE:
                        //System.out.println("Space key pressed");
                        cmdCenter.fireProjectile();
                        System.out.println("S");
                        break;   
            }
        }
    }
}
