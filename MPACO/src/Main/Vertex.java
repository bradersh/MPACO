package Main;

import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Vertex {
    
    private int id;
    private List<Edge> edgeList = new ArrayList<>();
    
    public int getId(){
        return id;
    }
    
    public Vertex(int id){
        this.id = id;
    }
    
    public void addEdge(Edge edge){
        edgeList.add(edge);
    }
    
    public List<Edge> getAdjacent(){
        return edgeList;
    }
}
