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
import javax.swing.JColorChooser;

/** Paramterised Shapes: draw tricolour flags and game boards */
public class ParameterisedShapes{

    //Constants for CORE  (three strip flags)
    public static final double FLAG_WIDTH = 200;
    public static final double FLAG_HEIGHT = 133;

    //Constants for COMPLETION
    public static final double BOARD_LEFT = 15;  // Left side of each row
    public static final double BOARD_TOP = 15;   // Top of the first row
    public static final double ROW_SIZE = 40;    // Height of each row.
    public static final double DISH_WIDTH = ROW_SIZE-4;      // Size of the dishes
    public static final double DISH_HEIGHT = DISH_WIDTH-10;  
    public static final double PEBBLE_DIAM = 10; // Size of the pebbles

    /**   CORE
     * asks user for a position and three colours, then calls the
     * drawTriColorFlag method, passing the appropriate arguments
     */
    public void doCore(){
        double left = UI.askDouble("Left of flag");
        double top = UI.askDouble("Top of flag");
        boolean horiz = UI.askBoolean("Are the stripes horizontal?");
        UI.println("Now choose the colours");
        Color stripe1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
        Color stripe2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
        Color stripe3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
        this.drawThreeStripeFlag(left, top, horiz, stripe1, stripe2, stripe3);
    }

    /**   CORE
     * draws a three colour flag at the given position consisting of
     * three equal size stripes of the given colors
     * The stripes are horizontal or vertical
     * The size of the flag is specified by the constants FLAG_WIDTH and FLAG_HEIGHT
    FLAG_WIDTH = 200;
    FLAG_HEIGHT = 133;
     */
    public void drawThreeStripeFlag(double x, double y, boolean horiz, java.awt.Color stripe1,  java.awt.Color stripe2,  java.awt.Color stripe3){

        if (horiz) {
            UI.setColor(stripe1);
            UI.fillRect(x, y, FLAG_WIDTH, FLAG_HEIGHT/3); 
            UI.setColor(stripe2);
            UI.fillRect(x, y+FLAG_HEIGHT/3, FLAG_WIDTH, FLAG_HEIGHT/3); 
            UI.setColor(stripe3);
            UI.fillRect(x, y+FLAG_HEIGHT*2/3, FLAG_WIDTH, FLAG_HEIGHT/3); 
        }
        else {
            UI.setColor(stripe1);
            UI.fillRect(x, y, FLAG_WIDTH/3, FLAG_HEIGHT); 
            UI.setColor(stripe2);
            UI.fillRect(x+FLAG_WIDTH/3, y, FLAG_WIDTH/3, FLAG_HEIGHT); 
            UI.setColor(stripe3);
            UI.fillRect(x+FLAG_WIDTH*2/3, y, FLAG_WIDTH/3, FLAG_HEIGHT);
        }
        UI.setColor(Color.black);
        UI.drawRect(x, y,FLAG_WIDTH, FLAG_HEIGHT);
    }

    /**   COMPLETION
     * Draws a pebble game board with five rows of increasing size
     *   The first row has 6 dishes, the second has 7 dishes, the third has 8, etc.
     *   The positions of the red and blue pebbles are shown in this table:
     *   (where the |'s separate the dishes)
     *     |   | r |   |   |   | b |
     *     |   | b | r |   |   |   |   |
     *     |   |   |   |   |   | r |   | b |
     *     | b |   |   | r |   |   |   |   |   |
     *     |   |   | b |   |   |   |   |   |   | r |
     *
     *  It uses the drawPebbleRow method which draws one row and the two pebbles in it.
     */
    public void doCompletion(){
        UI.clearGraphics();
        this.drawPebbleRow(1,6,2,6);
        this.drawPebbleRow(2,7,3,2);
        this.drawPebbleRow(3,8,6,8);
        this.drawPebbleRow(4,9,4,1);
        this.drawPebbleRow(5,10,10,3);
    }

    /**   COMPLETION
     * Draws a row of a pebble game. Parameters must be sufficient to specify
     * the position and size of the row, and the positions of the pebbles
     * Hint: It makes the code easier if you count from 0 rather than from 1
     * Hint: use the drawDish and drawPebble methods!
     * 
     *
    BOARD_LEFT = 15;  // Left side of each row
    BOARD_TOP = 15;   // Top of the first row
    ROW_SIZE = 40;    // Height of each row.
    DISH_WIDTH = ROW_SIZE-4;      // Size of the dishes
    DISH_HEIGHT = DISH_WIDTH-10;  
    PEBBLE_DIAM = 10; // Size of the pebbles
     */
    //Draws box width based on how many dishes and row location, 
    //places location of red pebble and places location of blue pebble
    public void drawPebbleRow(int rowNum, int numDishes, int redPos, int bluePos){
        UI.setColor(Color.black);
        UI.drawRect(BOARD_LEFT,BOARD_TOP+ROW_SIZE*rowNum,ROW_SIZE*numDishes, ROW_SIZE);
        for(int i=0; i <= numDishes-1; i++){
            this.drawDish(i*ROW_SIZE+BOARD_LEFT, rowNum*ROW_SIZE+BOARD_TOP);
            this.drawPebble((redPos-1)*ROW_SIZE+BOARD_LEFT, rowNum*ROW_SIZE+BOARD_TOP, Color.red);
            this.drawPebble((bluePos-1)*ROW_SIZE+BOARD_LEFT, rowNum*ROW_SIZE+BOARD_TOP, Color.blue);
        }

    }

    /**
     * Draw a dish in the square cell at (left,top)
     * Assumes the rows can be viewed as a sequence of square cells, each of
     * which contains a dish centered in the cell.
     */
    public void drawDish(double cellLeft, double cellTop){
        double dishLeft = cellLeft + ROW_SIZE/2 - DISH_WIDTH/2 ;
        double dishTop = cellTop + ROW_SIZE/2 - DISH_HEIGHT/2;
        UI.setColor(new Color(230, 230, 230));   // very light grey
        UI.fillOval(dishLeft, dishTop, DISH_WIDTH, DISH_HEIGHT);
        UI.setColor(Color.black);
        UI.drawOval(dishLeft, dishTop, DISH_WIDTH, DISH_HEIGHT);
    }

    /**
     * Draw a pebble in the square cell at (left,top)
     * Assumes the rows can be viewed as a sequence of square cells, each of
     * which contains a dish centered in the cell.
     */
    public void drawPebble(double cellLeft, double cellTop, Color pebbleColor){
        double pebbleTop = cellTop + ROW_SIZE/2 - PEBBLE_DIAM/2;
        double pebbleLeft = cellLeft + ROW_SIZE/2 - PEBBLE_DIAM/2;
        UI.setColor(pebbleColor);
        UI.fillOval(pebbleLeft, pebbleTop, PEBBLE_DIAM, PEBBLE_DIAM);
    }

}
