// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

public class RunFilesDrawExercise{

    public static void main(String[] args){
        FilesDrawExercise fde = new FilesDrawExercise();
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("draw circles", fde::drawCircles );
        UI.addButton("draw names", fde::drawNames );
        UI.addButton("Quit", UI::quit );
    }	
}
