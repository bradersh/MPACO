package Main;

import java.awt.Graphics;

/**
 *
 * @author BradleyH
 */
public abstract class Entity {
    
    protected float x, y;
    protected int feature; 
    
    public Entity(float x, float y, int feature){
        this.x = x;
        this.y = y;
        this.feature = feature;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}