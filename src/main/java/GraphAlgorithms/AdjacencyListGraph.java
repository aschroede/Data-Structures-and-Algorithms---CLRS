package GraphAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListGraph {

    //region Attributes

    // Indicates if the graph is directed or undirected
    public  boolean isDirected;

    // The graph object
    public ArrayList<ArrayList<Vertex>> m_AdjacencyList;
    
    public ArrayList<Vertex> m_Vertices;

    //endregion

    //region Constructor

    public AdjacencyListGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    //endregion

    //region Methods

    void addEdge(Vertex s, Vertex d){
        m_AdjacencyList.get(s.identity).add(d);
        if(!isDirected)
             m_AdjacencyList.get(d.identity).add(s);
    }

    public void BuildGraph() {

        int NumVertices = 0;
        List<List<Integer>> edges = new ArrayList<>();

        // Read edges from file
        try {
            Scanner sc = new Scanner(new File("C:\\Git\\Data-Structures-and-Algorithms---CLRS\\Resources\\SimpleGraph.csv"), "utf-8");
            sc.useDelimiter(",");

            while(sc.hasNext()){
                List<Integer> edge = new ArrayList<>();
                String numLine = sc.nextLine();
                String[] values = numLine.split(",");
                int u = Integer.parseInt(values[0]);
                int v = Integer.parseInt(values[1]);

                if(u > NumVertices)
                    NumVertices = u;
                if(v> NumVertices)
                    NumVertices = v;

                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        NumVertices++;


        m_AdjacencyList = new ArrayList<ArrayList<Vertex>>(NumVertices);
        m_Vertices = new ArrayList<Vertex>();

        // Create an adjacency list for each vertex
        for (int i = 0; i < NumVertices; i++) {
            m_AdjacencyList.add(new ArrayList<Vertex>());
        }

        // Create the vertices
        for (int i = 0; i < NumVertices; i++) {
            m_Vertices.add(new Vertex(i));
        }

        // Create the edges
        for (List<Integer> edge : edges){
            addEdge(m_Vertices.get(edge.get(0)), m_Vertices.get(edge.get(1)));
        }
    }

    public void printAdjacencyList(){
        System.out.println("\n ======= ADJACENCY LIST ======= ");
        for (int i = 0; i < m_AdjacencyList.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < m_AdjacencyList.get(i).size(); j++) {
                System.out.print(" ->" + m_AdjacencyList.get(i).get(j).identity);
            }
            System.out.println();
        }
        System.out.println();
    }

    //endregion
}


