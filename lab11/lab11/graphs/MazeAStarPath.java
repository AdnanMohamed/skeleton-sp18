package lab11.graphs;

import edu.princeton.cs.algs4.MinPQ;

/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    /** inherits:
     *  int[] distTo;
     *  int[] edgeTo;
     *  boolean[] marked;
     */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;


    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
//        for (int i = 0; i < maze.V(); ++i) {
//            distTo[i] = Integer.MAX_VALUE;
//        }
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        int sourceX = maze.toX(v);
        int targetX = maze.toX(t);
        int sourceY = maze.toY(v);
        int targetY = maze.toY(t);

        return Math.abs(sourceX - targetX) + Math.abs(sourceY - targetY);
    }

    /** Finds vertex estimated to be closest to target.
     *  and adjacent to v. */
    private int findMinimumUnmarked(int v) {
        int min = maze.adj(v).iterator().next();
        for (int w : maze.adj(v)) {
            if (!marked[w] && h(w) < h(min)) {
                min = w;
            }
        }
        return min;
    }

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        marked[s] = true;
        if (s == t) {
            targetFound = true;
        }
        MinPQ<Integer> PQ = new MinPQ<>();
        for (int i = 0; i < maze.V(); ++i) {
            if (marked[i]) {
                PQ.insert(findMinimumUnmarked(i));
            }
        }
        int n = PQ.delMin();
        distTo[n] = distTo[s] + 1;
        edgeTo[n] = s;
        maze.notify();
        astar(n);
    }

    /** Returns the estimated distance from v to target.
     *  Note: This accounts for the cost and hueristic. */
    private int estDistance(int v) {
        return distTo[v] + h(v);
    }

    @Override
    public void solve() {
        astar(s);
    }

}

