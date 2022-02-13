package GraphAlgorithms;

import javax.swing.*;
import java.awt.*;

public class GraphTester {

    public static void main(String[] args) {

        AdjacencyListGraph graph = new AdjacencyListGraph(false);
        graph.BuildGraph();
        graph.printAdjacencyList();

        DFS.DepthFirstSearchRecursive(graph);
        BFS.BreadthFirstSearch(graph, graph.m_Vertices.get(0));
    }
}

