package Main;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * @author BradleyH
 */

public class Display {
    
    private JFrame frame;
    private Canvas canvas;
    private final String title;
    private final int width, height;
    
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    
    //Creates a display with the required dimensions and some basic additional QOL functionality
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        
        frame.add(canvas);
        frame.pack();
    }
    
    public Canvas getCanvas(){ //Allows access to the canvas from other classes
        return canvas;
    }
}
