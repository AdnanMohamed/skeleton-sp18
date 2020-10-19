package Graph;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);
        while(!in.isEmpty()) {
            String[] entries = in.readLine().split(sp);
            for (String entry : entries) {
                if (!st.contains(entry)) {
                    st.put(entry, st.size());
                }
            }
        }
        in.close();
        G = new Graph(st.size());
        keys = new String[st.size()];
        in = new In(stream);
        while(!in.isEmpty()) {
            String[] entries = in.readLine().split(sp);
            int j = index(entries[0]);
            keys[j] = entries[0];
            for (int i = 1; i < entries.length; ++i) {
                int k = index(entries[i]);
                G.addEdge(j, k);
                keys[k] = entries[i];
            }
        }
        in.close();
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name (int index) {
        return keys[index];
    }

    public Graph G() {
        return G;
    }
}