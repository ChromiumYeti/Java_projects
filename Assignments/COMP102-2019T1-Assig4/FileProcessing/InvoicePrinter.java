// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 4
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;

/**
 * InvoicePrinter
 * Reads an order from a file and prints an invoice
 */

public class InvoicePrinter{

    /**
     * Asks the user for the name of a file containing the details of an order
     *  and then prints out an invoice for the order.
     * Each line of an order file contains an item, a count, and a unit-price.
     * eg: an order line for 3 packets of butter at $4.20 per packet would be
     *    butter      3  4.20
     *  
     * For each line in the order, the invoice must have a line with the
     *  the count, the item, the unit price, and the total price. eg
     *    3 x butter @ $4.20       $12:60
     * 
     * At the end of the invoice, it must print out
     *   the total cost of the order
     *   the GST component of the order
     *   the ex-GST cost.
     * Hints:
     *   This assignment builds directly on the lab exercise!
     *   Use the readAllLines method from the lab exercise and a Scanner for each line
     */
    public void printInvoice() {
        double total = 0;
        String hL = "========================================";

        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(UIFileChooser.open("Open Invoice file")));
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
            scan.close();
        } catch (IOException e) { UI.println("File failure: " + e); }
        
        UI.println(hL);
        UI.println(" Invoice:");
        UI.println(hL);
        for ( String line : lines ){
            Scanner lineSc = new Scanner(line);
            String item = lineSc.next();
            double qty = (double) lineSc.nextInt();
            double itemCost = (double) lineSc.nextDouble();
            double subTotal = qty*itemCost;
            //UI.printf("strings: ", item);
            UI.printf(" %.0f x %s\t@\t$%.2f\t$%.2f\n", qty, item, itemCost, subTotal);
            total = subTotal +total;
        }

        double GST = total - (total/1.15);//GST @ 15%
        UI.println(hL);
        UI.printf(" Total cost:\t\t\t$%.2f\n", total);
        UI.printf(" GST:\t\t\t\t$%.2f\n", GST);
        UI.printf(" ex-GST cost:\t\t\t$%.2f\n", total-GST);
        UI.println(hL);
    }

}
