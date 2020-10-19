package shortestPath;

public class DirectedEdge {

    private int src, dst;        // the edge source and destination.
    private double weight;   // the edge weight (a.k.a cost)
    public DirectedEdge(int v, int w, double weight) {
        src = v;
        dst = w;
        this.weight = weight;
    }

    public double weight() {
        return Double.parseDouble(String.format("%.3f", weight));
    }

    public int from() { return src; }

    public int to() { return dst; }

    public String toString() {
        return "{" + from() + "-> " +
                to() + " : " + weight() + "}";
    }
}
