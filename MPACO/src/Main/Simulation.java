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
public class Simulation implements Runnable{
    
    private boolean running = false;
    private Display display;
    public int width, height;
    public String title;
    private Thread thread;
    private BufferStrategy bufferS;
    private Graphics g;
    
    
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
        bufferS = display.getCanvas().getBufferStrategy();
        if(bufferS == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bufferS.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        //Draw start

        
        //Draw end
        
        
        bufferS.show();
        g.dispose();
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
