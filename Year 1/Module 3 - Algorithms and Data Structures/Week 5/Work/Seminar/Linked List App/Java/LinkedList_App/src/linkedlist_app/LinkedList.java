// LinkedList.java
// program demonstrating the implementation and use of a linked-list in java
// taken from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class
package linkedlist_app;

import java.util.NoSuchElementException;

public class LinkedList
{

    // Data fields (member variable)
    ListNode head;	// pointer to first node in list

    // Methods
    // default constructor - creates an empty list
    public LinkedList()
    {
        head = null;
    }

    // Constructor - creates a list from an array. The array is passed as a parameter
    public LinkedList(int[] a)
    {
        // DO NOT MODIFY THIS CONSTRUCTOR.

        // Populate list.
        for (int i = a.length - 1; i >= 0; i--)
        {
            head = new ListNode(a[i], head);
        }

    }

    // postcondition: Adds a node storing obj at front of this list.
    public void addFirst(int obj)
    {
        ListNode newNode = new ListNode(obj);
        newNode.next = head;
        head = newNode;
    }

    // postcondition: Returns the length of this list.
    public int getSize()
    {
        int size = 0;
        ListNode current = head;
        while (current != null)
        {
            size++;
            current = current.next;
        }
        return size;
    }

    // precondition: The last link node has a null link.
    // postcondition: Returns a string formed by concatenating the 
    //	data fields of all list nodes.
    @Override
    public String toString()
    {
        String result = "";
        ListNode current = head;
        while (current != null)
        {
            result += current.data + " ";
            current = current.next;
        }
        return result.trim();
    }

    // postcondition: Returns int stored at head of this list.
    public int getFirst()
    {
        if (head == null)
        {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    // postcondition: Returns int stored at end of this list.
    public int getLast()
    {
        if (head == null)
        {
            throw new NoSuchElementException();
        }
        ListNode current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        return current.data;
    }

    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj)
    {
        ListNode newNode = new ListNode(obj);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            ListNode current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a pointer to node containing a desired value, or null if not found
    public ListNode searchPointer(int n)
    {
        ListNode current = head;
        while (current != null)
        {
            if (current.data == n)
            {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a one-based index to node containing a desired value, or -1 if not found
    public int searchIndex(int n)
    {
        ListNode current = head;
        int index = 1;
        while (current != null)
        {
            if (current.data == n)
            {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: nth node is deleted if it exists. A 1-based index is used
    public boolean delete(int n)
    {
        if (head == null)
        {
            return false;
        }
        else if (head.data == n)
        {
            head = head.next;
            return true;
        }
        else
        {
            ListNode previous = head;
            ListNode current = head.next;
            while (current != null)
            {
                if (current.data == n)
                {
                    previous.next = current.next;
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    // postcondition: retrieves the data stored in node at position index of list.
    public int getAtPos(int index)
    {
        ListNode current = head;
        int count = 0;

        while (current != null)
        {
            if (count == index)
            {
                return current.data;
            }
            count++;
            current = current.next;
        }

        // index is out of range
        throw new IndexOutOfBoundsException("Index " + index + " is out of range.");
    }

    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int obj, int index)
    {
        ListNode current = head;
        int count = 0;

        while (current != null)
        {
            if (count == index)
            {
                ListNode newNode = new ListNode(obj);
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            count++;
            current = current.next;
        }

        // index is out of range
        return false;
    }

    // Method used in print statements - DO NOT ALTER !
    public String ordinality(int n)
    {
        String pos;

        if ((n % 10 == 1) && (n != 11))
        {
            pos = "st";
        }
        else if ((n % 10 == 2) && (n != 12))
        {
            pos = "nd";
        }
        else if ((n % 10 == 3) && (n != 13))
        {
            pos = "rd";
        }
        else
        {
            pos = "th";
        }

        return pos;
    }

} // end of class LinkedList
