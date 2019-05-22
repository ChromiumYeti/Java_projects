import ecs100.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class NumberMaker{
    public static final double BASE = 450;
    public static final double STEP = 4;

    private ArrayList<Double> numbers = new ArrayList<Double>();
    private double barX = 0;

    public void doMouse(String action, double x, double y) {
        if (action.equals("released")) {
            double number = BASE - y;
            UI.println(number);
            this.numbers.add(number);
            this.barX = this.barX + STEP;
            UI.setColor(Color.blue);
            UI.fillRect(this.barX, y, STEP-1, number);
        }
    }

    public void doNew(){
        UI.clearGraphics();  
        UI.clearText();  
        UI.drawLine(0, BASE, 500, BASE);
        this.barX = 0;
        this.numbers = new ArrayList<Double>();
    }

    public void doSave(){
        try{
            PrintStream outputFile = new PrintStream(new File(UIFileChooser.save()));
            for (double num : this.numbers){
                outputFile.println(num);
            }
	    outputFile.close();
            this.doNew();
        } catch(IOException e) { System.out.println("File error: "+e); }
    }

    public static void main(String[] args){
        NumberMaker nm = new NumberMaker();
        UI.setMouseListener(nm::doMouse);
        UI.addButton("New", nm::doNew); 
        UI.addButton("Save", nm::doSave); 
        UI.addButton("Quit", UI::quit); 
        UI.setDivider(0.1);
        UI.drawLine(0, BASE, 550, BASE);
    }

}

//   if (this.outputFile!=null){
