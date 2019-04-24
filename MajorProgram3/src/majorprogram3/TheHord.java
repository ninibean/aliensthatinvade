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

    private Alien[][] aliens;
    private double direction;
    private double lastDirection;
    private int numLiving;
    private boolean atEdge;
     ActionPane actionPane;
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
                    Alien a = new Alien(actionPane, alienSprites, 1);
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
                    Alien a = new Alien(actionPane, alienSprites, 2);
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
                    Alien a = new Alien(actionPane, alienSprites, 3);
                    aliens[i][j] = a;
                    a.setX(x3);
                    a.setY(y3);
                    actionPane.getChildren().add(a);
                    //a.setVisible(true);
                    a.move();
                    x3 += 35;
//                    r3 += 1;
//                    if(r1 == 11) {
//                        x2 = 90;
//                        y2 = 180;
//                    }
                }
            }
        }
        
    }
}
