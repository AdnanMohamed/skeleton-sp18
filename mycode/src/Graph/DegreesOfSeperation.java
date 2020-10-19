package Graph;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class DegreesOfSeperation {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("You did not enter the required 3 arguments!");
            System.out.println("Usage: file_name delimeter node_name.");
            System.exit(0);
        }
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];

        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        System.out.println(sg.name(v));
                    }
                } else {
                    System.out.println(s + "is not connected to " + sink);
                }
            } else {
                System.out.println(sink + " not in database.");
            }
        }
    }
}
