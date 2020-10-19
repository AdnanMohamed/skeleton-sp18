/** Implementation of Dijkstra's Algorithm.
 *  author: Adnan H. Mohamed.
 */
package shortestPath;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Arrays;
import java.util.LinkedList;

public class SP {
    private final int src;
    private DirectedEdge[] edgeTo;    // edgeTo[i] == x, x is the shortest known edge that connects from src.
    private double[] distTo;          // shortest distance.
    private boolean[] marked;         // marked[v] == true iff v is in the spt.
    private IndexMinPQ<Double> pq;    // contains the candidate vertices and their weights.

    SP(EdgeWeightedDigraph G, int s) {
        src = s;
        dijkstra(G);  //  runs dijkstra's algorithm
    }

    private void dijkstra(EdgeWeightedDigraph G) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);  // initialize all the vertices with distance of infinity.
        distTo[src] = 0;  // the distance from the src to src is zero.
        visit(G, src);
        while (!pq.isEmpty()) {
            int target = pq.minIndex();
            distTo[target] = pq.minKey();
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedDigraph G, int v) {
        marked[v] = true;  // mark that v is now in the spt.
        for (DirectedEdge e : G.adj(v)) {
            if (marked[e.to()]) {
                // if the adjacent vertex is already in the spt
                // then don't proceed, but keep updating others.
                continue;
            }
            if (!pq.contains(e.to())) {
                pq.insert(e.to(), distTo[v] + e.weight());
            }
            // updating the distances and best known edges.
            if (distTo[e.to()] > distTo[v] + e.weight()) {
                distTo[e.to()] = distTo[v] + e.weight();
                edgeTo[e.to()] = e;
            }
        }
    }

    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    Iterable<DirectedEdge> pathTo(int v) {
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
