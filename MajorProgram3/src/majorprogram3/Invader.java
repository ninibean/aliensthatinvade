/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

/**
 *
 * @author patte
 */
public abstract class Invader {
    private int pointValue; //points awarded
    
    public Invader() {
        pointValue = 0;
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
    
    
}
