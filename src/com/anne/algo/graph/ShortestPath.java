package com.anne.algo.graph;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {
    private Graph g;
    private int s;
    private int[] from;
    private boolean[] visited;
    private int[] ord;

    public ShortestPath(Graph g, int s) {
        assert s>=0 && s<g.V();
        this.g = g;
        this.s = s;

        from = new int[g.V()];
        visited = new boolean[g.V()];
        ord = new int[g.V()];

        for (int i=0; i<g.V(); i++) {
            from[i] = -1;
            ord[i] = -1;
            visited[i] = false;
        }

        LinkedList<Integer> q = new LinkedList<>();
        q.push(s);
        visited[s] = true;
        ord[s] = 0;
        while (! q.isEmpty()) {
            int v = q.pop();
            for (int i : g.adj(v)) {
                if (!visited[i]) {
                    q.push(i);
                    ord[i] = ord[v] +1;
                    visited[i] = true;
                    from[i] = v;
                }
            }
        }
    }

    public boolean hasPath(int w) {
        assert w>=0 && w<g.V();
        return visited[w];
    }

    public Vector<Integer> path(int w) {
        assert hasPath(w);
        int p = w;
        Stack<Integer> stack = new Stack<>();
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        Vector<Integer> vector = new Vector<>();
        while (! stack.isEmpty()) {
            vector.add(stack.pop());
        }
        return vector;
    }

    public void showPath(int w) {
        Vector<Integer> vector = path(w);
        for (int i : vector) {
            if (i != vector.lastElement()) {
                System.out.print(i + " -> ");
            }else {
                System.out.println(i);
            }
        }
    }

    public int length(int w) {
        assert w>=0 && w<g.V();
        return ord[w];
    }


}
