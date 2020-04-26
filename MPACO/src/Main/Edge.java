package Main;

/**
 *
 * @author BradleyH
 */

public class Edge {
    
    private int source, destination;
    private double weight;
    
    public Edge(int source, int destination, double weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public String toString(){
        return "Node " + source + " is connected to " + destination + " with a weight off " + weight;
    }
}
