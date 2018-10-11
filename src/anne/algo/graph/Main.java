package anne.algo.graph;

public class Main {
    public static void main(String[] args) {

        String filename = "src/anne/algo/graph/testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph.read(g, filename);
        g.show();
        System.out.println();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        Path dfs = new Path(g,0);
        System.out.print("DFS : ");
        dfs.showPath(4);

        ShortestPath bfs = new ShortestPath(g,0);
        System.out.print("BFS : ");
        bfs.showPath(4);
    }
}
