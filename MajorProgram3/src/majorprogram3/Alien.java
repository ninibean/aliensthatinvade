/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author patte
 */
public class Alien extends Invader {
    private int alienType;
    private Rectangle2D[] viewportRects = new Rectangle2D[2];
    private int currentImage;
    private ActionPane actionPane;
    
    public Alien(ActionPane aPane, Image sprites, int alienType) {
        actionPane = aPane;
        
        if (alienType == 1) {
            this.setImage(sprites);
            Rectangle2D viewportRect = new Rectangle2D(0, 174, 23, 23);
            this.setViewport(viewportRect);
            this.setPointValue(10);
            this.setScaleX(1.5);
            this.setScaleY(1.5);
            this.setViewportRects(viewportRects);
            this.setVisible(true);
        } else if (alienType == 2) {
            this.setImage(sprites);
            Rectangle2D viewportRect = new Rectangle2D(27, 174, 23, 23);
            this.setViewport(viewportRect);
            this.setPointValue(20);
            this.setScaleX(1.5);
            this.setScaleY(1.5);
            this.setViewportRects(viewportRects);
            this.setVisible(true);
        } else if (alienType == 3) {
            this.setImage(sprites);
            Rectangle2D viewportRect = new Rectangle2D(56, 174, 23, 23);
            this.setViewport(viewportRect);
            this.setPointValue(30);
            this.setScaleX(1.5);
            this.setScaleY(1.5);
            this.setViewportRects(viewportRects);
            this.setVisible(true);
        }
    }
    
    

    @Override
    public void move() {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection())) ;
        this.setX( newX );
        this.setY( newY );
    }

    /**
     * @return the alienType
     */
    public int getAlienType() {
        return alienType;
    }

    /**
     * @param alienType the alienType to set
     */
    public void setAlienType(int alienType) {
        this.alienType = alienType;
    }

    /**
     * @return the viewportRects
     */
    public Rectangle2D[] getViewportRects() {
        return viewportRects;
    }

    /**
     * @param viewportRects the viewportRects to set
     */
    public void setViewportRects(Rectangle2D[] viewportRects) {
        this.viewportRects = viewportRects;
    }

    /**
     * @return the currentImage
     */
    public int getCurrentImage() {
        return currentImage;
    }

    /**
     * @param currentImage the currentImage to set
     */
    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
    }

    /**
     * @return the actionPane
     */
    public ActionPane getActionPane() {
        return actionPane;
    }

    /**
     * @param actionPane the actionPane to set
     */
    public void setActionPane(ActionPane actionPane) {
        this.actionPane = actionPane;
    }
}
