package shortestPath;

import edu.princeton.cs.algs4.In;

public class TestShortestPath {
    public static void main(String[] args) {
        EdgeWeightedDigraph DG = new EdgeWeightedDigraph(new In(args[0]));
        int src;
        if (args.length == 2) {
            src = Integer.parseInt(args[1]);
            if (src < 0 || src >= DG.V()) {
                System.out.println(src + " is an invalid vertex.");
                System.out.println("Valid vertex is in [0, " + DG.V() + ")");
                System.exit(0);
            }
        } else {
            src = 0;
        }
        SP sp = new SP(DG, src);

        for (int dst = 0; dst < DG.V(); dst++) {
            System.out.print(src + " to " + dst);
            System.out.printf("  (%4.2f): ", sp.distTo(dst));
            if (sp.hasPathTo(dst)) {
                for (DirectedEdge e : sp.pathTo(dst)) {
                    System.out.print(e + "  ");
                }
                System.out.println();
            }
        }
    }
}
