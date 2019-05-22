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

public class ConditionalsExercise{

    public static final double LEFT = 100; //position of flags for drawAFlag
    public static final double TOP = 100; 

    /**
     * Ask user for an integer
     * if the number is a valid hour (1 to 12), then it prints the number in
     * the form  "The time is 6 o'clock" (if they entered 6)
     * otherwise it prints  "That number is not a valid time"
     */
    public void validHour(){
        int hour = UI.askInt ("Enter valid hour (1-12)");
        if (hour >= 1 && hour <= 12){
            UI.printf("The time is %d o'clock \n", hour);   
        }
        else{
            UI.println("That number is not a valid time");   
        }

    }

    /**
     * Asks the user to enter a word.
     * Says "Yes, that fits" if the word starts with "p" and is 7 characters long,
     * and "Sorry, that word won't work" otherwise.
     * You can use the length() method on a string to find out how long it it.
     */
    public void wordGame(){
        String word = UI.askString ("Enter a p word: ");

        if (word.startsWith("p") && word.length() == 7){
            UI.println("Yes, that fits");   
        }
        else {
            UI.println("Sorry, that word won't work");      
        }

    }

    /**
     * Asks the user to enter the name of a country, and
     * draws the appropriate flag (by calling one of the
     * draw...Flag methods below - you don't have to write them).
     * Recognises Japan, Indonesia, Austria and Bangladesh.
     * If the user enteres any other country, it will say
     *  "Sorry, I don't know about that country".
     */
    public void drawAFlag(){
        String word = UI.askString ("Enter a country name: ");

        if (word.equalsIgnoreCase("japan")){
            this.drawJapanFlag();  
        }
        else if (word.equalsIgnoreCase("indonesia")){
            this.drawIndonesiaFlag();  
        }
        else if (word.equalsIgnoreCase("austria")){
            this.drawAustriaFlag();  
        }
        else if (word.equalsIgnoreCase("bangladesh")){
            this.drawBangladeshFlag();  
        }
        else {
            UI.println("Sorry, I don't know about that country");      
        }
    }

    /** Asks the user to enter three words and prints out the longest one.
     * (if two words are equally long, it doesn't matter which it prints).
     * You can call the length() method on a string to find out how long it is.
     * Note that there are three possible cases to check for.
     */
    public void longestWord(){
        String word1 = UI.askString("Enter first word: ");
        String word2 = UI.askString("Enter second word: ");
        String word3 = UI.askString("Enter third word: ");

        if ((word1.length() > word2.length())&&(word1.length() > word3.length())){
            UI.println("First word is the longest");
        }
        else if ((word2.length() > word1.length())&&(word2.length() > word3.length())){
            UI.println("Second word is the longest");
        }
        else if ((word3.length() > word2.length())&&(word3.length() > word1.length())){
            UI.println("Third word is the longest");
        }
        else {
            UI.println("None of the words are the longest");
        }

    }

    /** ---------- The code below is already written for you ---------- **/
    // The flag methods called by doDrawAFlag.

    /** Draws the Japanese flag */
    public void drawJapanFlag(){
        double width = 250.0;
        double height = width*2.0/3.0;
        double circleDiam = height*3.0/5.0;
        double circleLeft = LEFT+width/2.0-circleDiam/2.0;
        double circleTop = TOP+height/2.0-circleDiam/2.0;
        UI.clearGraphics();
        UI.setColor(Color.red);
        UI.fillOval(circleLeft, circleTop, circleDiam, circleDiam);
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, height);
    }

    /** Draws the Indonesian flag */
    public void drawIndonesiaFlag(){
        double width = 250.0;
        double height = width*2.0/3.0;
        UI.clearGraphics();
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width, height/2.0);
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, height);
    }

    /** Draws the Austrian flag */
    public void drawAustriaFlag(){
        double width = 250.0;
        double height = width*2.0/3.0;
        UI.clearGraphics();
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width, height/3.0);
        UI.fillRect(LEFT, TOP+height*2.0/3.0, width, height/3.0);
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, height);
    }

    /** Draws the Bangladeshi flag  */
    public void drawBangladeshFlag(){
        double width = 250.0;
        double height = width*3.0/5.0;
        double circleDiam = width*2.0/5.0;
        double circleLeft = LEFT+width/2.0-circleDiam/2.0;
        double circleTop = TOP+height/2.0-circleDiam/2.0;
        UI.clearGraphics();
        UI.setColor(Color.green);
        UI.fillRect(LEFT, TOP, width, height);
        UI.setColor(Color.red);
        UI.fillOval(circleLeft,circleTop, circleDiam, circleDiam);
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, height);
    }

}
