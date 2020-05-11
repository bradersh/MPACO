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
    
    public Vertex(float x, float y, int feature){
        super(x, y);
        this.feature = feature;
    }
    
    public void tick(){
        evaporate();
    }
    
    public void assignAnt(Ant ant){
        currentAnts.add(ant);
    }
    
    public void render(Graphics g){
        switch (this.feature){
            case(1):g.drawImage(Assets.node, (int) x, (int) y, null);//Casted the floats to ints
            case(2):g.drawImage(Assets.node, (int) x, (int) y, null);
            case(3):g.drawImage(Assets.node, (int) x, (int) y, null);
            case(4):g.drawImage(Assets.node, (int) x, (int) y, null);
        }
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
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
}