/** DeleteTest.java
 * program to unit-test the delete method of class LinkedList
 */
package c_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

  
public class DeleteTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the delete() method of class C_LinkedList\n");
    }
    
    
     /**
     * Test 1 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_dummyNodeLinkPointerIsHead()   // Head's link pointer is head; i.e. dummy node points to itself
    {
        System.out.println("> Test1 - test_emptyList_dummyNodeLinkPointerIsHead(): delete a node in an empty list: dummy node's link pointer should still equal to head");
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("attempting to delete a node with an arbitrary index in a non-existing list...");
        // select node to be deleted
        int nodeIndex = 3;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertSame("dummy node's link pointer is no longer equal to head", instance.head.next, instance.head);
        System.out.println("As expected, deleting aborted, dummy node's link pointer is still equal to head");
    }
    
    
    /**
     * Test 2 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_deleteAnyNode()
    {
        System.out.println("> Test2 - test_emptyList_deleteAnyNode(): should fail");
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
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
     * Test 3 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_invalidIndex()
    {
        System.out.println("> Test3 - test_nonEmptyList_invalidIndex(): attempting to delete a node with an invalid index in a non-empty list: should fail");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        System.out.println("attempting to delete a node with an invalid index...");
        // select node to be deleted
        int nodeIndex = 0;
        boolean expResult = false;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was not found, deleting aborted");
    }

        
    /** Test 4 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_dummyNodeLinkPointerDisconnected()
    {    
        System.out.println("> Test4 - test_nonEmptyList_deleteFirstNode_dummyNodeLinkPointerDisconnected(): dummy node's link pointer should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNotSame("dummy node's link pointer is still connected to deleted node", instance.head.next, toDelete);
        System.out.println("As expected, dummy node's link pointer no longer points to deleted node");
    }

    
    /** Test 5 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_deletedNodePointsToNull()
    {    
        System.out.println("> Test5 - test_nonEmptyList_deleteFirstNode_deletedNodePointsToNull(): deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNull("deleted node not connected to null", toDelete.next);
        System.out.println("As expected, deleted node is successfully pointing to null");
    }
    
    
    /**
     * Test 6 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_nodeStillConnected()
    {
        System.out.println("> Test6 - test_nonEmptyList_deleteFirstNode_nodeStillConnected(): deleted node should no longer be connected to the list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head.next;
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
     * Test 7 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode_nodeBypassed()
    {
        System.out.println("> Test7 - test_nonEmptyList_deleteFirstNode_nodeBypassed(): deleted node should be bypassed");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // mark node to be deleted
        ListNode toDelete = instance.head.next;
        // mark node after node to be deleted
        ListNode after = toDelete.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("deleted node not bypassed in list", instance.head.next, after);
        System.out.println("As expected, dummy node now points to the successor of the deleted node in list");
    }

    
    /**
     * Test 8 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteFirstNode()
    {
        System.out.println("> Test8 - test_nonEmptyList_deleteFirstNode()");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        System.out.println("attempting to delete first node in list...");
        boolean expResult = true;
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("method returned an unexpected boolean", expResult, result);
        System.out.println("As expected, node was found and deleted");
    }
    
    
    /**
     * Test 9 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_firstPartOfListStillConnectedToDeletedNode()
    {   
        System.out.println("> Test9 - test_nonEmptyList_deleteMiddleNode_firstPartOfListStillConnectedToDeletedNode(): first part of list should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark node before node to be deleted
        ListNode before = instance.head.next;
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
     * Test 10 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodeDisconnectedFromRestOfList()
    {   
        System.out.println("> Test10 - test_nonEmptyList_deleteMiddleNode_deletedNodeDisconnectedFromRestOfList(): node to be deleted should be disconnected from second part of list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        ListNode toDelete = instance.head.next;
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
     * Test 11 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodePointsToNull()
    {   
        System.out.println("> Test11 - test_nonEmptyList_deleteMiddleNode_deletedNodePointsToNull(): deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        ListNode toDelete = instance.head.next;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("node to be deleted not connected to null", toDelete.next);
        System.out.println("As expected, deleted node is now pointing to null");
    }
    
    
    /**
     * Test 12 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode_nodeBypassed()
    {   
        System.out.println("> Test12 - test_nonEmptyList_deleteMiddleNode_nodeBypassed(): deleted node should be bypassed");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node before node to be deleted
        ListNode before = instance.head.next;
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
     * Test 13 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteMiddleNode()
    {   
        System.out.println("> Test13 - test_nonEmptyList_deleteMiddleNode(): node should be deleted");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        boolean expResult = true;
        System.out.println("attempting to delete a node in middle of list...");
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("method returned an unexpected boolean", expResult, result);
        System.out.println("As expected, node was found and deleted");
    }
    
    
    /**
     * Test 14 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteLastNode_nodeBeforeLastPointsToHead()
    {   
        System.out.println("> Test14 - test_nonEmptyList_deleteLastNode_nodeBeforeLastPointsToHead(): the node before last should now point to head");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;
        // get to and mark node before node to be deleted
        ListNode before = instance.head.next;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertSame("new last node not connected to head", before.next, instance.head);
        System.out.println("As expected, node before last now points to head");
    }
    
    
    /**
     * Test 15 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteLastNode_deletedNodePointsToNull()
    {   
        System.out.println("> Test15 - test_nonEmptyList_deleteLastNode_deletedNodePointsToNull(): deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;
        // get to and mark node to be deleted
        ListNode toDelete = instance.head.next;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("deleted node not set to null", toDelete.next);
        System.out.println("As expected, deleted node now points to null");
    }
    
    
    /**
     * Test 16 of delete method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_deleteLastNode()
    {   
        System.out.println("> Test16 - test_nonEmptyList_deleteLastNode(): last node should be deleted");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        C_LinkedList instance = new C_LinkedList(a);
        boolean expResult = true;
        System.out.println("attempting to delete last node in list...");
        // select node to be deleted
        int nodeIndex = a.length;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("method returned an unexpected boolean", expResult, result);
        System.out.println("As expected, last node was found and deleted");
    }
}
