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

/** ImageExercise
 *  Draw Images made of constructed colours.
 */

// Hint: 	The Color class has a constructor with three parameters that are
// the red, green, and blue components of the Color, eg new Color(20, 200, 100);
// The arguments must be integers between 0 and 255.
// You can make random integers between 0 and 255 using
// int red = (int)(Math.random()*256);

public class ImageExercise{

    public static final double LEFT = 40;   // left side of the grid
    public static final double TOP = 40;    // top of the grid

    /**
     * Draw a square grid board with white squares.
     * Position of the grid given by LEFT and TOP
     * num is the number of rows and columns of squares 
     */
    public void drawGridBoard(int num){
        double boardSize = 360;  // The size of the board on the window

        for (int row = 0; row < boardSize; row++) {
            double y = TOP + row*num;
            for (int col = 0; col < boardSize; col++) {
                double x = LEFT +col*num;
                UI.drawRect(x,y, num, num);
            }
        }

    }

    /** 
     * Draw an image made of squares of random colours
     * rows and cols specify the number of rows and colums of squares
     * The individual squares are 10x10 units
     * Position of the grid given by LEFT and TOP
     */
    public void drawRandomImage(int rows, int cols){
        double size = 10; // Size of the individual squares

        for (int row = 0; row < rows; row++) {
            double y = TOP + row*size;
            for (int col = 0; col < cols; col++) {
                double x = LEFT +col*size;
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);
                Color color = new Color(r, g, b);
                UI.setColor(color);
                UI.fillRect(x,y, size, size);
            }
        }
    }

    /**
     * Draw an image made of coloured squares that is a smooth
     *  gradient from red at the top to green at the bottom.
     * Each square should be 2x2 units.
     */
    public void drawGradient(int rows, int cols){
        double size = 2;    // Size of the individual squares
        int r = 255;
        int g = 0;
        int b = 0;
        int scaleY = 255/rows;
        //int scaleX = 255/cols;
        //for (int col = 0; col < cols; col++) {
        //double x = LEFT+col*size;
        double x = LEFT;
        for (int row = 0; row < rows; row++) {
            double y = TOP + row*size;
            if(r>0){r=r-1*scaleY;}
            if(g<255){g=g+1*scaleY;}
            Color color = new Color(r, g, b);
            UI.setColor(color);
            //UI.fillRect(x,y, size, size);
            UI.fillRect(x,y, cols*size, size);
        //}
        }

    }

}
