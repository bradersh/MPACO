package Main;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author BradleyH
 */
public class Ant extends FeatureEntity{
    
    private boolean depoisting = false; //Whether or not the ant is depositing pheremore
    private List<Ant> antList = new ArrayList<>();
    private double antFactor = 1.0; //The factor to which the number of spawned ants is decided (an antFactor of 1 would be 1 ant for each node etc.)
    private Vertex vertex;
    private Edge chosenEdge;
    
    public Ant(float x, float y, int feature, Vertex vertex){
        super(x, y);
        this.vertex = vertex;
    }
    
    public void tick(){
        HashMap<Edge, Double> edgeProb = new HashMap<>();
        for (Edge edge: vertex.getAdjacent()){
            edgeProb.put(edge, evaluateEdge(edge));
        }
        //check for ant on vertext
        //choose edge from hashmap here
        chosenEdge = null; //the chosen edge
        //remove ant from vertext and add to first edge segment 
        //else
        //if last vertext == feature, deposit == true 
        //int for step of edge (class variable)
        //move to next segment
        //remove from last segment array and add to new
        //check for ant on edge segment
        //for last segemtn change boolean for edge
        //boolean if its on edge if loop 
        //add to vertex ant array

        //needs to know about other ants (get ant in current location) 
    }
    
    public double evaluateEdge(Edge edge){
        return 0.0; //work out maths
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.ant, (int) x, (int) y, null);//Casted the floats to ints
    }
    
    public void deposit(){
        //location.deposit(); 
    }
}
