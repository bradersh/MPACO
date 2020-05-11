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
    
    public void render(Graphics g){ //Casted the floats to ints
        switch (this.feature){
            case(1):g.drawImage(Assets.node1, (int) x, (int) y, null);
            break;
            case(2):g.drawImage(Assets.node2, (int) x, (int) y, null);
            break;
            case(3):g.drawImage(Assets.node3, (int) x, (int) y, null);
            break;
            case(4):g.drawImage(Assets.node4, (int) x, (int) y, null);
            break;
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