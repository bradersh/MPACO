package Main;

/**
 *
 * @author BradleyH
 */
public abstract class Location {
    
    private int pheremone = 0;
    protected float x, y;
    
    public void deposit(){
        pheremone++;
    }
    
    public void evaporate(){
        pheremone--;
    }
    
    public int getPheremone(){
        return pheremone;
    }
    
    //get adjacent locations
    
}
