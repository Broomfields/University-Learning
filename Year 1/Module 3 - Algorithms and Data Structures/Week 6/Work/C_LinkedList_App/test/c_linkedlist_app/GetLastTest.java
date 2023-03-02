/** GetLastTest.java
 * program to unit-test the getLast method of class LinkedList
 */
package c_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class GetLastTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the getLast() method of class C_LinkedList\n");
    }
    
    
    /**
     * Test 1 of getLast method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_noDataReturned()
    {
        System.out.println("> Test1 - test_emptyList_noDataReturned(): should return sentinel value");
        int expResult = 999;
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        System.out.println("retrieving data value from last node of empty list...");
        int result = instance.getLast();
        // test value retrieved
        assertEquals(expResult, result);
        System.out.println("As expected, no data was retrieved");
    }
    
    
    /**
     * Test 2 of getLast method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_correctDataReturned()
    {
        System.out.println("> Test2 - test_nonEmptyList_correctDataReturned(): should return value in last node of list");
        // create a non-empty list
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {1, 2, 3, 4, 5};
        C_LinkedList instance = new C_LinkedList(a);
        // get to and mark end of list
        ListNode current = instance.head.next;
        int size = a.length;
        for (int i = 1; i < size; i++)
            current = current.next;
        int expResult = current.data;
        System.out.println("retrieving data value from last node in non-empty list...");
        int result = instance.getLast();
        // test value retrieved
        assertEquals("mismatch between value found in last node and value retrieved", expResult, result);
        System.out.println("As expected, data from last node in list was successfully retrieved");
    }      
}
