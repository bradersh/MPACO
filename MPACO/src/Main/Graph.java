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
    private ArrayList<Ant> ants = new ArrayList<Ant>();
    
    public Graph(int s){
        vertices = new Vertex[s]; //Number of vertices to create the array
        
        for (int i = 0; i < s; i++){
            vertices[i] = new Vertex(1.0f, 1.0f, i);
            for (int k = 0; k < antFactor; k++){
                Ant tempAnt = new Ant(1.0f, 1.0f, i, vertices[i]);     
                ants.add(tempAnt);
                vertices[i].addAnt(tempAnt);
            }
        }
        
        addEdge(vertices [0], vertices [1], 10);
        addEdge(vertices [1], vertices [2], 11);
        addEdge(vertices [1], vertices [3], 18);
        addEdge(vertices [3], vertices [4], 12);
        addEdge(vertices [3], vertices [0], 16);
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
        for(Ant ant : ants){
            ant.tick();
        }
    }
    
    public void render(Graphics g){
        
    }
}
