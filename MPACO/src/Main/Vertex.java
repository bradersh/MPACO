package Main;

import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Vertex extends Location {
    
    private int id;
    private List<Edge> edgeList = new ArrayList<>();
    private List<Feature> featureList = new ArrayList<>();
    
    public Vertex(int id){
        this.id = id;
        Feature feature = new Colour();
        featureList.add(feature);
    }
    
    public void tick(){
        evaporate();
    }
    
    public void render(){
        
    }
    
        
    public int getId(){
        return id;
    }
    
    public void addEdge(Edge edge){
        edgeList.add(edge);
    }
    
    public List<Edge> getAdjacent(){
        return edgeList;
    }
    
    public List<Feature> getFeature(){
        return featureList;
    }
}