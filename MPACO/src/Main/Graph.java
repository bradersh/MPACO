package Main;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Graph {
    
    protected Vertex[] vertices; //Contains details about its edges 
    
    public Graph(int s){
        vertices = new Vertex[s]; //Number of vertices to create the array
        
        for (int i = 0; i < s; i++){
            vertices[i] = new Vertex(1.0f, 1.0f, i);
        }
        
        Graph graph = new Graph(10); //Number of vertices
        
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
        
        List<Edge> adjacent = graph.getAdjacent(2);
        
        for (Edge edge : adjacent){
            System.out.println(edge);
        }
    }
    
    public void addEdge(int s, int d, double weight){ //Adding the bidirectional edges along with their weighting
        Edge edge = new Edge(s, d, weight);
        vertices[s].addEdge(edge);
        Edge edge2 = new Edge(d, s, weight);
        vertices[d].addEdge(edge2);
    }
    
    public List<Edge> getAdjacent(int s){ //Returns a list of the edges 
        return vertices[s].getAdjacent();
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        
    }
}
