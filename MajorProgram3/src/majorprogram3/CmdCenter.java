/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author patte
 */
public class CmdCenter extends GameObject {
     Projectile projectile;
    

    public CmdCenter(ActionPane actionPane) {
        //Read  in the entire sprite sheet from disk.
        try {
            Image cmdCenter = new Image(new FileInputStream("img/spritesheet.jpg"));
            this.setImage(cmdCenter);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        projectile = new Projectile(actionPane);
        
        Rectangle2D viewportRect = new Rectangle2D(219, 180, 24, 17);
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        this.setViewport(viewportRect);
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());
        //this.setX(getParentWidth() + 240); //Left-most: 10; center: 240; right-most: 470
        //this.setY(getParentHeight() +480);
        this.setX(240);
        this.setY(450);
        actionPane.getChildren().add(this);
    }
    
    
    public void fireProjectile() {
        projectile.setVisible(true);
        projectile.move();
        projectile.setX(this.getX());
        projectile.setY(this.getY()-30);
    }
    
    public Projectile getProjectile() {
        return projectile;
    }

    @Override
    public void move() {
//        double myWidth = this.getBoundsInParent().getMaxX() - this.getBoundsInParent().getMinX();
//        double newX = 0.0;
//        double speed = 5;
//        
//        if (this.getDirection() == 0.0) {
//            newX = this.getX() + this.getSpeed();
//        } else {
//            newX = this.getX() - this.getSpeed();
//        }
//        
//        if (newX < 0) {
//            this.setX(1);
//        } else if (newX + myWidth > this.getParentWidth() ) {
//            this.setX(this.getParentWidth() - myWidth);
//        } else {
//            this.setX(newX);
//        }
        //speed = 5;
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection())) ;
        this.setX(newX);
        this.setY(newY);
    }

}
