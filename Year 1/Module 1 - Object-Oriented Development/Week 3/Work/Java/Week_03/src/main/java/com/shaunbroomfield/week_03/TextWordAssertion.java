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
public class TextWordAssertion {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); // Create a Scanner object

        String word1 = "";
        String word2 = "";

        boolean entered = false;
        do {

            System.out.println("Enter a string containing two names (words seperated by whitespace): ");
            word1 = keyboard.next();
            word2 = keyboard.next();

            if (word1.length() == 0 || word2.length() == 0) {

                System.out.println("The string MUST contain two names (words seperated by whitespace): ");

            } else {

                entered = true;

            }

        } while (!entered);

        if (word1.length() == word2.length()) {

            System.out.println("Both of the names entered are the same length.");

        } else {

            System.out.println("The order of the names as dictated by length are:");

            if (word1.length() > word2.length()) {
                System.out.println("(1) \"" + word1 + "\" - length = " + word1.length() + ".");
                System.out.println("(2) \"" + word2 + "\" - length = " + word2.length() + ".");
            } else if (word2.length() > word1.length()) {
                System.out.println("(1) \"" + word2 + "\" - length = " + word2.length() + ".");
                System.out.println("(2) \"" + word1 + "\" - length = " + word1.length() + ".");
            }

        }

        System.out.println("Case test:");
        System.out.println("Upper : " + word1.toUpperCase());
        System.out.println("Lower : " + word2.toLowerCase());

        
        System.out.println("Case mutability test:");
        System.out.println(word1);
        System.out.println(word2);
    }
}
