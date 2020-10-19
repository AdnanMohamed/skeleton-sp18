package shortestPath;

import EdgeWeightedGraph.Edge;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private double weight;
    private Bag<DirectedEdge>[] edges;


    /** Empty V-vertex digraph. */
    EdgeWeightedDigraph(int V) {
        this.V = V;
        edges = new Bag[V];

        for (int i = 0; i < V; ++i) {
            edges[i] = new Bag<DirectedEdge>();
        }
    }

    /** construct the digraph from in. */
    EdgeWeightedDigraph(In in) {
        this(in.readInt());
        E = in.readInt();

        while (!in.isEmpty()) {
            int src = in.readInt();   // read the source vertex.
            int dst = in.readInt();   // read the destination vertex.
            double w = in.readDouble();  // read the weight/cost of this edge.
            weight += w;

            edges[src].add(new DirectedEdge(src, dst, w));
        }
    }

    /** number of vertices. */
    public int V() { return V; }

    /** number of edges. */
    public int E() { return E; }

    /** Adds an edge to the digraph. */
    public void addEdge(DirectedEdge e) {
        edges[e.from()].add(e);
        E++;
        weight += e.weight();
    }

    /** Returns edges that are source from v.
     *  Precondition: v is in this digraph. */
    public Iterable<DirectedEdge> adj(int v) {
        return edges[v];
    }

    /** Returns all edges in this digraph. */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> all_edges = new Bag<>();
        for (int i = 0; i < V; ++i) {
            for (DirectedEdge e : adj(i)) {
                all_edges.add(e);
            }
        }
        return all_edges;
    }

    @Override
    public String toString() {
        String g = "";
        for (int i = 0; i < V; ++i) {
            g += "V" + i + " | ";
            for (DirectedEdge e : adj(i)) {
                g += e + "  ";
            }
            g += "\n";
        }
        return g;
    }
}
