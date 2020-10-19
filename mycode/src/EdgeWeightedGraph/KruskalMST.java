package EdgeWeightedGraph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
    private Queue<Edge> mst;
    private double weight;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        UF uf = new UF(G.V());
        weight = 0;

        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        while (mst.size() < G.V() - 1) {
            Edge min = pq.delMin();
            int v = min.either();
            int w = min.other(v);
            if (uf.connected(v, w))
                continue;
            weight += min.weight();
            mst.enqueue(min);
            uf.union(v, w);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return Double.parseDouble(String.format("%.3f", weight));
    }
}
