package com.anne.algo.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ReadGraph {

    private static Scanner scanner;

    public static void read(Graph graph, String filename) {

        readFile(filename);

        int V = scanner.nextInt();
        if (V < 0) {
            throw new IllegalStateException("number of vertices in a Graph must be non-negative");
        }
        assert V == graph.V();
        int E = scanner.nextInt();
        if (E < 0) {
            throw new IllegalStateException("number of edges in a Graph must be non-negative");
        }

        for (int i=0; i<E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

    }

    private static void readFile(String filename) {
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open " + filename, e);
        }

    }
}
