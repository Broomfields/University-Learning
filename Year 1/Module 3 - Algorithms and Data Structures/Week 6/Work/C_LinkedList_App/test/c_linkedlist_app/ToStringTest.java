/** ToStringTest.java
 * program to unit-test the toString method of class LinkedList
 */
package c_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class ToStringTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the toString() method of class C_LinkedList\n");
    }
    
    
    /**
     * Test 1 of toString method, of class C_LinkedList.
     */
    @Test
    public void test_emptyList_emptyString()
    {
        System.out.println("> Test1 - test_emptyList_emptyString(): should return the empty string");
        System.out.print("creating an empty list...");
        C_LinkedList instance = new C_LinkedList();
        String expResult = "";
        System.out.println("attempting to retrieve content of list nodes...");
        String result = instance.toString();
        // test data retrieval
        assertEquals(expResult, result);
        System.out.println("As expected, the empty string was returned");
    }
    
    
    /**
     * Test 2 of toString method, of class C_LinkedList.
     */
    @Test
    public void test_nonEmptyList_correctStringReturned()
    {
        System.out.println("> Test2 - test_nonEmptyList_correctStringReturned(): should return a string with the content of each node underneath one another");
        System.out.print("creating a non-empty list...");
        int[] a = {1, 2, 3, 4, 5};
        C_LinkedList instance = new C_LinkedList(a);
        String expResult = "\n1\n2\n3\n4\n5";
        System.out.println("attempting to retrieve content of list nodes...");
        String result = instance.toString();
        // test data-retrieval from list
        assertEquals(expResult, result);
        System.out.println("As expected, the content of the list nodes were returned as a string");
    }
}
