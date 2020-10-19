package Digraph;

import edu.princeton.cs.algs4.In;

public class Topological {
    private Iterable<Integer> order;   // topological order

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);

        if (!cyclefinder.hasCycle()) {
            order = new DepthFirstOrder(G).reversePost();
        }
    }

    public Iterable<Integer> order() { return order; }

    public boolean isDAG() { return order != null; }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Digraph digraph = new Digraph(in);

        Topological topo = new Topological(digraph);

        for (int v : topo.order()) {
            System.out.println(v);
        }
    }
}
