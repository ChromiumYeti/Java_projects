// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 4
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.lang.Comparable;

/**
 * SalesVisualiser
 * Reads an order from a file and produces a bar graph of the data
 */

public class SalesVisualiser{

    // Constants for plotting the graph
    public static final double GRAPH_LEFT = 50;
    public static final double GRAPH_RIGHT = 650;
    public static final double GRAPH_BASE = 400;
    public static final double MONTH_WIDTH = (GRAPH_RIGHT-GRAPH_LEFT)/12;  // the width for each set of three bars
    public static final double BAR_WIDTH = 12;    // the width of each bar

    /**
     * Asks the user for the name of a file containing the details of sales
     *  reported by dealers over the last three years, and then produces a
     *  bar graph of the data, showing the sales for each month, with different
     *  color bars for each year.
     * Each line of a sales data file contains
     *    a year, a month, and a series of sales from the dealers
     *    There may be a different number of sales on each line.
     * For example:
     *   2016 01 21 15 32 12 2 7
     *   2016 02 5 18 12
     *   :
     *   2017 01 16 3 2 4 1 8 4 13
     *   2017 Feb 41 3
     *   :
     * There is no guarantee that the lines are in order of date
     * The total sales in any month will never be over 200.
     * 
     * The method should draw a bar graph with 12 sets of bars, one set for each month
     * Each set should have
     *  a red bar for the 2016 data,
     *  a green bar for the 2017 data, and
     *  a blue bar for the 2018 data
     * The height of the bar should be the total number of sales in that month
     * Hints:
     *   Use the readAllLines method from the lab exercise and a Scanner for each line
     *   After getting the year and month from the Scanner, you will need a loop to add
     *       up all the sales on each line.
     *   Look carefully at the example file and the example output.
     *   
     *   GRAPH_LEFT = 50;
     *   GRAPH_RIGHT = 650;
     *   GRAPH_BASE = 400;
     *   MONTH_WIDTH = (GRAPH_RIGHT-GRAPH_LEFT)/12;  // the width for each set of three bars
     *   BAR_WIDTH = 12;    // the width of each bar
     */
    
    //Tried to finish, but ran out of time.

    public void graphSales() {
        ArrayList<String> lines = new ArrayList<String>();

        // double maxLevel = Collections.max(lines);
        //double i = GRAPH_LEFT-(GRAPH_RIGHT - GRAPH_LEFT)/(count-1);
        int i=0;

        try {
            Scanner scan = new Scanner(new File(UIFileChooser.open("Sales data file")));
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
            scan.close();
        } catch (IOException e) { UI.println("File failure: " + e); }

        Collections.sort(lines);
        for ( String line : lines ){
            i=i+1;
            Scanner lineSc = new Scanner(line);
            int year = (int) lineSc.nextInt();
            int month = (int) lineSc.nextInt();
            int sales = 0;
            while (lineSc.hasNextInt()){
                sales = sales + (int) lineSc.nextInt();
            }

            UI.printf("%d, %d, %d\n", year, month, sales);
            UI.setColor(Color.red);
            UI.fillRect(GRAPH_LEFT-BAR_WIDTH+(BAR_WIDTH*i), GRAPH_BASE-sales, BAR_WIDTH-2, sales);

        }
        double count = lines.size();
        double step = (GRAPH_RIGHT - GRAPH_LEFT)/(count - 1);
        UI.setColor(Color.black);

        UI.drawLine(GRAPH_LEFT, GRAPH_BASE, GRAPH_LEFT+count*step, GRAPH_BASE); //Horizontal
        UI.drawLine(GRAPH_LEFT, GRAPH_BASE, GRAPH_LEFT, 0); //Vertical
        //UI.drawLine(GRAPH_RIGHT, GRAPH_BASE, GRAPH_RIGHT, GRAPH_BASE-maxLevel); //Vertical bar 2 to test GRAPH_RIGHT
    }
}