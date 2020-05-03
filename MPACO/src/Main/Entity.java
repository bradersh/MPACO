package Main;

import java.awt.Graphics;

/**
 *
 * @author BradleyH
 */
public abstract class Entity {
    
    protected float x, y;
    protected int pheremone = 0;
    
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public void deposit(){
        pheremone++;
    }
    
    public void evaporate(){
        pheremone--;
    }
    
    public int getPheremone(){
        return pheremone;
    }
    
}