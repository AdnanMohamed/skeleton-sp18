/* This code is an implementation for Prim's algorithm
   to find the minimum spanning tree.

   @author: Adnan H. Mohamed
 */

package EdgeWeightedGraph;

public class MST {

    private EdgeWeightedGraph mst;   // minimum spanning tree.
    private EdgeWeightedGraph WG;    // The complete weighted graph.
    private boolean[] marked;        // marked[i] = true iff i is in mst.

    public MST(EdgeWeightedGraph WG) {
        this.WG = WG;
        prim();
    }

    private void prim() {
        mst = new EdgeWeightedGraph(WG.V());
        marked = new boolean[WG.V()];
        int i = 0;
        while (i < WG.V() - 1) {
            Edge e = leastEdge();
            mst.addEdge(e);
            int v = e.either();
            marked[v] = true;
            marked[e.other(v)] = true;
            ++i;
        }
    }

    /** Returns the least weighted edge such that
     *  it's not in mst before.
     */
    private Edge leastEdge() {
        Edge min = new Edge(0, 0, Double.POSITIVE_INFINITY);
        if (mst.E() == 0) {
            for (Edge e : WG.adj(0)) {
                if (min.compareTo(e) > 0) {
                    min = e;
                }
            }
            return min;
        }
        for (int i = 0; i < marked.length; ++i) {
            if (marked[i]) {
                for (Edge e : WG.adj(i)) {
                    if (marked[e.other(i)] || min.compareTo(e) < 0) {
                        continue;
                    }
                    min = e;
                }
            }
        }
        return min;
    }

    public Iterable<Edge> edges() {
        return mst.edges();
    }

    public double weight() {
        double sum = 0;
        for (Edge e : edges()) {
            sum += e.weight();
        }
        return sum;
    }
}
