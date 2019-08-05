/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.geometry.Bounds;

/**
 *
 * @author patte
 */
public class GameUtility {
    private static boolean checkBounds(double val, double min, double max) {
        return (val >= min && val <= max);
    }
    
    public static boolean detectCollison(Projectile p, Invader inv) {
        Bounds b = inv.getBoundsInParent();
        if ((checkBounds(p.getY(), b.getMinY(), b.getMaxY())) && 
                (checkBounds(p.getX() + 1, b.getMinX(), b.getMaxX()))) {
            return true;
        } else {
            return false;
        }
    }
}
