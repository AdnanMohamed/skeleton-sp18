package Digraph;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDigraph {

    @Test
    public void test() {
        In file = new In("Digraph/tinyDG.txt");
        Digraph digraph = new Digraph(file);

        DirectedCycle dcycle = new DirectedCycle(digraph);
        assertTrue(dcycle.hasCycle());
        for (int n : dcycle.cycle()) {
            System.out.print(n + " ");
        }
    }
}
