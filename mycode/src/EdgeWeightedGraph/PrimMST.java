/** implementing Prim's algorithm. */
package EdgeWeightedGraph;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;

public class PrimMST {
    /**  ### CLASS INVARIANT ###
     *   For all v NOT on the tree but has at least one
     *   edge connecting v to the tree.
     *
     *   1- edgeTo[v] is the shortest edge connecting v
     *      to the tree, and distTo[v] is the weight of that edge.
     *
     *   2- All such vertices v are maintained on the index priority queue
     *      as an index v associated with the weight of edgeTo[v].
     */
    private Edge[] edgeTo;         // shortest edge from tree vertex
    private double[] distTo;       // distTo[w] = edgeTo[w].weight()
    private boolean[] marked;      // true if v on tree.
    private IndexMinPQ<Double> pq; // eligible crossing edges.
    private double weight;         // holds the weight of the tree.

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        weight = 0;

        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        visit(G, 0);
        while (!pq.isEmpty()) {
            double min_weight = pq.minKey();
            weight += min_weight;
            int v = pq.delMin();
            visit(G, v);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        distTo[v] = 0;

        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (distTo[w] == 0) {
                continue;
            }
            double new_cost = e.weight();
            if (distTo[w] > new_cost) {
                edgeTo[w] = e;
                distTo[w] = new_cost;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Stack<Edge> s = new Stack<Edge>();
        for (int i = 1; i < edgeTo.length; ++i) {
            s.push(edgeTo[i]);
        }
        return s;
    }

    public double weight() {
        return Double.parseDouble(String.format("%.3f", weight));
    }
}
