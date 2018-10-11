package anne.algo.graph;

import java.util.Stack;
import java.util.Vector;

public class Path {
    private Graph G;
    private int s;
    private int[] from;
    private boolean[] visited;

    public Path(Graph G, int s) {
        this.G = G;
        assert s>=0 && s<G.V();
        this.s = s;
        from = new int[G.V()];
        visited = new boolean[G.V()];
        for (int i=0; i<G.V(); i++) {
            from[i] = -1;
            visited[i] = false;
        }
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    /**
     * s到w是否有路径
     * @param w
     * @return
     */
    public boolean hasPath(int w) {
        assert w>=0 && w<G.V();
        return visited[w];
    }

    /**
     * s到w的路径
     * @param w
     * @return
     */
    public Vector<Integer> path(int w) {
        assert hasPath(w);
        int p = w;
        Stack<Integer> stack = new Stack<>();
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        Vector<Integer> vector = new Vector<>();
        while (!stack.isEmpty()) {
            vector.add(stack.pop());
        }
        return vector;
    }

    public void showPath(int w) {
        Vector<Integer> vector = path(w);
        for(int i : vector) {
            if (i != vector.lastElement()) {
                System.out.print(i + " -> ");
            } else {
                System.out.println(i);
            }
        }
    }

}

