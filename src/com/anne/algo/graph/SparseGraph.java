package com.anne.algo.graph;

import java.util.Vector;

public class SparseGraph implements Graph {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean isDirected;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean isDirected) {
        this.n = n;
        this.m = 0;
        this.isDirected = isDirected;
        this.g = new Vector[n];
        for (int i=0; i<n; i++) {
            g[i] = new Vector<>();
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
    public void addEdge(int v, int w) {
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        if (hasEdge(v, w)) {
            return;
        }
        g[v].add(w);
        m++;
        if (!isDirected) {
            g[w].add(v);
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        for (int i=0; i<g[v].size(); i++) {
            if (g[v].elementAt(i) == w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i=0; i<n; i++){
            System.out.print(i + ": ");
            for (int j=0; j<g[i].size(); j++) {
                System.out.print(g[i].elementAt(j) + " ");
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
        for (int i=0; i<g[v].size(); i++) {
            adjV.add(g[v].elementAt(i));
        }
        return adjV;
    }
}
