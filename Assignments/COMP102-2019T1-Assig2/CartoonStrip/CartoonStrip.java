// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 2
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.awt.Color;

/** Program to create simple animated cartoon strips using the
 *  CartoonCharacter class.  
 */

public class CartoonStrip{

    /** tellStory creates two cartoon characters on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the characters.
     */
    public void tellStory(){
        CartoonCharacter pastGuy = new CartoonCharacter(100, 150, "bob");//green
        CartoonCharacter futureGuy = new CartoonCharacter(300, 150, "alice");//blue
        futureGuy.lookLeft();
        pastGuy.frown();
        pastGuy.speak("Who Are you?");
        futureGuy.frown();
        futureGuy.speak("I am you.");
        futureGuy.walk(25);
        futureGuy.speak("From.");
        futureGuy.smile();
        futureGuy.speak("The.");
        futureGuy.walk(25);
        futureGuy.speak("Future!");
        futureGuy.walk(50);
        pastGuy.smile();
        pastGuy.speak("Really?");
        pastGuy.think("I've got a bad feeling..");
        pastGuy.frown();
        pastGuy.think("...about this...");
        futureGuy.speak("BYE!");
        futureGuy.walk(300);
        pastGuy.think("What!?");
        pastGuy.walk(10);
        pastGuy.walk(10);
        pastGuy.walk(10);
        pastGuy.walk(10);
        pastGuy.walk(10);
        pastGuy.lookLeft();
        pastGuy.think("Where did I go!?");
        pastGuy.lookRight();
        pastGuy.walk(20);
        pastGuy.walk(20);
        pastGuy.walk(20);
        pastGuy.walk(20);
        pastGuy.walk(20);
        pastGuy.lookLeft();
        pastGuy.lookRight();
        pastGuy.walk(25);
        futureGuy.lookRight();
        futureGuy.speak("                    LOOK OUT!");
        pastGuy.walk(25);
        pastGuy.lookLeft();
        pastGuy.smile();
        pastGuy.speak("Wait, what?");
        UI.setColor(Color.blue);
        UI.fillRect(295, 0, 80, 250);
        CartoonCharacter futureGuy2 = new CartoonCharacter(300, 150, "alice");//blue
        UI.setColor(Color.white);
        UI.fillRect(295, 0, 80, 250);
        futureGuy2.frown();
        futureGuy2.lookLeft();
        futureGuy2.lookRight();
        futureGuy2.smile();
        futureGuy2.lookLeft();
        CartoonCharacter pastGuy2 = new CartoonCharacter(0, 150, "bob");//green
        pastGuy2.walk(20);
        pastGuy2.walk(20);
        pastGuy2.walk(20);
        pastGuy2.walk(20);
        pastGuy2.walk(20);
        pastGuy2.frown();
        UI.setColor(Color.black);
        pastGuy2.speak("Who Are you?");
    }

    /** threeDancers creates three cartoon characters on the window.
     *  Then makes each character do the same little dance in turn,
     *  by calling the dance method.
     */
    public void threeDancers(){
        CartoonCharacter dancer1 = new CartoonCharacter(100, 150, "alice");//blue
        CartoonCharacter dancer2 = new CartoonCharacter(300, 150, "bob");//green
        CartoonCharacter dancer3 = new CartoonCharacter(500, 150, "casey");//yellow
        this.dance(dancer1);
        this.dance(dancer2);
        this.dance(dancer3);
    }

    /** Makes a character do a little dance.
     * Has one parameter - a CartoonCharacter object
     */
    public void dance(CartoonCharacter face){
        face.walk(5);
        face.lookLeft();
        face.walk(5);
        face.lookRight();
        face.walk(5);
        face.lookLeft();
        face.walk(5);
        face.lookRight();
        face.walk(20);
        face.speak("Never Gonna...");
        face.walk(20);
        face.speak("Give You...");
        face.walk(20);
        face.speak("Up...");
        face.lookLeft();
        face.walk(20);
        face.speak("Never Gonna...");
        face.walk(20);
        face.speak("Let You...");
        face.walk(20);
        face.speak("Down...");
        face.lookRight();
        face.speak("Never Gonna...");
        face.walk(20);
        face.speak("Run Around...");
        face.walk(20);
        face.speak("and...");
        face.walk(20);
        face.speak("Desert you...");
       
    }

}

