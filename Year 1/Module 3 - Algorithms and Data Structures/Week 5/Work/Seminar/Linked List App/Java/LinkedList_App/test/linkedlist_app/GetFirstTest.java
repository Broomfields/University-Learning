/** GetFirstTest.java
 * program to unit-test the getFirst method of class LinkedList
 */
package linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class GetFirstTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the getFirst() method of class LinkedList\n");
    }
    
    
    /**
     * Test 1 of getFirst method, of class LinkedList.
     */
    @Test
    public void test_emptyList_noDataReturned()
    {
        System.out.println("> Test1 - test_emptyList_noDataReturned(): should return sentinel value");
        int expResult = 999;
        System.out.print("creating an empty list...");
        LinkedList instance = new LinkedList();
        System.out.println("retrieving data value from first node of empty list...");
        int result = instance.getFirst();
        // test value retrieved
        assertEquals(expResult, result);
        System.out.println("As expected, no data was retrieved");
    }
    
    
    /**
     * Test 2 of getFirst method, of class LinkedList.
     */
    @Test
    public void test_nonEmptyList_correctDataReturned()
    {
        System.out.println("> Test2 - test_nonEmptyList_correctDataReturned(): should return value in first node of list");
        // create a non-empty list
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        LinkedList instance = new LinkedList(a);
        int expResult = instance.head.data;
        System.out.println("retrieving data value from first node in non-empty list...");
        int result = instance.getFirst();
        // test value retrieved
        assertEquals("mismatch between value found in first node and value retrieved", expResult, result);
        System.out.println("As expected, data from first node in list was successfully retrieved");
    }   
}
