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

public class RunNameTagPrinter {

/** Make buttons to let the user run the methods in NamePrinter */
    public static void main(String[] args){
	NameTagPrinter ntp = new NameTagPrinter();
        UI.initialise();                           // initialise the UI window.
        UI.addButton("Print", ntp::printNameTag ); // make buttons and specify
        UI.addButton("Draw", ntp::drawNameTag );   // what actions they do.
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0.4);
    }

}
