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
public class Projectile extends GameObject {
    
    public Projectile(ActionPane actionPane) {
        //this.setVisible(false);
        
        this.setSpeed(-15);
        this.setDirection(90);
        
        try {
            Image p = new Image(new FileInputStream("img/spritesheet.jpg"));
            this.setImage(p);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        Rectangle2D viewportRect = new Rectangle2D(320, 210, 24, 30);
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        this.setViewport(viewportRect);
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());
        //this.setX(getParentWidth() + 240); //Left-most: 10; center: 240; right-most: 470
        //this.setY(getParentHeight() +480);
        //this.setX();
        //this.setY();
        actionPane.getChildren().add(this);
    }
    
    
    
    
    public void move() {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection())) ;
        this.setX(newX);
        this.setY(newY);    
    }
        
}
