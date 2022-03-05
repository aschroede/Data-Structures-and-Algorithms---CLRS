package Algorithms;
import GraphAlgorithms.Dijkstra;
import GraphAlgorithms.WeightedGraph;
import java.io.IOException;

public class AlgorithmTester {

    public static void main(String[] args) throws IOException {
        String text = "2359023141526739921";
        String pattern = "31415";
        rabinKarpMatcher.rabinKarp(text, pattern, 10, 13);
    }
}
