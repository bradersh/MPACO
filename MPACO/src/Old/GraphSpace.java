package Old;

/**
 *
 * @author BradleyH
 */
public class GraphSpace {
    
    public static void main(String[] args){
        Graph graph = new Graph(4, false, true);
        
        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 3, 17);
        graph.addEdge(1, 2, 18);
        graph.addEdge(3, 1, 15);
        graph.addEdge(0, 2, 10);
        
        graph.printAdjMartix();
        
        System.out.println();
        
        graph.printEdges();
        
        System.out.println();
    }
}
