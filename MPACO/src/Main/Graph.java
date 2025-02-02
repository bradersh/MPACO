package Main;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author BradleyH
 */

public class Graph {
    
    protected Vertex[] vertices; //Contains details about its edges 
    private final int antFactor = 5; //Dictates how many ants will spawn per node
    private final ArrayList<Ant> ants = new ArrayList<>();
    private final ArrayList<Edge> edgeList = new ArrayList<>();
    
    public Graph(int s) throws IOException{
        vertices = new Vertex[s]; //Number of vertices to create the array
        
        //Takes a .csv file and inputs the x, y and feature values it contains into creating the vertices and ants
        BufferedReader csvReader = new BufferedReader(new FileReader("src/res/config/vertices.csv"));
        String row;
        int i = 0;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            float x = Float.parseFloat(data[0]); 
            float y = Float.parseFloat(data[1]); 
            int feature = Integer.parseInt(data[2]);
            vertices[i] = new Vertex(x, y, feature);
            for (int k = 0; k < antFactor; k++){
                Ant tempAnt = new Ant(x, y, feature, vertices[i]);     
                ants.add(tempAnt);
                vertices[i].addAnt(tempAnt);
            }
            i++;
        }
        csvReader.close();
        
        //takes a .csv file and takes the source, destination and weigth values and uses that to create the edges 
        csvReader = new BufferedReader(new FileReader("src/res/config/edge.csv"));
        row = "";
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            int source = Integer.parseInt(data[0]); 
            int destination = Integer.parseInt(data[1]); 
            double weight = Double.parseDouble(data[2]);
            addEdge(vertices [source], vertices [destination], weight);
        }
        csvReader.close();   
    }
    
    //Creates the edges and adds them into the edgelist
    public void addEdge(Vertex s, Vertex d, double weight){ //Adding the bidirectional edges along with their weighting
        Edge edge = new Edge(s, d, weight);
        s.addEdge(edge);
        d.addEdge(edge);
        edgeList.add(edge);
    }
    
    public ArrayList<Edge> getAdjacent(int s){ //Returns a list of the edges 
        return vertices[s].getAdjacent();
    }
    
    public void tick(){
        for(Ant ant : ants){
            ant.tick();
        }
    }
    
    //Runs through each edge, ant and vertex and calls the respective reder methods 
    public void render(Graphics g){
        for(Vertex vertex : vertices){
            vertex.render(g);
        }
        for(Ant ant : ants){
            ant.render(g);
        }
        for(Edge edge : edgeList){
            edge.render(g);
        }
    }
}
