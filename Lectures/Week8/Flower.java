import java.util.*;
import ecs100.*;
import java.awt.Color;
import java.io.*;


/** A Flower object represents a cartoon flower that is drawn in a
    window.  When the flower is first planted, it is small and green,
    and can grow taller, and bloom, and finally be picked.
    The flower is shown on the window as a straight green stalk with a small green
    circle on top when it is a bud and a large red circle when it is blooming.
    When it is picked, it has no circle at all.
    The class needs a constructor, and methods for growing, blooming, and picking.
    It will also need a method to erase the flower, and to draw the flower.
    Each of the grow, bloom, and pick methods should first call the erase method, then
    change the relevant field values, and then call the draw method.
 */
public class Flower{


    //Fields

    private double baseX;             // location of the center of the base of the flower
    private double baseY;
    private double height;            // current height of the stalk, from base of stalk to the center of the bud/flower
    private String stage;           // the stage of the plant: "Bud", "Bloom", or "Picked"
  

    /** Constructor:  Requires a position.
	Makes a new Flower in the Bud stage.*/
    public Flower(double x, double y){
	this.baseX = x;
	this.baseY = y;
	this.stage = "bud";
	this.height = 20;
    }

    /** Constructor 2:  Requires a position, height and stage
	Makes a new Flower.*/
    public Flower(double x, double y, double ht, String s){
	this.baseX = x;
	this.baseY = y;
	this.height = ht;
	this.stage = s;
    }


    /** Grow should make the flower taller, if it is in the "bud" or "bloom" stage.
     * otherwise it should do nothing.
     */
    public void grow(int amt){
	if ( this.stage.equals("bud") || this.stage.equals("bloom")){
	    this.height = this.height + Math.max(amt, 0);
	}
    }

    /** Grow should make the flower bloom, if it is in the "bud" stage.
    */
    public void bloom(){
	if (stage.equals("bud")){
	    this.stage = "bloom";
	}
    }

    /** If the flower is in the "bud" or the "bloom" stage,
	Pick should make the flower half the height that it was,
        and change the stage to "picked",
    */
    public void pick(){
	if ( this.stage.equals("bud") || this.stage.equals("bloom")){
	    this.stage = "picked";
	    this.height = this.height/2;
	}
    }

    /** returns true if the x,y is on the flower */
    public boolean on(double x, double y){
	double distFromCenter = Math.hypot(x-this.baseX, y-(this.baseY-this.height));
	if (Math.abs(x-this.baseX)<2 && y<this.baseY && y > this.baseY-this.height){
	    return true;
	}
	if (this.stage.equals("bud" ) && distFromCenter <= 10) {
	    return true;
	}
	if (this.stage.equals("bloom" ) && distFromCenter <= 20) {
	    return true;
	}
	return false;
    }

    /** Draws the flower 
	It needs to draw a narrow solid green rectangle of the right height
	from the base of the flower. Then, depending on whether the stage of the flower
	is "Bud",  "Bloom", or "Picked", it should draw a small green circle, or a big
	red circle, or no circle at all.
    */

    public void draw(){
	UI.setColor(Color.green);
	UI.fillRect(this.baseX-2, this.baseY - this.height, 5, this.height);
      
	if ( this.stage.equals("bud" )) {
	    UI.setColor(Color.green);
	    UI.fillOval(this.baseX-10, this.baseY-this.height-10, 20, 20);
	}
	else if ( this.stage.equals("bloom" )) {
	    UI.setColor(Color.red);
	    UI.fillOval(this.baseX-20, this.baseY-this.height-20, 40, 40);
	}
    }


    /**	Writes the state of the flower on a single line to the PrintStream.
    */
    public String toString(){
	return this.baseX+" "+this.baseY+" "+this.height+" "+this.stage;
    }
    // END OF YOUR CODE




}
