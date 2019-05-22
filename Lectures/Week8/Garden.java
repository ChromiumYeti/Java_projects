import ecs100.*;
import java.util.*;
import java.awt.Color;
import java.io.*;


/** The Garden class uses the Flower class to make a garden of flowers. 
 */

public class Garden {

    private ArrayList<Flower> flowers = new ArrayList<Flower>();    // a list to keep track of all the flowers

    /** Construct a new Garden object and set up the GUI */
    public static void main(String[] args){
        Garden g = new Garden();
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
     * plant a flower at the position of the mouse.
     * or pick the flower if mouse is on a flower
     */
    public void doMouse(String action, double x, double y) {
	if (action.equals("released")){
	    boolean found = false;
	    for (Flower flower : flowers){
		if (flower.on(x,y)){
		    flower.pick();
		    found = true;
		}
	    }
	    if (! found){
		Flower f = new Flower(x, y);
		this.flowers.add(f);
	    }
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


    /** Makes all the current flowers grow by 10 units */
    public void doGrow(){
	for(Flower f : this.flowers){
	    f.grow(10);
	}
        this.redisplay();
    }
    /** Makes all the current flowers bloom */
    public void doBloom(){
	for(Flower f : this.flowers){
	    f.bloom();
	}
        this.redisplay();
    }
    /** Picks all the current flowers */
    public void doPick(){
	for(Flower f : this.flowers){
	    f.pick();
	}
        this.redisplay();
    }
    /** Clears the window and removes all the current flowers */
    public void doClear(){
	this.flowers = new ArrayList<Flower>();  // make a new, empty list.
        this.redisplay();
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
