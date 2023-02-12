/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_02;

import java.util.Scanner;

/**
 *
 * @author Shaun Broomfield
 */
public class EmployeeManager {
 
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Enter the number of hours worked this week: ");
        int hoursWorkedThisWeek = Integer.parseInt(keyboard.nextLine());
        
        double hourlyRate = 9.75;
        
        double additionalRate = 4.75;
        int standardHoursCap = 45;
        
        double additionalPay = additionalRate * Math.max(0, (hoursWorkedThisWeek - standardHoursCap)); 
        
        double wage = (hoursWorkedThisWeek * hourlyRate) + additionalPay;
        
        System.out.println("This week's wage = " + wage);
    }
}
