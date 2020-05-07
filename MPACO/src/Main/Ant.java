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
    private Vertex vertex;
    private Edge chosenEdge;
    private int currentSegment;
    private boolean reverse;
    
    public Ant(float x, float y, int feature, Vertex vertex){
        super(x, y);
        this.vertex = vertex;
    }
    
    public void tick(){   
        if (vertex != null){
            Edge bestEdge = null;
            Double bestScore = 0.0;
            chosenEdge = null;
            for (Edge edge : vertex.getAdjacent()){
                boolean temporaryReverse = (edge.getDestination() == vertex); 
                if (evaluateEdge(edge, temporaryReverse) > bestScore){
                    bestScore = evaluateEdge(edge, temporaryReverse);
                    bestEdge = edge;
                }
            }
            Random rand = new Random();
            double n = rand.nextDouble();
            if (n >= 0.2){
                chosenEdge = bestEdge;
            }
            else{
                int index = rand.nextInt(vertex.getAdjacent().size());
                chosenEdge = vertex.getAdjacent().get(index);
            }
            reverse = (chosenEdge.getDestination() == vertex);
            vertex.removeAnt(this);
            vertex = null; 
            if (!reverse){
                chosenEdge.getEdgeSegment(0).addAnt(this);
                currentSegment = 0;
            }
            else{
                int lastIndex = chosenEdge.getEdgeSegmentSize() - 1;
                chosenEdge.getEdgeSegment(lastIndex).addAnt(this);
                currentSegment = lastIndex;
            }
        }
        else if(!onLastSegment()){
            chosenEdge.getEdgeSegment(currentSegment).removeAnt(this);
            if (!reverse){
                currentSegment ++;
            }
            if (reverse){
                currentSegment --;
            }
            chosenEdge.getEdgeSegment(currentSegment).addAnt(this);
        }
        else{
            chosenEdge.getEdgeSegment(currentSegment).removeAnt(this);
            if (reverse){
                vertex = chosenEdge.getSource();
            }
            if (!reverse){
                vertex = chosenEdge.getDestination();
            }
            vertex.addAnt(this);
            chosenEdge = null;
        }
        

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
    
    private boolean onLastSegment(){
        if (!reverse){
            return (currentSegment == chosenEdge.getEdgeSegmentSize() - 1);
        }
        else{
            return (currentSegment == 0);
        }
    } 
    
    private double evaluateEdge(Edge edge, boolean reverse){
        if (reverse){
            int lastIndex = edge.getEdgeSegmentSize() - 1;
            return 10.0 + edge.getEdgeSegment(lastIndex).getPheremone();
        }
        else{
            return 10.0 + edge.getEdgeSegment(0).getPheremone();
        }
        //each edge has a default value
        //each pheremone on the edge increases its value by 1
        //sum of all the values added together and a dice rolled between 0 and that number
        //e.g. if there are 3 paths, two with no pheremone both with a value of 10, and a pather with pheremone with a value of 20
        //a dice will be rolled out of 40, if its 0-9 its first basic path, 10 -19 the second basic path and 20-39 its the pheremone path
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
