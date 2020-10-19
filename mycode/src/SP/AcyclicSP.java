package SP;
/** Given an directed ACYCLIC weighted graph, this algorithm
 *  handles queries of the form:
 *   - What is the shortest path from s to v?
 *   - What is the shortest distance from s to v?
 */

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Topological;


import java.util.Arrays;
import java.util.LinkedList;

public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private final int src;

    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        src = s;
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0;
        Topological ordered = new Topological(G);

        for (int i : ordered.order()) {
            relax(G, i);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            if (distTo[e.to()] > distTo[e.from()] + e.weight()) {
                distTo[e.to()] = distTo[e.from()] + e.weight();
                edgeTo[e.to()] = e;
            }
        }
    }

    public double distTo(int v) { return distTo[v]; }

    public boolean hasPathTo(int v) { return distTo[v] < Double.POSITIVE_INFINITY; }

    public Iterable<DirectedEdge> pathTo (int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<DirectedEdge> sp = new LinkedList<>();
        for (int node = v; node != src; node = edgeTo[node].from()) {
            sp.addFirst(edgeTo[node]);
        }
        return sp;
    }
}
