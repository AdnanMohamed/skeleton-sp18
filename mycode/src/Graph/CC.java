package Graph;

public class CC {
    private boolean[] marked;  // marked[i] is true when the ith vertex is visited.
    private int[] id;          // id[i] = x when the ith vertex is in the component x.
    private int count;         // how many connected components.

    public CC(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0; i < g.V(); ++i) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: g.adjTo(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
