package anne.algo.minimumSpanTrees;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ReadWeightedGraph {

    private static Scanner scanner;

    public static void read(WeightedGraph<Double> g, String fileName){
        readFile(fileName);

        int n = scanner.nextInt();
        if (n < 0) {
            throw new IllegalStateException("number of vertices in a Graph must be nonnegative");
        }
        assert g.V() == n;
        int m = scanner.nextInt();
        if (m < 0) {
            throw new IllegalStateException("number of edges in a Graph must be nonnegative");
        }
        for (int i=0; i<m; i++) {
            int v = scanner.nextInt();
            assert v >= 0 && v < n;
            int w = scanner.nextInt();
            assert w >= 0 && w < n;
            double wt = scanner.nextDouble();
            g.addEdge(new Edge<Double>(v, w, wt));
        }

    }

    private static void readFile(String fileName) {
        assert fileName != null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
                scanner.useLocale(Locale.ENGLISH);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("can not read file: " + fileName, ioe);
        }


    }
}
