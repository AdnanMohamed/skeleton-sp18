package Digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;  // number of vertices.
    private int E;        // number of edges.
    private Bag<Integer>[] adj;  // adj[x] is the collection of
                                 // vertices reachable FROM x.

    /** Create a V-vertex digraph with no edges. */
    public Digraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new Bag<>();
        }
    }

    /** Creates a digraph from the input stream in. */
    public Digraph(In in) {
        this(in.readInt());
        this.E = in.readInt();
        while (!in.isEmpty()) {
            int src = in.readInt();
            int dst = in.readInt();
            validate(src);
            validate(dst);
            adj[src].add(dst);
        }
    }

    /** Returns the number of vertices. */
    public int V() { return this.V;}

    /** Returns the number of edges. */
    public int E() { return this.E;}

    /** Adds an edge FROM h TO t.
     *  Precondition: h & t < V and h & t >= 0*/
    public void addEdge(int h, int t) {
        validate(h);
        validate(t);
        adj[h].add(t);
        ++E;
    }

    /** Returns an iterable of vertices reachable from s.
     *  Precondition: S is a vertex in this digraph. */
    public Iterable<Integer> adj(int s) { return adj[s];}

    /** Returns the reverse of this digraph.
     *  The returned digraph has the same set
     *  of vertices but reversed edges. */
    public Digraph reverse() {
        Digraph reversed = new Digraph(V);
        for (int src = 0; src < V; ++src) {
            for (int dst : adj(src)) {
                reversed.addEdge(dst, src);
            }
        }
        return reversed;
    }

    @Override
    public String toString() {
        String matrix = "";
        for (int i = 0; i < V; ++i) {
            matrix += "V"+ i + "| ";
            for (int cell: adj(i)) {
                matrix += cell + " ";
            }
            matrix += "|\n";
        }
        return matrix;
    }

    /** Throws IndexOutOfBoundsException iff i is not in [0, V-1]. */
    private void validate(int i) {
        if (i < 0 || i >= V) {
            throw new IndexOutOfBoundsException(i + " is invalid index in this digraph.");
        }
    }
}
