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

/** The CirclesExercise program is a very simple program that lets the user
 *  place small and large circles on the graphics pane using the mouse.
 *  It has three buttons: Clear, Small, and Large.
 *  The "Clear" button should clear the graphics pane.
 *  The "Small" button should change the "current size" to 10,
 *  and the "Large" button should change the current size to 30.
 *  The current size should be stored in a field.
 *  When the user releases the mouse at any point on the graphics pane, the
 *  program should draw a blue circle of the current size centered at that point.
 */

public class CirclesExercise{
    //field to record the current size of the circles (10 or 30)
    //initial size should be 10
    /*# YOUR CODE HERE */

    /*# YOUR CODE HERE */

    /** Respond to mouse events.
     * This program only does something on a released event - it draws a circle
     * of the current size centered at the position the mouse was released
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("released")){
            /*# YOUR CODE HERE */

        }
    }

    /** main method set up the GUI:
     *  - set the mouse listener
     *  - add three buttons Clear, Small, and Large
     */
    public static void main(String[] arguments){
        CirclesExercise ce = new CirclesExercise();
        /*# YOUR CODE HERE */

        UI.addButton("Quit", UI::quit );
        UI.println("Click the mouse in the graphics pane");
    }	
}
