/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.scene.image.Image;

/**
 *
 * @author patte
 */
public class TheHord {

    Alien[][] aliens;
    private double direction;
    private double lastDirection;
    private int numLiving;
    private boolean atEdge;
    private ActionPane actionPane;
    private Image alienSprites;

    public TheHord(ActionPane actionPane) {
        aliens = new Alien[5][11];
        //this.actionPane= actionPane;
        try {
            alienSprites = new Image(new FileInputStream("img/spritesheet.jpg"));
            //this.setImage(alienSprites);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        //coordinates for first 2 rows
        int x1 = 90;
        int y1 = 150;
        int r1 = 0;
        //coordinates for next 2 rows
        int x2 = 85;
        int y2 = 90;
        int r2 = 0;
        //coordinates for last row
        int x3 = 90;
        int y3 = 63;
        int r3 = 0;
        
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 || i == 1) {
                    Alien a = new Alien(actionPane, getAlienSprites(), 1);
                    aliens[i][j] = a;
                    a.setX(x1);
                    a.setY(y1);
                    actionPane.getChildren().add(a);
                    //a.setVisible(true);
                    a.move();
                    x1 += 35;
                    r1 += 1;
                    if(r1 == 11) {
                        x1 = 90;
                        y1 = 180;
                    }
                } else if (i == 2 || i == 3) {
                    Alien a = new Alien(actionPane, getAlienSprites(), 2);
                    aliens[i][j] = a;
                    a.setX(x2);
                    a.setY(y2);
                    actionPane.getChildren().add(a);
                    //a.setVisible(true);
                    a.move();
                    x2 += 35;
                    r2 += 1;
                    if(r2 == 11) {
                        x2 = 85;
                        y2 = 120;
                    }
                } else if (i == 4) {
                    Alien a = new Alien(actionPane, getAlienSprites(), 3);
                    aliens[i][j] = a;
                    a.setX(x3);
                    a.setY(y3);
                    actionPane.getChildren().add(a);
                    //a.setVisible(true);
                    a.move();
                    x3 += 35;
                    r3 += 1;
//                    if(r1 == 11) {
//                        x2 = 90;
//                        y2 = 180;
//                    }
                }
            }
        }
        
    }
    
    public void move() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                aliens[i][j].setSpeed(3);
                double newX = aliens[i][j].getX() + aliens[i][j].getSpeed() * Math.cos(Math.toRadians(getDirection()));
                double newY = aliens[i][j].getY() + aliens[i][j].getSpeed()* Math.sin(Math.toRadians(getDirection()));
                aliens[i][j].setX(newX);
                aliens[i][j].setY(newY);
            }
        }
    }
    public Alien getAlien(int row, int col) {
        return aliens[row][col];
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * @return the lastDirection
     */
    public double getLastDirection() {
        return lastDirection;
    }

    /**
     * @param lastDirection the lastDirection to set
     */
    public void setLastDirection(double lastDirection) {
        this.lastDirection = lastDirection;
    }

    /**
     * @return the numLiving
     */
    public int getNumLiving() {
        return numLiving;
    }

    /**
     * @param numLiving the numLiving to set
     */
    public void setNumLiving(int numLiving) {
        this.numLiving = numLiving;
    }

    /**
     * @return the atEdge
     */
    public boolean isAtEdge() {
        return atEdge;
    }

    /**
     * @param atEdge the atEdge to set
     */
    public void setAtEdge(boolean atEdge) {
        this.atEdge = atEdge;
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

    /**
     * @return the alienSprites
     */
    public Image getAlienSprites() {
        return alienSprites;
    }

    /**
     * @param alienSprites the alienSprites to set
     */
    public void setAlienSprites(Image alienSprites) {
        this.alienSprites = alienSprites;
    }
}
