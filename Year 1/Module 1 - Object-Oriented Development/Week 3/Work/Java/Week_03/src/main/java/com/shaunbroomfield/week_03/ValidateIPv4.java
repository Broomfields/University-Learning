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
public class ValidateIPv4 {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Enter an IPv4 address: ");
        String address = keyboard.nextLine();

        String[] parts = address.split(".");
        
        int index = 0;
        int count = parts.length;
        boolean addressValid = count > 0;
        while(addressValid && index < count) {
        
            int part = Integer.parseInt(parts[index++]);
            
            if (part > 255 || part < 0) {
                addressValid = false;
            }
            
        }
        
        System.out.println("The given address \"" + address + "\" is " + (addressValid ? "valid" : "invalid") + ".");

    }
    
}
