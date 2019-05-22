// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

/** Run ForeachLoopsExercise methods */

public class RunForeachLoopsExercise{

    public static void main(String[] args){
        ForeachLoopsExercise fle = new ForeachLoopsExercise();
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("squareNumbers", fle::squareNumbers);
        UI.addButton("addBigNumbers", fle::addBigNumbers);
        UI.addButton("THWords", fle::printTHWords);
        UI.addButton("drawDots", fle::drawDots);
        UI.addButton("Quit", UI::quit );
    }
}
