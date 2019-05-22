// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2019T1, Assignment 2
 * Name: Christopher Yee
 * Username: yeechri2
 * ID: 300508277
 */

import ecs100.*;
import java.awt.Color;
//import java.util.ArrayList;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /**
     * Asks user for three integers and then checks if it is a valid date.
     */
    public void doCore(){
        int day = UI.askInt("Day:   ");
        int month = UI.askInt("Month: ");
        int year = UI.askInt("Year:  ");
        this.validateDateCore(day, month, year);
    }

    /** CORE
     * Determines whether the date specified by the three integers is a valid date.
     * Should report any components of the date that are invalid
     *  and report whether the whole date is valid or not.
     * For the Core, you may assume that
     * - All months have 31 days, numbered 1 to 31
     * - The months run from 1 to 12
     * - Years start from 1
     */
    public void validateDateCore(int day, int month, int year){
        if ((day<1 || day>31)||(month<1 || month>12)||(year<1)){
            if (day<1 || day>31){
                UI.printf("Day %d is invalid. ", day);
            }
            if (month<1 || month>12){
                UI.printf("Month %d is invalid. ", month);
            }
            if (year<1){
                UI.printf("Year %d is invalid. ", year);
            }
            UI.printf("This is not a valid date. \n");
        }
        else {
            UI.printf("Date is %d/%d/%d\n", day, month, year);
        }
    }

    /**
     * Asks user for three integers and then checks if it is a valid date.
     */
    public void doCompletion(){
        int day = UI.askInt("Day:   ");
        int month = UI.askInt("Month: ");
        int year = UI.askInt("Year:  ");
        this.validateDateCompletion(day, month, year);
    }

    /** COMPLETION
     * Determines whether the date specified by the three integers is a valid date.
     * Reports any components of the date that are invalid
     * Prints if the date is valid or not valid
     * For the Completion, you should check that
     * - Months have the correct number of days
     * - On leap years February can have 29 days.
     *    A year is a leap year if:
     *       - The year can be evenly divided by 4 but not 100, (eg 2016 but not 1900) OR
     *       - The year can be evenly divided by 400    (eg 2000)
     */

    public void validateDateCompletion(int day, int month, int year){

        //if leapYearChk has remainder values, it is not a leap year, else it is a leap year
        //if Feb has 29 days, check if year entered is a leap year
        int leapYearChk;
        boolean invalid = false;
        //String[] dayArray = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        if(year%400 !=0) {
            leapYearChk = 28;
        }
        else {
            leapYearChk = 29;
        }
        if ((day<1||day>leapYearChk)&&(month == 2)){
            UI.printf("Day %d is invalid for month %d.\n", day, month);//Feb = 28/29. Apr, Jun, Sep, Nov = 30
            invalid = true;
        }
        else if (((day<1)||(day>30))&&((month == 4)||(month == 6)||(month == 9)||(month == 11))){
            UI.printf("Day %d is invalid.\n", day);
            invalid = true;
        }
        else if (day<1 || day>31){
            UI.printf("Day %d is invalid.\n", day);
            invalid = true;
        }
        if (month<1 || month>12){
            UI.printf("Month %d is invalid.\n", month);
            invalid = true;
        }
        if (year<1){
            UI.printf("%d is an invalid year.\n", year);
            invalid = true;
        }
        if (invalid == true){
            UI.printf("%d/%d/%d is not a valid date.\n", day, month, year);
        }
        else {
            UI.printf("Date is %d/%d/%d\n", day, month, year);
        }
        if(leapYearChk == 29) {
            UI.printf("%d is a leap year.\n", year);
        }
        else if(leapYearChk == 28){
            UI.printf("%d is not leap year.\n", year);
        }
    }
}
