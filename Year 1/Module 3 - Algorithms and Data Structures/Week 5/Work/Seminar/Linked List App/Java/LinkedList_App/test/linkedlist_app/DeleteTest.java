/** DeleteTest.java
 * program to unit-test the delete method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

  
public class DeleteTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the delete() method of class LinkedList\n");
    }
    
    
     /**
     * Test 1 of delete method, of class LinkedList.
     */
    @Test
    public void test_emptyList_headNull()
    {
        System.out.println("> Test1 - test_emptyList_headNull(): head should still point to null");
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("attempting to delete a node with an arbitrary index in a non-existing list...");
        // select node to be deleted
        int nodeIndex = 3;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("head no longer points to null", instance.head);
        System.out.println("As expected, deleting aborted, head still points to null");
    }
    
    
    /**
     * Test 2 of delete method, of class LinkedList.
     */
    @Test
    public void test_emptyList_deleteAnyNode()
    {
        System.out.println("> Test2 - test_emptyList_deleteAnyNode(): should fail");
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        System.out.println("attempting to delete a node with an arbitrary index in a non-existing list...");
        // select node to be deleted
        int nodeIndex = 3;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, no node was found, deleting aborted");
    }

    
    /**
     * Test 3 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_invalidIndex_headNotNull()
    {
        System.out.println("> Test3 - test_nonEmptyList_invalidIndex_headNotNull(): head should remain not null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // mark first node in list
        ListNode first = instance.head;
        System.out.println("attempting to delete a node with an invalid index...");
        // select node to be deleted
        int nodeIndex = 0;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("head no longer pointing to first node of list", instance.head, first);
        System.out.println("As expected, node was not found, deleting aborted, head is still non-null and pointing to first node in list");        
    }
    
    
    /**
     * Test 4 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_invalidIndex()
    {
        System.out.println("> Test4 - test_nonEmptyList_invalidIndex(): should fail");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        System.out.println("attempting to delete a node with an invalid index...");
        // select node to be deleted
        int nodeIndex = 0;
        boolean expResult = false;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was not found, deleting aborted");
    }

        
    /** Test 5 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_headDisconnected()
    {    
        System.out.println("> Test5 - test_nonEmptyList_deleteFirstNode_headDisconnected(): head should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNotSame("head of list still connected to deleted node", instance.head, toDelete);
        System.out.println("As expected, head no longer points to deleted node");
    }

    
    /** Test 6 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_deletedNodePointsToNull()
    {    
        System.out.println("> Test6 - test_nonEmptyList_deleteFirstNode_deletedNodePointsToNull(): deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNull("deleted node not connected to null", toDelete.next);
        System.out.println("As expected, deleted node is successfully pointing to null");
    }
    
    
    /**
     * Test 7 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_nodeStillConnected()
    {
        System.out.println("> Test7 - test_nonEmptyList_deleteFirstNode_nodeStillConnected(): deleted node should no longer be connected to the list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head;
        // mark node after node to be deleted
        ListNode after = toDelete.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("node to be deleted still connected to list", toDelete.next, after);
        System.out.println("As expected, the deleted node is no longer connected to the list");
    }
    
    
    /**
     * Test 8 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_nodeBypassed()
    {
        System.out.println("> Test8 - test_nonEmptyList_deleteFirstNode_nodeBypassed(): deleted node should be bypassed");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head;
        // mark node after node to be deleted
        ListNode after = toDelete.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("deleted node not bypassed in list", instance.head, after);
        System.out.println("As expected, head now points to the successor of the deleted node in list");
    }

    
    /**
     * Test 9 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode()
    {
        System.out.println("> Test9 - test_nonEmptyList_deleteFirstNode()");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        System.out.println("attempting to delete first node in list...");
        boolean expResult = true;
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was found and deleted");
    }
    
    
    /**
     * Test 10 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_firstPartOfListStillConnectedToDeletedNode()
    {   
        System.out.println("> Test10 - test_nonEmptyList_deleteMiddleNode_firstPartOfListStillConnectedToDeletedNode(): first part of list should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // get to and mark node before node to be deleted
        ListNode before = instance.head;
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        // mark node to be deleted
        ListNode toDelete = before.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("first part of list still connected to node to be deleted", before.next, toDelete);
        System.out.println("As expected, first part of list is now disconnected from the deleted node");
    }
    
    
    /**
     * Test 11 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodeDisconnectedFromRestOfList()
    {   
        System.out.println("> Test11 - test_nonEmptyList_deleteMiddleNode_deletedNodeDisconnectedFromRestOfList(): node to be deleted should be disconnected from second part of list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        // mark node after node to be deleted
        ListNode after = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("node to be deleted still connected to second half of list", toDelete.next, after);
        System.out.println("As expected, deleted node is no longer connected to second part of list");
    }
    
    
    /**
     * Test 12 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodePointsToNull()
    {   
        System.out.println("> Test12 - test_nonEmptyList_deleteMiddleNode_deletedNodePointsToNull(): deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("node to be deleted not connected to null", toDelete.next);
        System.out.println("As expected, deleted node is now pointing to null");
    }
    
    
    /**
     * Test 13 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_nodeBypassed()
    {   
        System.out.println("> Test13 - test_nonEmptyList_deleteMiddleNode_nodeBypassed(): deleted node should be bypassed");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node before node to be deleted
        ListNode before = instance.head;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        // mark node to be deleted
        ListNode toDelete = before.next;
        // mark node after node to be deleted
        ListNode after = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("deleted node not bypassed in list", before.next, after);
        System.out.println("As expected, deleted node was bypassed");
    }
    
    
    /**
     * Test 14 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode()
    {   
        System.out.println("> Test14 - test_nonEmptyList_deleteMiddleNode(): node should be deleted");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        boolean expResult = true;
        System.out.println("attempting to delete a node in middle of list...");
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was found and deleted");
    }
    
    
    /**
     * Test 15 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteLastNode_nodeBeforeLastPointsToNull()
    {   
        System.out.println("> Test15 - test_nonEmptyList_deleteLastNode_nodeBeforeLastPointsToNull(): the node before last should now point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;   // number of nodes in list
        // get to and mark node before node to be deleted
        ListNode before = instance.head;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("new last node not connected to null", before.next);
        System.out.println("As expected, node before last now points to null");
    }
    
    
    /**
     * Test 16 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteLastNode_deletedNodePointsToNull()
    {   
        System.out.println("> Test16 - test_nonEmptyList_deleteLastNode_deletedNodePointsToNull(): deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;   // number of nodes in list
        // get to and mark node to be deleted
        ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("deleted node not set to null", toDelete.next);
        System.out.println("As expected, deleted node now points to null");
    }
    
    
    /**
     * Test 17 of delete method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteLastNode()
    {   
        System.out.println("> Test17 - test_nonEmptyList_deleteLastNode(): last node should be deleted");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        boolean expResult = true;
        System.out.println("attempting to delete last node in list...");
        // select node to be deleted
        int nodeIndex = a.length;   // number of nodes in list
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, last node was found and deleted");
    }
}
