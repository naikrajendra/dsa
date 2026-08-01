package com.hackerrank.warmup;

/**
 * DayOfProgrammer class provides a method to determine the date of the 
 * 256th day of the year, known as the "Day of the Programmer," based on the given year. 
 * The method accounts for leap years and the transition from the Julian to the 
 * Gregorian calendar.
 * 
 * DayOfProgrammer
 */

public class DayOfProgrammer {

    public static String dayOfProgrammer(int year) {
    // Write your code here
    // is year falls into Julian Calender i.e. 1700 - 1917
    // find if year is leap year as per Julian Calender calculations 
    // i.e. divisible by 4
    // if leapYear, return 12.09.year else 13.09.year
    // if year == 1918
    // check if it is leapYear, if yes, 12+13 = 25.09.1918 else 13+13 = 16.09.1918 
    // if year > 1918
    // find if it is leapYear - divisble 400, 4 but not 100
    // if it is leapYear, dayOfprogrammer 12.09.year
    // else 13.09.year
        // 1984, 2017, 2016,1800,1918
        if( year > 1699 && year < 1918) { //1800
            if ( year%4 == 0) {
                return "12.09." + year; //"12.09.1800"
            } else {
                return "13.09." + year;
            }           
        } else if ( year == 1918) {
            if (year%400 == 0 ||  (year%4 == 0 & year%100!=0)) { // 479
                return "25.09.1918";
            } else {
                return "26.09.1918"; //"26.09.1918"
            }
        } else if ( year > 1918 && year <= 2700) { //1984,2017, 2016
            if (year%400 == 0 ||  (year%4 == 0 & year%100!=0)) {
                return "12.09." + year; // "12.09.1984", "12.09.2016"
            } else {
                return "13.09." + year; // "13.09.2017"
            }
        } else {
            return "00.00.0000";
        }
    }

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1984));
        System.out.println(dayOfProgrammer(2017));
        System.out.println(dayOfProgrammer(2016));
        System.out.println(dayOfProgrammer(1800));
        System.out.println(dayOfProgrammer(1918));
    }

}


