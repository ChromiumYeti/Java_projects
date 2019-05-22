
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 1
 * Name: Christopher Yee
 * Username: YEECHRI2
 * ID: 300508227
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various flags
 *
 * You can find lots of flag details (including the correct dimensions and colours)
 * from  http://www.crwflags.com/fotw/flags/    
 */

public class FlagDrawer{

    public static final double LEFT = 100;  // the left side of the flags
    public static final double TOP = 50;    // the top of the flags

    /**   CORE
     * Draw the flag of Belgium.
     * The flag has three vertical stripes;
     * The left is black, the middle is yellow, and the right is red.
     * The flag is 13/15 as high as it is wide (ratio 13:15).
     */
    public void drawBelgiumFlag(){
        UI.clearGraphics();
        UI.println("Belgium Flag");
        double width = UI.askDouble("How wide: ");
        double height = width * 13/15;
        UI.setColor(Color.black);
        UI.fillRect(LEFT, TOP, width/3, height);
        UI.setColor(Color.yellow);
        UI.fillRect(LEFT+width/3, TOP, width/3, height);
        UI.setColor(Color.red);
        UI.fillRect(LEFT+width*2/3, TOP, width/3, height);

    }

    /** CORE
     *  The Swiss flag consists of a red square with a white cross in the center
     *  The cross can be drawn as a horizontal rectangle and a vertical rectangle.
     */
    public void drawSwissFlag() {
        UI.println("Swiss Flag: ");
        UI.clearGraphics();
        double size = UI.askDouble("How wide: ");
        double crossShortDim = size * 6/32;
        double crossLongDim = size * 20/32;
        double crossShortDist = size * 6/32;
        double crossLongDist = size * 13/32;
        UI.setColor(Color.red.brighter());
        UI.fillRect(LEFT, TOP, size, size);
        UI.setColor(Color.white);
        UI.fillRect(LEFT+crossLongDist, TOP+crossShortDist, crossShortDim, crossLongDim);
        UI.setColor(Color.white);
        UI.fillRect(LEFT+crossShortDist, TOP+crossLongDist, crossLongDim, crossShortDim);

    }

    /** COMPLETION
     *  The unofficial flag of Palmyra Atoll has three horizontal stripes with part of a yellow circle.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  The top stripe is red and is 10/20 of the height of the flag.
     *  The middle stripe is blue and is 7/20 of the height of the flag.
     *  The bottom stripe is yellow and is 3/20 of the height of the flag.
     *  The diameter of the yellow circle is 1/2 of the width of the flag, 
     *      and its top is slightly below the top of the flag.
     *  HINT: think in which order to paint the different parts of the flag.
     */
    public void drawPalmyraFlag() {
        UI.clearGraphics();
        UI.println("Palmyra Flag");
        double width = UI.askDouble("How wide: ");
        double height = width * 2/3;
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width, height/2);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+width/4, TOP+height/25, width/2, height*3/4); //height*3/4 = width/2
        UI.setColor(Color.blue);
        UI.fillRect(LEFT, TOP+height/2, width, height*0.35);
        UI.setColor(Color.yellow);
        UI.fillRect(LEFT, TOP+height*0.85, width, height*0.15);
    }


    /** COMPLETION
     * Pacman flag
     * A yellow pacman on a black background chasing white, red, and green dots to the right.
     */
    public  void drawPacman() {
        UI.clearGraphics();        
        UI.println("Pacman Flag");
        double width = UI.askDouble("How wide: ");
        double height = width * 81/142;
        double pacmanSize = height *2/3;
        double pacmanFill = 300;
        double pacmanMouthStart = 30;
        double dotSize = height/7;
        double dotOffset = dotSize *1.75;
        UI.setColor(Color.black);
        UI.fillRect(LEFT, TOP, width, height);
        //UI.drawImage("pacman.gif",LEFT,TOP, width, height); //used for alignment
        UI.setColor(Color.yellow);
        //UI.fillOval(LEFT+width/4-pacmanSize/2, TOP+height/2-pacmanSize/2, pacmanSize, pacmanSize);
        UI.fillArc(LEFT+width/4-pacmanSize/2, TOP+height/2-pacmanSize/2,pacmanSize, pacmanSize,pacmanMouthStart,pacmanFill);
        UI.setColor(Color.white);
        UI.fillOval(LEFT+width/2-dotSize/2, TOP+height/2-dotSize/2, dotSize, dotSize);
        UI.setColor(Color.red);
        UI.fillOval(LEFT+width/2-dotSize/2+dotOffset, TOP+height/2-dotSize/2, dotSize, dotSize);
        UI.setColor(Color.green);
        UI.fillOval(LEFT+width/2-dotSize/2+dotOffset*2, TOP+height/2-dotSize/2, dotSize, dotSize);
        //Dot positions could be done using an incremental loop

    }

    /** CHALLENGE
     *  The flag of the Seychelles
     *  Width = 2 x height
     *  Radiating triangles.
     */
    public  void drawSeychellesFlag(){
        UI.clearGraphics();        
        UI.println("Seychelles Flag");
        double width = UI.askDouble("How wide: ");
        double height = width * 1/2;
        double BOT = TOP + height;
        double RIGHT = LEFT + width;
        int nPts = 3;
        int nPtsRed = 4;
        double blueXPts[] = {LEFT,LEFT,LEFT+width/3};
        double blueYPts[] = {BOT,TOP,TOP};
        double yellowXPts[] = {LEFT,LEFT+width/3,LEFT+width*2/3};
        double yellowYPts[] = {BOT,TOP,TOP};
        double redXPts[] = {LEFT,LEFT+width*2/3,RIGHT, RIGHT};
        double redYPts[] = {BOT,TOP,TOP,TOP +height/3};
        double whiteXPts[] = {LEFT,RIGHT,RIGHT};
        double whiteYPts[] = {BOT,TOP +height/3,TOP +height* 2/3};
        double greenXPts[] = {LEFT,RIGHT,RIGHT};
        double greenYPts[] = {BOT,TOP +height* 2/3,BOT};
        Color darkBlue = new Color(3, 63, 134);
        Color darkYellow = new Color(251, 218, 86);
        Color darkRed = new Color(214,39,40);
        Color darkGreen = new Color(2,122,60);
        //UI.drawImage("seychelles.gif",LEFT,TOP-height*0.1, width*1.1, height*1.1); //used for alignment
        UI.setColor(darkBlue);
        UI.fillPolygon(blueXPts,blueYPts,nPts);
        UI.setColor(darkYellow);
        UI.fillPolygon(yellowXPts,yellowYPts,nPts);
        UI.setColor(darkRed);
        UI.fillPolygon(redXPts,redYPts,nPtsRed);
        UI.setColor(Color.white);
        UI.fillPolygon(whiteXPts,whiteYPts,nPts);
        UI.setColor(darkGreen);
        UI.fillPolygon(greenXPts,greenYPts,nPts);
    }


    /**   CHALLENGE
     * Draw the flag of China,
     * Width = 2/3 height,
     * Red background with larger star in corner with four gold stars around it
     * The little stars all point towards the larger star.
     * A full marks solution will have a method for drawing a 5 pointed star,
     * and call that method for each of the stars
     */
    public void drawChinaFlag() {
        UI.clearGraphics();        
        UI.println("China Flag");
        double width = UI.askDouble("How wide: ");
        double height = width * 2/3; //height should be 2/3 of the width, otherwise it would be vertical
        Color darkRed = new Color(204,0,0);
        Color gold = new Color(255,204,0);
        //double xPtsStar[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 }; 
        //double yPtsStar[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
        //double starPts[] = 
        //int nPts = 10;
        
        UI.setColor(darkRed);
        UI.fillRect(LEFT, TOP, width, height);
        UI.setColor(gold);
        UI.fillArc (LEFT, TOP, width/7, width/7, -108, 36); //Top Point 1
        UI.fillArc (LEFT+(width/14), TOP+(width/14), width/7, width/7, 180, 36); //Point 2
        UI.fillArc (LEFT, TOP, width/7, width/7, -108, 36); //Point 3
        UI.fillArc (LEFT, TOP, width/7, width/7, -108, 36); //Point 4
        UI.fillArc (LEFT, TOP, width/7, width/7, -108, 36); //Point 5
        //UI.fillPolygon(xPtsStar,yPtsStar,nPts);
        
        
    }



}
