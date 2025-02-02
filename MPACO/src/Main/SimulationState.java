package Main;

import java.awt.Graphics;
import java.io.IOException;

/**
 * @author BradleyH
 */

public class SimulationState extends State {

    private final Graph graph;
    
    public SimulationState() throws IOException{
        graph = new Graph(13); //Number of vertices
    }
    
    @Override
    public void tick() {
        graph.tick();
    }

    @Override
    public void render(Graphics g) {
        graph.render(g);
    }
}
