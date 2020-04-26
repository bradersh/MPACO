package Old;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author BradleyH
 */
public class SimulationView extends JFrame{
    
    public SimulationView(){
        initSim();
    }
    
    private void initSim(){
        setTitle("MPACO");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            
            SimulationView Sim = new SimulationView();
            Sim.setVisible(true);
        });
    }
}