// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** A very simple program that prints out a name tag in two different ways */
public class NameTagPrinter {

    //----------------- Printing -----------------------------------------
    /**
     * Ask for name and then print a nametag with
     * the name inside a box made of asterisks
     */ 
    public void printNameTag(){
        String name = UI.askString("What is your name");
        UI.println("*********************************");
        UI.println("*                               *");
        UI.println("*  Hi Everybody! I'm            *");
        UI.println("*                               *");
        UI.println("*          " + name + "               *");
        UI.println("*                               *");
        UI.println("*********************************");
        UI.println();
    }

    //----------------- Drawing -----------------------------------------
    /**
     * Ask for name and then draw a nametag on the graphics pane
     *  The rectangular nametag is 300 units wide and 150 units high
     *  and its left edge is 100 units over and its top is 70 units down
     */ 
    public void drawNameTag(){
        String name = UI.askString("What is your name");
        UI.setFontSize(24);
        UI.drawRect(100, 70, 300, 150);                // draws the outline of a rectangle
        UI.drawString("Helloooo, my name is", 120, 125);  // puts the string near the top
        UI.drawString(name,  200, 170);                // puts the name near the center
    }


}
