// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;

/**
 * Exercises for programs that read data from files.
 */

public class FilesDataExercise{

    /**
     * sumNumbers should first use readAllNumbers to read the numbers from a 
     *  file called "numbers.txt" into an ArrayList
     * Then it should add up all the numbers, and print the total at the end.
     * (The total should be 2174)
     */
    public void sumNumbers(){
        ArrayList<Double> numbers = this.readAllNumbers("numbers.txt");

        double total = 0.0;
        for(double sum : numbers){
            total = total + sum;

        }
        UI.printf("Total: %.0f\n", total);
    }

    /**
     * Utility method: 
     * Reads a file consisting of numbers into a list of numbers.
     * Returns the list of numbers
     */
    public ArrayList<Double> readAllNumbers(String fname){
        ArrayList<Double> ans = new ArrayList<Double>();
        try {
            Scanner scan = new Scanner(new File(fname));
            while (scan.hasNext()){
                if (scan.hasNextDouble()){
                    ans.add(scan.nextDouble());
                }
                else {
                    scan.next();  // throw away any non-numbers
                }
            }
            scan.close();

        }
        catch(IOException e){UI.println("File reading failed");}
        return ans;
    }

    //----------------------------------------------------------------
    /**
     * printLongestWord should first use readAllTokens to read the words from a
     *  file called "text.txt" into an ArrayList 
     * Then it should find the longest word and print it out.
     * (The longest word should be "differentiated;")
     */
    public void printLongestWord(){
        /*# YOUR CODE HERE */

    }

    /**
     * Utility method: 
     * Read all the tokens in a file into a list of tokens.
     * Returns the list
     */
    public ArrayList<String> readAllTokens(String fname){
        ArrayList<String> ans = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(fname));
            while (scan.hasNext()){
                if (scan.hasNextBoolean()){
                    ans.add(scan.nextLine());
                }
                else {
                    scan.next();  // throw away any non-numbers
                }
            }
            scan.close();

        }
        catch(IOException e){UI.println("File reading failed");}
        
        return ans;
    }

    //----------------------------------------------------------------
    /**
     * printFirstWords should first use readAllLines to read all the lines from
     *  a file called "text.txt" into an ArrayList
     * Then it should print out the first token (word) on each line.
     * It will need a Scanner on each line in order to extract the first word
     */
    public void printFirstWords(){
        ArrayList<String> lines = this.readAllLines("text.txt");
        /*# YOUR CODE HERE */

    }

    /**
     * Utility method: 
     * Read each line in a file into a list of Strings
     * Returns the list
     */
    public ArrayList<String> readAllLines(String fname){
        ArrayList<String> ans = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(fname));
            while (scan.hasNext()){
                if (scan.hasNextBoolean()){
                    ans.add(scan.nextLine());
                }
                else {
                    scan.next();  // throw away any non-numbers
                }
            }
            scan.close();

        }
        catch(IOException e){UI.println("File reading failed");}
        
        return ans;

        // Remove the next line! It is here to make the file compile until you fix this method.
        //return null;   
    }
    //----------------------------------------------------------------

    /**
     * countLargeCourses should first use readAllLines to read all the lines from
     *  a file called "course-counts.txt" into an ArrayList
     * Each line of "course-counts.txt" contains a course code (eg COMP102) and the number of
     *  students in the course 
     * Then it should count (and print out) how many of the courses have
     *  more than 100 students
     * It will need a Scanner on each line in order to extract the course code and course size.
     */
    public void countLargeCourses(){
        ArrayList<String> lines = this.readAllLines("course-counts.txt");
        /*# YOUR CODE HERE */

    }

    /**
     * computeTotalOrder should first use readAllLines to read all the lines from
     *  a file called "order.txt" into an ArrayList
     * Each line of "order.txt" contains an item, a count, and a unit-price
     * Then it should add up the total cost of the order.
     * Note: The cost of each item is the count * unit-price
     * It will need a Scanner on each line in order to extract the count and unit-price
     */
    public void computeTotalOrder(){
        /*# YOUR CODE HERE */

    }

}
