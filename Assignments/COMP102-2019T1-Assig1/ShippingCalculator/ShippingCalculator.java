
                // This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 1
 * Name: Christopher Yee
 * Username: YEECHRI2
 * ID: 300508227
 */

import ecs100.*;

/** Program for calculating cost of shipping a package */

public class ShippingCalculator{

    public static final double HANDLING = 1.60;    // cost of handling a shipment
    public static final double SIZE_RATE = 300;           // cost per cubic meter
    public static final double WEIGHT_RATE = 1.50;        // cost per kg

    /**
     * Calculates and prints cost of shipping a package.
     */
    public void calculateShippingCore(){
        double height = UI.askDouble("Enter height of package in cm:" );
        double width = UI.askDouble("Enter width of package in cm:" );
        double length = UI.askDouble("Enter length of package in cm:" );
        double sizeCharge = height/100 * width/100 * length/100 * SIZE_RATE;
            UI.printf("Size charge per zone: $ %.2f %n", sizeCharge);
        double weight = UI.askDouble("Enter weight of package in kg:" );
            double weightCharge = weight * WEIGHT_RATE;
            UI.printf("Weight charge per zone: $ %.2f \n", weightCharge);
        double zones = UI.askDouble("Enter number of zones:" );
        double totalCharge = (sizeCharge + weightCharge) * zones + HANDLING;
            UI.printf("Total Charge: $ %.2f \n", totalCharge) ;
    }

    /**
     * Calculates and prints cost of shipping a collection of packages.
     */
    public void calculateShippingCompletion(){
        double zones = UI.askDouble("Enter number of zones:" );
        double numberOfPackagesSize1 = UI.askDouble("Number of packages of first size:" );
        double heightSize1 = UI.askDouble("Enter height of package (cm):" );
        double widthSize1 = UI.askDouble("Enter width of package (cm):" );
        double lengthSize1 = UI.askDouble("Enter length of package (cm):" );
        double weightSize1 = UI.askDouble("Enter weight of package (kg):" );
        UI.println("-------------------------------------");
        double numberOfPackagesSize2 = UI.askDouble("Number of packages of second size:" );
        double heightSize2 = UI.askDouble("Enter height of package (cm):" );
        double widthSize2 = UI.askDouble("Enter width of package (cm):" );
        double lengthSize2 = UI.askDouble("Enter length of package (cm):" );
        double weightSize2 = UI.askDouble("Enter weight of package (kg):" );
        UI.println("-------------------------------------");

        double sizeChargeSize1 = heightSize1/100 * widthSize1/100 * lengthSize1/100 * numberOfPackagesSize1 * SIZE_RATE;
        double weightChargeSize1 = weightSize1 * numberOfPackagesSize1* WEIGHT_RATE;
        double sizeChargeSize2 = heightSize2/100 * widthSize2/100 * lengthSize2/100 * numberOfPackagesSize2 * SIZE_RATE;
        double weightChargeSize2 = weightSize2 * numberOfPackagesSize2 * WEIGHT_RATE;
        UI.printf("Group 1 size charge per zone: $ %.2f \n", sizeChargeSize1);
        UI.printf("Group 1 weight charge per zone: $ %.2f \n", weightChargeSize1);
        UI.printf("Group 2 size charge per zone: $ %.2f \n", sizeChargeSize2);
        UI.printf("Group 2 weight charge per zone: $%.2f \n", weightChargeSize2);

        double chargeBeforeDiscount = (sizeChargeSize1 + weightChargeSize1 + sizeChargeSize2 + weightChargeSize2) * zones + HANDLING;
        double totalNumberOfPackages = numberOfPackagesSize1 + numberOfPackagesSize2;
        //double discount = chargeBeforeDiscount * (1.0-1.0/totalNumberOfPackages)/3.0; //Original Discount
        //Work on better discount formula in weekend
        double discount = chargeBeforeDiscount * (1.0-1.0/totalNumberOfPackages)/3.0;
        double charge = chargeBeforeDiscount - discount;
    
        UI.printf("Total before discount: $ %.2f \n", chargeBeforeDiscount);
        UI.printf("Discount for %.0f items: $ %.2f \n", totalNumberOfPackages, discount);
        UI.printf("Total after discount: $ %.2f \n", charge);
        

    }
}
