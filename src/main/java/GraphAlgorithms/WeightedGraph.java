package GraphAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WeightedGraph {

    public  boolean isDirected;

    public ArrayList<ArrayList<Edge>> AdjacencyList;
    public ArrayList<Vertex> m_Vertices;
    public ArrayList<Edge> m_Edges;


    public WeightedGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public WeightedGraph(boolean isDirected, int NumVertices) {
        this.isDirected = isDirected;

        AdjacencyList = new ArrayList<ArrayList<Edge>>(NumVertices);
        m_Vertices = new ArrayList<Vertex>();

        // Create an adjacency list for each vertex
        for (int i = 0; i < NumVertices; i++) {
            AdjacencyList.add(new ArrayList<Edge>());
        }

        // Create the vertices
        for (int i = 0; i < NumVertices; i++) {
            m_Vertices.add(new Vertex(i));
        }
    }

    void addEdge(Vertex s, Vertex d, int weight){
        Edge newEdge = new Edge(s, d, weight);
        AdjacencyList.get(s.identity).add(newEdge);
        if(!isDirected)
            AdjacencyList.get(d.identity).add(newEdge);
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
                int source = Integer.parseInt(values[0]);
                int destination = Integer.parseInt(values[1]);
                int weight = Integer.parseInt(values[2]);

                if(source > NumVertices)
                    NumVertices = source;
                if(destination> NumVertices)
                    NumVertices = destination;

                edge.add(source);
                edge.add(destination);
                edge.add(weight);
                edges.add(edge);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        NumVertices++;


        AdjacencyList = new ArrayList<ArrayList<Edge>>(NumVertices);
        m_Vertices = new ArrayList<Vertex>();

        // Create an adjacency list for each vertex
        for (int i = 0; i < NumVertices; i++) {
            AdjacencyList.add(new ArrayList<Edge>());
        }

        // Create the vertices
        for (int i = 0; i < NumVertices; i++) {
            m_Vertices.add(new Vertex(i));
        }

        // Create the edges
        for (List<Integer> edge : edges){
            addEdge(m_Vertices.get(edge.get(0)), m_Vertices.get(edge.get(1)), edge.get(2));
        }
    }

    public void printAdjacencyList(){
        System.out.println("\n ======= ADJACENCY LIST ======= ");
        for (int i = 0; i < AdjacencyList.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < AdjacencyList.get(i).size(); j++) {
                System.out.print(" ->" + AdjacencyList.get(i).get(j).destination.identity);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void TransposeGraph(){

        ArrayList<ArrayList<Edge>> TempAdjacencyList = new ArrayList<ArrayList<Edge>>(m_Vertices.size());

        // Setup new adjacency list
        for (int i = 0; i < m_Vertices.size(); i++) {
            TempAdjacencyList.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < AdjacencyList.size(); i++) {
            for (Edge e : AdjacencyList.get(i)){
                TempAdjacencyList.get(e.destination.identity).add(new Edge(e.source, e.destination, e.weight));
            }
        }
        AdjacencyList = TempAdjacencyList;
    }

    public void FindStronglyConnectedComponents(){
        DFS.DepthFirstSearchRecursive(this);
        TransposeGraph();
        Collections.sort(m_Vertices);
        DFS.DepthFirstSearchRecursive(this);
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

    public void initializeSingleSource(int source){
        for(Vertex v : m_Vertices){
            v.distance = Integer.MAX_VALUE;
            v.parent = null;
        }
        m_Vertices.get(source).distance = 0;
        m_Vertices.stream().filter(x -> x.identity == source).findFirst().get().distance=0;
    }

    public void relax(Vertex u, Vertex v, int weight){
        if(u.distance == Integer.MAX_VALUE)
            return;
        if(v.distance > u.distance + weight){
            v.distance = u.distance + weight;
            v.parent = u;
        }
    }
}
