package Main;

import java.awt.Graphics;
import java.util.*;

/**
 * @author BradleyH
 */

public class Ant extends FeatureEntity{
   
    private Vertex vertex;
    private Vertex lastVertex;
    private Edge chosenEdge;
    private int currentSegment;
    private boolean reverse;
    
    public Ant(float x, float y, int feature, Vertex vertex){
        super(x, y);
        this.vertex = vertex;
        this.feature = feature;
    }
    
    /*
    * This is the main tick method for the ant, it will decided which route to 
    * take if on a vertex, otherwise it will increment the ant down the edge 
    * segment, all whilst depositing pheremone if the last vetext matched its
    * feature 
    */
    @Override
    public void tick(){ 
        if (vertex != null){
            Edge bestEdge = null;
            Double bestScore = -1.0;
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
            if (n >= 0.3){
                chosenEdge = bestEdge;
            }
            else{
                int index = rand.nextInt(vertex.getAdjacent().size());
                chosenEdge = vertex.getAdjacent().get(index);
            }
            reverse = (chosenEdge.getDestination() == vertex);
            lastVertex = vertex;
            vertex.removeAnt(this); 
            if (!reverse){
                chosenEdge.getEdgeSegment(0).addAnt(this);
                currentSegment = 0;
            }
            else{
                int lastIndex = chosenEdge.getEdgeSegmentSize() - 1;
                chosenEdge.getEdgeSegment(lastIndex).addAnt(this);
                currentSegment = lastIndex;
            }
            if (lastVertex.getFeature() == this.getFeature()){
                vertex.deposit(this.feature);
            }
            vertex = null;
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
            if (lastVertex.getFeature() == this.getFeature()){
                chosenEdge.getEdgeSegment(currentSegment).deposit(this.feature);
            }
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
    
    //Simple method indicating if the ant is on the last edge segment, to indicate that it should be joining a vertex
    private boolean onLastSegment(){
        if (!reverse){
            return (currentSegment == chosenEdge.getEdgeSegmentSize() - 1);
        }
        else{
            return (currentSegment == 0);
        }
    } 
    
    //Method to decide which route the ant should take, influenced by the right amount of matching pheremone 
    private double evaluateEdge(Edge edge, boolean reverse){
        if (reverse){
            int lastIndex = edge.getEdgeSegmentSize() - 1;
            return edge.getEdgeSegment(lastIndex).getPheremone(this.getFeature());
        }
        else{
            return edge.getEdgeSegment(0).getPheremone(this.getFeature());
        }
    }
    
    //Method to help draw the ant for x in the direction its travelling regardless of direction 
    private float calculateForX(float x, float xx, int weight){
        float valueX = (xx - x) / weight;;
        return valueX;
    }
    
    //Method to help draw the ant for y in the direction its travelling regardless of direction 
    private float calculateForY(float y, float yy, int weight){
        float valueY = (yy - y) / weight;
        return valueY;
    }
    
    //Mthod used to render the different ants based on thier feature
    public void render(Graphics g){//Casted the floats to ints
        switch (this.feature){
            case(1):g.drawImage(Assets.ant1, (int) x, (int) y, null);
            break;
            case(2):g.drawImage(Assets.ant2, (int) x, (int) y, null);
            break;
            case(3):g.drawImage(Assets.ant3, (int) x, (int) y, null);
            break;
            case(4):g.drawImage(Assets.ant4, (int) x, (int) y, null);
            break;
        }
    }
    
    //Updates the ants position so that it can be drawn in the correct location
    public void updatePosition(float newX, float newY){
        x = newX;
        y = newY;
    }
}
