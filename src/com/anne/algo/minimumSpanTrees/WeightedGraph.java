package com.anne.algo.minimumSpanTrees;

public interface WeightedGraph<Weight extends Number & Comparable> {
    int V();
    int E();
    void addEdge(Edge<Weight> edge);
    boolean hasEdge(int v, int w);
    void show();
    Iterable<Edge<Weight>> adj(int v);

}
