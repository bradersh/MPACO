package Main;

/**
 * @author BradleyH
 */

public class Launcher {
    
    public static void main(String[] args){
        Simulation simulation = new Simulation("MPACO", 800, 800); //Creates the simulation object with a width and height for the display 
        simulation.start(); //Starts the simulation loop
    }
}
