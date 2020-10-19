package EdgeWeightedGraph;

public class Edge implements Comparable<Edge>{

    private int v, w;      // the endpoints of this edge.
    private double weight; // the weight of this edge.

    /** Creates an edge with endpoints (v, w)
     *  and cost equal to weight. */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    /** Returns any of the endpoints. */
    public int either() {
        return v;
    }

    /** Returns the endpoint w such that w != vertex.
     *  Precondition: vertex is an endpoint of this edge. */
    public int other(int vertex) {
        if (vertex != v && vertex != w) {
            throw new RuntimeException("This edge is not incident on " + vertex);
        }
        return vertex == v ? w : v;
    }

    /** Returns positive integer if this edge's weight
     *  is greater than e, negative if this weight's less,
     *  zero if equal.
     */
    public int compareTo(Edge e) {
        return Double.compare(weight, e.weight);
    }

    /** The string representation of this edge. */
    public String toString() {
        return "{" + v + ", " + w + " weight = " + weight + "}";
    }
}
