package GraphAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class UnweightedGraph {

    public  boolean isDirected;

    public ArrayList<ArrayList<Vertex>> AdjacencyList;
    
    public ArrayList<Vertex> m_Vertices;


    public UnweightedGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public UnweightedGraph(boolean isDirected, int NumVertices) {
        this.isDirected = isDirected;

        AdjacencyList = new ArrayList<ArrayList<Vertex>>(NumVertices);
        m_Vertices = new ArrayList<Vertex>();

        // Create an adjacency list for each vertex
        for (int i = 0; i < NumVertices; i++) {
            AdjacencyList.add(new ArrayList<Vertex>());
        }

        // Create the vertices
        for (int i = 0; i < NumVertices; i++) {
            m_Vertices.add(new Vertex(i));
        }
    }

    void addEdge(Vertex s, Vertex d){
        AdjacencyList.get(s.identity).add(d);
        if(!isDirected)
             AdjacencyList.get(d.identity).add(s);
    }

    public void BuildGraph(String filePath) {

        int NumVertices = 0;
        List<List<Integer>> edges = new ArrayList<>();

        // Read edges from file
        try {
            Scanner sc = new Scanner(new File(filePath), "utf-8");
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


        AdjacencyList = new ArrayList<ArrayList<Vertex>>(NumVertices);
        m_Vertices = new ArrayList<Vertex>();

        // Create an adjacency list for each vertex
        for (int i = 0; i < NumVertices; i++) {
            AdjacencyList.add(new ArrayList<Vertex>());
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
        for (int i = 0; i < AdjacencyList.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < AdjacencyList.get(i).size(); j++) {
                System.out.print(" ->" + AdjacencyList.get(i).get(j).identity);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void TransposeGraph(){

        ArrayList<ArrayList<Vertex>> TempAdjacencyList = new ArrayList<ArrayList<Vertex>>(m_Vertices.size());

        // Setup new adjacency list
        for (int i = 0; i < m_Vertices.size(); i++) {
            TempAdjacencyList.add(new ArrayList<Vertex>());
        }

        for (int i = 0; i < AdjacencyList.size(); i++) {
            for (Vertex v : AdjacencyList.get(i)){
                TempAdjacencyList.get(v.identity).add(m_Vertices.get(i));
            }
        }
        AdjacencyList = TempAdjacencyList;
    }

    public void FindStronglyConnectedComponents(){
        //DFS.DepthFirstSearchRecursive(this);
        TransposeGraph();
        Collections.sort(m_Vertices);
        //DFS.DepthFirstSearchRecursive(this);
        Map<Integer, List<Vertex>> stronglyConnectedComponents =
                m_Vertices.stream().collect(Collectors.groupingBy(vertex -> vertex.connectedComponent));

        System.out.println("\n ======= STRONGLY CONNECTED COMPONENTS ======= ");

        for (var entry : stronglyConnectedComponents.entrySet()) {

            for (var value : entry.getValue()){
                System.out.print(value.identity + ",");
            }
            System.out.println();
        }
    }

    public void initializeSingleSource(Vertex source){
        for(Vertex v : m_Vertices){
            v.distance = Integer.MAX_VALUE;
            v.parent = null;
        }
        source.distance = 0;
    }

}


