// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 7
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.util.*;
import java.awt.Color;

/** Program for a simple game in which the player has to blow up balloons
 *   on the screen.
 *  The game starts with a collection of randomly placed small balloons
 *    (coloured circles) on the graphics pane.
 *  The player then clicks on balloons to blow them up by a small amount
 *   (randomly increases the radius between 2 and 6 pixels).
 *  If an expanded balloon touches another balloon, then they both "burst" and go grey.
 *  The goal is to get the largest score. The score is the total of the
 *   sizes (areas) of all the active balloons, minus the total size of all
 *   the burst balloons.
 *  At each step, the current score is recalculated and displayed,
 *   along with the highest score that the player has achieved so far.
 *  At any time, the player may choose to stop and "lock in" their score.
 *
 *  The BalloonGame class has a field containing an Arraylist of Balloon objects
 *   to represent the current set of Balloons on the screen.
 *  It has a field to hold the highest score.
 *
 *  The New Game button should start a new game.
 *  The Lock Score button should finish the current game, updating the highest score
 *
 *  Clicking (ie, releasing) the mouse on the graphics pane is the main "action"
 *  of the game. The action should do the following
 *    Find out if the mouse was clicked on top of any balloon.
 *    If so,
 *      Make the balloon a bit larger and redraw it.
 *      Check whether the balloon is touching any other balloon.
 *      If so
 *         burst the two balloons (which will make them go grey)
 *         redraw the burst Balloons
 *      Recalculate and redisplay the score
 *   If all the balloons are gone, the game is over.
 *    
 *   To start a game, the program should
 *       Clear the graphics pane
 *       Initialise the score information
 *       Make a new list of Balloons at random positions
 *       Print a message 
 *
 *   If the game is over, the program should
 *      Update the highest score if the current score is better,
 *      Print a message reporting the scores,
 *      Start a new game.
 *     
 *   There are lots of ways of designing the program. It is not a good idea
 *   to try to put everything into one big method.
 *        
 *  Note that the Balloon class is written for you. Make sure that you know
 *   all its methods - no marks for redoing code that is given to you.
 *    
 */
public class BalloonGame {
    private static int MAX_BALLOONS = 20;

    private ArrayList <Balloon> balloons = new ArrayList<Balloon>(); // The list of balloons
    // (initially empty)
    private ArrayList <Double> scores = new ArrayList<Double>();

    // Fields
    double RES = 600;
    double score;
    int bPenalty =0;
    double currentScore =0;

    /** Start the game:
     *  Clear the graphics pane
     *  Initialise the score information 
     *  Make a new set of Balloons at random positions
     */
    public void restartGame(){
        UI.clearGraphics();
        balloons = new ArrayList<Balloon>();
        for (int bCount =0; bCount < MAX_BALLOONS; bCount++) {
            double xPos = Math.random()*RES;
            double yPos = Math.random()*RES;
            Balloon b = new Balloon(xPos, yPos);
            this.balloons.add(b);
            //UI.printf("Coords %f %f\n", xPos, yPos);
        }
        this.redisplay();
    }

    /**
     * Main game action:
     *	Find the balloon at (x,y) if any,
     *  Expand it 
     *  Check whether it is touching another balloon,
     *  If so, update the penalty, burst both balloons, and remove them from the list
     *  Report the score.
     *  If there are no active balloons left, end the game.
     */
    public void  doMouse(String action, double x, double y){
        Balloon b = this.findBalloonOn(x,y);

        if (action.equals("released")){

            b.expand();
            for (Balloon balloon : balloons){
                Balloon b2 = this.findTouching(balloon);
                if (b.isTouching(b2)&& b!=b2){
                    b.burst();
                    b2.burst();
                }
            }
            calculateScore();
            UI.printMessage("Your score: "+currentScore);

        }
        this.redisplay();
    }
    // Possible additional helper methods:
    /** for finding the (active) balloon that the point (x,y) is on, if any */
    public Balloon findBalloonOn(double x, double y){
        Balloon balloonFind = null;
        for (Balloon balloon : balloons){
            if (balloon.on(x,y)){
                balloonFind = balloon;
            }

        }
        return balloonFind;
    }

    /**for finding another active balloon touching the given one.*/
    public Balloon findTouching(Balloon balloon){
        Balloon balloonTouch = null;
        for (Balloon balloonCheck : balloons){
            if (balloon.isTouching(balloonCheck)){
                balloonTouch = balloon;
                //balloons.remove(balloonTouch);
                //balloons.remove(balloonCheck);
                //bPenalty = balloonCheck.size();
            }

        }
        return balloonTouch;
    }

    /**for calculating the current score*/
    public int calculateScore(){

        for (Balloon balloon : balloons){
            currentScore = balloon.size() - bPenalty;
            scores.add(currentScore);

        }
        return (int) currentScore;
    }

    /**to find out if all the balloons have been burst.*/
    // public boolean allBalloonsBurst(){

    // }

    /**to update the highestScore and print a message*/
    // public void endGame(){
    // //UI.printMessage("Your score: %f", currentScore);
    // }

    public void redisplay(){
        UI.clearGraphics();
        for(Balloon b : this.balloons){
            b.draw();
        }
    }

    public void balloonCount(double numB){
        double numB2 = numB % 2; 
        if(numB2 == 0) {
            MAX_BALLOONS = (int) numB;
        }
        else {
            MAX_BALLOONS = (int) numB +1;
        }
    }
    // public void lockScore(){

    // }

    /**
     * Main:  set up the GUI
     */
    public static void main(String[] arguments){
        UI.setWindowSize(600,600);
        BalloonGame bg = new BalloonGame();
        UI.setMouseListener( bg::doMouse );
        UI.addButton("New Game", bg::restartGame);
        UI.addSlider("Number of Balloons", 2, 50, 20, bg::balloonCount);
        //UI.addButton("Lock Score", bg::lockScore);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);
    }   

}
