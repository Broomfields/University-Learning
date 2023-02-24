// LinkedList_App.java
// program to test class LinkedList
// taken from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class
package linkedlist_app;

import java.util.Scanner;

public class LinkedList_App {

    public static void main(String[] args) {
        LinkedList lL = new LinkedList();
        System.out.println("List has " + lL.getSize() + " elements");
        Scanner input = new Scanner(System.in);

        lL.addFirst(1);
        System.out.println(lL.toString());
        System.out.println("List has " + lL.getSize() + " elements");
        System.out.println("First element is " + lL.getFirst()
                + ", last element is " + lL.getLast());
        lL.addLast(2);
        System.out.println(lL.toString());
        System.out.println("List has " + lL.getSize() + " elements");
        System.out.println("First element is " + lL.getFirst()
                + ", last element is " + lL.getLast());
        lL.addLast(3);
        System.out.println(lL.toString());
        System.out.println("List has " + lL.getSize() + " elements");
        System.out.println("First element is " + lL.getFirst()
                + ", last element is " + lL.getLast());
        lL.addFirst(4);
        System.out.println(lL.toString());
        System.out.println("List has " + lL.getSize() + " elements");
        System.out.println("First element is " + lL.getFirst()
                + ", last element is " + lL.getLast());
        lL.addFirst(5);
        System.out.println(lL.toString());
        System.out.println("List has " + lL.getSize() + " elements");
        System.out.println("First element is " + lL.getFirst()
                + ", last element is " + lL.getLast());

        System.out.println("please enter the value to be searched");
        int n = input.nextInt();

        ListNode current = lL.searchPointer(n);
        if (current != null) {
            System.out.println("found value : " + current.data);
        }

        int p = lL.searchIndex(n);
        if (p != -1) {
            System.out.println("found value at position: " + p);
        }

        System.out.println("please enter the node to be deleted");
        n = input.nextInt();
        System.out.println("deleting " + n + lL.ordinality(n) + " node...");
        if (lL.delete(n) == true) {
            System.out.println("delete() returned true");
        }

        System.out.println(lL.toString());
        System.out.println("List has " + lL.getSize() + " elements");
        System.out.println("First element is " + lL.getFirst()
                + ", last element is " + lL.getLast());

        int[] a = {1, 2, 3, 4, 5, 6, 7};
        LinkedList lL1 = new LinkedList(a);

        System.out.println("List has " + lL1.getSize() + " elements");
        System.out.println(lL1.toString());
        System.out.println("First element is " + lL1.getFirst()
                + ", last element is " + lL1.getLast());

        System.out.println("please enter the node index whose data need retrieving");
        p = input.nextInt();
        System.out.println("node index " + p + " data value : " + lL1.getAtPos(p));

        System.out.println("please enter the index after which to insert a new node");
        p = input.nextInt();
        if (lL1.addAfterPos(10, p) == true) {
            System.out.println("node inserted");
        }
        System.out.println(lL1.toString());

        LinkedList lL2 = new LinkedList();
        if (lL2.addAfterPos(29, 1) == true) {
            System.out.println("node inserted in empty list");
        }

        lL2.addFirst(29);
        if (lL2.addAfterPos(29, 1) == true) {
            System.out.println("node inserted in list");
        }

    }

} // end class LinkedList_App
