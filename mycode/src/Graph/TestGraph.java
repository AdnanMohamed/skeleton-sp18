package Graph;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class TestGraph {

    @Test
    public void TestConstructor() {
        Graph g = new Graph(1);
        assertTrue(g.V() == 1);
        assertTrue(g.E() == 0);

        final int TEST_SIZE = 10;

        Graph g2 = new Graph(TEST_SIZE);
        assertTrue(g2.V() == TEST_SIZE);
        assertTrue(g2.E() == 0);

        for (int i = 0; i < TEST_SIZE; ++i) {
            g.addEdge(0, 0);
        }
        assertTrue(g.V() == 1);
        assertTrue(g.E() == TEST_SIZE);

    }

    @Test
    public void TestAddAdjTo() {
        Random r = new Random(1215);
        Graph g = new Graph(1);

        final int TEST_SIZE = 10;

        for (int i = 0; i < TEST_SIZE; ++i) {
            g.addEdge(0, 0);
        }
        assertTrue(g.V() == 1);
        assertTrue(g.E() == TEST_SIZE);

        final int TEST_SIZE2 = 100;
        Graph g2 = new Graph(TEST_SIZE2);

        boolean[][] adj = new boolean[TEST_SIZE2][TEST_SIZE2];

        for (int i = 0; i < TEST_SIZE2 * TEST_SIZE2; ++i) {
            int v = Math.floorMod(r.nextInt(), g2.V());
            int w = Math.floorMod(r.nextInt(), g2.V());
            if (!adj[v][w]) {
                adj[v][w] = true;
                adj[w][v] = true;
            }
            g2.addEdge(v, w);
        }
        assertTrue(g2.E() == TEST_SIZE2 * TEST_SIZE2);
        for (int i = 0; i < TEST_SIZE2; ++i) {
            for (int e: g2.adjTo(i)) {
                assertTrue(adj[i][e]);
            }
        }
    }

    @Test
    public void TestConstructor2() {
        In fin = new In("Graph/tinyG.txt");
        Graph g = new Graph(fin);
        fin.close();
        assertTrue(g.V() == 13);
        assertTrue(g.E() == 13);

        Set<Integer> adj0 = new HashSet<>();
        adj0.add(1);
        adj0.add(5);
        adj0.add(6);
        adj0.add(2);

        Set<Integer> adj1 = new HashSet<>();
        adj1.add(0);

        Set<Integer> adj2 = new HashSet<>();
        adj2.add(0);

        Set<Integer> adj5 = new HashSet<>();
        adj5.add(0);
        adj5.add(3);
        adj5.add(4);

        Set<Integer> adj6 = new HashSet<>();
        adj6.add(0);
        adj6.add(4);

        Set<Integer> adj3 = new HashSet<>();
        adj1.add(5);
        adj1.add(4);

        Set<Integer> adj4 = new HashSet<>();
        adj1.add(3);
        adj1.add(5);
        adj1.add(6);

        Set<Integer> adj7 = new HashSet<>();
        adj1.add(8);

        Set<Integer> adj8 = new HashSet<>();
        adj1.add(7);

        Set<Integer> adj9 = new HashSet<>();
        adj9.add(10);
        adj9.add(11);
        adj9.add(12);

        Set<Integer> adj10 = new HashSet<>();
        adj10.add(9);

        Set<Integer> adj11 = new HashSet<>();
        adj11.add(9);
        adj11.add(12);

        Set<Integer> adj12 = new HashSet<>();
        adj12.add(9);
        adj12.add(11);

        Set<Integer>[] sets = new Set[13];
        sets[0] = adj0;
        sets[1] = adj1;
        sets[2] = adj2;
        sets[3] = adj3;
        sets[4] = adj4;
        sets[5] = adj5;
        sets[6] = adj6;
        sets[7] = adj7;
        sets[8] = adj8;
        sets[9] = adj9;
        sets[10] = adj10;
        sets[11] = adj11;
        sets[12] = adj12;

        for (int i = 0; i < 13; ++i) {
            for (int v:g.adjTo(i)) {
                sets[i].contains(v);
            }
        }
    }

    @Test
    public void TestDegree() {
        In fin = new In("Graph/tinyG.txt");
        Graph g = new Graph(fin);
        fin.close();

        assertTrue(Graph.degree(g, 0) == 4);
        assertTrue(Graph.degree(g, 3) == 2);
        assertTrue(Graph.degree(g, 9) == 3);
        assertTrue(Graph.degree(g, 7) == 1);
        assertTrue(Graph.maxDegree(g) == 4);
        assertTrue(Graph.avgDegree(g) == 2);
        assertTrue(Graph.numberOfSelfLoops(g) == 0);
    }

    @Test
    public void TestLoops() {
        In fin = new In("Graph/G10.txt");
        Graph g = new Graph(fin);
        fin.close();

        assertTrue(Graph.numberOfSelfLoops(g) == 2);
        System.out.println(g);
    }
}
