package Graph;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDFS {

    @Test
    public void test() {
        In fin = new In("Graph/tinyG.txt");
        Graph g = new Graph(fin);
        fin.close();
        DeapthFirstSearch V0 = new DeapthFirstSearch(g, 0);
        assertEquals(7, V0.count());
        for (int i: g.adjTo(0)) {
            assertTrue(V0.marked(i));
        }

        DeapthFirstSearch V1 = new DeapthFirstSearch(g, 1);
        assertEquals(7, V1.count());

        DeapthFirstSearch V2 = new DeapthFirstSearch(g, 2);
        assertEquals(7, V2.count());

        DeapthFirstSearch V3 = new DeapthFirstSearch(g, 3);
        assertEquals(7, V3.count());

        DeapthFirstSearch V4 = new DeapthFirstSearch(g, 4);
        assertEquals(7, V4.count());

        DeapthFirstSearch V5 = new DeapthFirstSearch(g, 5);
        assertEquals(7, V5.count());

        DeapthFirstSearch V6 = new DeapthFirstSearch(g, 6);
        assertEquals(7, V6.count());

        DeapthFirstSearch V7 = new DeapthFirstSearch(g, 7);
        assertEquals(2, V7.count());

        DeapthFirstSearch V8 = new DeapthFirstSearch(g, 8);
        assertEquals(2, V8.count());

        DeapthFirstSearch V9 = new DeapthFirstSearch(g, 9);
        assertEquals(4, V9.count());

        DeapthFirstSearch V10 = new DeapthFirstSearch(g, 10);
        assertEquals(4, V10.count());

        DeapthFirstSearch V11 = new DeapthFirstSearch(g, 11);
        assertEquals(4, V11.count());

        DeapthFirstSearch V12 = new DeapthFirstSearch(g, 12);
        assertEquals(4, V12.count());
    }
}
