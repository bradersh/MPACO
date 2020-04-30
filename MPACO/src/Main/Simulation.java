package Main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BradleyH
 */
public class Simulation implements Runnable{
    
    private boolean running = false;
    private Display display;
    public int width, height;
    public String title;
    private Thread thread;
    
    public Simulation(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    private void init(){
        display = new Display(title, width, height);
    }
    
    private void tick(){
        
    }
    
    private void render(){
        
    }
    
    public void run(){
        init();
        
        while(running){
            tick();
            render();
        }
        stop();
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
