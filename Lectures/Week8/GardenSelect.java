/* Code for COMP 102 
 * Name: pondy
 */

import ecs100.*;
import java.util.*;
import java.awt.Color;
import java.io.*;


/** The GardenSelect class uses the Flower class to make a garden of flowers. 
 */

public class GardenSelect {

    private ArrayList<Flower> flowers = new ArrayList<Flower>();    // a list to keep track of all the flowers
    private Flower selectedFlower;

    /** Construct a new GardenSelect object and set up the GUI */
    public static void main(String[] args){
        GardenSelect g = new GardenSelect();
	UI.setMouseListener(g::doMouse); 
	UI.addButton("Grow", g::doGrow);
	UI.addButton("Bloom", g::doBloom);
	UI.addButton("Pick", g::doPick);
	UI.addButton("Clear", g::doClear);
	UI.addButton("Save", g::doSave);
	UI.addButton("Load", g::doLoad);
	UI.addButton("Quit", UI::quit);
	UI.setDivider(0.0);
    }

    /** Respond to mouse events:
     * If on a flower, select it.
     * else plant a flower at the position of the mouse.
    */
    public void doMouse(String action, double x, double y) {
	if (action.equals("released")){
	    for (Flower flower : flowers){
		if (flower.on(x,y)){
		    this.selectedFlower = flower;
		    return;
		}
	    }
            Flower flower = new Flower(x, y);
            this.flowers.add(flower);
            this.selectedFlower = flower;
	}
        this.redisplay();
    }


    /** Redisplays all the flowers */
    public void redisplay(){
        UI.clearGraphics();
	for(Flower f : this.flowers){
	    f.draw();
	}
    }

    /** Makes selected flower grow by 10 units */
    public void doGrow(){
	if (this.selectedFlower != null){
	    this.selectedFlower.grow(10);
	}
        this.redisplay();
    }
    /** Makes selected flower bloom */
    public void doBloom(){
	if (this.selectedFlower != null){
	    this.selectedFlower.bloom();
	}
        this.redisplay();
    }
    
    /** Picks selected flower */
    public void doPick(){
	if (this.selectedFlower != null){
	    this.selectedFlower.pick();
	}
        this.redisplay();
    }
    /** Clears the window and removes all the current flowers */
    public void doClear(){
	this.flowers = new ArrayList<Flower>();  // make a new, empty list.
	UI.clearGraphics();
    }

    public void doLoad(){
        this.doClear();
	try {
	    Scanner sc = new Scanner(new File(UIFileChooser.open()));
	    while(sc.hasNext()){
		this.flowers.add(new Flower(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.next()));
	    }
	    sc.close();
        }catch(IOException e){}
        this.redisplay();
    }

    public void doSave(){
	try {
	    PrintStream out = new PrintStream(new File(UIFileChooser.save()));
	    for(Flower flower : this.flowers){
		out.println(flower);
	    }
	    out.close();
        }catch(IOException e){}
    }
          


}
