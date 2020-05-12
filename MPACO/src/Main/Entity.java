package Main;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author BradleyH
 */

public abstract class Entity {
    
    protected float x, y;
    protected ArrayList<Pheremone> pheremone = new ArrayList<>(); //Stores the amount of pheremone at differetn locations
    protected int pheremoneEvaporateCount = 0; //A counter to indicated when enough ticks have passed and pheremone should evaporate 
    protected int maximumCount = 10; //The point at which oheremone does start to evaporate
    
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    //Used to add pheremone of a particualr feature to the list 
    public void deposit(int feature){
        for (int i = 0; i < 10; i++){
            pheremone.add(new Pheremone(feature));
        }
    }
    
    //Used to remove pheremone from the list
    public void evaporate(){
        if (pheremoneEvaporateCount == maximumCount){
            pheremone.remove(0);
            pheremoneEvaporateCount = 0;
        }
        else{
            pheremoneEvaporateCount ++;
        }
    }
    
    //Used to indicate how much pheremone of a particular feature is in a particular location
    public int getPheremone(int feature){
        int pheremoneCount = 0;
        for (Pheremone pheremone : pheremone){
            if (pheremone.getFeature() == feature){
                pheremoneCount++;
            }
        }
        return pheremoneCount;
    } 
}