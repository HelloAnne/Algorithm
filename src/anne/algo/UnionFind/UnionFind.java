package anne.algo.UnionFind;

public class UnionFind {
    private int[] parent;
    private int count;
    private int[] rank;

    public UnionFind(int count) {
        this.count = count;
        parent = new int[count];
        rank = new int[count];
        for (int i=0; i<count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[parent[p]];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[qRoot] > rank[pRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] ++;
        }

    }

    public static void main(String[] args) {

        int n = 40000000;
        UnionFind uf = new UnionFind(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.union(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("union find: " + 2*n + " ops, " + (endTime-startTime)/1000.0 + "s");
    }

    }
