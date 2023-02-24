/** SearchPointerTest.java
 * program to unit-test the searchPointer method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class SearchPointerTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the searchPointer() method of class LinkedList\n");
    }
    
    
    /**
     * Test 1 of searchPointer method of class LinkedList.
     */
    @Test
    public void test_emptyList()
    {
        System.out.println("> Test1 - test_emptyList(): should return null");
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        ListNode expResult = null;
        // select arbitrary value to search in list 
        int desVal = 3;
        System.out.println("attempting to locate node with desired value...");
        ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("although the list is empty, null was not returned", expResult, result);
        System.out.println("As expected, null was returned");
    }
    
    
    /**
     * Test 2 of searchPointer method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInFirstNode()
    {
        System.out.println("> Test2 - test_nonEmptyList_dataInFirstNode(): should return pointer to first node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // set desired value to search for
        int desVal = 5;
        // mark first node in list
        ListNode first = instance.head;
        //insert arbitrary value into first node
        first.data = desVal;
        ListNode expResult = first;
        System.out.println("attempting to locate node with desired value...");
        ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("a pointer to the first node was not returned", expResult, result);
        System.out.println("As expected, a pointer to the first node was returned");
    }
    
    
    /**
     * Test 3 of searchPointer method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInMiddleNode()
    {
        System.out.println("> Test3 - test_nonEmptyList_dataInMiddleNode(): should return pointer to corresponding node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // select an arbitrary node to contain the desired value
        int nodeIndex = 4;
        // get to and mark target node
        ListNode target = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            target = target.next;
        // set desired value to search for
        int desVal = 5;
        // insert desired value into target node
        target.data = desVal;
        ListNode expResult = target;
        System.out.println("attempting to locate node with desired value...");
        ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("a pointer to the target node was not returned", expResult, result);
        System.out.println("As expected, a pointer to the correct node was returned");
    }
    
    
    /**
     * Test 4 of searchPointer method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInLastNode()
    {
        System.out.println("> Test4 - test_nonEmptyList_dataInLastNode(): should return pointer to last node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // get to and mark last node
        ListNode last = instance.head;
        int nodesInList = a.length;
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        // set desired value to search for
        int desVal = 5;
        // insert desired value into last node
        last.data = desVal;
        ListNode expResult = last;
        System.out.println("attempting to locate node with desired value...");
        ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("a pointer to the last node was not returned", expResult, result);
        System.out.println("As expected, a pointer to the last node was returned");
    }
    
    
    /**
     * Test 5 of searchPointer method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataNotFound()
    {
        System.out.println("> Test5 - test_nonEmptyList_dataNotFound(): should return pointer to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // set desired value to search for
        int desVal = 5;
        ListNode expResult = null;
        System.out.println("attempting to locate node with desired value...");
        ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("although value was not found, a pointer to null was not returned", expResult, result);
        System.out.println("As expected, value was not found in list, a pointer to null was returned");
    }
}
