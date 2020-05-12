package Main;

import java.awt.Graphics;

/**
 * @author BradleyH
 */

public abstract class State {
    
    //Manages game state but is not related to the abstract class
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    //End
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
