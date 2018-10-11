package anne.algo.graph;

import java.util.Vector;

/**
 * 稠密图 -- 邻接矩阵
 */
public class DenseGraph implements Graph {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.directed = directed;
        this.n = n;
        this.m = 0;  // 初始化没有任何边
        g = new boolean[n][n];// g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边。false为boolean型变量的默认值
    }

    /**
     * 返回节点个数
     * @return
     */
    @Override
    public int V() {
        return n;
    }

    /**
     * 返回边的个数
     * @return
     */
    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        if (g[v][w]) {
            return;
        }
        g[v][w] = true;
        m++;
        if (!directed) {
            g[w][v] = true;
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        return g[v][w];
    }

    @Override
    public void show() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v) {
        Vector<Integer> adjV = new Vector<>();
        for (int i=0; i<n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }
}
