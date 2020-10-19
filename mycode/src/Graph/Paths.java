package Graph;

import java.util.LinkedList;
import java.util.List;

public class Paths {
    private boolean[] marked;  // Has dfs() been called for this vertex?
    private int[] edgeTo;      // last vertex on known path to this vertex.
    private final int s;       // source

    /** finds paths in G from source s. */
    Paths(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w: g.adjTo(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    /** Returns true iff there is a
     *  path from s to v.
     */
    boolean hasPathTo(int v) {
        return marked[v];
    }

    /** Returns a path from s to v;
     *  null if no such path exist.
     */
    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> p = new LinkedList<>();
        p.addFirst(v);
        int next = p.getFirst();
        while (next != s)
        {
            p.addFirst(edgeTo[next]);
            next = edgeTo[next];
        }
        return p;
    }
}
