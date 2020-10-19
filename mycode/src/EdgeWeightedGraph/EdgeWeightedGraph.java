package EdgeWeightedGraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.prefs.BackingStoreException;

public class EdgeWeightedGraph {

    private final int V;      // number of vertices.
    private int E;            // number of edges.
    private Bag<Edge>[] adj;  // adj[i] contains the weighted edges incident on vertex i.

    /** Creates an empty V-vertex edge-weighted graph. */
    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new Bag<Edge>();
        }
    }

    /** Creates an edge-weighted graph from the input stream. */
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        this.E = in.readInt();
        while (!in.isEmpty()) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge edge = new Edge(v, w, weight);
            adj[v].add(edge);
            adj[w].add(edge);
        }
    }

    /** number of vertices. */
    public int V() {
        return V;
    }

    /** number of edges. */
    public int E() {
        return E;
    }

    /** adds a weighted edge to this graph. */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /** Returns an iterable containing all
     *  edges adjacent on v. */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /** Returns an iterable containing all
     *  edges in this graph. */
    public Iterable<Edge> edges() {
        LinkedList<Edge> edges_lst = new LinkedList<>();
        for (int i = 0; i < V; ++i) {
            for (Edge e : adj[i]) {
                if (e.other(i) > i) {
                    edges_lst.add(e);
                }
            }
        }
        return edges_lst;
    }

    /** string representation of this graph. */
    @Override
    public String toString() {
        String g = "";
        for (int i = 0; i < V; ++i) {
            g += "V" + i + " | ";
            for (Edge e : adj(i)) {
                g += e + "  ";
            }
            g += "\n";
        }
        return g;
    }
}
