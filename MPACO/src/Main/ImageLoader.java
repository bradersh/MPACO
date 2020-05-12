package Main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author BradleyH
 */

public class ImageLoader { 
    
    public static BufferedImage loadImage(String path){ //Returns an object of the loaded image via a path to the file passed as a string
        try { //Try catch statement for errors
            return ImageIO.read(ImageLoader.class.getResource(path));//Return the image via the path 
        } catch (IOException e){
            System.exit(1);//If an image isnt loaded dont run the simulation
        }
        return null;//Removes errors
    }
}
