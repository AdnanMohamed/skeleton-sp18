package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;  // true if a shortest path to this vertex is known.
    private int[] edgeTo;      // last vertex on known path to this vertex.
    private final int s;       // source.

    public BreadthFirstPaths(Graph g, int s) {
        this.s = s;
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        marked[s] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        while (!q.isEmpty()) {
            int w = q.remove();
            for (int v : g.adjTo(w)) {
                if (!marked[v]) {
                    marked[v] = true;
                    edgeTo[v] = w;
                    q.add(v);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> p = new LinkedList<>();
        p.addFirst(v);
        int next = p.getFirst();
        while (next != s) {
            p.addFirst(edgeTo[next]);
            next = edgeTo[next];
        }
        return p;
    }
}
