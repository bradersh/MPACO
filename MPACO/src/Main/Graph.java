package Main;

import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Graph {
    
    private Vertex[] vertices;
    
    public Graph(int s){
        vertices = new Vertex[s];
        
        for (int i = 0; i < s; i++){
            vertices[i] = new Vertex(i);
        }
    }
    
    public void addEdge(int s, int d, double weight){
        Edge edge = new Edge(s, d, weight);
        vertices[s].addEdge(edge);
        vertices[d].addEdge(edge);
    }
    
    public List<Edge> getAdjacent(int s){
        return vertices[s].getAdjacent();
    }
    
    public static void main(String[] args){
        Graph graph = new Graph(10);
        
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 11);
        graph.addEdge(3, 4, 12);
        graph.addEdge(3, 5, 13);
        graph.addEdge(5, 6, 14);
        graph.addEdge(5, 7, 18);
        graph.addEdge(5, 8, 19);
        graph.addEdge(7, 8, 20);
        graph.addEdge(8, 9, 30);
        graph.addEdge(8, 1, 9);
        
        List<Edge> adj = graph.getAdjacent(1);
        
        for (Edge edge : adj){
            System.out.println(edge);
        }
        
    }
    
}
