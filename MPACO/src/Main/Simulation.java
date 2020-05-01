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
        Assets.init();

    }
    
    int x = 0;
    
    private void tick(){
        x += 1;
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

        g.drawImage(Assets.ant, x, 20, null);
        //Draw end
        
        
        bufferS.show();
        g.dispose();
    }
    
    public void run(){
        init();
        
        int fps = 60; //Amount of times tick and render method are called every second
        double timePerTick = 1000000000 / fps; //Maximum amount of time to run tick and render methods to achieve desired 60fps 
        double delta = 0; //Amount of time until tick and render methods need to be called
        long now; //Current time of the computer 
        long lastTime = System.nanoTime(); //Returns the current time of the computer but in nanoseconds
        long timer = 0; //time until 1 second acheived 
        int ticks = 0; //How many times tick and render method called in 60 seconds 
        
        while(running){
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
