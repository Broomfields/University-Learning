/** isEmptyTest.java
 * program to unit-test the toString method of class LinkedList
 * 
 * @author A Occhipinti - Saul Johnson
 */
package c_linkedlist_app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.BeforeClass;


/**
 *
 * @author U0033257
 */
public class isEmtpyTest {
    
        @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the isEmpty method of class C_LinkedList\n");
    }

     /**
     * Test of isEmpty method, of class CircularLinkedList.
     */
    @Test
    public void testIsEmpty() {
        // Create instance.
        C_LinkedList instance = new C_LinkedList(
                new int[] {2, 4, 6, 7, 8});
        boolean empty = new C_LinkedList().isEmpty();
        assertTrue("True should return for empty lists.", empty);
        boolean notEmpty = instance.isEmpty();
        assertFalse("False should return for non-empty lists.", notEmpty);
    }
}
