/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingtest;

/**
 *
 * @author U0033257
 */
import java.util.Random;
import static sortingtest.SortingTest.generateData;

public class SortingTest
{

  static final int arraySize = 23;
  static final int maxValue  = 50;
  static final int MAX 	   = 32767;
    
  static int[] dataArray = new int[arraySize];
 
    // HELPER METHODS ##############################
  
  static void generateData(int maxDataValue)
  {
    Random randomGenerator = new Random();
      
    for (int i = 0; i < arraySize; i++)
      dataArray[i] = randomGenerator.nextInt(maxDataValue);
  }

  
  static void printArrayContents(String labelText)
  {
    System.out.print(labelText + " Array contents : { ");
      
    for (int i = 0; i < arraySize; i++)
		System.out.print(dataArray[i] + " ");
	      
    System.out.println("}");
  }
  
  
  static void swap(int[] a, int k, int l)
  {
    int temp = a[k];
    a[k] = a[l];
    a[l] = temp;
  }

  // SORTING ALGORITHMS ###########################

  // bubble Sort
  static void bubbleSort()
  {
    // YOUR CODE GOES HERE
  }
  
  
  // bubble Sort optimized
  static void bubbleSort_opt1()
  {
    // YOUR CODE GOES HERE
  }

  
  // bubble Sort optimized
  static void bubbleSort_opt2()
  {
    // YOUR CODE GOES HERE
  }
  
  // CocktailShaker Sort
  static void shakerSort()
  {
    // YOUR CODE GOES HERE
  }
  
 //###################################################   Selection and Insertion Sort - To be done in Week 4 (Next week) ################################### 
  // Selection Sort
  static void selectionSort()
  {
    // YOUR CODE GOES HERE
  }
  
  
// Insertion Sort
  static void insertionSort()
  {
    // YOUR CODE GOES HERE
  }
  
  //######################################################################################################################
  
  public static void main(String[] args) 
  {
    // Bubble sort
    generateData(maxValue);
    printArrayContents("\nUnsorted		");
    
    System.out.println("Sorting...");
    bubbleSort();
    printArrayContents("Bubble			");
    /*  
    // Bubble sort optimised 1
    generateData(maxValue);
    printArrayContents("\nUnsorted		");
    
    System.out.println("Sorting...");
    bubbleSort_opt1();
    printArrayContents("Bubble opt 1		");
    
    // Bubble sort optimised 2
    generateData(maxValue);
    printArrayContents("\nUnsorted		");
    
    System.out.println("Sorting...");
    bubbleSort_opt2();
    printArrayContents("Bubble opt 2		");
      
    // Cocktail Shaker sort
    generateData(maxValue);
    printArrayContents("\nUnsorted		");

    System.out.println("Sorting...");
    shakerSort();
    printArrayContents("Shaker			");
    
    //###################################################   Selection and Insertion Sort - For Week 4/Next week ###################################
     // Selection sort
    generateData(maxValue);
    printArrayContents("\nUnsorted		");
    
		System.out.println("Sorting...");
    selectionSort();
    printArrayContents("Selection		");
    
    // Insertion sort
    generateData(maxValue);
    printArrayContents("\nUnsorted		");
    
		System.out.println("Sorting...");
    insertionSort();
    printArrayContents("Insertion		");
    
     //###################################################################################################################### 
    */
  }

  
  

 
}// end of class