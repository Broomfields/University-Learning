/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scanningarray;

import java.util.Random;

/**
 *
 * @author U0033257
 */
public class ScanningArray {

  static final int arraySize = 15;
  static final int maxValue = 50;
  static final int MAX = 32767;

  // static int[] dataArray = new int[arraySize];
  static int[] dataArray = new int[] { 41, 30, 19, 25, 38, 27, 2, 39, 23, 48, 7, 11, 16, 17, 24 };

  public static void main(String[] args) {
    // Use the method below if you want to test you method with a random array of
    // size maxValue
    // generateData(maxValue);

    printArrayContents("\n");

    ex1();
    ex2();
    ex3();
    ex4();
    ex5();
    ex6();
    ex7();
    ex8();
    ex9();

  }

  // **You can find below some useful methods to generate random data or display
  // the i-th element of your array**//
  // generate array of data
  static void generateData(int maxDataValue) {
    Random randomGenerator = new Random();

    for (int i = 0; i < arraySize; i++)
      dataArray[i] = randomGenerator.nextInt(maxDataValue);
  }

  // print content of array
  static void printArrayContents(String labelText) {
    System.out.print(labelText + "Array contents: {");

    for (int i = 0; i < arraySize; i++)
      System.out.print(dataArray[i] + " ");

    System.out.println("}");
  }

  // print cell currently visited
  static void visitCell(int index) {
    System.out.printf("%2d ", dataArray[index]);
  }

  // pack white spaces left
  static void packLeft(int k) {
    for (int i = 0; i < k; i++)
      System.out.print("   ");
  }

  // ###########################################################

  // scan array from left to right
  static void ex1() {
    // YOUR CODE GOES HERE
  }

  // scan array from right to left
  static void ex2() {
    // YOUR CODE GOES HERE
  }

  // scan array from left to centre, then right to centre
  static void ex3() {
    // YOUR CODE GOES HERE
  }

  // scan array from centre to left, then centre to right
  static void ex4() {
    // YOUR CODE GOES HERE
  }

  // scan array from left to right, then right to left
  static void ex5() {
    // YOUR CODE GOES HERE
  }

  // scan array from left to right, then right to left, as many time as there are
  // items in the array
  static void ex6() {
    // YOUR CODE GOES HERE
  }

  // scan array from left to right, then right to left,
  // then repeat process but at right end, each time, one cell short than the
  // previous pass
  static void ex7() {
    // YOUR CODE GOES HERE
  }

  // scan array from left to right, then right to left,
  // then repeat process but at left end, each time, one cell short than the
  // previous pass
  static void ex8() {
    // YOUR CODE GOES HERE
  }

  // scan array from left to right, then right to left,
  // then repeat process but at each end, each time, one cell short than the
  // previous pass
  static void ex9() {
    // YOUR CODE GOES HERE
  }

}
