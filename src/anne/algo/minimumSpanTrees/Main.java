package anne.algo.minimumSpanTrees;

public class Main {
    public static void main(String[] args) {

        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "src/anne/algo/minimumSpanTrees/testG1.txt";
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph.read(g1, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();

        System.out.println();

        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<Double>(8, false);
        ReadWeightedGraph.read(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();
    }
}
