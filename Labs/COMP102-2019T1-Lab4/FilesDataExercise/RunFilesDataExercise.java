// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

public class RunFilesDataExercise{

    public static void main(String[] args){
        FilesDataExercise fde = new FilesDataExercise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("sum numbers", fde::sumNumbers );
        UI.addButton("longest word", fde::printLongestWord );
        UI.addButton("first words", fde::printFirstWords );
        UI.addButton("large courses", fde::countLargeCourses );
        UI.addButton("total order", fde::computeTotalOrder );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);
    }	
}
