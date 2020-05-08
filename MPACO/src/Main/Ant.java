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
    private Vertex lastVertex;
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
            lastVertex = vertex;
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
            System.out.println(chosenEdge);
        }        
        else if(!onLastSegment()){
            chosenEdge.getEdgeSegment(currentSegment).removeAnt(this);
            if (!reverse){
                currentSegment ++;
                this.updatePosition(x + calculateForX(lastVertex.getX(), chosenEdge.getDestination().getX(), chosenEdge.getEdgeSegmentSize()), y + calculateForY(lastVertex.getY(), chosenEdge.getDestination().getY(), chosenEdge.getEdgeSegmentSize()));
            }
            if (reverse){
                currentSegment --;
                this.updatePosition(x + calculateForX(lastVertex.getX(), chosenEdge.getSource().getX(), chosenEdge.getEdgeSegmentSize()), y + calculateForY(lastVertex.getY(), chosenEdge.getSource().getY(), chosenEdge.getEdgeSegmentSize()));

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
            this.updatePosition(vertex.getX(), vertex.getY());
            chosenEdge = null;
        }
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
    }
    
    private float calculateForX(float x, float xx, int weight){
        float valueX = (xx - x) / weight;;
        return valueX;
    }
    
    private float calculateForY(float y, float yy, int weight){
        float valueY = (yy - y) / weight;
        return valueY;
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.ant, (int) x, (int) y, null);//Casted the floats to ints
    }
    
    public void deposit(){
        //location.deposit(); 
    }
    
    public void updatePosition(float newX, float newY){
        x = newX;
        y = newY;
    }
}
