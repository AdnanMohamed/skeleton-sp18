/** Test file for BST class.
 *  View BST class in BST.java
 *
 * @author Adnan H. Mohamed
 *
 */
package BinarySearchTree;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBST {

    @Test //(timeout = 30000)
    public void Test1() {
        BST<Integer, String> bst = new BST<>();
        bst.put(17, "Adnan");
        bst.put(38, "Yaseen");
        bst.put(14, "Falah");
        bst.put(12, "Kareem");
        bst.put(16, "Zainab");

        assertEquals("Adnan", bst.get(17));
        assertEquals("Kareem", bst.get(12));
        assertEquals("Zainab", bst.get(16));
        assertEquals("Yaseen", bst.get(38));
        assertEquals("Falah", bst.get(14));
        assertEquals(5, bst.size());

        assertEquals(17, (int)bst.select(3));
        assertEquals(14, (int)bst.select(1));
        assertEquals(12, (int)bst.select(0));

        String[] names = {"Ali", "Faisal", "Basil", "Batool", "Fahad",
                         "Mohamed", "Baqer", "Jawad"};
        for (int i = 1; i <= names.length; ++i) {
            bst.put(i, names[i - 1]);
        }
        bst.delete(17);
        for (int i = 1; i <= names.length; ++i) {
            assertEquals(i, (int)bst.min());
            bst.deleteMin();
        }

    }
}