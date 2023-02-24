/** SearchIndexTest.java
 * program to unit-test the searchIndex method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class SearchIndexTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the searchIndex() method of class LinkedList\n");
    }
    
    
    /**
     * Test 1 of searchIndex method of class LinkedList.
     */
    @Test
    public void test_emptyList()
    {
        System.out.println("> Test1 - test_emptyList(): should return -1");
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        int expResult = -1;
        // select arbitrary value to search in list 
        int desVal = 3;
        System.out.println("attempting to locate node with desired value...");
        int result = instance.searchIndex(desVal);
        // test node searching
        assertEquals("although the list is empty, -1 was not returned", expResult, result);
        System.out.println("As expected, -1 was returned");
    }
    
    
    /**
     * Test 2 of searchIndex method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInFirstNode()
    {
        System.out.println("> Test2 - test_nonEmptyList_dataInFirstNode(): should return index of 1");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // set desired value to search for
        int desVal = 5;
        // mark first node in list
        ListNode first = instance.head;
        //insert arbitrary value into first node
        first.data = desVal;
        int expResult = 1;
        System.out.println("attempting to locate node with desired value...");
        int result = instance.searchIndex(desVal);
        // test node searching
        assertEquals("an index of 1 was not returned", expResult, result);
        System.out.println("As expected, an index of 1 was returned");
    }
    
    
    /**
     * Test 3 of searchIndex method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInMiddleNode()
    {
        System.out.println("> Test3 - test_nonEmptyList_dataInMiddleNode(): should return corresponding index");
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
        int expResult = nodeIndex;
        System.out.println("attempting to locate node with desired value...");
        int result = instance.searchIndex(desVal);
        // test node searching
        assertEquals("the index of the target node was not returned", expResult, result);
        System.out.println("As expected, the index position of the correct node was returned");
    }
    
    
    /**
     * Test 4 of searchIndex method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataInLastNode()
    {
        System.out.println("> Test4 - test_nonEmptyList_dataInLastNode(): should return index of last node");
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
        int expResult = nodesInList;
        System.out.println("attempting to locate node with desired value...");
        int result = instance.searchIndex(desVal);
        // test node searching
        assertEquals("the index of the last node was not returned", expResult, result);
        System.out.println("As expected, the index of the last node was returned");
    }
    
    
    /**
     * Test 5 of searchIndex method of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_dataNotFound()
    {
        System.out.println("> Test5 - test_nonEmptyList_dataNotFound(): should return -1");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        // set desired value to search for
        int desVal = 5;
        int expResult = -1;
        System.out.println("attempting to locate node with desired value...");
        int result = instance.searchIndex(desVal);
        // test node searching
        assertEquals("although the desired value was not found, -1 was not returned", expResult, result);
        System.out.println("As expected, the desired value was not found in list, -1 was returned");
    }
}
