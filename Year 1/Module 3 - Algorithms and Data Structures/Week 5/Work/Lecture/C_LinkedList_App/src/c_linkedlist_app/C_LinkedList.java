// C_LinkedList.java
// program demonstrating the implementation and use of a circular linked-list in java.
// This variation contains a dummy or sentinel node to simplify and accelerate some of the list-handling algorithms.
// This node marks the start of the list (and end of the list).
// head always points to the dummy/sentinel node. A 1-based indexing system is used.
// adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class
package c_linkedlist_app;

public class C_LinkedList
{

    // Data fields (member variable)
    ListNode head;	// pointer to dummy/sentinel node in list. This marks the start of the list.

    // default constructor - creates an empty list with only a sentinel node containing sentinel value 999
    // head points towards the dummy/sentinel node
    public C_LinkedList()
    {
        ListNode newNode = new ListNode(999);
        head = newNode;
        newNode.next = head;
    }

    // Constructor - creates a circular list from an array. The array and its size are passed as parameters
    // head points towards the dummy/sentinel node
    public C_LinkedList(int[] a)
    {
        ListNode last = null;
        ListNode newNode = null;
        ListNode prev = null;
        int size = a.length;
        for (int iota = 1; iota <= size; iota++)
        {
            newNode = new ListNode(a[size - iota], prev);
            if (iota == 1)
            {
                last = newNode;
            }
            prev = newNode;
        }
        head = new ListNode(999, newNode);
        last.next = head;
    }

    // Methods
    // Method to check if circular linked lists is empty
    public boolean isEmpty()
    {
        return head.next == head;
    }

    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj)
    {
        ListNode node = new ListNode(obj, head);
        ListNode current = head;
        while (current.next != head)
        {
            current = current.next;
        }
        current.next = node;
    }

    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int obj, int index)
    {
        if (index < 1)
        {
            return false;
        }
        
        ListNode current = head.next;
        for (int iota = 1; iota < index && current.next != head; iota++)
        {
            current = current.next;
        }
        
        if (index > getSize() || current == head)
        {
            return false;
        }

        ListNode node = new ListNode(obj, current.next);
        current.next = node;
        return true;
    }

    // postcondition: Returns int stored at head of this list.
    public int getFirst()
    {
        if (head.next == head)
        {
            throw new IllegalStateException("List is empty");
        }
        return head.next.data;
    }

    // postcondition: Returns int stored at end of this list.
    public int getLast()
    {
        if (head.next == head)
        {
            throw new IllegalStateException("List is empty");
        }
        ListNode current = head.next;
        while (current.next != head)
        {
            current = current.next;
        }
        return current.data;
    }

    // postcondition: retrieves the data stored in node at position index of list.
    public int getAtPos(int index)
    {
        if (index < 1 || index > getSize())
        {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        ListNode current = head.next;
        for (int iota = 1; iota < index; iota++)
        {
            current = current.next;
        }
        return current.data;
    }

    // postcondition: Returns the length of this list.
    public int getSize()
    {
        int size = 0;
        ListNode current = head.next;
        while (current != head)
        {
            size++;
            current = current.next;
        }
        return size;
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: Returns a string formed by concatenating the
    // data fields of all list nodes.
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        ListNode current = head.next;
        while (current != head)
        {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: nth node is deleted if it exists. A 1-based index is used.
    public boolean delete(int node)
    {
        if (node < 1 || node > getSize())
        {
            return false;
        }
        ListNode current = head;
        for (int iota = 0; iota < node - 1; iota++)
        {
            current = current.next;
        }
        current.next = current.next.next;
        return true;
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: returns a pointer to node containing a desired value, or null if not found
    public ListNode searchPointer(int node)
    {
        // YOUR CODE GOES HERE
    }// end of method searchPointer()

    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: returns a one-based index to node containing a desired value, or -1 if not found
    public int searchIndex(int node)
    {
        // YOUR CODE GOES HERE
    }// end of method searchIndex()

    // Method used in print statements
    public String ordinality(int node)
    {
        String pos;

        if ((node % 10 == 1) && (node != 11))
        {
            pos = "st";
        }
        else if ((node % 10 == 2) && (node != 12))
        {
            pos = "nd";
        }
        else if ((node % 10 == 3) && (node != 13))
        {
            pos = "rd";
        }
        else
        {
            pos = "th";
        }

        return pos;
    }

    //public boolean isEmpty()
//    {
//        if (head.next == head)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//        //return(head.next==head);
//    }

    public String listToString()
    {
        ListNode current = head.next;
        String output = "";
        //stop once current is at the head again
        //current.data == 999;
        while (current != head)
        {
            output = output + current.data + " ";
            current = current.next;
        }
        return output;
    }

    public boolean isSecondEven()
    {
        //check if the list doesn't have a second item
        if (head.next.next == head)
        {
            System.out.println("There is no second item");
            return false;
        }
        //get second item
        int secItem = head.next.next.data;
        if (secItem % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        //return(secItem%2==0);
    }

} // end of class C_LinkedList
