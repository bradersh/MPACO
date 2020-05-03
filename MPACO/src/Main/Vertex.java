package Main;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Vertex extends FeatureEntity {
    
    private int id;
    private List<Edge> edgeList = new ArrayList<>();
    //private List<Feature> featureList = new ArrayList<>();
    
    public Vertex(float x, float y, int feature){
        super(x, y);
        this.id = id;
    }
    
    public void tick(){
        //evaporate();
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.node, 200, 200, null);
    }
    
    public void addEdge(Edge edge){
        edgeList.add(edge);
    }
    
    public int getId(){
        return id;
    }
    
    public List<Edge> getAdjacent(){
        return edgeList;
    }
    
    /*
    public List<Feature> getFeature(){
        return featureList;
    }
    */
}