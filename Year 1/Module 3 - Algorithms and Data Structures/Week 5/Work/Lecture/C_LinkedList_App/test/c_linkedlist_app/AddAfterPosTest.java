/** addAfterPosTest.java
 * program to unit-test the addAfterPos method of class LinkedList
 * July 2015
 * @author Eudes Diemoz
 */
package c_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class AddAfterPosTest
{
     @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the addAfterPos() method of class C_LinkedList\n");
    }
    
    
    /**
     * Test 1 of addAfterPos() method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_emptyList_nodeShouldNotBeAddedAfterNoNode()
    {
        System.out.println("> Test1 - test_emptyList_nodeShouldNotBeAddedAfterNoNode(): no node should be added since there are no node to add anything after");
        boolean expResult = false;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("attempting to insert a new node after some node in an empty list...");
        int nodeIndex = 1;
        boolean result = instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("a mismatch was obtained, unexpectedly true was returned", expResult, result);
        System.out.println("As expected, no node was added to empty list since there were no node to add anything after");
    }
    
    
    /**
     * Test 2 of addAfterPos() method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_insertNewNodeAfterFirstNode()
    {
        System.out.println("> Test2 - test_nonEmptyList_insertNewNodeAfterFirstNode(): new node should be inserted after first node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // mark first node in list
        ListNode first = instance.head.next; 
        // mark second node in list
        ListNode second = first.next; 
        System.out.println("attempting to add a node after the first node in list...");
        int nodeIndex = 1;
        boolean result = instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("a node was not added between the first and second nodes of the list", first.next.next, second);
        System.out.println("As expected, a node was added between the first and second nodes of the list");
    }
    
    
    /**
     * Test 3 of addAfterPos method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newValueInsertedAfterFirstNode()
    {
        System.out.println("> Test3 - test_nonEmptyList_newValueInsertedAfterFirstNode(): new data value should be stored in new node after first node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // mark first node in list
        ListNode first = instance.head.next; 
        // select arbitrary value to be added to list
        int obj = 29;
        System.out.println("adding a node after the first node in list...");
        int nodeIndex = 1;
        instance.addAfterPos(obj, nodeIndex);
        // test node insertion
        assertEquals("new data value was not found in new node", first.next.data, obj);
        System.out.println("As expected, new data was successfully stored in new node");
    }
    
    
    /**
     * Test 4 of addAfterPos() method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_insertNewNodeInMiddleOfList()
    {
        System.out.println("> Test4 - test_nonEmptyList_insertNewNodeInMiddleOfList(): new node should be inserted in middle of list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // select arbitrary node index after which to insert new node
        int nodeIndex = 4;
        // get to and mark node before insertion point
        ListNode before = instance.head.next; 
        for (int i = 1; i < nodeIndex; i++)
            before = before.next;
        // mark node after insertion point
        ListNode after = before.next; 
        System.out.println("attempting to add a new node after position nodeIndex in list...");
        boolean result = instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("a node was not added between nodes before and after of the list", before.next.next, after);
        System.out.println("As expected, a node was added between nodes before and after of the list");
    }
    
    
    /**
     * Test 5 of addAfterPos method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newValueInsertedAfterSomeMiddleNode()
    {
        System.out.println("> Test5 - test_nonEmptyList_newValueInsertedAfterSomeMiddleNode(): new data value should be stored in new node after some arbitrarily selected middle node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        C_LinkedList instance = new C_LinkedList(a);
        // select arbitrary node index after which to insert new node
        int nodeIndex = 4;
        // get to and mark node before insertion point
        ListNode before = instance.head.next; 
        for (int i = 1; i < nodeIndex; i++)
            before = before.next;
        // select arbitrary value to be added to list
        int obj = 29;
        System.out.println("adding a node after node with position nodeIndex in list...");
        instance.addAfterPos(obj, nodeIndex);
        // test node insertion
        assertEquals("new data value was not found in new node", before.next.data, obj);
        System.out.println("As expected, new data was successfully stored in new node");
    }
   
    
    /**
     * Test 6 of addAfterPos() method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_insertNewNodeAfterLastNode()
    {
        System.out.println("> Test6 - test_nonEmptyList_insertNewNodeAfterLastNode(): what was the last node should now have its link pointer pointing to a new node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        int nodesInList = a.length;
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark last node in list
        ListNode last = instance.head.next;
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        System.out.println("attempting to add a node after the last node in list...");
        int nodeIndex = nodesInList;
        boolean result = instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertNotSame("the last node before insertion is still unexpectedly equal to head", last.next, instance.head);
        System.out.println("As expected, the last node before insertion is no longer equal to head");
    }   
    
    
    /**
     * Test 7 of addAfterPos() method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_insertNewNodeAfterLastNode_ConnectToDummyNode()
    {
        System.out.println("> Test7 - test_nonEmptyList_insertNewNodeAfterLastNode_ConnectToDummyNode(): the new node should now have its link pointer equal to head");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        int nodesInList = a.length;
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark last node in list
        ListNode last = instance.head.next;
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        System.out.println("attempting to add a node after the last node in list...");
        int nodeIndex = nodesInList;
        boolean result = instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertSame("the new node'link pointer is not equal to head", last.next.next, instance.head);
        System.out.println("As expected, the new node should now have its link pointer equal to head");
    }
    
    
    /**
     * Test 8 of addAfterPos method, of class C_LinkedList.
     */
    @Ignore
    @Test
    public void test_nonEmptyList_newValueInsertedAfterLastNode()
    {
        System.out.println("> Test8 - test_nonEmptyList_newValueInsertedAfterLastNode(): new data value should be stored in new node after last node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        int nodesInList = a.length;
        C_LinkedList instance = new C_LinkedList(a);
        // mark last node in list
        ListNode last = instance.head.next; 
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        // select arbitrary value to be added to list
        int obj = 29;
        System.out.println("adding a node after the first node in list...");
        instance.addAfterPos(obj, nodesInList);
        // test node insertion
        assertEquals("new data value was not found in new node", last.next.data, obj);
        System.out.println("As expected, new data was successfully stored in new node");
    }
}
