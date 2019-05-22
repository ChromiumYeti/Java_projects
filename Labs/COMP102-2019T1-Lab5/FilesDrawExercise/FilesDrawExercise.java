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

/**
 * Exercises for programs that read data from files.
 */

public class FilesDrawExercise{

    public static final double DIAM = 20;  // The diameter of the circles in drawCircles.

    /**
     * Reads a file called "circle-positions.txt"
     * The first line of the file has the number of circles to draw
     * Each later line contains two numbers - the x and y positions of a circle
     * The method should read the first number,  
     *  then read all the lines for the circles (use readSomeLines(...)
     *  then loop through all the line, pulling out the x and y of each position,
     *   setting a colour, and then drawing a circle (size 20) at the position.
     * eg, if a line of the file has 120 350 on it, then
     *  it draws a circle centered at (120, 350).
     * You can make them all the same colour or random colours
     */
    public void drawCircles(){
        int num = (int) lines.nextInt();
        while(scan.nextLine()){
            int x;
            int y;
            UI.drawOval(x,y,DIAM,DIAM);

        }
    }

    /**
     * Reads count lines from the Scanner and returns a list of the lines
     */
    public ArrayList<String> readSomeLines(Scanner scan, int count){
        ArrayList<String> lines = new ArrayList<String>();
        for(int i = 0; i < count; i++){
            lines.add(scan.nextLine());
        }
        return lines;
    }

    /**
     * Read a file called "names.txt" containing  of names and positions,
     * and draw them on the graphics pane.
     * The first line of the file has the number of names in the file
     * Each remaining line of the file has two numbers (x and y) and a name,
     * followed by three integers specifying the color to draw the name.
     * For each line, it sets the color, then draws the name at the position.
     * If the three colour integers are in r, g, and b, then you can set the colour
     * using  UI.setColor(new Color(r, g, b)));
     */
    public void drawNames(){
        /*# YOUR CODE HERE */

    }

}
