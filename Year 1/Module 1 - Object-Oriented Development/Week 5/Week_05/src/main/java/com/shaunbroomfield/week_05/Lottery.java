/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_05;

import java.util.Scanner;

/**
 *
 * @author Shaun Broomfield
 */
public class Lottery {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int[] lottery_numbers = new int[7];

        System.out.println("Please enter 7 numbers");

        for (int index = 0; index < lottery_numbers.length; index++) {
            System.out.println(
                    String.format("Number %d:", index + 1));

            int number = keyboard.nextInt();

            lottery_numbers[index] = number;
        }

        for (int index = 0; index < lottery_numbers.length; index++) {
            System.out.println(
                    String.format(
                            "Number %d: %3d",
                            index + 1,
                            lottery_numbers[index]));
        }
    }

}
