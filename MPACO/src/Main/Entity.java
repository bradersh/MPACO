package Main;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author BradleyH
 */
public abstract class Entity {
    
    protected float x, y;
    protected ArrayList<Pheremone> pheremone = new ArrayList<>();
    protected int pheremoneEvaporateCount = 0;
    protected int maximumCount = 10;
    
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public void deposit(int feature){
        for (int i = 0; i < 10; i++){
            pheremone.add(new Pheremone(feature));
        }
    }
    
    public void evaporate(){
        if (pheremoneEvaporateCount == maximumCount){
            pheremone.remove(0);
            pheremoneEvaporateCount = 0;
        }
        else{
            pheremoneEvaporateCount ++;
        }
    }
    
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