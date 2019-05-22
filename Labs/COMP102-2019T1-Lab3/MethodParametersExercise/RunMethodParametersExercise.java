// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

/** Run MethodParametersExercise methods */

public class RunMethodParametersExercise {

    /** Constructor: set up the user interface (already written for you) */ 
    public static void main(String[] args){
        MethodParametersExercise mpe = new MethodParametersExercise();
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("NameTags", mpe::doNameTags );
        UI.addButton("BottleSong", mpe::printBottleSong );
        UI.addButton("SignalFlag", mpe::drawSignalZeroFlag );
        UI.addButton("Quit", UI::quit );
    }
}
