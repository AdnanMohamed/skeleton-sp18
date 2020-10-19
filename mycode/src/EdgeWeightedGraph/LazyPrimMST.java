package EdgeWeightedGraph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
    private boolean[] marked;    // MST vertices.
    private Queue<Edge> mst;     // MST edges.
    private MinPQ<Edge> pq;      // crossing (and ineligible) edges.

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        visit(G, 0);
        while (mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!marked[v]) {
                mst.enqueue(e);
                visit(G, v);
            }
            if (!marked[w]) {
                mst.enqueue(e);
                visit(G, w);
            }
        }
    }

    /** Postcondition: marks v as visited (i.e. v is now considered in mst.)
     *                 All adjacent edges to v are added to the pq.
     *  Precondition G is connected and v is in G. */
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double total_weight = 0;
        for (Edge e : mst) {
            total_weight += e.weight();
        }
        return Double.parseDouble(String.format("%.3f", total_weight));
    }
}
