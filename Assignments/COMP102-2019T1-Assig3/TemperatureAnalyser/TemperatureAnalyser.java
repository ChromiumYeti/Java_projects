// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 3
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;

/** The program contains several methods for analysing the readings of the temperature levels over the course of a day.
 *  There are several things about the temperature levels that a user may be interested in: 
 *    The average temperature level.
 *    How the temperatures rose and fell over the day.
 *    The maximum and the minimum temperature levels during the day.
 */
public class TemperatureAnalyser{

    /* analyse reads a sequence of temperature levels from the user and prints out
     *    average, maximum, and minimum level and plots all the levels
     *    by calling appropriate methods
     */
    public void analyse(){
        UI.clearPanes();
        ArrayList<Double> listOfNumbers = UI.askNumbers("Enter levels, end with 'done': ");
        if (listOfNumbers.size() != 0) {
            this.printAverage(listOfNumbers);
            this.plotLevels(listOfNumbers);

            UI.printf("Maximum level was:  %.1f\n", this.maximumOfList(listOfNumbers));
            UI.printf("Minimum level was:  %.1f\n", this.minimumOfList(listOfNumbers));
        }
        else {
            UI.println("No readings");
        }
    }

    /** Print the average level
     *   - There is guaranteed to be at least one level,
     *   - The method will need a variable to keep track of the sum, which 
     *     needs to be initialised to an appropriate value.
     *  CORE
     */
    public void printAverage(ArrayList<Double> listOfNumbers) {
        //UI.println("method printAverage() is not implemented yet");  // remove when you have implemented your method
        double total = 0.0;
        int count = listOfNumbers.size();
        for(double num : listOfNumbers){
            total = total + num;
            //UI.printf("num: %.1f  \n", num);
        }
        double avg = total/count;
        UI.printf("Average Temperature Level: %.1f degrees. \n", avg);
    }

    /**
     * Plot a bar graph of the sequence of levels,
     * using narrow rectangles whose heights are equal to the level.
     * [Core]
     *   - Plot the bars.
     * [Completion]
     *   - Draws a horizontal line for the x-axis (or baseline) without any labels.
     *   - Any level greater than 400 should be plotted as if it were just 400, putting an
     *         asterisk ("*") above it to show that it has been cut off.
     * [Challenge:] 
     *   - The graph should also have labels on the axes, roughly every 50 pixels.
     *   - The graph should also draw negative temperature levels correctly.
     *   - Scale the y-axis and the bars so that the largest numbers and the smallest just fit on the graph.
     *     The numbers on the y axis should reflect the scaling.
     *   - Scale the x-axis so that all the bars fit in the window.
     */
    public void plotLevels(ArrayList<Double> listOfNumbers) {
        //UI.println("method plotLevels() is not implemented yet");  // remove when you have implemented your method
        int base = 420;              //base of the graph
        int left = 50;               //left of the graph
        int step = 25;               //distance between plotted points
        int count = listOfNumbers.size();
        int i=0;

        for(double num : listOfNumbers){
            i=i+1;
            UI.setColor(Color.blue);

            if (num > 400){
                num = 400;
                UI.setColor(Color.red);
                UI.drawString("*", (step/2)+step+step*i, base-num);
            }
            if (num < 0){
                UI.fillRect(step+step*i+1, base, step-2, num*-1);
                UI.setColor(Color.black);
                UI.drawLine(left, base, left, base+400);//-y axis
                for (int l=0; l >= -400; l=l+50){
                    UI.drawLine(left, base+l, left-5, base+l);
                }

            }
            //UI.printf("i= %d num: %.1f  \n", i, num);
            
                UI.fillRect(step+step*i+1, base-num, step-2, num);
            
        }

        UI.setColor(Color.black);

        UI.drawLine(left, base, left+step * count, base);//x axis
        for (int j=1; j < (left+step * count)/50; j++){
            UI.drawLine(left*j, base, left*j, base+5);
        }
        UI.drawLine(left, base, left, 0);//y axis
        for (int k=0; k <= 400; k=k+50){
            UI.drawLine(left, base-k, left-5, base-k);
        }

        UI.println("Finished plotting");
    }

    /** Find and return the maximum level in the list
     *   - There is guaranteed to be at least one level,
     *   - The method will need a variable to keep track of the maximum, which
     *     needs to be initialised to an appropriate value.
     *  COMPLETION
     */
    public double maximumOfList(ArrayList<Double> listOfNumbers) {
        //UI.println("method maximumOfList() is not implemented yet");  // remove when you have implemented your method
        double maxLevel = Collections.max(listOfNumbers);

        return maxLevel;  //remove when you have implemented your method
    }

    /** Find and return the minimum level in the list
     *   - There is guaranteed to be at least one level,
     *   - The method will need a variable to keep track of the minimum, which
     *     needs to be initialised to an appropriate value.
     *  COMPLETION
     */
    public double minimumOfList(ArrayList<Double> listOfNumbers) {
        //UI.println("method minimumOfList() is not implemented yet");  // remove when you have implemented your method
        double minLevel = Collections.min(listOfNumbers);

        return minLevel;  //remove when you have implemented your method
    }

}
