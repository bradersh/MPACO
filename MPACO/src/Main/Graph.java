package Main;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Graph {
    
    protected Vertex[] vertices; //Contains details about its edges 
    private int antFactor = 3;
    
    public Graph(int s){
        vertices = new Vertex[s]; //Number of vertices to create the array
        
        for (int i = 0; i < s; i++){
            vertices[i] = new Vertex(1.0f, 1.0f, i);
            vertices[i].assignAnt(antFactor);
        }
        
        Graph graph = new Graph(10); //Number of vertices
        
        graph.addEdge(vertices [0], vertices [1], 10);
        graph.addEdge(vertices [1], vertices [2], 11);
        graph.addEdge(vertices [1], vertices [3], 18);
        graph.addEdge(vertices [3], vertices [4], 12);
        graph.addEdge(vertices [3], vertices [0], 16);
        
        List<Edge> adjacent = graph.getAdjacent(2);
        
        for (Edge edge : adjacent){
            System.out.println(edge);
        }
    }
    
    public void addEdge(Vertex s, Vertex d, double weight){ //Adding the bidirectional edges along with their weighting
        Edge edge = new Edge(s, d, weight);
        s.addEdge(edge);
        d.addEdge(edge);
    }
    
    public ArrayList<Edge> getAdjacent(int s){ //Returns a list of the edges 
        return vertices[s].getAdjacent();
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        
    }
}
