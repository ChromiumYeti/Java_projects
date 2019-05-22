// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name: Christopher Yee
 * Username: YEECHRI2
 * ID: 300508227
 */

import ecs100.*;

/** Program for calculating various things
 * Some methods convert between two units
 * Other methods perform other simple calculations 
 */

public class CalculatorExercise{

    /**
     * Ask for miles then convert to kilometers
     */
    public void milesToKilometers(){
        double milesConv = 1.609344; //1 Mile = 1.609344 Km
        double enterMiles = UI.askDouble("Enter miles to convert to km: ");
        double convertMilesToKm = enterMiles * milesConv;
        UI.println(enterMiles + " miles is " + convertMilesToKm + " kilometres.");

    }	

    /**
     * Ask for base and height, then calculate area of triangle
     */
    public void triangleArea(){
        double base = UI.askDouble("Enter base: ");
        double height = UI.askDouble("Enter height: ");
        double area = height * base /2; //Area is height x base / 2
        UI.println("Area of triangle is: " + area + " sq.u");

    }

    /**
     * Ask for grams then convert to ounces
     */
    public void gramsToOunces(){
        /*# YOUR CODE HERE */

    }

    /**
     * Ask for radius, and then compute surface area and the volume of a sphere
     *  see notes or http://math2.org/math/geometry/areasvols.htm  for formulas
     */
    public void surfaceAndVolumeOfSphere(){
        /*# YOUR CODE HERE */

    }

    /**
     * Ask for kelvin then convert to Fahrenheit
     */
    public void kelvinToFahrenheit(){
        /*# YOUR CODE HERE */

    }

    /** 
     * Ask for number of pizzas and cost per pizza, then compute cost of order of pizzas
     */
    public void costOfPizzas(){
        /*# YOUR CODE HERE */

    }

}
