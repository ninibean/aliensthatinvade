/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
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
    private Random rand = new Random();

    public GamePane() {
        actionPane = new ActionPane();
        MyTimer timer = new MyTimer();
        // this.setCenter(actionPane);

        cmdCenter = new CmdCenter(actionPane);

        MyCmdHandler mch = new MyCmdHandler();
        this.setOnKeyPressed(mch);
        this.getChildren().add(actionPane);

        timer.start();

        ship = new SpaceShip();
        actionPane.getChildren().add(ship);

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
                long rand = generator.nextInt(25);
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
            if (ship.getBoundsInParent().intersects(cmdCenter.projectile.getBoundsInParent())){
                
                ship.setVisible(false);
                System.out.println("BOOM");
                cmdCenter.projectile.setVisible(false);
                ssWaiting = false;
            } else {
                cmdCenter.projectile.setVisible(true);
            }
             
        }
        
    }
}
