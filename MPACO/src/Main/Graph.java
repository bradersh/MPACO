package Main;

/**
 *
 * @author BradleyH
 */
public class Graph {
    
    private int vertices;
    private boolean directed; //This allows for the choice between a directed or undirect graph
    private boolean weighted; //This allows for a weighted or unweighted graph
    private float[][] aMatrix;
    private boolean[][] aMatrixSet; //Allows for safer implementation of weighted graphs by checking if an edge exists 
    
    public Graph(int vertices, boolean directed, boolean weighted){
        
        this.vertices = vertices;
        this.directed = directed;
        this.weighted = weighted;
        //This will help set-up my adjacency aMatrix to the right size
        aMatrix = new float[vertices][vertices];
        aMatrixSet = new boolean[vertices][vertices];
    }
    
    public void addEdge(int source, int destination){ 
    //This will ensure symetry is maintained by adding the source and destination at the same time I add the destination and source

        int valueAdded = 1; //This simply adds a value of 1 if the graph isnt weighted
        
        if (weighted){
            valueAdded = 0; //This adds a value of 0 if the graph is weighted but no value is assigned
        }
        
        aMatrix[source][destination] = valueAdded;
        aMatrixSet[source][destination] = true;
        
        if (!directed){
            aMatrix[destination][source] = valueAdded;
            aMatrixSet[destination][source] = true;
        }
    }
    
    public void addEdge(int source, int destination, float weight){
        
        float valueAdded = weight;
        
        if (!weighted){
            valueAdded = 1;
        }
        
        aMatrix[source][destination] = valueAdded;
        aMatrixSet[source][destination] = true;
        
        if (!directed){
            aMatrix[destination][source] = valueAdded;
            aMatrixSet[destination][source] = true;
        }
    }
    
    public void printAdjMartix(){
        for (int i = 0; i < vertices; i++){
            for (int u = 0; u < vertices; u++){ //This ensures only value that are set will be printed
                if (aMatrixSet[i][u]) 
                    System.out.format("%8s", String.valueOf(aMatrix[i][u]));
                else System.out.format("%8s", "/ ");
            }
            System.out.println();
        }    
    }
    
    public void printEdges(){ //This goes through each row of the matrix and prints values if they've been set
        for (int i = 0; i < vertices; i++){
            System.out.print("Node " + i + " has a connection with: ");
            for (int u = 0; u < vertices; u++){
                if (aMatrixSet[i][u]){
                    System.out.print(u + ", ");
                }
            }
            System.out.println();
        }
    }
    
    public boolean hasEdge(int source, int destination){
        return aMatrixSet[source][destination];
    }
    
    public Float edgeValue(int source, int destination){
        if (!weighted || !aMatrixSet[source][destination])
            return null;
        return aMatrix[source][destination];
    }
}
