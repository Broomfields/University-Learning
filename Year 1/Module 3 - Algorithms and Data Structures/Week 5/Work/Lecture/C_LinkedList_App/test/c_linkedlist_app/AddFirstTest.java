/** AddFirstTest.java
 * program to unit-test the addFirst method of class C_LinkedList
 * July 2015
 * @author Eudes Diemoz
 */
package c_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class AddFirstTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the addFirst() method of class C_LinkedList\n");
    }
   

    /**
     * Test 1 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_emptyList_dummyNodeLinkPointerNoLongerHead() // dummy node's link pointer no longer points to itself
    {
        System.out.println("> Test1 - test_emptyList_dummyNodeLinkPointerNoLongerHead(): head.next should no longer be equal to head");
        int obj = 7;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("inserting a new node at front of empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNotSame("head.next equals to head", instance.head, instance.head.next);
        System.out.println("As expected, head.next is no longer equal to head");
    }
    
    
    /**
     * Test 2 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_emptyList_newNodeLinkPointerEqualsHead()
    {
        System.out.println("> Test2 - test_emptyList_newNodeLinkPointerEqualsHead(): new node's link pointer should be equal to head");
        int obj = 7;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("inserting a new node at front of empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertSame("new node's link pointer is not equal to head", instance.head.next.next, instance.head);
        System.out.println("As expected, new node's link pointer is successfully equal to head");
    }
    
    
    /**
     * Test 3 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_emptyList_newValueInsertedInNode()
    {
        System.out.println("> Test3 - test_emptyList_newValueInsertedInNode(): new data value should be in new node");
        int obj = 7;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("inserting a new node at front of empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertEquals("new data value not found in new node", instance.head.next.data, obj);
        System.out.println("As expected, new data successfully stored in new node");
    }
     
    
    /**
     * Test 4 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_dummyNodeDisconnectedFromExistingList()
    {
        System.out.println("> Test4 - test_nonEmptyList_dummyNodeDisconnectedFromExistingList(): dummy node should no longer be connected to the first node of the existing list");
        int obj = 7;
        
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        // mark first node of existing list
        ListNode oldFirst = instance.head.next;
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNotSame("dummy node is still connected to the first node of the existing list", instance.head.next, oldFirst);
        System.out.println("As expected, dummy node is no longer connected to the first node of the existing list");
    }
    
    
    /**
     * Test 5 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newNodePointsNotToNull()
    {
        System.out.println("> Test5 - test_nonEmptyList_newNodePointsNotToNull(): new node should not point to null");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertNotNull("new node points to null", instance.head.next.next);
        System.out.println("As expected, new node does not point to null");
    }
    
    
    /**
     * Test 6 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newNodeConnectedToList()
    {
        System.out.println("> Test6 - test_nonEmptyList_newNodeConnectedToList(): new node should be connected to list");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        // mark first node of existing list
        ListNode oldFirst = instance.head.next;
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertEquals("new node not connected to rest of list", instance.head.next.next, oldFirst);
        System.out.println("As expected, new node successfully connected to front of linked-list");
    }
    
    
    /**
     * Test 7 of addFirst method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newValueInsertedInNode()
    {
        System.out.println("> Test7 - test_nonEmptyList_newValueInsertedInNode(): new data value should be in new node");
        int obj = 7;
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        System.out.println("inserting a new node at front of non-empty list...");
        instance.addFirst(obj);
        // test node insertion
        assertEquals("new data value not found in new node", instance.head.next.data, obj);
        System.out.println("As expected, new data value successfully inserted in new node");
    }
   
}