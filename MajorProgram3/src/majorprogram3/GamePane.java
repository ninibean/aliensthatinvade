/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.animation.AnimationTimer;
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
        MyTimer timer = new MyTimer();
       // this.setCenter(actionPane);
        
        cmdCenter = new CmdCenter(actionPane);
        
        MyCmdHandler mch = new MyCmdHandler();
        this.setOnKeyPressed(mch);
        this.getChildren().add(actionPane);
        
        timer.start();
        
        
    }
    
    
    public class MyCmdHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            //CmdCenter cmd = (CmdCenter) event.getSource();
            switch (event.getCode()) {
                    case LEFT: 
                        //System.out.println("Left key pressed");
                        cmdCenter.setSpeed(15);
                        cmdCenter.setDirection(180);
                        cmdCenter.move(); 
                        System.out.println("L");
                        break;
                    case RIGHT:
                        //System.out.println("Right key pressed");
                        cmdCenter.setSpeed(15);
                        cmdCenter.setDirection(0);
                        cmdCenter.move();
                        System.out.println("R");
                        break;
                    case SPACE:
                        //System.out.println("Space key pressed");
                        cmdCenter.fireProjectile();
                        //cmdCenter.projectile.setSpeed(-15);
                        //cmdCenter.projectile.setDirection(90);
                         System.out.println("S");
                        break;
                    default:
                        break;
            }
        }
    }
    
    public class MyTimer extends AnimationTimer {
       private long previous = 0;
        //@Override
        public void handle(long now) {
            if (now - previous >= 2500000L ) { //L makes a large number passable as an int value
                cmdCenter.projectile.move();
                previous = now;
            }
        }
    }
}
