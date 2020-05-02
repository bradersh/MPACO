package Main;

import java.util.LinkedList;

/**
 *
 * @author BradleyH
 */

public class Edge {
    
    private int source, destination; //Stores the two nodes whcih share an edge 
    private double weight; //This will represent the "distance" between each node which the ants will travel
    private LinkedList<EdgeSegment> edgeSegmentList = new LinkedList<>();
    
    public Edge(int source, int destination, double weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public String toString(){ //Used to print the Edge class to see the edges created with their weighting 
        return "Node " + source + " is connected to " + destination + " with a weight off " + weight;
    }
    
    
    
    public LinkedList<EdgeSegment> getEdgeSegment(){
        return edgeSegmentList;
    } 
}
