package Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BradleyH
 */
public class Simulation implements Runnable{ //Runnable allows the game to run on a thread
    
    private boolean running = false;
    private Display display;
    public int width, height;
    public String title;
    private Thread thread; //The thread for the program to run on 
    private BufferStrategy bufferS; 
    private Graphics g;
    
    //Declares it as a state but can be initialised to any type of state
    private State simulationState;  
    private State settingsState;
    
    public Simulation(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    private void init(){
        display = new Display(title, width, height);
        Assets.init(); //Loads in all of the sprite sheet objects
        
        simulationState = new SimulationState();
        settingsState = new SettingsState();
        State.setState(simulationState);
    }
    
    private void tick(){ //Responsible for the ticks everything runs off
        if(State.getState() != null)//Prevents any big errors incase the state doesn't exist
            State.getState().tick();
    }
    
    private void render(){ //Responsible for rendering (Drawing) all of the graphics to the screen
        bufferS = display.getCanvas().getBufferStrategy(); //This uses buffers to draw the image to the screen to prevent flickering 
        if(bufferS == null){
            display.getCanvas().createBufferStrategy(3);//Sets the number of buffers to 3 if it isnt already set
            return; //Leave the method to prevent errors 
        }
        g = bufferS.getDrawGraphics();
        g.clearRect(0, 0, width, height); //Clears the rectangle 
        
        //Draw start
        if(State.getState() != null)//Prevents any big errors incase state = null
            State.getState().render(g);
        //Draw end
        
        bufferS.show(); //Displays the buffers to the screen now that drawing is done
        g.dispose(); //Graphics object is cleard properly 
    }
    
    public void run(){
        init(); //Calls the init method only once to initialise the graphics 
        
        int fps = 60; //Amount of times tick and render method are called every second
        double timePerTick = 1000000000 / fps; //Maximum amount of time to run tick and render methods to achieve desired 60fps 
        double delta = 0; //Amount of time until tick and render methods need to be called
        long now; //Current time of the computer 
        long lastTime = System.nanoTime(); //Returns the current time of the computer but in nanoseconds
        long timer = 0; //time until 1 second acheived 
        int ticks = 0; //How many times tick and render method called in 60 seconds 
        
        while(running){ //The simulation loop
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick; //amount of time passed since line of code last called to check if tick and render methods need to be called
            timer += now - lastTime; //Adds to timer value amount of nanoseconds passed since last called code 
            lastTime = now;
            
            if(delta >= 1){ //Will indicate if tick and render are quired to reach 60fps 
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000){ //Checks if timer exceeds 1 second, how many ticks occured within that second
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
            
        }
        stop();
    }
    
    public synchronized void start(){ //Start the thread (Synchronized is to be used when working directly with threads)
        if(running)
            return; //Prevents this loop occuring if running is already true 
        running = true; //Sets running value to true to allow the simulation loop to begin 
        thread = new Thread(this); //Passes this class (simulation) in the thread
        thread.start(); //Calls the run method
    }
    
    public synchronized void stop(){ //Stop the thread
        if(!running)
            return; //Prevents the program stopping twice if it is already stopped
        running = false; //Sets running value to false to stop the simulation loop
        try {
            thread.join(); //Stops the thread, surrounded with a try catch statement
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
