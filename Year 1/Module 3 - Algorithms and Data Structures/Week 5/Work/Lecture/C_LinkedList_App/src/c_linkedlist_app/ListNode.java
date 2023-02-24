/** ListNode.java
 * class ListNode representing a node with information and link fields
 * adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
 * ADS class
 */

package c_linkedlist_app;

public class ListNode
{
    // Data fields
    int		data;	// data stored in the node
    ListNode	next;	//link to link node

    // Methods
    //Constructors
    // postcondition: Creates a new empty node
    public ListNode()
    {
            data = 0;
            next = null;
    }

    // postcondition: Creates a new node storing obj
    public ListNode(int obj)
    {
            data = obj;
            next = null;
    }

    // postcondition: Creates a new node storing obj
    // and linked to node referenced by link.
    public ListNode(int obj, ListNode nxt)
    {
            data = obj;
            next = nxt;
    }
} // end of class ListNode