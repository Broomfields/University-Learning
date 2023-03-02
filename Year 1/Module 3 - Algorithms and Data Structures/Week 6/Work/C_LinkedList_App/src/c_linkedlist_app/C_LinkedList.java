// C_LinkedList.java
// program demonstrating the implementation and use of a circular linked-list in java.
// This variation contains a dummy or sentinel node to simplify and accelerate some of the list-handling algorithms.
// This node marks the start of the list (and end of the list).
// head always points to the dummy/sentinel node. A 1-based indexing system is used.
// adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class

package c_linkedlist_app;

public class C_LinkedList {
    // Data fields (member variable)
    ListNode head; // pointer to dummy/sentinel node in list. This marks the start of the list.

    // default constructor - creates an empty list with only a sentinel node
    // containing sentinel value 999
    // head points towards the dummy/sentinel node
    public C_LinkedList() {
        ListNode newNode = new ListNode(999);
        head = newNode;
        newNode.next = head;
    }

    // Constructor - creates a circular list from an array. The array and its size
    // are passed as parameters
    // head points towards the dummy/sentinel node
    public C_LinkedList(int[] a) {
        ListNode last = null;
        ListNode newNode = null;
        ListNode prev = null;
        int size = a.length;
        for (int i = 1; i <= size; i++) {
            newNode = new ListNode(a[size - i], prev);
            if (i == 1)
                last = newNode;
            prev = newNode;
        }
        head = new ListNode(999, newNode);
        last.next = head;
    }

    // Methods
    // --------

    // Method to check if circular linked lists is empty
    public boolean isEmpty() {
        return head.next == head;
    }

    // postcondition: Adds a node storing obj at front of this list.
    public void addFirst(int obj) {
        ListNode newNode = new ListNode(obj, head.next);
        head.next = newNode;
    }

    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj) {
        ListNode newNode = new ListNode(obj, head);
        ListNode current = head.next;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
    }

    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int obj, int index) {
        ListNode current = head.next;
        for (int i = 1; i < index; i++) {
            current = current.next;
            if (current == head) {
                return false;
            }
        }
        ListNode newNode = new ListNode(obj, current.next);
        current.next = newNode;
        return true;
    }

    // postcondition: Returns int stored at head of this list.
    public int getFirst() {
        return head.next.data;
    }

    // postcondition: Returns int stored at end of this list.
    public int getLast() {
        ListNode current = head.next;
        while (current.next != head) {
            current = current.next;
        }
        return current.data;
    }

    // postcondition: retrieves the data stored in node at position index of list.
    public int getAtPos(int index) {
        if (index <= 0 || isEmpty()) {
            throw new IndexOutOfBoundsException("Invalid index or list is empty");
        }

        ListNode current = head.next; // start from the first node

        for (int i = 1; i < index; i++) {
            current = current.next; // move to the next node
            if (current == head) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }

        return current.data; // return the data stored in the node at position index
    }

    // postcondition: Returns the length of this list.
    public int getSize() {
        int count = 0;
        ListNode current = head.next; // start from the first node

        while (current != head) {
            count++;
            current = current.next; // move to the next node
        }

        return count; // return the length of the list
    }

    // precondition: The last link node has a link to head.
    // postcondition: Returns a string formed by concatenating the
    // data fields of all list nodes.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = head.next; // start from the first node

        while (current != head) {
            sb.append(current.data).append(" "); // append the data stored in the current node
            current = current.next; // move to the next node
        }

        return sb.toString().trim(); // return the string representation of the list
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link
    // pointer of the last node, if it exists, points to head
    // postcondition: nth node is deleted if it exists. A 1-based index is used.
    public boolean delete(int n) {
        if (isEmpty()) {
            return false;
        }

        ListNode current = head.next; // start from the first node
        ListNode prev = head; // set prev to the dummy node

        for (int i = 1; i < n; i++) {
            prev = current;
            current = current.next; // move to the next node
            if (current == head) { // if we reach the dummy node before finding the nth node
                return false;
            }
        }

        prev.next = current.next; // unlink the current node
        current.next = null; // set the next reference of the current node to null

        return true; // node successfully deleted
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link
    // pointer of the last node, if it exists, points to head
    // postcondition: returns a pointer to node containing a desired value, or null
    // if not found
    public ListNode searchPointer(int n) {
        ListNode current = head.next; // start from the first node

        while (current != head) {
            if (current.data == n) {
                return current; // node containing the desired value found
            }
            current = current.next; // move to the next node
        }

        return null; // desired value not found
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link
    // pointer of the last node, if it exists, points to head
    // postcondition: returns a one-based index to node containing a desired value,
    // or -1 if not found
    public int searchIndex(int n) {
        ListNode current = head.next;
        int index = 1;
        while (current != head) {
            if (current.data == n) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1; // value not found in list
    }

    // Method used in print statements
    public String ordinality(int n) {
        String pos;

        if ((n % 10 == 1) && (n != 11))
            pos = "st";
        else if ((n % 10 == 2) && (n != 12))
            pos = "nd";
        else if ((n % 10 == 3) && (n != 13))
            pos = "rd";
        else
            pos = "th";

        return pos;
    }

} // end of class C_LinkedList
