package Main;

/**
 *
 * @author BradleyH
 */

public class Edge {
    
    //linked list with a collection of edgesegment  and methods to get segment next to (e.g. vertex) (edge knows about end segment or the whole list) 
    private int source, destination; //Stores the two nodes whcih share an edge 
    private double weight; //This will represent the "distance" between each node which the ants will travel
    
    public Edge(int source, int destination, double weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public String toString(){ //Used to print the Edge class to see the edges created with their weighting 
        return "Node " + source + " is connected to " + destination + " with a weight off " + weight;
    }
}
