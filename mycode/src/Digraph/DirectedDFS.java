package Digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS {
    private boolean marked[];

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int src : sources) {
            dfs(G, src);
        }
    }

    public void dfs(Digraph G, int s) {
        marked[s] = true;
        for (int dst : G.adj(s)) {
            if (!marked[dst]) {
                dfs(G, dst);
            }
        }
    }

    boolean marked(int v) { return marked[v]; }

    /** Test client. */
    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));

        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; ++i) {
            sources.add(Integer.parseInt(args[i]));
        }

        DirectedDFS reachable = new DirectedDFS(G, sources);

        for (int v = 0; v < G.V(); ++v) {
            if (reachable.marked(v))
                StdOut.print(v + " ");
            StdOut.println();
        }
    }
}
