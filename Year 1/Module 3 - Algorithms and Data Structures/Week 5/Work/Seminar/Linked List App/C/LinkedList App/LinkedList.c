// LinkedList.c
// program demonstrating the implementation and use of a linked-list in c
// taken from Problem Solving with C by Elliot Koffman and Ursula Woltz
// ADS class

package linkedlist_app;

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
        for (int i = a.length - 1; i >= 0; i--) {
            head = new ListNode(a[i], head);
        }
    
    }
    
    
   
    // postcondition: Adds a node storing obj at front of this list.
    public void addFirst(int obj)
    {
        // YOUR CODE GOES HERE
    }
    
        // postcondition: Returns the length of this list.
//    public int getSize()
    {
        // YOUR CODE GOES HERE
    }
    
    // precondition: The last link node has a null link.
    // postcondition: Returns a string formed by concatenating the 
    //	data fields of all list nodes.
//    @Override
//    public String toString()
    {
        // YOUR CODE GOES HERE
    }

    
    // postcondition: Returns int stored at head of this list.
//    public int getFirst()
    {
        // YOUR CODE GOES HERE
    }

    
    // postcondition: Returns int stored at end of this list.
//    public int getLast()
    {
        // YOUR CODE GOES HERE
    }
    
       
    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj)
    {
        // YOUR CODE GOES HERE
    }
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a pointer to node containing a desired value, or null if not found
//    public ListNode searchPointer(int n)
    {
        // YOUR CODE GOES HERE
    }// end of method searchPointer()
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a one-based index to node containing a desired value, or -1 if not found
//    public int searchIndex(int n)
    {
        // YOUR CODE GOES HERE
    }// end of method searchIndex()
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: nth node is deleted if it exists. A 1-based index is used
//    public boolean delete(int n)
    {
        // YOUR CODE GOES HERE
    }// end of delete() method
    
    
    // postcondition: retrieves the data stored in node at position index of list.
//    public int getAtPos(int index)
    {
        // YOUR CODE GOES HERE
    }

    
    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
//    public boolean addAfterPos(int obj, int index)
    {
        // YOUR CODE GOES HERE
    }
    
    
    // Method used in print statements - DO NOT ALTER !
    public String ordinality(int n)
    {
        String pos;
          
        if ((n%10 == 1) && (n != 11))
            pos = "st";
        else if ((n%10 == 2) && (n != 12))
            pos = "nd";
        else if ((n%10 == 3) && (n != 13))
            pos = "rd";
        else
            pos = "th";
        
        return pos;
    }
        
} // end of class LinkedList
