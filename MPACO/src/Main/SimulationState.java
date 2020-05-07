package Main;

import java.awt.Graphics;

/**
 *
 * @author BradleyH
 */
public class SimulationState extends State {

    private Graph graph;
    
    public SimulationState(){
        graph = new Graph(5); //Number of vertices
    }
    
    @Override
    public void tick() {
        graph.tick();
        //vertex.tick();
        //edge.tick();
        
    }

    @Override
    public void render(Graphics g) {
        graph.render(g);
    }
}
