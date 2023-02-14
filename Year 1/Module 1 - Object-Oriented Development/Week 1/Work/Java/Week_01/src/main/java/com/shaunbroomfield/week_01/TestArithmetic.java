/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_01;

/**
 *
 * @author Shaun Broomfield
 */
public class TestArithmetic {
    
    // Write code declaring three variables of type int, called a, b and c
    // Initialise these variables to 3, 5 and 10 respectively.

    // Write code here assigning the sum of a and c to a new int 
    // variable called d
    // Print out the value of d. It should be 13

    // Write code here assigning the product of a and b to a new 
    // int variable called e
    // Print out the value of e. It should be 15.

    // Write code here assigning the remainder when c is divided by a to a 
    // new int variable called f
    // Print out the value of f. It should be 1.

    // Divide c by a and assign the result to a new int variable called g. 
    // Note that the result is technically incorrect (i.e. no decimal places).

    // Repeat the operation above, assigning the result to a double 
    // variable h.  Note the result is still technically incorrect 
    // (i.e. there is a decimal place, but it reads 0).
    // How can you get the correct answer (3.33333333)?

    // Declare an int variable called Celsius. Initialise it to 30. 
    // Now print out the Fahrenheit equivalent of this value.
    // To convert Celsius temperatures to Fahrenheit you 
    // multiply the temperature by 9/5 and add 32. If you are not getting 
    // the right answer, review your notes on operator precedence.

    // Declare an int variable called Fahrenheit. Initialise it to 0. 
    // Now print out the Celsius equivalent of this this value.

    
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c = 10;
        
        int d = a + b + c;
        System.out.println(d);

        int e = a * b;
        System.out.println(e);

        int f = (c % a);
        System.out.println(f);

        int g = (c / a);
        System.out.println(g);

        double h = (c / a);
        System.out.println(h);

        double i = ((double)c / a);
        System.out.println(i);

        int inCelsius = 30;
        int outFahrenheit = (int)(((double)inCelsius) * ((double)9/5)) + 32;
        System.out.println(outFahrenheit);

        int inFahrenheit = 0;
        int outCelsius = (int)((double)(inFahrenheit - 32) / ((double)9/5));
        System.out.println(outFahrenheit);
    }
    
    public static double formula1(double x, double y) {
        return (3 * x) + y;
    }
    
    public static double formula2(double x, double y) {
        return (x + y) / 7;
    }
    
    public static double formula3(double x, double y, double z) {
        return ((3 * x) + y) / (z + 2);
    }
}
