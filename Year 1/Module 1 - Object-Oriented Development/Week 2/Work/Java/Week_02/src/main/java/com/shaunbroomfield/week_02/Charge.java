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
public class Charge {

    // Get age from user
    // Set charge to 20.00 (assume adult)
    // If age less than 18 then
    //     Set charge to 15.00
    // End if
    // Print charge value with appropriate message
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Enter the user's age: ");
        int age = Integer.parseInt(keyboard.nextLine());
    
        double charge = 20.0;
        if (age < 18) {
            charge = 15.0;
        }
        
        System.out.println("Charge = " + charge);
    }
}
