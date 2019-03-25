package com.anne.algo.minimumSpanTrees;

import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;
    private int m;
    private boolean directed;
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Vector[n];
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
    public void addEdge(Edge edge) {
        int v = edge.v();
        int w = edge.w();

        assert v>=0 && v<n;
        assert w>=0 && w<n;

        g[v].add(new Edge<Weight>(edge));
        if (!directed) {
            g[w].add(new Edge<Weight>(w, v, (Weight) edge.wt()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        for (int i=0; i<g[v].size(); i++) {
            if (g[v].elementAt(i).other(v) == w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i=0; i<n; i++) {
            System.out.print("vertex " + i + ": ");
            for (Edge<Weight> edge : g[i]) {
                System.out.print( "( to:" + edge.other(i) + ",wt:" + edge.wt() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v>=0 && v<n;
        return g[v];
    }
}
