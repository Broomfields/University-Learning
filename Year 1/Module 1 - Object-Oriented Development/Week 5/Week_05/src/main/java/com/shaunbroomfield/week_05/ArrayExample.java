/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_05;

/**
 *
 * @author Shaun Broomfield
 */
public class ArrayExample {

    public static void main(String[] args) {

        // int[] array = { 12, 3, 5, -1, 0, 5, 99, 10 };
        // int[] array = { 12, 3, 5, 0, 5, 99, 10 }; // -1 removed
        int[] array = { 12, 3, 5, -1, 0, 5, 99, 10, 27, 11, 3, 2880, 8600, 314};

        int length = array.length;
        int index = 0;
        while (index++ < length) {
            System.out.printf(
                    "Index %d: Value: %d\n",
                    index,
                    array[index]);
        }

    }
}
