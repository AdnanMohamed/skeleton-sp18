package Graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph g) {
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); ++s) {
            if (!marked[s]) {
                dfs(g, s, s);
            }
        }
    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;
        for (int i: g.adjTo(v)) {
            if (!marked[i]) {
                dfs(g, i, v);
            } else if (i != u) {
                hasCycle = true;
                return;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
