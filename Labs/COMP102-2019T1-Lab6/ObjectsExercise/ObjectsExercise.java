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

/** Exercise for defining objects.
 *  This program contains methods for testing Lamp, PartyBalloon, and FlagStaff objects.
 *  It is all written for you, but you need to read it to see what the
 *  Lamp, PartyBalloon, and FlagStaff classes should do
 */

public class ObjectsExercise{

    public static final double GROUND = 400;

    // the lamps: need to be in a field because two different methods need to access it.
    private Lamp myLamp; 
    private Lamp yrLamp;

    /** Makes several Lamp objects */
    public void createLamps(){
        UI.clearPanes();

        myLamp = new Lamp(100, 150);
        myLamp.draw();
        yrLamp = new Lamp(300, 250);
        yrLamp.draw();

        UI.println("Click on the lamps to turn them on and off and change their color");
    }	

    /** Manages the Lamp objects */
    public void manageLamps(String action, double x, double y){
        if (action.equals("released")){
            if (myLamp==null || yrLamp==null) {
                UI.printMessage("Press Lamps button first to create some lamps");
                return;  // the lamps haven't been constructed yet.
            }
            if (myLamp.onBulb(x,y)){
                myLamp.changeColor();
                myLamp.draw();
            }
            else if (myLamp.onStem(x,y)){
                myLamp.turnOff();
                myLamp.draw();
            }
            else if (yrLamp.onBulb(x,y)){
                yrLamp.changeColor();
                yrLamp.draw();
            }
            else if (yrLamp.onStem(x,y)){
                yrLamp.turnOff();
                yrLamp.draw();
            }
        }
    }	

    /** Makes a pair of PartyBalloon objects and makes them fly into the sky */
    public void flyPartyBalloon(){
        this.clear();
        this.drawGround();

        int count = 0;
        // make two random colours
        Color colr1 = Color.getHSBColor((float)Math.random(),1,1);
        Color colr2 = Color.getHSBColor((float)Math.random(),1,1);

        // choose two random x positions
        double x1 = Math.random()*500;
        double x2 = Math.random()*500;

        // make and draw two PartyBalloon objects.
        PartyBalloon myBalloon = new PartyBalloon(x1, 370, colr1);
        PartyBalloon yourBalloon = new PartyBalloon(x2, 370, colr2);
        myBalloon.draw();
        yourBalloon.draw();
        UI.sleep(200);

        // repeatedly move and redraw the balloons.
        int steps = 0;
        while (steps < 18){
            //move the balloons
            myBalloon.riseLeft();
            yourBalloon.riseRight();

            //redraw the ground and the balloons
            UI.clearGraphics();
            this.drawGround();
            myBalloon.draw();
            yourBalloon.draw();

            steps = steps + 1;
            UI.sleep(200);
        }
    }

    /** 
     * Makes two FlagStaff objects and makes the flags go up and down.
     */
    public void doFlagStaff(){
        this.clear();
        FlagStaff flag1 = new FlagStaff(110, GROUND);  
        FlagStaff flag2 = new FlagStaff(380, GROUND);

        this.drawGround();
        flag1.redraw();
        flag2.redraw();
        UI.sleep(500);

        int steps = 0;
        UI.println("Make flags go up");
        while (steps < 8){
            // make flags go up by a random amount 
            flag1.raise(Math.random()*100);
            flag2.raise(Math.random()*100);

            UI.clearGraphics();
            this.drawGround();
            flag1.redraw();
            flag2.redraw();

            UI.sleep(500);
            steps++;   //(shorthand for steps = steps + 1;
        }
        UI.println("Make flags go down");
        while (steps> 0){
            // make flags go down by a random fraction
            flag1.lower(Math.random()*100);
            flag2.lower(Math.random()*100);

            UI.clearGraphics();
            this.drawGround();
            flag1.redraw();
            flag2.redraw();

            UI.sleep(500);
            steps--;   //(shorthand for steps = steps - 1;
        }
    }

    /** Draw the ground */
    public void drawGround(){
        UI.setColor(new Color(120, 80, 0));   // dark brown,
        UI.fillRect(0,GROUND,600,10);  
    }

    public void clear(){
        UI.clearPanes();
        myLamp = null;
        yrLamp = null;
    }

    // Main
    /** Create a new BallGame object and setup the interface */
    public static void main(String[] args){
        ObjectsExercise oe = new ObjectsExercise();
        UI.setMouseListener(oe::manageLamps);   // the mouse will switch on/off the lamps
        UI.addButton("Clear", oe::clear );
        UI.addButton("Lamps", oe::createLamps );
        UI.addButton("PartyBalloons", oe::flyPartyBalloon );
        UI.addButton("FlagStaff", oe::doFlagStaff );
        UI.addButton("Quit", UI::quit );        
    }

}
