package Digraph;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
    private int[] edgeTo;
    private boolean[] marked;
    private Stack<Integer> cycle;  // vertices on a cycle (if one exists).
    private boolean[] onStack;     // vertices on recursive call stack.

    DirectedCycle(Digraph G) {
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];

        for (int i = 0; i < G.V(); ++i) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int s : G.adj(v)) {
            if (hasCycle())
                return;
            else if (!marked[s]) {
                edgeTo[s] = v;
                dfs(G, s);
            } else if (onStack[s]) {
                cycle = new Stack<>();
                for (int x = v; x != s; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(s);
                cycle.push(v);
                onStack[s] = false;
            }
        }
        onStack[v] = false;  // mark it as popped from the stack.
    }
}
