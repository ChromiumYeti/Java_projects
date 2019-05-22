// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

public class RunImageExercise{

    /**
     * Sets up an interface.
     * The actions on the buttons ask for the size of the grid and then call the
     * method to draw the grid.
     */
    public static void main(String[] args){
        ImageExercise ie = new ImageExercise();
        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Grid", 
            ()->ie.drawGridBoard(UI.askInt("Grid size: ")));
        UI.addButton("Random Image", 
            ()->ie.drawRandomImage(UI.askInt("Rows: "),UI.askInt("Cols: ")));
        UI.addButton("Gradient Image", 
            ()->ie.drawGradient(UI.askInt("Rows: "),UI.askInt("Cols: ")));
        UI.addButton("Quit", UI::quit);
    }	
}    
