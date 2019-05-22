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
import java.util.*;

/** FireworksDisplayExercise
 * Runs a fireworks display with waves of fireworks.
 * Each wave has lots of fireworks that start together
 * When they have all finished, it starts the next wave.
 * The "Go" button starts off the display.
 * The "Size" slider controls the number of fireworks in the next wave.
 */

public class FireworksDisplayExercise{

    private int numFireworks = 20;

    /**
     * Run the display (called by the Go button)
     */
    public void runDisplay(){
        // create a list of fireworks
        // (stored in local variable because only used in this method)
        ArrayList<Firework> wave = new ArrayList<Firework>();
        for (int i=0; i<numFireworks; i++){
            wave.add(this.makeFirework());
        }

        // main loop (goes forever)
        while (true){
            // redraw the background
            UI.clearGraphics();
            UI.setColor(Color.black);
            UI.fillRect(0, 0, 1000, 700);

            // draw all the fireworks and pause for 70 milliseconds
            /*# YOUR CODE HERE */

            UI.sleep(70); 

            // make all the fireworks take one step
            /*# YOUR CODE HERE */

            // find out if ALL the fireworks have finished,
            // (if there is one firework that is not finished, then
            //  they are not all finished)
            boolean allFinished = true;
            /*# YOUR CODE HERE */

            // if all the fireworks have finished, create a new wave:
            // create a new arraylist in wave and a new list of fireworks
            if (allFinished){
                /*# YOUR CODE HERE */

            }
        }
    }

    /**
     * Set the number of fireworks for the next wave
     *  (Have to convert to an int!)
     */
    public void setSize(double value){
        /*# YOUR CODE HERE */

    }

    /**
     * Make a new Firework at a random position, random color, random height.
     */
    public Firework makeFirework(){
        double x = 50+Math.random()*600;
        Color col = Color.getHSBColor((float)Math.random(), 1.0f, 1.0f);
        double height = 100+Math.random()*400;
        return new Firework(x, col, height);
    }

    /**
     * main method sets up the GUI with a button and a slider
     */
    public static void main(String[] args){
        FireworksDisplayExercise fde = new FireworksDisplayExercise();
        /*# YOUR CODE HERE */

        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(800, 600);
        UI.setDivider(0.0);     // hide the text pane
    }
}
