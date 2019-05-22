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

/** Draws flags of various countries.
 *
 * The correct dimensions of the official flags varies from country to country.
 * Many flags are 2/3 as high as they are wide.
 * It is fine on the flags of Bangladesh, Japan, etc to make the circles
 * exactly half the height of the flags.
 * The exact colours of the flags will also be difficult to match;
 * It is fine to use the standard colours: red, green, blue, orange.
 * You can find lots of details, including the correct dimensions and colours, of flags from
 * http://www.crwflags.com/fotw/flags/    
 *
 */
public class FlagExercise{

    // Constants
    public static final double LEFT = 100;  // the left side of the flags
    public static final double TOP = 50;    // the top of the flags

    /** Draw a flag of Japan at (LEFT,TOP) with the specified width.
     *  The flag has a white background and a red circle in the middle.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  Calculate 
     *  - the height of the flag (2.0/3.0 of the width)
     *  - the circle diameter (3.0/5.0 of the height)
     *  - and the left and top of the circle.
     *  Then draw the outline of the flag and the circle
     */
    public void drawJapanFlag(){
        UI.clearGraphics();
        double width = UI.askDouble("How wide: ");
        double height = width*2.0/3.0;
        /*# YOUR CODE HERE */

    }

    /** Draw a flag of Indonesia at (LEFT,TOP) with the specified width.
     *  The flag has two horizontal stripes;
     *  the top is red and the bottom is white.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     */
    public void drawIndonesiaFlag(){
        UI.clearGraphics();
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */

    }

    /** Draw a flag of Austria at (LEFT,TOP) with the specified width.
     *  The flag  has three horizontal stripes:
     *  the top and bottom are red and the middle is white.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     */
    public void drawAustriaFlag(){
        UI.clearGraphics();
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */

    }

    /** Draw a flag  of Bangladesh at (LEFT,TOP) with the specified width.
     *  The flag has a green background and
     *  a red circle in the middle (off-set to the left).
     *  The flag is 3/5 as high as it is wide (ratio 3:5).
     */
    public void drawBangladeshFlag(){
        UI.clearGraphics();
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */

    }

    /** Draw a flag of Niger at (LEFT,TOP) with the specified width.
     *  The flag has three horizontal stripes,
     *  orange at the top, white in the middle, green at the bottom,
     *  and an orange circle in the middle of the middle stripe.
     *  The flag is 6/7 as high as it is wide (ratio 6:7).
     */
    public void drawNigerFlag(){
        UI.clearGraphics();
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */

    }


}

