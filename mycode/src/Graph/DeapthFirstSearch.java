package Graph;

public class DeapthFirstSearch {
    private boolean[] marked;
    private int count;

    public DeapthFirstSearch(Graph g, int src) {
        marked = new boolean[g.V()];
        marked[src] = true;
        dfs(g, src);
    }

    private void dfs(Graph g, int src) {
        marked[src] = true;
        count++;
        for (int v: g.adjTo(src)) {
            if (!marked(v)) {
                dfs(g, v);
            }
        }
    }

    /** Returns true iff w is connected to src.
     * Precondition: w is in G. */
    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {return count;}
}
