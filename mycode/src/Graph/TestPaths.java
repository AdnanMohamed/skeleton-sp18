package Graph;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.nio.file.Path;
import java.util.Iterator;

import static org.junit.Assert.*;

public class TestPaths {
    private static void printPath(Iterable<Integer> iter) {
        for (Iterator<Integer>it = iter.iterator(); it.hasNext();) {
            System.out.format("(%d) --> ", it.next());
        }
        System.out.println();
    }

    @Test
    public void test() {
        In fin = new In("Graph/tinyG.txt");
        Graph g = new Graph(fin);
        fin.close();
        Paths p = new Paths(g, 0);

        assertTrue(p.hasPathTo(1));
        assertTrue(p.hasPathTo(2));
        assertTrue(p.hasPathTo(3));
        assertTrue(p.hasPathTo(4));
        assertTrue(p.hasPathTo(5));
        assertTrue(p.hasPathTo(6));

        for (int i = 0; i < 7; ++i) {
            printPath(p.pathTo(i));
        }

        Paths p2 = new Paths(g,7);

        assertTrue(p2.hasPathTo(8));

        Paths p3 = new Paths(g, 12);

        assertTrue(p3.hasPathTo(9));
        assertTrue(p3.hasPathTo(10));
        assertTrue(p3.hasPathTo(11));
    }
}
