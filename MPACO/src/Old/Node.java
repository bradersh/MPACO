package Old;

import java.util.*;

/**
 *
 * @author BradleyH
 */
public class Node {
    
    private ArrayList<Edge> nodeListMap; //An array list provided by java util 
    
    public Node(int vertices){ //Constructor for the class, creating an empty graph with the given vertices(nodes) 
        nodeListMap = new ArrayList<>(); //New Hash map taking an input as an integer 
        for(int i=1; i<=vertices; i++){ //Create a graph for the number of vertices(nodes) the user inputs 
            ArrayList<Edge> neighbouringNodes = new ArrayList<>(); 
            nodeListMap.addneighbouringNodes); //E.g. for node 1, I have created an arraylist which is called neighbours 
        }
    }
    
    public void addNeighbour(int v, int n){ //Function to created the edges using the inputted veticies(nodes)
        if(v > nodeListMap.size() || n > nodeListMap.size()){ //Check that the input is within the range of vertices(nodes)
            return;
        }
        (nodeListMap.get(v)).add(n); //This allows for non-directional travel e.g. if ant can travel from 1 to 2, the reverse is possible 
        (nodeListMap.get(n)).add(v);
    }
    
    public ArrayList<Integer> getNeighbours(int v){ //Returns the list of neighbours for a particular vertex(node)
        if(v > nodeListMap.size()){
            return null;
        }
        return new ArrayList<>(nodeListMap.get(v)); //Returns the list of neighbours to a specific vertex(node)
    }
    
    public static void main(String args[]){ 
        int count = 1, source, destination; //Source and destionation vertice(node)
        System.out.print("Enter the number of vertices and edges required");
        Scanner scan = new Scanner(System.in);
        int number_of_vertices = scan.nextInt(); //Both take input from the user 
        int number_of_edges = scan.nextInt();
        Node nodeList = new Node(number_of_vertices); //Create a new instance of the class with number of vertices
        System.out.print("Enter the number of edges as <source> <destination>");
        while(count <= number_of_edges){ //Ensure the input matches number of edges required
            source = scan.nextInt();
            destination = scan.nextInt();
            nodeList.addEdges(source, destination); //Adds the edges to the list
            count++;
        }
        System.out.println("Output:\n"); //Shows the vertices as well as connecting edges in format v -> e
        for(int i=1; i<=number_of_vertices; i++){
            System.out.print(i + " -> ");
            ArrayList<Integer> edgeList = nodeList.getNeighbours(i);
            for(int u=1;; u++){
                if(u != edgeList.size()){ //Checks if the neighbour is the last neighbour 
                    System.out.print(edgeList.get(u-1) +" -> ");
                }
                else{
                    System.out.print(edgeList.get(u-1));
                    break;
                }
            }
            System.out.println();
        }
    }  
}
