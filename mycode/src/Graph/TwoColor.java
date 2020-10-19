package Graph;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph g) {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int i = 0; i < g.V(); ++i) {
            dfs(g, i);
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;

        for (int w: g.adjTo(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[v] == color[w]) {
                isTwoColorable = false;
                return;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
