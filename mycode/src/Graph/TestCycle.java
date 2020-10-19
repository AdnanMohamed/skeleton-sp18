package Graph;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCycle {
    @Test
    public void test() {
        In fin = new In("Graph/G10.txt");
        Graph g = new Graph(fin);
        fin.close();

        Cycle c = new Cycle(g);
        assertTrue(!c.hasCycle());
    }
}
