// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 7
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class MiniPaint{

    // fields to remember:
    //  - the shape that will be drawn when the mouse is next released.
    //  - whether the shape should be filled or not
    //  - the position the mouse was pressed, 
    //  - the name of the image file
    //  - the colour used to draw later shapes
    private String shapeType = "";
    private boolean fillShape = false;
    private double lastX, lastY, top, left, width, height;
    private int nPoints;

    private String imgFName;
    private Color currentColor = Color.black; 

    // Methods to change the shape that will be drawn when the mouse is next released.
    // These methods just save information to the fields.
    /** Respond to the Line button */
    public void doSetLine(){
        shapeType = "drLine";
        UI.printMessage("Click and drag to create a line."); 
    }

    /** Respond to the Rect button */
    public void doSetRect(){
        shapeType = "drRect";
        UI.printMessage("Click and drag from the top left to bottom right corner to create a rectangle."); 

    }

    /** Respond to the Oval button */
    public void doSetOval(){
        shapeType = "drOval";
        UI.printMessage("Click and drag from the top left to bottom right dimension to create an oval.");

    }

    /** Respond to the Image button */
    public void doSetImage(){
        shapeType = "drImg";
        UI.printMessage("Select an image, then click and drag from the top left to bottom right corner to place an image.");

        imgFName = UIFileChooser.open("Choose an image file");
    }

    /** Respond to the Colour button */
    public void doSetColour(){
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
        UI.fillRect(0,0,10,10);

    }

    /** Respond to the Fill button */
    public void doSetFill(){
        fillShape = true;
    }

    /** Respond to the Nofill button */
    public void doSetNoFill(){
        fillShape = false;
    }

    /** Setting Line Width */
    public void doSetLnW(double lnW){
        UI.setLineWidth(lnW);

    }

    /** Respond to the Erase button */
    public void doSetErase(){
        shapeType = "drErase";
        UI.printMessage("Click and drag from the top left to bottom right corner to create a rectangle erase.");

    }

    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw what is specified by current shape
     * Uses the value stored in the field to determine which kind of shape to draw.
     *  It should call the drawALine, drawARectangle, drawAnOval, or drawAnImage, methods
     *  passing the x and y where the mouse was released.
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed") ) {
            this.lastX = x;
            this.lastY = y;
            //UI.printf("pressed %f, %f\n", x,y);
        }
        if (action.equals("released") ) {
            left = this.lastX;
            top = this.lastY;
            width = x-this.lastX;
            height = y-this.lastY;
            if (this.lastX < x ){
                left = this.lastX;
                width = x-this.lastX;

            }
            else {
                left = x;
                width = this.lastX-x;
            }
            if (this.lastY < y ){
                top = this.lastY;
                height = y-this.lastY;
            }
            else {
                top = y;
                height = this.lastY-y;
            }
            if (shapeType.equals("drLine")){
                this.drawALine(x,y);

            }
            else if (shapeType.equals("drRect")){
                this.drawARectangle(x,y);
            }
            else if (shapeType.equals("drOval")){
                this.drawAnOval(x,y);
            }

            else if (shapeType.equals("drImg")){
                this.drawAnImage(x,y);
            }

            else if (shapeType.equals("drErase")){
                this.erase(x,y);
            }
            else if (shapeType.equals("")){
                UI.printMessage("Select a tool to use.");                
            }
        }
        if (action.equals("clicked") ) {
            this.lastX = x;
            this.lastY = y;
            // what to do if mouse button is clicked
        }

    }

    /**
     * Draw a line between the mouse pressed and mouse released points.
     * x and y are the position the mouse was released.
     */
    public void drawALine(double x, double y){
        UI.drawLine(this.lastX, this.lastY, x, y);
    }

    /**
     * Draw a rectangle between the mouse pressed and mouse released points.
     * x and y are the position the mouse was released.
     * Works out the left, top, width, and height from x, y, lastX and lastY
     * Then draws the rectangle, filled or outline, depending on the fill field.
     */
    public void drawARectangle(double x, double y){
        if(!fillShape) {
            UI.drawRect(left, top, width, height);
        }
        else {
            UI.fillRect(left, top, width, height);
        }
    }

    /**
     * Draw an oval between the mouse pressed and mouse released points.
     * x and y are the position the mouse was released.
     * Works out the left, top, width, and height from x, y, lastX and lastY
     * Then draws the oval, filled or outline, depending on the fill field.
     */
    public void drawAnOval(double x, double y){
        if(!fillShape) {
            UI.drawOval(left, top, width, height);
        }
        else {
            UI.fillOval(left, top, width, height);
        }

    }

    /** 
     * Draws the current image between the mouse pressed and mouse released points.
     * x and y are the position the mouse was released.
     * Works out the left, top, width, and height from x, y, lastX and lastY
     * Then draws the image, if there is one.
     */
    public void drawAnImage(double x, double y){
        UI.drawImage(imgFName, left, top, width, height);
        //use file chooser here
    }

    /**
     * Erases a rectangular section. 
     */
    public void erase(double x, double y){
        UI.eraseRect(left, top, width, height);
    }

    /** Main:  constructs a new MiniPaint object and set up GUI*/
    public static void main(String[] arguments){
        MiniPaint mp = new MiniPaint();
        UI.setMouseListener( mp::doMouse );
        //UI.setMouseMotionListener( mp::doMouse);
        UI.addButton("Lines", mp::doSetLine);

        UI.addButton("Rectangles", mp::doSetRect);
        UI.addButton("Ovals", mp::doSetOval);

        UI.addButton("Palette", mp::doSetColour);
        UI.addButton("Fill", mp::doSetFill);
        UI.addButton("No Fill", mp::doSetNoFill);

        UI.addSlider("Line Width", 1, 50, 10, mp::doSetLnW);
        UI.addButton("Place Image", mp::doSetImage);
        UI.addButton("Erase", mp::doSetErase);
        UI.addButton("Clear", UI::clearGraphics);

        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);  // Hide the text area.
        //UI.setColor(Color.black);
        UI.setLineWidth(10);
        UI.fillRect(0,0,10,10); //Colour indicator box in top left corner of Graphics Pane
    }	

}
