package Graph;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBFS {

    @Test
    public void test() {
        In fin = new In("Graph/tinyG.txt");
        Graph g = new Graph(fin);
        fin.close();
        BreadthFirstPaths bfs = new BreadthFirstPaths(g, 0);

        for (int v = 0; v < 7; v++) {
            System.out.printf("from %d to %d: ",0, v);
            for (int w: bfs.pathTo(v)) {
                System.out.print("("+ w + ") ");
            }
            System.out.println();
        }
    }
}
