
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import ecs100.*;
import java.util.*;
import java.io.*;

public class test
{
    public void runTest()
    {
        double total = 0;
        String hL = "=======================================";

        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(UIFileChooser.open()));
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
            scan.close();
        } catch (IOException e) { UI.println("File failure: " + e); }
        //return lines;
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
            UI.printf("%.0f x %s @\t$%.2f\t $%.2f\n", qty, item, itemCost, subTotal);
            total = subTotal +total;
        }

        double GST = total*0.15;//GST @ 15%
        UI.println(hL);
        UI.printf(" Total cost\t\t$%.2f\n", total);
        UI.printf(" GST\t\t\t$ %.2f\n", GST);
        UI.printf(" ex-GST cost\t\t$%.2f\n", total-GST);
        UI.println(hL);
    }
}

