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
    private Projectile projectile;
    

    public CmdCenter(ActionPane actionPane) {
        //Read in the entire sprite sheet from disk.
        try {
            Image cmdCenter = new Image(new FileInputStream("C:/Users/patte/Documents/CS Code and Projects/spritesheet.jpg"));
            this.setImage(cmdCenter);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        //Specify which portion of the sprite sheet you want displayed. by giving the (x,y)  
        //location of the top-left corner and the width and the height.
        Rectangle2D viewportRect = new Rectangle2D(219, 180, 24, 17);

        //As a matter of preference, I scaled the image to make it appear larger.
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        this.setViewport(viewportRect);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());

        //Give an initial location to the CmdCenter
        this.setX(getParentWidth() + 240); //Left-most: 10; center: 240; right-most: 470
        this.setY(getParentHeight() +480);
    }
    
    public void fireProjectile() {
        
    }
    
    public Projectile getProjectile() {
        return null;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
