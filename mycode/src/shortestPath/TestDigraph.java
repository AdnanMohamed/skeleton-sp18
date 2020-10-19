package shortestPath;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
import edu.princeton.cs.algs4.In;
import static org.junit.Assert.*;

public class TestDigraph {

    @Test
    public void test() {
        String filename = "shortestPath/tinyEWD.txt";
        EdgeWeightedDigraph wg = new EdgeWeightedDigraph(new In(filename));
        assertEquals(8, wg.V());
        assertEquals(15, wg.E());
        System.out.print(wg);
    }
}
