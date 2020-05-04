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
        Ant ant = new Ant(x, y, feature, vertex);
        //if ants location is a vertex :
        
        vertex.addAnt(ant);
        vertex.getAnt();
        
        HashMap<Edge, Double> edgeProb = new HashMap<>();
        for (Edge edge : vertex.getAdjacent()){
            edgeProb.put(edge, evaluateEdge(edge));
        }
        
        
        
        //choose edge from hashmap here
        chosenEdge = null; //the chosen edge
        //remove ant from vertext and add to first edge segment 
        
        //else
        //if last vertext == feature, deposit == true 
        //int for step of edge (class variable indicating the step i.e. if weight is 10, set to 10 and reduce each tick, the njoin vertex.)
        //remove from last segment array and add to new
        //check for ant on edge segment
        //repeat
        //if
        //last segemtn change boolean for edge
        //boolean if its on edge if loop 
        //add to vertex ant array
    }
    
    public double evaluateEdge(Edge edge){
        
        //each edge has a default value
        //each pheremone on the edge increases its value by 1
        //sum of all the values added together and a dice rolled between 0 and that number
        //e.g. if there are 3 paths, two with no pheremone both with a value of 10, and a pather with pheremone with a value of 20
        //a dice will be rolled out of 40, if its 0-9 its first basic path, 10 -19 the second basic path and 20-39 its the pheremone path 
        
        return 0.0; //work out maths
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.ant, (int) x, (int) y, null);//Casted the floats to ints
    }
    
    public void deposit(){
        //location.deposit(); 
    }
    
    private Vertex[] vertices;
    
    //CHECK!!!
    public ArrayList<Ant> getAnt(int s){ //Returns a list of the edges 
        vertices = new Vertex[s];
        return vertices[s].getAnt();
    }
}
