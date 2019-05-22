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


/** Describes Car objects that can be moved and turned to left or right.
    Designed for a simulation of roads and traffic lights.
    You can make a new car (specify the (x,y) position, and its colour)
    drive(double dist) makes it move it forward by some distance,
    left() and right() make it turn it left or right.
 */

public class Car{
    // Fields
    private double x, y;
    private String direction;    //East, South, West North
    private Color color;
    private double width = 15;
    private double length = 35;
    private double offset = 4;  // offset of the roof from the center


    // Constructors
    /** Construct a new Car object; parameters are the position and colour of the car.
    */
    public Car(double x, double y, Color col){
	this.x = x;
	this.y = y;
	this.color = col;
	this.direction = "East";
	this.draw();
    }

    /** Make the car move a distance in its current direction*/
    public void drive(double dist){
	this.erase();
	if (this.direction.equals("East")){
	    this.x = this.x + dist;
	}
        else if (this.direction.equals("South")){
	    this.y = this.y + dist;
	}
	else if (this.direction.equals("West")){
	    this.x = this.x - dist;
	}
	else if (this.direction.equals("North")){
	    this.y = this.y - dist;
	}
	this.draw();
    }

    /** turn the car 90 degrees to the left */
    public void left(){
	this.erase();
	if (this.direction.equals("East")){
	    this.direction = "North";
	}
        else if (this.direction.equals("South")){
	    this.direction = "East";
	}
	else if (this.direction.equals("West")){
            direction = "South";
	}
	else if (this.direction.equals("North")){
	    direction = "West";
	}
	this.draw();
    }
    
    /** turn the car 90 degrees to the right */
    public void right(){
	this.erase();
	if (this.direction.equals("East")){
            direction = "South";
	}
        else if (this.direction.equals("South")){
	    direction = "West";
	}
	else if (this.direction.equals("West")){
	    this.direction = "North";
	}
	else if (this.direction.equals("North")){
	    this.direction = "East";
	}
	this.draw();
    }
    
    // internal methods.
    /** draw the car: a rectangle with a darker rectangle for the roof, slightly offset
	towards the back of the car*/
    private void draw(){
	// draw the body of the car
	UI.setColor(this.color);
	if (this.direction.equals("East") || this.direction.equals("West")){ 
	    UI.fillRect(this.x-this.length/2, this.y-this.width/2, this.length, this.width);
	}
	else {// direction up or down
	    UI.fillRect(this.x-this.width/2, this.y-this.length/2, this.width, this.length);
	}
	// draw the roof of the car
	UI.setColor(this.color.darker());
	double w = this.width/2;
	if (this.direction.equals("East")){
	    UI.fillRect(this.x-w-this.offset, this.y-w, this.width, this.width);
	}
	else if (this.direction.equals("South")){
	    UI.fillRect(this.x-w, this.y-w-this.offset, this.width, this.width);
	}
	else if (this.direction.equals("West")){
	    UI.fillRect(this.x-w+this.offset, this.y-w, this.width, this.width);
	}
	else if (this.direction.equals("North")){
	    UI.fillRect(this.x-w, this.y-w+this.offset, this.width, this.width);
	}
	UI.sleep(150);
    }

    /** erase the car */
    private void erase(){
	if (this.direction.equals("East") || this.direction.equals("West")){ 
	    UI.eraseRect(this.x-this.length/2, this.y-this.width/2, this.length, this.width);
	}
	else {// direction up or down
	    UI.eraseRect(this.x-this.width/2, this.y-this.length/2, this.width, this.length);
	}

    }

}
