package anne.algo.minimumSpanTrees;

import java.util.Vector;

public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;
    private int m;
    private boolean directed;
    private Edge<Weight>[][] g;

    public DenseWeightedGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;

        g = new Edge[n][n];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge edge) {
        int v = edge.v();
        int w = edge.w();
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        if (hasEdge(v, w)){
            return;
        }
        g[v][w] = new Edge<Weight>(edge);
        m++;
        if (!directed) {
            g[w][v] = new Edge<Weight>(w, v, (Weight) edge.wt());
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v>0 && v<n;
        assert w>0 && w<n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].wt() + " ");
                } else {
                    System.out.print("NULL ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v>=0 && v<n;
        Vector<Edge<Weight>> vector = new Vector<>();
        for (int i=0; i<n; i++) {
            if (g[v][i] != null) {
                vector.add(g[v][i]);
            }
        }
        return vector;
    }
}
