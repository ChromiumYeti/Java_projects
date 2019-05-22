// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Creates a crowd of cartoon figures, and lets the user control them:
 *   "Restart" button will clear the graphics pane and create a new crowd
 *   Two buttons let the user specify the current direction
 *   Releasing the mouse on a figure makes the figure turn in the current direction
 *    and then move 30 units in that direction
 *
 */
public class CrowdMoverExercise{

    public static final int CROWD_SIZE = 12;
    public static final double STEP = 30;

    // field to store list of Figures.
    // Need field because multiple events call methods that access it
    private ArrayList<CartoonFigure> crowd = new ArrayList<CartoonFigure>();

    private String currentDirection = "left";

    /**
     * Clears graphics pane,
     * Makes a new list of Cartoon Figures in crowd
     *  (make new ArrayList, then
     *   add new Figures to it, using makeRandomFigure() )
     * Redraws all the characters.
     */
    public void restart() {
        /*# YOUR CODE HERE */

    }

    /**
     * Set the current direction to left (responding to button)
     */
    public void setLeft(){
        /*# YOUR CODE HERE */

    }

    /**
     * Set the current direction to right (responding to button)
     */
    public void setRight(){
        /*# YOUR CODE HERE */

    }

    /**
     * Respond to mouse release: releasing on a cartoon figure make it turn and move
     *  Must find figure under the mouse (if any), 
     *  (use findFigureOn(..) method. If it returns null, then not on any character)
     *  Then makes the figure turn and move (if there was a figure)
     *  Then redraws the crowd
     */
    public void doMouse (String action, double x, double y){
        /*# YOUR CODE HERE */

    }

    /**
     * Find a character in crowd that the point (x, y) is on.
     *  Returns null if point is not on any character
     */
    public CartoonFigure findFigureOn(double x, double y){
        CartoonFigure answer = null;
        for (CartoonFigure cf : this.crowd){
            if (cf.isOn(x, y)){
                answer = cf;
            }
        }
        return answer;
    }

    /**
     * Makes a random new character
     */
    public CartoonFigure makeRandomFigure(){
        double x = 50 + Math.random()*600;
        double y = 50 + Math.random()*350;
        int dice = (int)(Math.random()*4);  // random integer from 0 to 3
        String imageName = "fig"+dice;
        return new CartoonFigure(x, y, imageName);
    }

    /**
     * Set up interface: mouse, buttons for Restart, Left, Right, and quit
     */
    public static void main(String[] args){
        CrowdMoverExercise cme = new CrowdMoverExercise();
        /*# YOUR CODE HERE */

        UI.addButton("Quit", UI::quit);
    }	

}
