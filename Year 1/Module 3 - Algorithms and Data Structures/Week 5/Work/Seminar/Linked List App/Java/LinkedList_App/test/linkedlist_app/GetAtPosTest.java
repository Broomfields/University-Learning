/** GetAtPosTest.java
 * program to unit-test the getAtPos method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class GetAtPosTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the getAtPos() method of class LinkedList\n");
    }
    
    
    /**
     * Test 1 of getAtPos method, of class LinkedList.
     */
    @Test
    public void test_emptyList_noDataReturned()
    {
        System.out.println("> Test1 - test_emptyList_noDataReturned(): should return sentinel value");
        int expResult = 999;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("attempting to retrieve data value from any node in empty list...");
        // select node to be read
        int nodeIndex = 3;
        int result = instance.getAtPos(nodeIndex);
        // test value retrieved
        assertEquals(expResult, result);
        System.out.println("As expected, no data was retrieved");
    }
    
    
    /**
     * Test 2 of getAtPos method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInFirstNodeReturned()
    {
        System.out.println("> Test2 - test_nonEmptyList_dataInFirstNodeReturned(): should return value in first node of list");
        // create a non-empty list
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        int expResult = instance.head.data;
        System.out.println("retrieving data value from first node in non-empty list...");
        int result = instance.getAtPos(1);
        // test value retrieved
        assertEquals("mismatch between value found in first node and value retrieved", expResult, result);
        System.out.println("As expected, data from first node in list was successfully retrieved");
    } 
    
    
    /**
     * Test 3 of getAtPos method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInLastNodeReturned()
    {
        System.out.println("> Test3 - test_nonEmptyList_dataInLastNodeReturned(): should return value in last node of list");
        // create a non-empty list
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head;
        int nodesInList = a.length;
        for (int i = 1; i < nodesInList; i++)
            current = current.next;
        int expResult = current.data;
        System.out.println("retrieving data value from last node in non-empty list...");
        int result = instance.getAtPos(5);
        // test value retrieved
        assertEquals("mismatch between value found in last node and value retrieved", expResult, result);
        System.out.println("As expected, data from last node in list was successfully retrieved");
    } 
    
    
    /**
     * Test 4 of getAtPos method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInMiddleNodeReturned()
    {   
        System.out.println("> Test4 - test_nonEmptyList_dataInMiddleNodeReturned(): should return data value from selected node in middle of list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select arbitrary node to be read
        int nodeIndex = 5;
        // get to and mark node to be read
        ListNode target = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            target = target.next;
        int expResult = target.data;
        System.out.println("attempting to retrieve data from a node in middle of list...");
        int result = instance.getAtPos(nodeIndex);
        // test node deletion
        assertEquals("mismatch between value found in node in middle of list and value retrieved", expResult, result);
        System.out.println("As expected, data from appropriate node in middle of list was successfully retrieved");
    }
    
    
    /**
     * Test 5 of getAtPos method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_invalidIndex()
    {   
        System.out.println("> Test5 - test_nonEmptyList_invalidIndex(): should return sentinel value");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select an invalid index
        int nodeIndex = 0;
        System.out.println("attempting to retrieve data from a node with an invalid index...");
        int result = instance.getAtPos(nodeIndex);
        int expResult = 999;    // sentinel value
        // test node deletion
        assertEquals("despite an invalid index, the sentinel value was not returned", expResult, result);
        System.out.println("As expected, no data was retrieved, sentinel value was successfully returned");
    }
    
}
