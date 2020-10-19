package Digraph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> post;         // vertices in postorder
    private Queue<Integer> pre;          // vertices in preorder
    private Stack<Integer> reversePost;  // vertices in reverse postorder;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() { return pre; }
    public Iterable<Integer> post() { return post; }
    public Iterable<Integer> reversePost() { return reversePost; }
}
