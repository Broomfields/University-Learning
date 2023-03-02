// C_LinkedList_App.java
// program to test class C_LinkedList
// adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class

package c_linkedlist_app;

import java.util.Scanner;

public class C_LinkedList_App
{
    public static void main(String[] args)
    {
        
       C_LinkedList clL1 = new C_LinkedList();
       System.out.println("List has " + clL1.getSize() + " elements");
       Scanner input = new Scanner(System.in);
      
       clL1.addFirst(1);
       System.out.println("List has " + clL1.getSize() + " elements");
       System.out.println(clL1.toString());
       System.out.println("First element is " + clL1.getFirst() +
                                               ", last element is " + clL1.getLast());
       clL1.addLast(2);
       System.out.println("List has " + clL1.getSize() + " elements");
       System.out.println(clL1.toString());
       System.out.println("First element is " + clL1.getFirst() +
                                               ", last element is " + clL1.getLast());
       clL1.addLast(3);
       System.out.println("List has " + clL1.getSize() + " elements");
       System.out.println(clL1.toString());
       System.out.println("First element is " + clL1.getFirst() +
                                               ", last element is " + clL1.getLast());
       clL1.addFirst(4);
       System.out.println("List has " + clL1.getSize() + " elements");
       System.out.println(clL1.toString());
       System.out.println("First element is " + clL1.getFirst() +
                                               ", last element is " + clL1.getLast());
       clL1.addFirst(5);
       System.out.println("List has " + clL1.getSize() + " elements");
       System.out.println(clL1.toString());
       System.out.println("First element is " + clL1.getFirst() +
                                               ", last element is " + clL1.getLast());
       
       System.out.println("please enter the value to be searched");
       int n = input.nextInt();
       
       ListNode current = clL1.searchPointer(n);
       if (current != null)
       {
           System.out.println("found value : " + current.data);
       }
       
       int p = clL1.searchIndex(n);
       if (p != -1)
       {
           System.out.println("found value at position: " + p);
       }
       
       C_LinkedList clL2 = new C_LinkedList();
       System.out.println("List clL2 has " + clL2.getSize() + " elements");
       System.out.println("sentinel value = " + clL2.head.data);
       if (clL2.isEmpty() == true)
         System.out.println("List clL2 is empty");
       
       System.out.println("\n\n");
       int[] a = {1, 2, 3, 4, 5, 6, 7};
       C_LinkedList clL3 = new C_LinkedList(a);
       
       System.out.println("List has " + clL3.getSize() + " elements");
       String s = clL3.toString();
       System.out.println("list content = " + s);
       
       System.out.println("please enter the node to be deleted");
       n = input.nextInt();
       System.out.println("deleting " + n + clL3.ordinality(n)  + " node...");
       if (clL3.delete(n) == true)
           System.out.println("delete() returned true");
       System.out.println("List has " + clL3.getSize() + " elements");  
       System.out.println(clL3.toString());
      
       clL3.addAfterPos(29, 3);
       System.out.println("After insertion, list has " + clL3.getSize() + " elements");
       s = clL3.toString();
       System.out.println("list content = " + s);
       
       System.out.println("5" + clL3.ordinality(5) + " item in list is now " + clL3.getAtPos(5));
    }
	
} // end class C_LinkedList_App