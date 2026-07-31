package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the grades for a class of students. The grades are integers in the range from 0 to 100.
 * A grade is considered failing if it is less than 40. If a student has a failing grade, it is rounded up to the next multiple of 5 if the difference between the grade and the next multiple of 5 is less than 3. If the grade is 38 or less, no rounding occurs as the result will still be a failing grade.
 * For example, if the grade is 84, it will be rounded to 85.
 * If the grade is 29, no rounding occurs as the result will still be a failing grade.
 * Given the initial grades for each of a number of students, write code to automate the rounding process.
 * 
 * GradingStudents
 */

public class GradingStudents {

        public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        //check if grades is not null and > 0
        if(grades == null && grades.size() < 1) return grades;
        List<Integer> roundedGrades = new ArrayList<>();
        // for loop to go over the each grade
        // 4, 73, 67, 38, 33
        for(int grade : grades) {
            
        // if grade < 38, dont do rounding
            if (grade < 38) {
                roundedGrades.add(grade); // 4, 33
                continue;
            }
        // if grade % 5 == 0, dont do rounding
            int mod = grade % 5; // 3, 2, 3
            if (mod == 0) {
                roundedGrades.add(grade);
                continue;
            }
        // if grade % 5 >= 3, grade = grade + modulus
            if (mod >= 3) {
                grade = grade + ( 5 - mod); // 73 + (5-3) = 75 , 38 + (5-3) = 40
                roundedGrades.add(grade); // 75, 40
            } else {
                roundedGrades.add(grade); // 67
                
            }
        // if grade % 5 < 3, dont do rounding
            
        // return roundedGrades; 
        }
        return roundedGrades;
        
    }

    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        grades.add(4);
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        List<Integer> res = gradingStudents(grades);
        System.out.println(res); // [4, 75, 67, 40, 33]
    }

}
