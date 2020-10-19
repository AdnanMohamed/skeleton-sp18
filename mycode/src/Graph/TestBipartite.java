package Graph;

import edu.princeton.cs.algs4.Bipartite;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBipartite {

    @Test
    public void test() {
        In fin = new In("Graph/tinyG.txt");
        Graph g = new Graph(fin);
        fin.close();
        System.out.print(g);

        TwoColor bipartite = new TwoColor(g);
        assertTrue(!bipartite.isBipartite());
    }
}
