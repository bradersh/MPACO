package Main;

import java.awt.Graphics;

/**
 *
 * @author BradleyH
 */
public class SimulationState extends State {

    private Ant ant;
    
    public SimulationState(){
        ant = new Ant(100, 100, 1);
    }
    
    @Override
    public void tick() {
        ant.tick();
    }

    @Override
    public void render(Graphics g) {
        ant.render(g);
    }
    
}
