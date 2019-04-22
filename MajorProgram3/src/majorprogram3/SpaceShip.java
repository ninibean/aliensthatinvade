/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javax.management.timer.Timer;

/**
 *
 * @author patte
 */
public class SpaceShip extends Invader {
    private moveTimer moveTimer; //ship movement
    private Timer launchTimer; //when the ship is launhed
    private GamePane gamePane;
    private Random rand = new Random();
    
    public SpaceShip() {
        moveTimer = new moveTimer();
        try {
            Image spaceShip = new Image(new FileInputStream("img/spritesheet.jpg"));
            this.setImage(spaceShip);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        //projectile = new Projectile(actionPane);
        
        Rectangle2D viewportRect = new Rectangle2D(170, 176, 40, 20);
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        this.setViewport(viewportRect);
        //setParentWidth(actionPane.getPrefWidth());
        //setParentHeight(actionPane.getPrefHeight());
        //this.setX(getParentWidth() + 240); //Left-most: 10; center: 240; right-most: 470
        //this.setY(getParentHeight() +480);
        this.setX(20);
        this.setY(10);
        this.moveTimer.start();
        
    }
    
//    public void startMoveTimer() {
//        moveTimer.start();
//    }
//    
//    public void stopMoveTimer() {
//        moveTimer.stop();
//    }
//    
//    public void startLaunchTimer() {
//        launchTimer.start();
//    }
//    
//    public void stopLaunchTimer() {
//        launchTimer.stop();
//    }
//    
//    public void setRandomPointValue() {
//        //
//        
//    }

    @Override
    public void move() {
        this.setSpeed(3);
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        //double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection())) ;
        this.setX(newX);
        //this.setY(newY);
    }
    
    public void launchTimer() {
        moveTimer = new moveTimer();
        int time = rand.nextInt(5);  
        
        if (time <= 5) {
            moveTimer.start();
        }
        
    }
    
    public class moveTimer extends AnimationTimer {
        private long previous;
        int directionRand = rand.nextInt(2);
        @Override
        public void handle(long now) {
            if (previous == 0) {
                previous = now;
            } else if (now - previous >= 15000000L && directionRand == 1) {
                setDirection(0);
                move();
                previous = now;
            } else if (now - previous >= 15000000L && directionRand == 0) {
                setDirection(180);
                move();
                previous = now;
            }
        }  
    }
}
