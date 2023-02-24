/** AddLastTest.java
 * program to unit-test the addLast method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class AddLastTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the addLast() method of class LinkedList\n");
    }
    
    
    /**
     * Test 1 of addLast method, of class LinkedList.
     */
    @Test
    public void test_emptyList_headNotNull()
    {
        System.out.println("> Test1 - test_emptyList_headNotNull(): head should not be null");
        int obj = 7;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("inserting a new node at end of empty list...");
        instance.addLast(obj);
        // test node insertion
        assertNotNull("head points to null", instance.head);
        System.out.println("As expected, head is no longer null");
    }
    
    
    /**
     * Test 2 of addLast method, of class LinkedList.
     */
    @Test
    public void test_emptyList_newNodePointsToNull()
    {
        System.out.println("> Test2 - test_emptyList_newNodePointsToNull(): new node should point to null");
        int obj = 7;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("inserting a new node at end of empty list...");
        instance.addLast(obj);
        // test node insertion
        assertNull("new node does not point to null", instance.head.next);
        System.out.println("As expected, new node successfully points to null");
    }
    
    
    /**
     * Test 3 of addLast method, of class LinkedList.
     */
    @Test
    public void test_emptyList_newValueInsertedInNode()
    {
        System.out.println("> Test3 - test_emptyList_newValueInsertedInNode(): new data value should be in new node");
        int obj = 7;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("inserting a new node at end of empty list...");
        instance.addLast(obj);
        // test node insertion
        assertEquals("new data value not found in new node", instance.head.data, obj);
        System.out.println("As expected, new data successfully stored in new node");
    }
    
    
    /**
     * Test 4 of addLast method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_endOfExistingListNotNull()
    {
        System.out.println("> Test4 - test_nonEmptyList_endOfExistingListNotNull(): end of existing-list should no longer point to null");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head;
        int nodesInList = a.length;
        for (int i = 1; i < nodesInList; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertNotNull("end of existing-list points to null", current.next);
        System.out.println("As expected, the end of the existing list no longer points to null");
    }
    
    
    /**
     * Test 5 of addLast method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_newNodePointsToNull()
    {
        System.out.println("> Test5 - test_nonEmptyList_newNodePointsToNull(): new node should point to null");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head;
        int nodesInList = a.length;
        for (int i = 1; i < nodesInList; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertNull("new node does not point to null", current.next.next);
        System.out.println("As expected, new node points to null");
    }
    
    
    /**
     * Test 6 of addFirst method, of class LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newValueInsertedInNode()
    {
        System.out.println("> Test6 - test_nonEmptyList_newValueInsertedInNode(): new data value should be in new node");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head;
        int nodesInList = a.length;
        for (int i = 1; i < nodesInList; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertEquals("new data value not found in new node", current.next.data, obj);
        System.out.println("As expected, new data value successfully inserted in new node");
    }
}
