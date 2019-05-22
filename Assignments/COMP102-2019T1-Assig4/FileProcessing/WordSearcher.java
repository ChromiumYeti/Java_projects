// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 4
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.util.*;
import java.io.*;

public class WordSearcher {

    /**
     * Asks the user for a pattern and then finds and prints out (one per line) all
     *  the words in a dictionary that contain that pattern.
     * At the end, it prints out how many words contained the pattern.
     * It stops printing out words after it has found 100 of them, but it still
     *  prints the total number of matches at the end.
     * The dictionary is in the file dictionary.txt. 
     * Hints:
     *   Use the readAllTokens method from the lab exercise
     */

    public ArrayList<String> readAllTokens(String fname){
        ArrayList<String> ans = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(new File(fname));
            while (scan.hasNext()){
                if (scan.hasNext()){
                    ans.add(scan.nextLine());
                }
                else {
                    scan.next();  
                }
            }
            scan.close();

        }
        catch(IOException e){UI.println("File reading failed");}

        return ans;
    }

    public void search() {
        ArrayList<String> words = this.readAllTokens("dictionary.txt");
        String searchString = UI.askString("Pattern to search for:");
        int i = 0;


        for(String wordSearch : words){
            if (wordSearch.contains(searchString)){
                if (i <100){
                    UI.println(wordSearch);
                }
                i=i+1;
           }
           
        }

        UI.println("Total matching words: "+i);
    }

}

