
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 5
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Renders plain ppm images onto the graphics panel
 *  ppm images are the simplest possible colour image format.
 */

public class ImageRenderer{
    public static final int TOP = 20;   // top edge of the image
    public static final int LEFT = 20;  // left edge of the image
    public static final int PIXEL_SIZE = 2;  

    // CORE

    /** 
     * Renders a ppm image file.
     * Asks for the name of the file and opens a Scanner
     * then calls renderImageHelper, passing the Scanner.
     */
    public void renderImageCore(){
        //String format = "";
        try {
            Scanner sc = new Scanner(new File(UIFileChooser.open("Open PPM/PGM File")));
            UI.clearGraphics();
            UI.clearText();
            while (sc.hasNext()){
                if (sc.hasNext("P3")){
                    //format = sc.next();
                    // The next token is skipped if the above is there, even if the string that comes out is correct
                    if (sc.hasNextInt()){
                        sc.nextInt();
                    }
                    else if (sc.hasNext("#")){
                        sc.nextLine();
                        sc.next();
                    }
                    else {
                        sc.next();// Should be throwing away any non-numbers

                    }
                    //UI.printf("Format: %s\n", format);
                    UI.println("Format: P3");
                    this.renderImageHelper(sc);   
                }
                else if (sc.hasNext("P2")){
                    if (sc.hasNextInt()){
                        sc.nextInt();
                    }
                    else {
                        sc.next();// Should be throwing away any non-numbers

                    }
                    UI.println("Format: P3");
                    this.renderImageHelperGreyScale(sc);    
                }
                else {
                    UI.println("Incorrect file type");
                }
            }
            sc.close();
        }
        catch(IOException e){UI.println("File reading failed");}

    }

    /** Core:
     * Renders a ppm image file, given an open Scanner 
     * Renders the image at position (LEFT, TOP).
     * Each pixel of the image is rendered by a square of size PIXEL_SIZE
     * Assumes that
     * - the colour depth is 255,
     * - there is just one image in the file (not "animated"), and
     * - there are no comments in the file.
     * The first four tokens are "P3", number of columns, number of rows, 255
     * The remaining tokens are the pixel values (red, green, blue for each pixel)
     * Hint: to draw the pixels, it is probably easiest to have a nested for loop
     *  that will repeatedly
     *  - read the next three numbers from the scanner
     *  - construct the Color and set UI's color
     *  - draw the pixel.
     *  (ie, don't construct an ArrayList of numbers).
     */
    public void renderImageHelper(Scanner sc){
        //String format = sc.next();
        int cols = (int) sc.nextInt();
        int rows = (int) sc.nextInt();
        int colourDepth = (int) sc.nextInt();
        int convert = 255/colourDepth; 
        UI.printf("Dimensions: %d x %d\nColour depth: %d\n", cols, rows, colourDepth);
        while (sc.hasNext()){
            for (int row =0; row <rows; row++) {
                double y = TOP + row*PIXEL_SIZE;
                for (int col = 0; col <cols; col++) {
                    double x = LEFT+col*PIXEL_SIZE;
                    int r = (int) sc.nextInt()*convert;
                    int g = (int) sc.nextInt()*convert;
                    int b = (int) sc.nextInt()*convert;
                    UI.setColor(new Color(r, g, b));
                    UI.fillRect(x,y, PIXEL_SIZE, PIXEL_SIZE);
                    //UI.printf("Coords: %d %d\t RGB %d %d %d\n", col, row, r, g, b);
                }
            }
        }

    }

    public void renderImageHelperGreyScale(Scanner sc){
        //String format = sc.next();
        int cols = (int) sc.nextInt();
        int rows = (int) sc.nextInt();
        int colourDepth = (int) sc.nextInt();
        int convert = 255/colourDepth; 
        UI.printf("Dimensions: %d x %d\nColour depth: %d\n", cols, rows, colourDepth);
        while (sc.hasNext()){
            for (int row =0; row <rows; row++) {
                double y = TOP + row*PIXEL_SIZE;
                for (int col = 0; col <cols; col++) {
                    double x = LEFT+col*PIXEL_SIZE;
                    int c = (int) sc.nextInt()*convert;
                    UI.setColor(new Color(c, c, c));
                    UI.fillRect(x,y, PIXEL_SIZE, PIXEL_SIZE);

                }
            }
        }
    }

    /** Completion
     * Renders a ppm image file which may be animated
     * There may be multiple images in the file, each with their own header and pixel values.
     * Asks for the name of the file, then renders the image at position (LEFT, TOP).
     * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
     * Renders each image in the file in turn with 200 mSec delay.
     * Repeats the whole sequence 3 times.
     */
    public void renderAnimatedImage(){
        try {
            Scanner asc = new Scanner(new File(UIFileChooser.open("Open PPM/PGM File")));
            UI.clearText();
            UI.clearGraphics();

            if (asc.hasNext("P3")){
                this.renderAnimHelper(asc);
                this.renderAnimHelper(asc);
                this.renderAnimHelper(asc);
            }

            else {
                UI.println("Incorrect file type");
            }
            asc.close();
        }
        catch(IOException e){UI.println("File reading failed");}
    }
    public void renderAnimHelper(Scanner asc){
        int maxFrames = 14;
                //int totalReps = 10;
                //for (int repCount = 1; repCount < totalReps; repCount++) {
                    while (asc.hasNext()){
                    
                        for (int frameCount = 1; frameCount < maxFrames; frameCount++) {
                            String format = asc.next();
                            int cols = (int) asc.nextInt();
                            int rows = (int) asc.nextInt();
                            int colourDepth = (int) asc.nextInt();
                            int convert = 255/colourDepth; 


                            for (int row =0; row <rows; row++) {
                                double y = TOP + row*PIXEL_SIZE;
                                for (int col = 0; col <cols; col++) {
                                    double x = LEFT+col*PIXEL_SIZE;
                                    int r = (int) asc.nextInt()*convert;
                                    int g = (int) asc.nextInt()*convert;
                                    int b = (int) asc.nextInt()*convert;
                                    UI.setColor(new Color(r, g, b));
                                    UI.fillRect(x,y, PIXEL_SIZE, PIXEL_SIZE);
                                    //UI.printf("Coords: %d %d\t RGB %d %d %d\n", col, row, r, g, b);
                                }
                            }
                            UI.sleep(100);
                            UI.clearGraphics();
                            UI.printf("Frame Count: %d\n",frameCount); //For debug
                        }
                        
                    }
                    //UI.printf("Rep Count: %d\n",repCount); //For debug
                //}
    }
}
