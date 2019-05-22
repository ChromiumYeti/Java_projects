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

/** Four methods that use ArrayLists
 * cartoonCrowd(String filename):
 *      read values from file,
 *      create an ArrayList of objects,
 *      call methods on objects
 *  Uses an ArrayList. 
 *
 * doPlotNumbersCompareToMiddle():
 * doPlotNumbersCompareToNext():
 *      read numbers from file into an ArrayList of numbers
 *      then access values.
 *  Uses an ArrayList. 
 *
 * doReadAndReverse():
 *      read tokens from file into an ArrayList of Strings
 *      then access values in reverse order
 *  Uses an ArrayList. 
 *
 */

public class FilesArrayListExercise{

    public void doLittleCrowd() {
        this.cartoonCrowd("little-crowd.txt");
    }

    public void doBigCrowd() {
        this.cartoonCrowd("big-crowd.txt");
    }

    /**
     * cartoonCrowd:
     * Parameter is the name of a file.
     *    Reads a file specifying a collection of cartoonCharacters 
     * Each line contains a string and an x and y value.
     * Should create an ArrayList of CartoonCharacters
     * Using a while loop to read through the file
     * it should repeatedly
     *      read the three values on a line
     *      create a new CartoonCharacter with those values
     *      store the CartoonCharacter in the next place in the array
     * It should then, in turn,
     *   make each cartoonCharacter look left and frown, 
     *   then make each cartoonCharacter walk forward 40 units
     */
    public void cartoonCrowd (String filename){
        ArrayList <CartoonCharacter> figures = new ArrayList<CartoonCharacter>(); 
        try{
            Scanner sc = new Scanner(new File(filename));
            /*# YOUR CODE HERE */

        } catch(IOException e){UI.println("File reading failed");}
    }

    /**
     * Reads a sequence of numbers from the file "numbers.txt" into an ArrayList
     * Finds the number half way through the sequence of numbers
     * [if the size of the list is n, the middle number is at index (n-1)/2 ]
     * Then plots the numbers as a sequence of rectangles of width = 5 and
     * height = the number being plotted,
     * The color is
     *    green if the number is less than the middle number,
     *    black if it is equal to the middle number, 
     *    red   if the number is larger than the middle number,
     * Note: it has to read all the numbers before it can plot any of them.
     */
    public void doPlotNumbersCompareToMiddle(){
        double base = 450;
        UI.drawLine(0, base, 600, base);     // draws the base line
        ArrayList<Double> nums = new ArrayList<Double>(); // the ArrayList of numbers

        try{
            Scanner sc = new Scanner(new File("numbers.txt"));
            // read numbers from the file into the ArrayList
            /*# YOUR CODE HERE */

            sc.close();
        } catch(IOException e){UI.println("Fail: " + e);}
        // plot the numbers, 
        double x = 0; // x position of first bar (increment by 6 each time)
        /*# YOUR CODE HERE */

    }

    /**
     * Reads a sequence of numbers from the file "numbers.txt" into an ArrayList
     * Then plots the numbers as a sequence of rectangles of width = 5 and
     * height = the number being plotted,
     * The color is
     *    green if the number is less than the next number,
     *    black if it is equal to the next number, 
     *    red  if the number is larger than the next number, or it is the last number.
     * Note: it has to read all the numbers before it can plot any of them.
     */
    public void doPlotNumbersCompareToNext(){
        double base = 450;
        UI.drawLine(0, base, 600, base);     // draws the base line
        ArrayList<Double> nums = new ArrayList<Double>(); // the ArrayList of numbers

        try{
            Scanner sc = new Scanner(new File("numbers.txt"));
            // read numbers from the file into the ArrayList
            /*# YOUR CODE HERE */

            sc.close();
        } catch(IOException e){UI.println("Fail: " + e);}
        // plot the numbers, 
        double x = 0; // x position of first bar (increment by 6 each time)
        /*# YOUR CODE HERE */

    }

    /** 
     * Asks the user for a file, and reads each token from the file, storing
     * them in an ArrayList.
     *     It prints out the number of tokens it read and then
     * prints the tokens in reverse order.
     */
    public void doReadAndReverse(){
        ArrayList<String> tokens = new ArrayList<String>(); // the ArrayList of tokens
        try{
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            for (int i = 0; i<this.tokens.size()/2; i++){
                this.tokens.set( i, this.tokens.set( tokens.size() -1 -i), this.tokens.get(i));
            }

        } catch(IOException e){UI.println("File reading failed");}
    }

    /** ---------- The code below is already written for you ---------- **/
    /**
     * Utility method to list the contents of a file.
     */
    public void doShowFile(){
        String fname = UIFileChooser.open();
        UI.println("Contents of " + fname+":\n----------------");
        try{
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                UI.println(sc.nextLine());
            }
            sc.close();
            UI.println("--------------");
        } catch(IOException e){System.out.printf("Fail: %s\n", e);}
    }

    public static void main(String[] args){
        FilesArrayListExercise fale = new FilesArrayListExercise();
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Show file", fale::doShowFile);
        UI.addButton("CartoonCrowd (little)", fale::doLittleCrowd);
        UI.addButton("CartoonCrowd (big)", fale::doBigCrowd);
        UI.addButton("Plot Compare Mid", fale::doPlotNumbersCompareToMiddle);
        UI.addButton("Plot Compare Next", fale::doPlotNumbersCompareToNext);
        UI.addButton("ReadAndReverse", fale::doReadAndReverse);
        UI.addButton("Quit", UI::quit);
    }	

}
