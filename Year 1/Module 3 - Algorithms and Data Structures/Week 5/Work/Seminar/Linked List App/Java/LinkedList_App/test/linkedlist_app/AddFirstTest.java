/** AddFirstTest.java
 * program to unit-test the addFirst method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class AddFirstTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the addFirst() method of class LinkedList\n");
    }
    

    /**
     * Test 1 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_emptyList_headNotNull()
    {
        System.out.println("> Test1 - test_emptyList_headNotNull(): head should not be null");
        int obj = 7;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("inserting a new node at front of empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNotNull("head points to null", instance.head);
        System.out.println("As expected, head is no longer null");
    }
    
    
    /**
     * Test 2 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_emptyList_newNodePointsToNull()
    {
        System.out.println("> Test2 - test_emptyList_newNodePointsToNull(): new node should point to null");
        int obj = 7;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("inserting a new node at front of empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNull("new node does not point to null", instance.head.next);
        System.out.println("As expected, new node successfully points to null");
    }
    
    
    /**
     * Test 3 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_emptyList_newValueInsertedInNode()
    {
        System.out.println("> Test3 - test_emptyList_newValueInsertedInNode(): new data value should be in new node");
        int obj = 7;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("inserting a new node at front of empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertEquals("new data value not found in new node", instance.head.data, obj);
        System.out.println("As expected, new data successfully stored in new node");
    }
     
    
    /**
     * Test 4 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_headNotNull()
    {
        System.out.println("> Test4 - test_nonEmptyList_headNotNull(): head should remain not null");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNotNull("head points to null", instance.head);
        System.out.println("As expected, head is still not null");
    }
    
    
    /**
     * Test 5 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_newNodePointsNotToNull()
    {
        System.out.println("> Test5 - test_nonEmptyList_newNodePointsNotToNull(): new node should not point to null");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNotNull("new node points to null", instance.head.next);
        System.out.println("As expected, new node does not point to null");
    }
    
    
    /**
     * Test 6 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_newNodeConnectedToList()
    {
        System.out.println("> Test6 - test_nonEmptyList_newNodeConnectedToList(): new node should be connected to list");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // mark start of list
        ListNode current = instance.head;
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertEquals("new node not connected to rest of list", instance.head.next, current);
        System.out.println("As expected, new node successfully connected to front of linked-list");
    }
    
    
    /**
     * Test 7 of addFirst method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_newValueInsertedInNode()
    {
        System.out.println("> Test7 - test_nonEmptyList_newValueInsertedInNode(): new data value should be in new node");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertEquals("new data value not found in new node", instance.head.data, obj);
        System.out.println("As expected, new data value successfully inserted in new node");
    }
   
}