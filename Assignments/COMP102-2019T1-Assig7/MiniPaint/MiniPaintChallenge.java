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
import javax.swing.JColorChooser;

public class MiniPaintChallenge{
    private String shapeType = "";
    private boolean fillShape = false;
    private double lastX, lastY, top, left, width, height, rbLastX, rbLastY;
    private int nPoints, lnW;

    private String imgFName;
    private Color currentColor = Color.black; 

    // Methods to change the shape that will be drawn when the mouse is next released.
    // These methods just save information to the fields.
    /** Respond to the Line button */
    public void doSetLine(){
        shapeType = "drLine";
    }

    public void doSetCurve(){
        shapeType = "drCurve";
    }

    /** Respond to the Rect button */
    public void doSetRect(){
        shapeType = "drRect";

    }

    /** Respond to the Oval button */
    public void doSetOval(){
        shapeType = "drOval";

    }

    public void doSetPoly(){
        shapeType = "drPoly";

    }

    /** Respond to the Image button */
    public void doSetImage(){
        shapeType = "drImg";
        imgFName = UIFileChooser.open("Choose an image file");
    }

    /** Respond to the Colour button */
    public void doSetColour(){
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
        UI.fillRect(0,0,10,10);

    }

    /** Respond to the Fill/Nofill button */
    // public void doSetFill(){
    // fillShape = true;
    // }

    // public void doSetNoFill(){
    // fillShape = false;
    // }
    public void doSetFillTest(double fillToggle){
        if (fillToggle == 0) {
            fillShape = true;
        }
        else {
            fillShape = false;    
        }
    }
    //Setting Line Width
    public void doSetLnW(double lnW){
        UI.setLineWidth(lnW);

    }

    public void doSetPolySides(double polySides){
        nPoints = (int) polySides;

    }

    public void doSetErase(){
        shapeType = "drErase";
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
        ArrayList<Double> xCoordPoly = new ArrayList<Double>();
        ArrayList<Double> yCoordPoly = new ArrayList<Double>(); 
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
        else if (action.equals("clicked") ) {
            // if (shapeType.equals("drPoly")){
                // xCoordPoly.add(x);
                // yCoordPoly.add(y);

                // //need to fix this, allow n number of values = n points,

                // double[] xPoints = xCoordPoly.toArray();
                // double[] yPoints = yCoordPoly.toArray();
                // int nPoints = xPoints.length;
                // this.drawAPolygon(xPoints,yPoints,nPoints);

            // }

        }
        if (action.equals("dragged") ) {
            if (shapeType.equals("drLine")){
                this.rbLastX = x;
                this.rbLastY = y;
                this.drawRBLine(x,y);

            } 
            //UI.setLineWidth(1);
            //UI.sleep(100);
            //UI.eraseLine(this.rbLastX, this.rbLastY, x, y);

            //UI.setImmediateRepaint(false);
        }

    }

    /**
     * Draw a line between the mouse pressed and mouse released points.
     * x and y are the position the mouse was released.
     */
    public void drawALine(double x, double y){
        UI.drawLine(this.lastX, this.lastY, x, y);
    }

    public void drawRBLine(double x, double y){
        UI.invertLine(this.rbLastX, this.rbLastY, x, y);
    }

    // public void drawACurve(double x, double y){
    // UI.drawLine(this.lastX, this.lastY, x, y);//Not implemented yet
    // }

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

    public void drawAPolygon(double[] xPoints, double[] yPoints, int nPoints){
        if(!fillShape) {
            UI.drawPolygon(xPoints, yPoints, nPoints);
        }
        else {
            UI.fillPolygon(xPoints, yPoints, nPoints);
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
    // Main:  constructs a new MiniPaint object and set up GUI

    // Main:  constructs a new MiniPaintChallenge object
    public static void main(String[] arguments){
        MiniPaintChallenge mpc = new MiniPaintChallenge();
        UI.setMouseMotionListener( mpc::doMouse);
        UI.addButton("Lines", mpc::doSetLine);
        //UI.addButton("Curves", mpc::doSetCurve);
        UI.addButton("Rectangles", mpc::doSetRect);
        UI.addButton("Ovals", mpc::doSetOval);
        //UI.addButton("Polygons", mpc::doSetPoly);
        UI.addSlider("Number of sides", 1, 20, 3, mpc::doSetPolySides);
        UI.addButton("Palette", mpc::doSetColour);
        //UI.addButton("Fill", mpc::doSetFill);
        //UI.addButton("No Fill", mpc::doSetNoFill);
        UI.addSlider("Fill                               No Fill", 0, 1, 1, mpc::doSetFillTest);
        UI.addSlider("Line Width", 1, 50, 10, mpc::doSetLnW);
        UI.addButton("Place Image", mpc::doSetImage);
        UI.addButton("Erase", mpc::doSetErase);
        UI.addButton("Clear", UI::clearGraphics);

        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);  // Hide the text area.
        //UI.setColor(Color.black);
        UI.setLineWidth(10);
        UI.fillRect(0,0,10,10);
    }   

}
