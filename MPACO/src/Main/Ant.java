package Main;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author BradleyH
 */
public class Ant extends Entity{
    
    private boolean depoisting = false; //Whether or not the ant is depositing pheremore
    private double antFactor; //The factor to which the number of spawned ants is decided (an antFactor of 1 would be 1 ant for each node etc.)
    private List<Ant> antList = new ArrayList<>();
    private Location location;
    
    public Ant(float x, float y, int feature){
        super(x, y, feature);
        
    }
    
    public void tick(){
        //deposit();
        //collection of possible route to take 
        //decide route to take 
        //move to location 
        //needs to know about other ants (get ant in current location) 

    }
    
    public void render(Graphics g){
        g.drawImage(Assets.ant, (int) x, (int) y, null);//Casted the floats to ints
    }
    
    public void deposit(){
        //location.deposit(); 
    }
}
