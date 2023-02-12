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
public class Area {
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter width: ");
        int width = in.nextInt();

        System.out.print("Please enter height: ");
        int height = in.nextInt();

        System.out.println("\nThe area is: " + calcArea(width, height));
    }
    
    private static double calcArea(double width, double height) {
        return (width * height);
    }
}
