package Main;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author BradleyH
 */

public class Vertex extends FeatureEntity {

    private ArrayList<Edge> edgeList = new ArrayList<>();
    private ArrayList<Ant> currentAnts = new ArrayList<>();
    private List<Feature> featureList = new ArrayList<>();
    
    public Vertex(float x, float y, int feature){
        super(x, y);
    }
    
    public void tick(){
        //evaporate();
    }
    
    public void assignAnt(Ant ant){
        currentAnts.add(ant);
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.node, 200, 200, null);
    }
    
    public void addEdge(Edge edge){
        edgeList.add(edge);
    }
    
    public ArrayList<Edge> getAdjacent(){
        return edgeList;
    }
    
    public ArrayList<Ant> getAnt(){
        return currentAnts;
    }
    
    public void addAnt(Ant newAnt){
        currentAnts.add(newAnt);
    }
    
    public void removeAnt(Ant newAnt){
        currentAnts.remove(newAnt);
    }
    
    public List<Feature> getFeature(){
        return featureList;
    }
}