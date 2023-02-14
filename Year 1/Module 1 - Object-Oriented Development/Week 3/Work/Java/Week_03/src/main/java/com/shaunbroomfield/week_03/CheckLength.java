/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_03;

import java.util.Scanner;

/**
 *
 * @author Shaun Broomfield
 */
public class CheckLength {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Enter a string where the length > 5 and < 10: ");
        String text = keyboard.nextLine();
        
        int length = text.length();
        String statement = "does not meet the parameters";
        if (length > 5 && length < 10) {
            statement = "meets the parameters";
        }
        
        System.out.println("The entered text " + statement + " as the length of the text is " + length + ".");
        
    }
}
