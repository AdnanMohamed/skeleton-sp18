package EdgeWeightedGraph.Tests;

import EdgeWeightedGraph.EdgeWeightedGraph;
import EdgeWeightedGraph.Edge;
import EdgeWeightedGraph.MST;
import EdgeWeightedGraph.LazyPrimMST;
import EdgeWeightedGraph.PrimMST;
import EdgeWeightedGraph.KruskalMST;
import edu.princeton.cs.algs4.In;

public class TestMST {
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph WG = new EdgeWeightedGraph(in);

        KruskalMST mst = new KruskalMST(WG);
//        for (Edge e : mst.edges()) {
//            System.out.println(e);
//        }
        System.out.println(mst.weight());
    }
}
