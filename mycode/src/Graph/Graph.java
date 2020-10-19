/** multi-undirected graph data structure implementation.
 *   This implementation is while following with
 *   "Algorithms 4th edition" Graphs Chapter.
 */

package Graph;

import java.util.LinkedList;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {

    /**  #### CLASS INVARIANT ####
     *    1- V is the number of vertices in this graph.
     *    2- E is the number of edges in this graph.
     *    3- adj is the adjacency matrix for this graph,
     *       where adj[i][j] = x --means vertex i is connected
     *       to vertex j by x edges. (x is nonegative).
     */

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /** Creates a graph with v vertices and
     *  no edges.
     * @param v  number of edges (v > 0).
     */
    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[V];
        // initialize the array with empty bags.
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new Bag<>();
        }
    }

    /** Creates a Graph from the input stream.
     * Precondition: The format of the file is
     * 2E + 2 integers starting by V, E, and pair of integers
     * representing each edge (Each on its seperate line). */
    public Graph(In in) {
        this.V = in.readInt();
        this.E = in.readInt();
        adj = new Bag[V];
        // initialize the array with empty bags.
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new Bag<>();
        }
        int v, w;
        for (int i = 0; i < E; ++i) {
            v = in.readInt();
            w = in.readInt();
            adj[v].add(w);
            if (v != w) {
                adj[w].add(v);
            }
        }
    }

    /** Returns the number of vertices. */
    public int V() {return this.V;}

    /** Returns the number of edges. */
    public int E() {return this.E;}

    /** Adds an edge between vertex v and w. */
    public void addEdge(int v, int w) {
        // assumes v and w are in [0, V - 1]
        validate(v);
        validate(w);
        adj[v].add(w);
        if (v != w) {
            adj[w].add(v);
        }
        E++;
    }

    Iterable<Integer> adjTo(int v) {
        // assumes v is in the range [0, V - 1]
        validate(v);
        return adj[v];
    }

    @Override
    public String toString() {
        String matrix = "";
        for (int i = 0; i < V; ++i) {
            matrix += "V"+ i + "| ";
            for (int cell: adjTo(i)) {
                matrix += cell + " ";
            }
            matrix += "|\n";
        }
        return matrix;
    }

    /** Returns the number of edges in G adjacent on v.
     *  Precondition: v is a vertex in G.
     * @param g  Unidirected multigraph
     * @param v  vertex label
     */
    public static int degree(Graph g, int v) {
        int deg = 0;
        for (int i : g.adjTo(v)) {
            deg++;
        }
        return deg;
    }

    /** Returns the maximum degree among all
     *  vertices in G. */
    public static int maxDegree(Graph g) {
        int max = degree(g, 0);
        for (int i = 1; i < g.V(); ++i) {
            int d = degree(g, i);
            if (max < d) {
                max = d;
            }
        }
        return max;
    }

    public static int avgDegree(Graph g) {
        // Sum(degrees) = 2 * Edges
        // So the average is the following.
        return 2 * g.E() / g.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int loops = 0;
        for (int i = 0; i < G.V(); ++i) {
            for (int v: G.adjTo(i)) {
                if (v == i) {
                    loops++;
                    break;
                }
            }
        }
        return loops;
    }
    /** Throws IndexOutOfBoundsException iff i
     *  is out of the range [0, V-1]. */
    private void validate(int i) {
        if (i < 0 || i >= V) {
            throw new IndexOutOfBoundsException("The argument should be within [0, V - 1].");
        }
    }
}
