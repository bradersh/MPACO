package Main;

import java.awt.Graphics;

/**
 *
 * @author BradleyH
 */
public class SimulationState extends State {

    private Ant ant;
    private Vertex vertex;
    private Edge edge;
    
    public SimulationState(){
        ant = new Ant(100, 100, 1);
        vertex = new Vertex(1.0f, 1.0f, 1);
        edge = new Edge(1, 2, 300);
    }
    
    @Override
    public void tick() {
        ant.tick();
        //vertex.tick();
        //edge.tick();
        
    }

    @Override
    public void render(Graphics g) {
        ant.render(g);
        vertex.render(g);
        edge.render(g);
    }
    
}
