/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_06;

import java.util.Scanner;

/**
 *
 * @author Shaun Broomfield
 */
public class GradeMethods {
    
    public static void main(String[] args) {
        int mark = getMark();
        System.out.print("The Mark is: " + mark);
        
        char grade = getGrade(mark);
        System.out.print("The Grade is: " + grade);
    }
    
    public static int getMark() {
        
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a grade (0-100):");
        int mark = keyboard.nextInt();
       
        if (mark < 0 || mark > 100) {
            mark = -1;
        }
        
        return mark;
    }
    
    
    public static char getGrade(int mark) {
        
        // A is 70 or more, B is 60-69, C is 50-59, D is 40-49 and F is 0-39.
            
        char grade = ' ';
        if (mark >= 70) {
            grade = 'A';
        }
        else if (mark <= 69 && mark >= 60) {
            grade = 'B';
        }
        else if (mark <= 59 && mark >= 50) {
            grade = 'C';
        }
        else if (mark <= 49 && mark >= 40) {
            grade = 'D';
        }
        else if (mark <= 39) {
            grade = 'F';
        }
        
        return grade;
    }

}
