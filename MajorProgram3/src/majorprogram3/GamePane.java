/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javax.management.timer.Timer;

/**
 *
 * @author patte
 */
public class GamePane extends BorderPane {

    private ActionPane actionPane;
    private CmdCenter cmdCenter;
    private SpaceShip ship;
    private StatusPane sPane;
    private ControlPane cPane;
    private Random rand = new Random();
    private MyTimer timer;
    private TheHord hord;

    public GamePane() {
        actionPane = new ActionPane();
        timer = new MyTimer();
        cmdCenter = new CmdCenter(actionPane);
        hord = new TheHord(actionPane);
        MyCmdHandler mch = new MyCmdHandler();
        ControlPaneHandler cph = new ControlPaneHandler();
        ship = new SpaceShip();
        sPane = new StatusPane();
        cPane = new ControlPane();
        
        this.setOnKeyPressed(mch);
        this.getChildren().add(actionPane);
        //cPane.setFocusTraversable(false);
        cPane.getExit().setOnAction(cph);
        cPane.getReset().setOnAction(cph);
        cPane.getStart().setOnAction(cph);
 
        

        actionPane.getChildren().add(ship);
        actionPane.getChildren().add(sPane);
        actionPane.getChildren().add(cPane);
        //actionPane.getChildren().add(hord);
        // timer.start();
        //this.setCenter(cmdCenter);
        this.setTop(sPane);
        this.setBottom(cPane);
        

    }

    public class MyCmdHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            //CmdCenter cmd = (CmdCenter) event.getSource();
            switch (event.getCode()) {
                case LEFT:
                    //System.out.println("Left key pressed");
                    cmdCenter.setSpeed(15);
                    if (cmdCenter.getX() < 10) {
                        cmdCenter.setX(15);
                    } else {
                        cmdCenter.setDirection(180);
                    }
                    cmdCenter.move();
                    System.out.println("L");
                    break;
                case RIGHT:
                    //System.out.println("Right key pressed");
                    cmdCenter.setSpeed(15);
                    if (cmdCenter.getX() > 470) {
                        cmdCenter.setX(457);
                    } else {
                        cmdCenter.setDirection(0);
                    }
                    cmdCenter.move();
                    System.out.println("R");
                    break;
                case SPACE:
                    //System.out.println("Space key pressed");
                    if (cmdCenter.projectile.getY() < 0) {
                        cmdCenter.fireProjectile();
                        System.out.println("pew!");
                    }
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
        private long previousShip;
        int directionRand = rand.nextInt(2);
        private boolean ssWaiting = false;
        private boolean shipCollision = false;
        private long spawnTime;
        private Random generator = new Random();
        private GamePane gp;
        //@Override
        public void handle(long now) {
            if (now - previous >= 2500000L) { //L makes a large number passable as an int value
                cmdCenter.projectile.move();
                previous = now;
            }
            if (previousShip == 0) {
                previousShip = now;
            } else if (now - previousShip >= 15000000L && ship.isVisible()) {
                //ship.setDirection(0);
                ship.move();
                previousShip = now;
           } 

            if (!ssWaiting) {
                //ship.setVisible(false);
                long rand = generator.nextInt(20);
                spawnTime = (long) (now + (rand + 5) * (Math.pow(10, 9)));
                ssWaiting = true;
            }
            if (ssWaiting && now >= spawnTime) {
                int directionChooser = generator.nextInt(2);
                ship.setVisible(true);
                //int direction;
                switch (directionChooser) {
                    case 1:
                        ship.setDirection(180);
                        ship.setX(500);
                        break;
                    default:
                        ship.setDirection(0);
                        ship.setX(0);
                        break;
                }
                System.out.println(ship.isVisible());
                ssWaiting = false;
            }
            if (ship.getBoundsInParent().intersects(cmdCenter.projectile.getBoundsInParent() )){
                ship.setRandomPointValue();
                sPane.getStatusLabel().setText("Points: " + ship.getPointValue());
                //sPane.setStatusLabel("Points: " + ship.getPointValue());
                ship.setVisible(false);
                cmdCenter.projectile.setVisible(false);
                System.out.println("BOOM");
                ssWaiting = false;
            }
             
           for (int i = 0; i < 5; i++) {
               //int[] is = hord.aliens[i];
               for(int j = 0; j < 11; j++) {
                   if (hord.aliens[i][j].isVisible() && cmdCenter.projectile.isVisible()) {
                       if (hord.aliens[i][j].getBoundsInParent().intersects(cmdCenter.projectile.getBoundsInParent())) {
                           cmdCenter.projectile.setVisible(false);
                           //hord.aliens[i][j].getPointValue();
                           sPane.getStatusLabel().setText("Points: " + hord.aliens[i][j].getPointValue());
                           hord.aliens[i][j].setVisible(false);
                           break;
                       } 
                   }
               }
           }
        }
        
    }
    
    public class ControlPaneHandler implements EventHandler<ActionEvent> {
        //GamePane gp = new GamePane();
        MyCmdHandler mch = new MyCmdHandler();
        @Override
        public void handle(ActionEvent event) {
            Button butt = (Button) event.getSource();
            if (butt.getText().equals("Start")) {
                timer.start();
                //sPane.getStatusLabel().setText("Points");
                //cmdCenter.setOnKeyPressed(mch);
                //butt.setFocusTraversable(false);
            } else if (butt.getText().equals("Reset")) {
                timer.stop();
                ship.setVisible(false);
                cmdCenter.setX(240);
                for (int i = 0; i < 5; i++) {
                    for(int j = 0; j < 11; j++) {
                        hord.aliens[i][j].setVisible(true);
               }
           }
                //cmdCenter.disableProperty();
                cmdCenter.projectile.setX(cmdCenter.getX());
                sPane.getStatusLabel().setText("Points: 0");
            } else if (butt.getText().equals("Exit")) {
                System.exit(-1);
            }
        }
    }
}
