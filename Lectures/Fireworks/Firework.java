import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** Firework   */

public class Firework{

    public static final double GROUND = 400;
    public static final double STEP_SIZE = 5;
    public static final double GROW_SIZE = 2;
    
    private double xPos;
    private double ht = 0;
    private double maxHeight;
    private double radius = 3;
    private Color color;

    public Firework(double x, Color c, double h){
        xPos = x;
        color = c;
        maxHeight = h;
    }


    /**
    * Make the firework move one step:
    *  If below maxHeight, move it up by STEP_SIZE
    *  If at maxHeight and not finished, make the radius bigger by GROW_SIZE, 
    */
    public void step(){
        if (this.ht < maxHeight){
            this.ht = this.ht + STEP_SIZE;
        }
        else if (! this.isFinished()){
            this.radius = this.radius + GROW_SIZE;
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