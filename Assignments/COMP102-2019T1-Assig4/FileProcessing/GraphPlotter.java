// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 4
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class GraphPlotter {

    // Constants for plotting the graph
    public static final double GRAPH_LEFT = 50;
    public static final double GRAPH_RIGHT = 550;
    public static final double GRAPH_BASE = 400;
    /**
     * Plot a graph of a sequence of numbers read from a file using +'s for each point.
     * The origin of the graph should be at (GRAPH_LEFT, GRAPH_BASE)
     * The method should ask the user for the name of a file
     *  then read all the numbers from the file into an ArrayList.
     * It should then plot the numbers:
     *  - Draw two axes
     *  - Plot each number as a small +.
     *  - The x value of the first point should be at GRAPH_LEFT, and
     *    the last point should be at GRAPH_RIGHT.
     *  - The points should be separated by (GRAPH_RIGHT - GRAPH_LEFT)/(number of points - 1)
     * Hints:
     *   use the readAllNumbers method from the lab exercise
     *   look at the model answers for the Temperature Analyser problem from assignment 3.
     */
    public ArrayList<Double> readAllNumbers(String fname){
        ArrayList<Double> ans = new ArrayList<Double>();
        try {
            
            Scanner scan = new Scanner(new File(UIFileChooser.open("Open Graph plotting data file")));
            UI.clearGraphics();
            while (scan.hasNext()){
                if (scan.hasNextDouble()){
                    ans.add(scan.nextDouble());
                }
                else {
                    scan.next();  // throw away any non-numbers
                }
            }
            scan.close();
        }
        catch(IOException e){UI.println("File reading failed");}
        return ans;
    }

    public void plotGraph() {
        ArrayList<Double> numbers = this.readAllNumbers("");
        double count = numbers.size();
        double maxLevel = Collections.max(numbers);
        double i = GRAPH_LEFT-(GRAPH_RIGHT - GRAPH_LEFT)/(count-1);
        double step = (GRAPH_RIGHT - GRAPH_LEFT)/(count - 1);

        UI.setColor(Color.black);
        for(double plotNum : numbers){
            i=i+step;
            this.plotCross(i,GRAPH_BASE-plotNum);
            //UI.println(plotNum);
        }
        UI.drawLine(GRAPH_LEFT, GRAPH_BASE, GRAPH_LEFT+count*step, GRAPH_BASE); //Horizontal
        UI.drawLine(GRAPH_LEFT, GRAPH_BASE, GRAPH_LEFT, GRAPH_BASE-maxLevel); //Vertical
        //UI.drawLine(GRAPH_RIGHT, GRAPH_BASE, GRAPH_RIGHT, GRAPH_BASE-maxLevel); //Vertical bar 2 to test GRAPH_RIGHT
    }

    public void plotCross(double x, double y) {
        double length = 3;
        UI.setColor(Color.black);
        UI.drawLine(x-length,y,x+length,y); //Horizontal
        UI.drawLine(x,y+length,x,y-length); //Vertical
    }
}
