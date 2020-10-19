package EdgeWeightedGraph.Tests;

import EdgeWeightedGraph.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class test1 {
    @Test
    public void test() {
        String filename = "EdgeWeightedGraph/tinyEWG.txt";
        EdgeWeightedGraph wg = new EdgeWeightedGraph(new In(filename));
        assertEquals(8, wg.V());
        assertEquals(16, wg.E());
        System.out.print(wg);
    }
}
