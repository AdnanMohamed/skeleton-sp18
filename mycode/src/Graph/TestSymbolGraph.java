package Graph;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class TestSymbolGraph {
    public static void main(String[] args) {
        String filename = "Graph/movies.txt";
        String delim = "/";
        SymbolGraph sg = new SymbolGraph(filename, delim);

        Graph G = sg.G();

        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : G.adjTo(sg.index(source))) {
                StdOut.println("   " + sg.name(w));
            }
        }
    }
}
