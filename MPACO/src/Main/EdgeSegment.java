package Main;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author BradleyH
 */

public class EdgeSegment extends Entity {
    
    private ArrayList<Ant> currentAnts = new ArrayList<>(); //Stores the current ants on each segemtn to implement interactions 

    public EdgeSegment() {
        super(0, 0);
    }
    
    public void addAnt(Ant newAnt){
        currentAnts.add(newAnt);
    }
    
    public void removeAnt(Ant newAnt){
        currentAnts.remove(newAnt);
    }

    @Override
    public void tick() {
        evaporate();
    }

    @Override
    public void render(Graphics g) {
        
    }
}
