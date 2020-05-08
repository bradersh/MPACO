package Main;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author BradleyH
 */

public class Edge {
    
    private Vertex source, destination; //Stores the two nodes whcih share an edge 
    private double weight; //This will represent the "distance" between each node which the ants will travel
    private LinkedList<EdgeSegment> edgeSegmentList = new LinkedList<>();
    
    public Edge(Vertex source, Vertex destination, double weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        
        for (int i = 0; i < weight; i++){
            edgeSegmentList.add(new EdgeSegment());
        }
    }
    
    public String toString(){ //Used to print the Edge class to see the edges created with their weighting 
        return "Node " + source + " is connected to " + destination + " with a weight off " + weight;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        for(EdgeSegment edgeSegment : edgeSegmentList){
            g.drawLine((int)source.getX() + 16, (int)source.getY() + 16, (int)destination.getX() + 16, (int)destination.getY() + 16);
        }
    }
    
    public EdgeSegment getEdgeSegment(int id){
        return edgeSegmentList.get(id);
    }
    
    public int getEdgeSegmentSize(){
        return edgeSegmentList.size();
    }
    
    public Vertex getDestination() {
        return destination;
    }
    
    public Vertex getSource() {
        return source;
    }
}
