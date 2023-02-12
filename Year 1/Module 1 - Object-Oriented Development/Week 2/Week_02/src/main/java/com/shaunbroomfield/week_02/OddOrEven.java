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
public class OddOrEven {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Enter a value: ");
        int value = Integer.parseInt(keyboard.nextLine());
    
        Boolean isEven = false;
        if ((value % 2) == 0) {
            isEven = true;
        }
        
        System.out.println(value + " is " + (isEven ? "even" : "odd"));
    }
}
