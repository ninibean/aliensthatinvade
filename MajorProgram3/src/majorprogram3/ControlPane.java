/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        //gp = new GamePane();
        start = new Button("Start");
        reset = new Button("Reset");
        exit = new Button("Exit");
        //ControlPaneHandler click = new ControlPaneHandler();
        //exit.setOnAction(click);
        
        this.getChildren().addAll(start, reset, exit);
        start.setFocusTraversable(false);
        reset.setFocusTraversable(false);
        exit.setFocusTraversable(false);
        this.setAlignment(Pos.CENTER);
    }
    
    
    
//    private class ControlPaneHandler implements EventHandler<ActionEvent> {
//        //GamePane gp = new GamePane();
//        @Override
//        public void handle(ActionEvent event) {
//            Button butt = (Button) event.getSource();
//            if (butt.getText().equals("Start")) {
//                // gp.timer.start();
//            } else if (butt.getText().equals("Reset")) {
//                //gp.r
//            } else if (butt.getText().equals("Exit")) {
//                System.exit(-1);
//            }
//        }
//    }

    /**
     * @return the start
     */
    public Button getStart() {
        return start;
    }

    /**
     * @return the reset
     */
    public Button getReset() {
        return reset;
    }

    /**
     * @return the exit
     */
    public Button getExit() {
        return exit;
    }
}
