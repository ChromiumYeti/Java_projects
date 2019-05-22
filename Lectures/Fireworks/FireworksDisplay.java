import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** FireworksDisplay   */

public class FireworksDisplay{


    public void runFirework(){
        Firework f1 = new Firework(100, Color.yellow, 300);
        Firework f2 = new Firework(300, Color.orange, 150);
        while (true){
            f1.step();
            f2.step();
            if (f1.isFinished()){
                f1 = newFirework();
            }
            if (f2.isFinished()){
                f2 = newFirework();
            }
            UI.clearGraphics();
            UI.setColor(Color.black);
            UI.fillRect(0, 0, 700, 900);
            f1.draw();
            f2.draw();
            UI.sleep(50);            
        }

    }

    public void runDisplay(){
        ArrayList<Firework> fws = new ArrayList<Firework>();
        for (int i=0; i<6; i++){
            fws.add(this.newFirework());
        }
        while (true){
            for (Firework fw : fws){
                fw.step();
            }
            UI.clearGraphics();
            UI.setColor(Color.black);
            UI.fillRect(0, 0, 700, 900);
            for (Firework fw : fws){
                fw.draw();
            }
            
            UI.sleep(50);            
        }

    }

    public Firework newFirework(){
        double x = 50+Math.random()*600;
        Color c = Color.getHSBColor((float)Math.random(), 1.0f, 1.0f);
        double height = 100+Math.random()*300;
        return new Firework(x, c, height);
    }




    public static void main(String[] args){
        FireworksDisplay Fir = new FireworksDisplay();
        UI.addButton("Go", Fir::runFirework);
        UI.addButton("Quit", UI::quit);
    }



}