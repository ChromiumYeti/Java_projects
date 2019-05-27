// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 9
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.util.*;
import java.io.*;

/**
 * EarthquakeAnalyser
 * Analyses data about a collection of 4335 NZ earthquakes from May 2016 to May 2017
 * Each line of the file "earthquake-data.txt" has a description of one earthquake:
 *   ID time longitude  latitude magnitude depth region
 * Data is from http://quakesearch.geonet.org.nz/
 *  Note bigearthquake-data.txt has just the 421 earthquakes of magnitude 4.0 and above
 *   which may be useful for testing, since it is not as big as the full file.
 * 
 * Core:  two methods:
 *   loadData
 *      Loads the data from a file into a field containing an
 *      ArrayList of Earthquake objects.
 *      Hint : to make an Earthquake object, read all the lines from the file
 *              and then take each line apart into the values to pass to the
 *              Earthquake constructor
 *   findBigOnes
 *      Prints out all the earthquakes in the ArrayList that have a magnitude 5.5 and over.
 *      Hint: see the methods in the Earthquake class, especially getMagnitude and toString
 *   
 * Completion: one method:
 *   findPairs
 *  Compares each Earthquake in the list with every other Earthquake
 *      and finds every pair of "close" earthquakes - earthquakes that
 *        - are within 1km of each other, and
 *        - have depths within 1km of each other, and
 *        - are separated by at least 24 hours days 
 *      For each pair, prints
 *        - their ID's,
 *        - the distance between them
 *        - the depth difference
 *        - the number of days between them.

 * Challenge: two methods
 *  findFollowOns;
 *      Constructs a new ArrayList containing every earthquake with a magnitude that is at least 6.0
 *      For each such earthquake on this list
 *       - finds a list of all the "follow-on" earthquakes:
 *         later earthquakes within a distance of 10km and depth difference <= 10km.
 *       - If there are at least two follow-on earthquakes, then it prints out
 *          the full details of the big earthquake followed by
 *          ID, magnitude and days since the big one for each follow-on earthquake
 *  plotEarthquakes
 *      Given a time range, plots earthquake as circles by position
 *      You may choose to represent earthquake with different colours or sizes
 *      depending on their magnitude or depth.

 * The file "example-output.txt" has sample output for the "bigearthquake-data.txt"
 *   file, which only contains earthquakes with magnitude 4 and above.
 */

public class EarthquakeAnalyser{

    private ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();

    /*
     * Load data from the data file into the earthquakes field:
     * clear the earthquakes field.
     * Read lines from file
     * For each line, use Scanner to break up each line and make an Earthquake
     *  adding it to the earthquakes field.
     */
    public void loadData(){
        String filename = UIFileChooser.open("Data File");
        earthquakes.clear();
        //int i=0;

        ArrayList<String> lines = this.readAllLines(filename);

        for ( String line :lines){
            //i++;
            Scanner lineSc = new Scanner(line);
            String ID = (String) lineSc.next();
            //int year = (int) lineSc.nextInt();
            //int month = (int) lineSc.nextInt();
            //int day = (int) lineSc.nextInt();
            String time = (String) lineSc.next();
            double longitude = (double) lineSc.nextDouble();
            double latitude = (double) lineSc.nextDouble();
            double magnitude = (double) lineSc.nextDouble();
            double depth = (double) lineSc.nextDouble();
            String region = (String) lineSc.next();
            Earthquake quakes = new Earthquake(ID, time, longitude,latitude,magnitude,depth,region);
            this.earthquakes.add(quakes);

            //UI.printf("ID: %s\tTime: %s\tLong: %.2f\tLat: %.2f\tMag: %.2f\tDepth: %.2f\tRegion: %s\n",ID,time,longitude,latitude,magnitude,depth,region); 
        }

        UI.printf("Loaded %d earthquakes into list\n", this.earthquakes.size());
        UI.println("----------------------------");
    }

    /**
     * Utility method: 
     * Read each line in a file into a list of Strings
     * Returns the list
     */
    public ArrayList<String> readAllLines(String fname){
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(fname));
            while (scan.hasNext()){
                lines.add(scan.nextLine());
            }
            //UI.printf("%s\n", lines);
            scan.close();
            return lines;
        }
        catch(IOException e){UI.println("File reading failed");}
        return null;
    }

    /**
     * Print details of all earthquakes with a magnitude of 5.5 or more
     */
    public void findBigOnes(){
        UI.println("Earthquakes 5.5 and above");
        for(Earthquake earthquakes: this.earthquakes){
            if (earthquakes.getMagnitude() >= 5.5){
                UI.println(earthquakes.toString());
            }
        }
        UI.println("------------------------");
    }

    /**
     * Print all pairs of earthquakes and within 1km depth from earthquakes within 1km of each other
     * and separated by at least 1 day;
     */
    public void findPairs(){
        UI.println("Close earthquakes");
        //double pairs = 0;

        for (int i=0; i < this.earthquakes.size(); i++) {
            for (int j=i+1; j < this.earthquakes.size(); j++) {
                String ID1 = this.earthquakes.get(i).getID();
                String ID2 = this.earthquakes.get(j).getID();
                double distBtwn = this.earthquakes.get(i).distanceTo(this.earthquakes.get(j));
                double depDiff = Math.abs(earthquakes.get(i).getDepth() - earthquakes.get(j).getDepth());
                double daysBtwn = Math.abs(earthquakes.get(i).timeBetween(earthquakes.get(j)))/1440;
                if(this.earthquakes.get(i) != this.earthquakes.get(j)
                && distBtwn <=1.0 
                && depDiff <=1.0
                && daysBtwn <= 24
                ){
                    UI.printf("Pair of Earthquakes - ID1 %s and ID2 %s. Distance between: %.1f km. Depth difference: %.1f km. Days betweeen: %.2f\n",
                        ID1,ID2,distBtwn,depDiff,daysBtwn);
                }
            }
        }
        //UI.printf("Loaded %d earthquakes into list\n", this.earthquakes.size());
        UI.println("----------------------------");
    }

    /**
     * CHALLENGE 1
     * Constructs a new ArrayList containing every earthquake with a magnitude that is at least 6 
     * For each earthquake on this list
     * - finds a list of all the "follow-on" earthquakes:
     *   later earthquakes within a distance of 10km and depth difference <= 10km.
     * - If there are at least two follow-on earthquakes, then it prints out
     *     the full details of the big earthquake followed by
     *    ID, magnitude and days since the big one for each follow-on earthquake
     */

    public void findFollowOns(){
        UI.println("Big earthquakes and their follow-on earthquakes");
        /*# YOUR CODE HERE */

        UI.println("-------------------------------------");
    }

    /**
     * CHALLENGE 2
     * Given a time range, plots earthquake as circles.
     * You may choose to represent earthquake 
     * with different colours or sizes depending
     * on their magnitude or depth.
     */
    //longitude = x, latitude = y. top left corner of image is about 164.5,-30
    public void plotEarthquakes(){
        UI.clearPanes();
        for (int i=0; i < this.earthquakes.size(); i++) {

        }
    }

    public static void main(String[] arguments){
        EarthquakeAnalyser obj = new EarthquakeAnalyser();
        UI.initialise();
        UI.addButton("Load", obj::loadData);
        UI.addButton("Big ones",  obj::findBigOnes);
        UI.addButton("Pairs", obj::findPairs);
        UI.addButton("Follow-ons", obj::findFollowOns);
        UI.addButton("Plot", obj::plotEarthquakes);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1.0);  //text pane only 
    }   

}
