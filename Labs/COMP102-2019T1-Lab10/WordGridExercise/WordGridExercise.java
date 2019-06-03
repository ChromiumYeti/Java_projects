// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/** WordGridExercise 
 * lets the user load, edit, and save a 2D table of words. 
 * The table is represented by a 2D array of Strings, using null
 *    to represent empty cells. 
 */
public class WordGridExercise{
    // Fields
    private int selectedRow = 0;  // selected cell
    private int selectedCol = 0;

    private String currentWord = "-";

    private int LEFT =50;  // position of left top corner of table
    private int TOP = 20;
    private int WIDTH = 60;   // size of cells
    private int HEIGHT = 20;

    private String[][] wordGrid = new String[10][8];

    /** Display the grid of words.
     *  Draw a rectangle for every element, 
     *   but only draw the string if it is not null
     */
    public void redisplay(){
        UI.clearGraphics();
        UI.setColor(Color.black);
        /*# YOUR CODE HERE */

        //highlights the selected cell
        UI.setColor(Color.red);
        UI.drawRect(this.LEFT+this.selectedCol*this.WIDTH,
            this.TOP+this.selectedRow*this.HEIGHT,
            this.WIDTH, this.HEIGHT);
    }

    /*
     * Replace every word in the table by the word in upper case. 
     */
    public void upperCase(){
        /*# YOUR CODE HERE */

        this.redisplay();
    }

    /*
     * Find every cell that contains a word and has an empty cell to its right,
     * and copy the word into the empty cell.
     * (Note, if the cell that was empty but now has a word has an empty cell
     * to its right, then the word could be copied to that empty cell.)
     */
    public void fillRight(){
        /*# YOUR CODE HERE */

        this.redisplay();
    }

    /**
     *  Load file into the array of words
     *  File represented as a sparse array:
     *   first line has size (number of rows and cols)
     *   other lines have row, col, entry for each non-null element
     *  Construct array of correct size, then read and add every entry.
     */
    public void loadSparse(){
        try{
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            /*# YOUR CODE HERE */

            sc.close();
        }
        catch(IOException e){UI.println("Fail: " + e);}
    }

    /** ---------- The code below is already written for you ---------- **/

    /**
     * Utility method: 
     * Read each line in a file into a list of Strings
     * Returns the list
     * You do not have to use this method if you do not want to.
     */
    public ArrayList<String> readAllLines(String fname){
        ArrayList<String> ans = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(fname));
            while (scan.hasNext()){
                ans.add(scan.nextLine());
            }
            scan.close();
        }
        catch(IOException e){UI.println("File reading failed"+e);}
        return ans;
    }

    /** Respond to buttons events */
    public void setEntry(){
        this.wordGrid[this.selectedRow][this.selectedCol] = this.currentWord;
        this.redisplay();
    }

    public void deleteEntry(){
        this.wordGrid[this.selectedRow][this.selectedCol] = null;
        this.redisplay();
    }

    public void loadWords(){
        this.loadSparse();
        this.redisplay();
    }

    /** Respond to textField entries */
    public void setWord(String value){
        this.currentWord = value;
        this.redisplay();
    }

    /** Respond to mouse events */
    public void doMouse(String action, double x, double y) {
        if (action.equals("released")){
            int c = ((int)x - this.LEFT)/ this.WIDTH;
            int r = ((int)y - this.TOP)/ this.HEIGHT;
            if (r >= 0 && r < this.wordGrid.length && c >=0 && c < this.wordGrid[0].length){
                this.selectedRow = r;
                this.selectedCol = c;
                this.redisplay();
            }
        }
    }

    // Main
    public static void main(String[] arguments){
        WordGridExercise obj = new WordGridExercise ();
        UI.setMouseListener( obj::doMouse );
        UI.addTextField("Word", obj::setWord );
        UI.addButton("Set Entry", obj::setEntry);
        UI.addButton("Delete Entry", obj::deleteEntry);
        UI.addButton("Uppercase", obj::upperCase);
        UI.addButton("Fill Right", obj::fillRight);
        UI.addButton("Load Words", obj::loadWords);
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0); // expand Graphic Pane area
        obj.redisplay();
    }	
}
