/** AddLastTest.java
 * program to unit-test the addLast method of class LinkedList
 */
package c_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class AddLastTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the addLast() method of class C_LinkedList\n");
    }
    
    
    /**
     * Test 1 of addLast method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_dummyNodeLinkPointerNoLongerHead()
    {
        System.out.println("> Test1 - test_emptyList_dummyNodeLinkPointerNoLongerHead(): addLast in empty list: head.next should no longer be equal to head");
        int obj = 7;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("inserting a new node at end of empty list...");
        instance.addLast(obj);
        // test node insertion
        assertNotSame("head.next equals to head", instance.head.next, instance.head);
        System.out.println("As expected, head.next is no longer equal to head");
    }
    
    
    /**
     * Test 2 of addLast method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_newNodeLinkPointerEqualsHead()
    {
        System.out.println("> Test2 - test_emptyList_newNodeLinkPointerEqualsHead(): addFirst in empty list: new node's link pointer should be equal to head");
        int obj = 7;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("inserting a new node at end of empty list...");
        instance.addLast(obj);
        // test node insertion
        assertSame("new node's link pointer is not equal to head", instance.head.next.next, instance.head);
        System.out.println("As expected, new node's link pointer is successfully equal to head");
    }
    
    
    /**
     * Test 3 of addLast method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_newValueInsertedInNode()
    {
        System.out.println("> Test3 - test_emptyList_newValueInsertedInNode(): addLast in empty list: new data value should be in new node");
        int obj = 7;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("inserting a new node at end of empty list...");
        instance.addLast(obj);
        // test node insertion
        assertEquals("new data value not found in new node", instance.head.next.data, obj);
        System.out.println("As expected, new data successfully stored in new node");
    }
    
    
    /**
     * Test 4 of addLast method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_endOfExistingListNotHead()
    {
        System.out.println("> Test4 - test_nonEmptyList_endOfExistingListNotHead(): addLast in a non-empty list: end of existing-list should no longer point to head");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head.next;
        int size = a.length;
        for (int i = 1; i < size; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertNotSame("end of existing-list points to head", current.next, instance.head);
        System.out.println("As expected, the end of the existing list no longer points to head");
    }
    
    
    /**
     * Test 5 of addLast method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_newNodeLinkPointerEqualsHead()
    {
        System.out.println("> Test5 - test_nonEmptyList_newNodeLinkPointerEqualsHead(): addLast in non-empty list: new node's link pointer should equal to head");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head.next;
        int size = a.length;
        for (int i = 1; i < size; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertSame("new node's link pointer does not point to head", current.next.next, instance.head);
        System.out.println("As expected, new node's link pointer is equal to head");
    }
    
    
    /**
     * Test 6 of addFirst method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_endOfExistingListPointsToNewNode()
    {
        System.out.println("> Test6 - test_nonEmptyList_endOfExistingListPointsToNewNode(): addLast in non-empty list: last node in existing list should point to new node");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5};
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head.next;
        int size = a.length;
        for (int i = 1; i < size; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertEquals("last node in existing list does not point to new node", current.next.next, instance.head);
        System.out.println("As expected, last node in existing list points to new node");
    }
    
    
    /**
     * Test 7 of addFirst method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_newValueInsertedInNode()
    {
        System.out.println("> Test7 - test_nonEmptyList_newValueInsertedInNode(): addLast in non-empty list: new data value should be in new node");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5};
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head.next;
        int size = a.length;
        for (int i = 1; i < size; i++)
            current = current.next;
        System.out.println("inserting a new node at end of non-empty list...");
        instance.addLast(obj);
        // test node insertion
        assertEquals("new data value not found in new node", current.next.data, obj);
        System.out.println("As expected, new data value successfully inserted in new node");
    }
}
