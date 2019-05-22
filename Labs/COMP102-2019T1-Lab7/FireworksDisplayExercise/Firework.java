// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** Firework   */
public class Firework{
    public static final double GROUND = 550;
    public static final double RISE_STEP = 5;
    public static final double GROW_STEP = 2;

    private double xPos;
    private double ht = 0;
    private double maxHeight;
    private double radius = 2;
    private Color color;

    public Firework(double x, Color c, double h){
        xPos = x;
        color = c;
        maxHeight = h;
    }

    /**
     * Make the firework move one step:
     *  If below maxHeight, move it up by RISE_STEP
     *  If at maxHeight and not finished, make the radius bigger by GROW_STEP, 
     */
    public void step(){
        if (this.ht < maxHeight){
            this.ht = this.ht + RISE_STEP;
        }
        else if (! this.isFinished()){
            this.radius = this.radius + GROW_STEP;
        }
    }

    /**
     * Finished if the radius is at least half of maxHeight
     */
    public boolean isFinished(){
        return (this.radius >= this.maxHeight/2);
    }

    /**
     * Draw the firework as a circle of the current size, unless it is finished
     */
    public void draw(){
        if (! this.isFinished() ){
            UI.setColor(this.color);
            double left = this.xPos-this.radius;
            double top = GROUND-this.ht-this.radius;
            UI.fillOval(left, top, this.radius*2, this.radius*2);
        }
    }

}
